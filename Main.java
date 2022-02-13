package Grade_11.UIUC_CS124;

import java.util.*;
import java.lang.Thread;
class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        char ch = 'y';
        do {
            System.out.print("\f");
            System.out.println("    Welcome to Hangman!");
            System.out.println("Please enter a word:");
            String input_word = userInput.next().toLowerCase().trim();
            //basic input validation - no spaces
            System.out.println("Word saved!");
            //do we want to include hints? The number of tries a user gets?
            try {
                Thread current_thread = new Thread();
                current_thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Error in sleeping thread");
                System.exit(0);
            }
            System.out.print("\f");

            InputWords ipwords = new InputWords(input_word);
            Output op = new Output(input_word, ipwords);
            System.out.println("The word is:");
            op.print();
            int errors = ipwords.errors;
            for (int i = 0; i < input_word.length() + 3; i++) {
                errors = ipwords.errors;
                System.out.println("Please enter a letter:");
                char guess = userInput.next().toLowerCase().charAt(0);
                if (ipwords.addCorrectLetter(guess)) {
                    System.out.println("Letter already inputted, please try again.");
                    i--;
                    continue;
                }
                if (ipwords.errors > errors) {
                    System.out.println("Sorry that was incorrect.");
                } else {
                    System.out.println("That was correct!");
                }
                if (op.print()) {
                    break;
                }
            }
            System.out.println("Do you want to play again?");
            System.out.println("Enter y or n");
            ch = userInput.next().toLowerCase().charAt(0);
        } while(ch == 'y');
    }
}