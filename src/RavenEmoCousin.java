/**
 * This program is to get the user enter a sentence, divide the sentence into words
 * Identify the words representing good and bad emotions.
 * Use it to decide the feeling of the user and output the appropriate response
 * First, create a recursive method that accept a String argument
 * The String sentence will be split into words ignoring punctuations
 *            and save those words into an Arrays
 * Declare and initialize to zero integer that will be used to count good and bad words
 * Declare and initialize two Arrays of good and bad words
 *            Use an inner and outer for loop to check if any good and bad words
 *            are present into the user sentence. if a good words is detected, add 1 to
 *            good words. If a bad word is detected, add 1 to bad words.
 * Use an if statement to compare between good and bad words, which one are more present
 * If good words are more present, great the user.
 * If there is an equality between both, end the program.
 * If there are more bad words than goods words, prompt the user to explain why he is feeling
 *            so bad and start the process again.
 *
 */

//There are two ways of doing this task: loops and recursion
//In this program, we use recursion because it seems to
//require less lines of code than loops
import java.util.Scanner;
import java.util.Arrays;

public class RavenEmoCousin {
    public Scanner in = new Scanner(System.in);
    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);
        String sentence;

        System.out.println("Good morning, how are you feeling today. ");
        System.out.println("You can enter 'Q' or 'q' to exit: ");
        sentence = in.nextLine();
        gettingSentence(sentence);
    }

    public static void gettingSentence(String sentence)  {
        Scanner in = new Scanner (System.in);
        int good = 0;
        int bad = 0;
        String ans;
        String [ ] positive = {"good", "glad", "happy", "relaxed", "accomplished", "alert", "creative"};
        String [ ] negative = {"bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid"};
        String[] words = sentence.split("\\W+");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
            for (int j = 0; j < positive.length; j++) {
                if (words[i].equals(positive[j]))
                    good += 1;
            }
            for (int k = 0; k < negative.length; k++) {
                if (words[i].equals(negative[k]))
                    bad += 1;
            }
        }
        System.out.println();

        if (good > bad ) {
            System.out.println("I am so happy for you...Yay...");
        }
        else if (good == bad) {
            System.out.println("Meh.");
        }
        else {
            System.out.println("Really! Why, tell me more! ('Q', 'q' to exist). ");
            System.out.println("Your response: ");
            ans = in.nextLine();
            if (!ans.equals('Q') || !ans.equals('q')) {
                gettingSentence(ans);
            }
        }
    }
}
