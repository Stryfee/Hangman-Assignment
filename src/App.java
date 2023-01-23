import java.util.*;
import java.io.File;

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
    public static int hang = 0;
    public static String wrongLetters = "";
    public static void wrongGuess(char a){
        if (wrongLetters.contains(a +"")){
            System.out.println("You already used this word!");
        }else{
            wrongLetters += a + " ";
            hangman(++hang);
        }
        System.out.println("Wrong letters: "+ wrongLetters.toUpperCase());
    }
    
    public static void main (String[] args) throws Exception{
        String repeat = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome To Hangman!, would you like to learn how to play? (y/n)");
        String ans = in.nextLine();
        if (ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")) {
            System.out.println("the computer picks a word and you try to guess it by guessing letters. Each incorrect guess brings you closer to being \"hanged.\"");
        }
        System.out.println("Lets begin!");
        while (!(repeat.equals("n")) || (repeat.equalsIgnoreCase("no"))){
            game();
            System.out.println("Would you like to play again? (y/n)");
            repeat = in.nextLine();
            hang = 0;
            wrongLetters = "";
        }
    }
    public static void game() throws Exception {
        Scanner in = new Scanner(System.in);
        String word = generateWord();
        String Attempt = generateUnderlines(word);


        System.out.println(Attempt);

        System.out.println("Guess a Letter!");
        String guess = in.nextLine();
        if(guess.trim()==""){
         while(!(guess.trim() == "")){
                System.out.println("you cannot enter a blank character!");
                System.out.println("Guess a Letter!");
                guess = in.nextLine();
            }
        }
        Attempt = (guessChar(word, Attempt, guess.charAt(0)));
        System.out.println(Attempt);

        while (!Attempt.equals(word)) {
            if(hang >= 12){
                break;
            }
            System.out.println("Guess another Letter!");
            guess = in.nextLine();
            if(guess.trim()==""){
                while(!(guess.trim() == "")){
                       System.out.println("you cannot enter a blank character!");
                       System.out.println("Guess a Letter!");
                       guess = in.nextLine();
                   }
               }
            Attempt = (guessChar(word, Attempt, guess.charAt(0)));
            System.out.println(Attempt);
        }
        if(Attempt.equals(word) || hang<12){
            System.out.printf("You win! %s was the word!%n",word);
        }else{
            System.out.printf("You Lose! %s was the word!%n",word);
        }
       
    }

    public static String guessChar(String word, String Attempt, char Guess) {
        int count = 0;
        String checkingString = Attempt.replaceAll(" ", "");
        String new_str = "";
        for(int i = 0; i < 10; i++){
            String Number = i+"";
            String placeHolder = Guess+"";
            if(Number.equalsIgnoreCase(placeHolder)){
                System.out.println("You cannot use number as a guess!");
                return Attempt;
            }
        }
        for(int i = 0; i <word.length(); i++){
            if(Guess == word.charAt(i)){ 
                new_str += Guess;
                count++;
                checkingString.replace(word.charAt(i)+"", Guess+"");
            }else{
                new_str += checkingString.charAt(i);
            }
        }
        if (count == 0){
            wrongGuess(Guess);
        }else{
            hangman(hang);
        }
        return new_str;
    }

    public static String generateWord() throws Exception {
        // get file from bin to get the words
        File Object = new File("bin/Words.txt");
        Scanner reader = new Scanner(Object);
        // generates word from an array of words
        Random rand = new Random();
        // create arraylist for words to be appended
        ArrayList<String> Words = new ArrayList<String>();
        while (reader.hasNextLine()) {
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

    public static void hangman(int a) {
        if (a >= 11) {
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println(" /|\\  | ");
            System.out.println(" / \\  |");
            System.out.println("      | ");
            System.out.println("=========");
        } else if (a >= 9) {
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println(" /|\\  | ");
            System.out.println(" /    |");
            System.out.println("      | ");
            System.out.println("=========");
        } else if (a >= 7) {
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println(" /|\\  | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        } else if (a >= 5) {
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println(" /|   | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        } else if (a >= 3) {
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println("  |   | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        } else if (a >= 1) {
            System.out.println("  +---+ ");
            System.out.println("  |   | ");
            System.out.println("  O   | ");
            System.out.println("      | ");
            System.out.println("      |");
            System.out.println("      | ");
            System.out.println("=========");
        } else if (a >= 0) {
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
