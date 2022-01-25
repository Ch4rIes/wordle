import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static ArrayList<String> words;
    public static void main(String args[]){

        words = new ArrayList<>();
        readWords();
        String word = words.get((int)(Math.random() * words.size()));
        // please set your word that you want to guess here
        System.out.println(ANSI_GREEN + "GREEN = RIGHT LETTER + RIGHT PLACE");
        System.out.println(ANSI_PURPLE + "PURPLE = RIGHT LETTER + WRONG PLACE");
        System.out.println(ANSI_RESET + "WHITE = WRONG LETTER + WRONG PLACE");
        System.out.println("\n\n HAVE FUN PLAYING \n\n");
        Scanner Scan = new Scanner(System.in);
        for(int i = 1 ; i <= 6 ; i++){
            System.out.println("Try number: " + i);
            // now the user should take a guess on the word
            System.out.println("Please type in your word below: ");
            String current_guess = Scan.nextLine();
            while(current_guess.length() != 5 || !words.contains(current_guess)){
                System.out.println("Please type in a 5 letter word");
                current_guess = Scan.nextLine();
            }
            boolean all_correct = true;
            for(int j = 0 ; j < 5 ; j++){
                if(word.charAt(j) == current_guess.charAt(j)){
                    System.out.print(ANSI_GREEN + current_guess.charAt(j) + ANSI_RESET);
                }else if(word.contains(Character.toString(current_guess.charAt(j)))){
                    System.out.print(ANSI_PURPLE+ current_guess.charAt(j) + ANSI_RESET);
                    all_correct = false;
                }else{
                    System.out.print(ANSI_RESET + current_guess.charAt(j) + ANSI_RESET);
                    all_correct = false;
                }
            }
            System.out.println();
            if(all_correct) {
                System.out.println("\n\n YOU HAVE GUESSED THE WORD \n\n");
                return;
            }
        }
        System.out.println("You have run out of chances");
    }
    public static void readWords(){
        try {
            File myObj = new File("words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.length() == 5) words.add(data.toLowerCase());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
