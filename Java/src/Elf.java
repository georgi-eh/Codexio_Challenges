import java.util.Scanner;

public class Elf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstWord, secondWord;
        int droppedLetters = 0;

        System.out.print("Enter the first word: ");
        firstWord = input.nextLine();
        System.out.print("Enter the second word: ");
        secondWord = input.nextLine();

        for (char letter : firstWord.toCharArray()) {
            if (secondWord.indexOf(letter) != -1) {
                secondWord = secondWord.replaceFirst(String.valueOf(letter), "");
                continue;
            }
            droppedLetters++;
        }

        droppedLetters += secondWord.length();
        System.out.println("Number of dropped letters: " + droppedLetters);
    }
}
