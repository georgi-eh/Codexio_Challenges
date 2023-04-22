import java.util.Scanner;

public class CarrotJumps {

    // Check whether an index is valid given a matrix
    public static boolean isValid(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    // Check whether a carrot has neighbor carrots
    public static boolean hasNoNeighbors(char[][] matrix, int row, int col) {
        int neighbors = 0;
        int[][] allPossibleNeighbors = {
                {row - 1, col},
                {row, col - 1},
                {row, col + 1},
                {row + 1, col}
        };

        for (int[] nextCell : allPossibleNeighbors) {
            int nextRow = nextCell[0];
            int nextCol = nextCell[1];

            if (isValid(nextRow, nextCol, matrix)) {
                if (matrix[nextRow][nextCol] == 'x') {
                    neighbors += 1;
                }
            }
        }

        return neighbors == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the dimension of the matrix (one int)
        int size = Integer.parseInt(scanner.nextLine());

        // Input matrix, designate a carrot with "x"
        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < size; j++) {
                field[i][j] = row.charAt(j);
            }
        }

        // We assume that number of jumps is equal to number of groups of carrots
        int jumps = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // We check whether a cell is carrot, if it is, we remove it and check whether it has neighboring carrots
                // If no neighboring carrots, we have a group of carrots and we have to jump
                if (field[row][col] == 'x') {
                    field[row][col] = '.';
                    if (hasNoNeighbors(field, row, col)) {
                        jumps += 1;
                    }
                }
            }
        }

        System.out.println("Number of jumps: " + jumps);
    }
}
