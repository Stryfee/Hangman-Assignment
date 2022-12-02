import java.util.*;

/*
 * HANG MAN
 * By Vineet Patel
 * 
 * TO DO - plan the assignment/ get hangman ascii art/ finish main program/ get dictionary file IO.
 * 
 * Bugs - crashes after first check
 * 
 * started - 2022/11/30
 * completed - 2022/
 * 
 * 
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Scanner in = new Scanner(System.in);

        // String word = generateWord();
        // String Underlined = generateUnderlines(word);

        // // check to see if stuff works, del after
        // System.out.println(word);
        // System.out.println(Underlined);

        // System.out.println("Guess a Letter!");
        // String guess = in.nextLine();
        // System.out.println(guessChar(guess.charAt(0), word));
        // Underlined = guessChar(guess.charAt(0), word);
        // while (Underlined != word) {
        //     System.out.println("Guess another Letter!");
        //     guess = in.nextLine();
        //     System.out.println(guessChar(guess.charAt(0), word));
        //     Underlined = guessChar(guess.charAt(0), word);
        // }

        hangman(6);

    }

    public static String guessChar(char guess, String word) {
        // empty string to put the letters and print the underlines again
        String a = "";
        // check loop for each letter in the word
        for (int i = 0; i < word.length(); i++) {
            if (guess == word.charAt(i)) {
                // store letter at specific spot(ex. guess = v, word = virginia, store v at
                // first letter of word)
                a += (guess + " ");
            } else {
                // if guess doesnt match with what the letter is, add underlines
                a += "_ ";
            }

        }

        return a;

    }

    public static String generateWord() {
        // generates word from an array of words
        Random rand = new Random();
        String[] words = { "cook", "bowls", "virginia" };
        // get random num as index for the chosen word
        int randomnum = rand.nextInt(words.length);
        // store chosen word in a variable
        String ChosenWord = words[randomnum];
        // return variable
        return ChosenWord;
    }

    public static String generateUnderlines(String word) {
        // generates underlines for set word
        String kek = "";
        for (int i = 0; i < word.length(); i++) {
            kek += "_ ";
        }
        return kek;

    }

    public static void hangman(int a){
        if (a == 6){
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println(" /|\\  | ");
            System.out.println(" / \\  |");
            System.out.println("      | ");
            System.out.println("=========");
        }
    }

}
