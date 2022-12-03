import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


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
        Scanner in = new Scanner(System.in);
        String attempt = "";
        String word = generateWord();
        String Underlined = generateUnderlines(word);

        // check to see if stuff works, del after
        System.out.println(word);
        System.out.println(Underlined);

        System.out.println("Guess a Letter!");
        String guess = in.nextLine();
        attempt = (guessChar(word, attempt, guess.charAt(0)));
        System.out.println(attempt);
        while (attempt != word) {
            System.out.println("Guess another Letter!");
            guess = in.nextLine();
            attempt = (guessChar(word, attempt, guess.charAt(0)));
            System.out.println(attempt);

        }



    }

    public static String guessChar(String word, String Attempt, char Guess) {
        ArrayList<Character> placeholder = new ArrayList<Character>();
        ArrayList<Character> wordList = new ArrayList<Character>(); 
        for (int i = 0; i < word.length(); i++){
            wordList.add(word.charAt(i));
        }
        String b = "";
        for (int i = 0; i < word.length(); i++){
            if (Guess == word.charAt(i)){
                placeholder.add(Guess);
            }else{
                placeholder.add('_');
            }
        }

        for (int i = 0; i < word.length(); i++){
            if (placeholder.get(i) != Attempt.charAt(i)){
                b += placeholder.get(i);
            }else{
                b += "_ ";
            }
        }

        return b;
    }

    public static String generateWord() throws Exception{
        //get file from bin to get the words
        File Object = new File("bin/Words.txt");
        Scanner reader = new Scanner(Object);
        // generates word from an array of words
        Random rand = new Random();
        //create arraylist for words to be appended
        ArrayList<String> Words = new ArrayList<String>();
        while (reader.hasNextLine()){
            String appenededWord = reader.nextLine();
            Words.add(appenededWord);
        }
        reader.close();
        // get random num as index for the chosen word
        int randomnum = rand.nextInt(Words.size());
        // store chosen word in a variable
        String ChosenWord = Words.get(randomnum);
        // return variable
        return ChosenWord;
    }

    public static String generateUnderlines(String word) {
        // generates underlines for set word
        String underlines = "";
        for (int i = 0; i < word.length(); i++) {
            underlines += "_ ";
        }
        return underlines;

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
        }else if(a == 5){
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println(" /|\\  | ");
            System.out.println(" /    |");
            System.out.println("      | ");
            System.out.println("=========");
        }else if(a == 4){
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println(" /|\\  | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        }else if (a == 3){
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println(" /|   | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        }else if (a == 2){
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println("  |   | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        }else if (a == 1){
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println("      | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        }else if (a == 0){
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("      | ");
            System.out.println("      | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        }
    }

}
