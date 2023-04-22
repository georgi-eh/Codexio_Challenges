# Check whether an index is valid given a matrix
def is_valid(row, col, matrix):
    return row >= 0 and row < len(matrix) and col >= 0 and col < len(matrix)


# Check whether a carrot has neighbor carrots
def has_no_neighbors(matrix, row, col):
    neighbors = 0
    all_possible_neighbors = [
        [row - 1, col],
        [row, col - 1],
        [row, col + 1],
        [row + 1, col]
    ]

    for next_row, next_col in all_possible_neighbors:
        if is_valid(next_row, next_col, matrix):
            if matrix[next_row][next_col] == "x":
                neighbors += 1
    if neighbors == 0:
        return True
    return False


# Input the dimension of the matrix (one int)
size = int(input("Please give matrix size (one number): "))

# Input matrix, designate a carrot with "x"
field = [[x for x in input().split()] for _ in range(size)]

# We assume that number of jumps is equal to number of groups of carrots
jumps = 0
for row in range(size):
    for col in range(size):
        # We check whether a cell is carrot, if it is, we remove it and check whether it has neighboring carrots
        # If no neighboring carrots, we have a group of carrots and we have to jump
        if field[row][col] == "x":
            field[row][col] = "."
            if has_no_neighbors(field, row, col):
                jumps += 1
print(f"Number of jumps: {jumps}")
