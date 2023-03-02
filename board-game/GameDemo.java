/**
 * This class describes board after taking various input from users.
 *
 * Author: Harsh Kurjibhai patel
 * id: B00881655
 */

import java.util.Scanner;
import java.awt.*;

public class GameDemo {

    /**
     * This method creates a board as per user's input
     *
     * @param new_board:  the new board object
     * @param c           : number of words in the string given by user
     * @param i           : denotes the starting index of word after first space and I have used it to assign proper values of x,y,speed and movement of piece.
     * @param input_text: the string entered by user.
     */
    public static void create(Board new_board, int c, int i, String input_text) {
        Scanner sc = new Scanner(System.in);
        String s1 = "", speed = "", type = "";
        int no_of_words = 0;
        int x_point = 0;
        int y_point = 0;
        // Running for loop till the end of text entered by puser and assigning it to different variables.
        for (int j = i + 1; j < input_text.length(); j++) {
            //getting each alphabet from the input of user and creating a sub-string at each space.
            char ch = input_text.charAt(j);
            if (ch == ' ') {
                s1 = input_text.substring(c, j);
                c = j + 1;
                no_of_words++;
            }
            //it denotes the word after the first space.
            if (no_of_words == 1) {
                x_point = Integer.parseInt(s1);
            }
            //it denotes the word after second space.
            if (no_of_words == 2) {
                y_point = Integer.parseInt(s1);
            }
            //it denotes the word after third space.
            if (no_of_words == 3) {
                speed = s1;
            }
            //it denotes the word after fourth space.
            if (no_of_words == 4) {
                type = s1;
            }
        }
        System.out.println("Enter Name of the piece: ");
        String Name = sc.next();
        System.out.println("Enter Colour of piece: ");
        String Colour = sc.next();

        if (speed.equals("")) {
            Point position = new Point(x_point, y_point);
            // By default the speed is slow and movement is nonflexible.
            new_board.add(Name, Colour, position, "slow", "nonflexible");
        }

        if (speed.equalsIgnoreCase("fast") && type.equals("")) {
            Point position = new Point(x_point, y_point);
            new_board.add(Name, Colour, position, speed, "nonflexible");
        }

        if (speed.equalsIgnoreCase("flexible") && type.equals("")) {
            Point position = new Point(x_point, y_point);
            new_board.add(Name, Colour, position, "slow", speed);
        }
        if (speed.equalsIgnoreCase("fast") && type.equalsIgnoreCase("flexible")) {
            Point position = new Point(x_point, y_point);
            new_board.add(Name, Colour, position, speed, type);
        }
        sc.nextLine();
    }

    /**
     * This method moves the piece to given place as per user's input.
     *
     * @param new_board   new board obejct.
     * @param c:          number of words in string given by user
     * @param i:          denotes the starting index of word after space.
     * @param input_text: String entered by user.
     */
    public static void move(Board new_board, int i, int c, String input_text) {
        String s1 = "", direction = "";
        int no_of_words = 0;
        int x_point = 0;
        int y_point = 0;
        int movement = 1;

        for (int j = i + 1; j < input_text.length(); j++) {
            char ch = input_text.charAt(j);
            if (ch == ' ') {
                s1 = input_text.substring(c, j);
                c = j + 1;
                no_of_words++;
            }
            if (no_of_words == 1) {
                x_point = Integer.parseInt(s1);
            }
            if (no_of_words == 2) {
                y_point = Integer.parseInt(s1);
            }
            if (no_of_words == 3) {
                direction = s1;
            }
            //denotes the number of steps to move in given direction
            if (no_of_words == 4) {
                movement = Integer.parseInt(s1);
            }
        }
        Point position = new Point(x_point, y_point);
        new_board.move(position, direction, movement);
    }

    /**
     * This methods displays the necessary information about the game to user.
     */
    public static void help() {
        System.out.println("Possible commands are as follows:\n" +
                "create location [fast][flexible]: Creates a new piece.\n" +
                "move location direction [spaces]: Moves a piece.\n" +
                "print: Displays the board.\n" +
                "help: Displays help.\n" +
                "exit: Exits the program\n");
    }


    public static void main(String[] args) {
        Board new_board = new Board();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the command (Type of details): ");
        String input = sc.nextLine();
        input += " ";

        int length_of_substring = 0;
        String sub_string = "";
        int i;
        for (i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                sub_string = input.substring(length_of_substring, i);
                length_of_substring = i + 1;
                break;
            }
        }

        //checks what the user wants to do in the game
        while (!sub_string.equalsIgnoreCase("exit")) {
            if (sub_string.equalsIgnoreCase("create")) {
                GameDemo.create(new_board, length_of_substring, i, input);
            }
            if (sub_string.equalsIgnoreCase("move")) {
                GameDemo.move(new_board, i, length_of_substring, input);
            }
            if (sub_string.equalsIgnoreCase("help")) {
                GameDemo.help();
            }
            if (sub_string.equalsIgnoreCase("print")) {
                new_board.display();
            }

            System.out.println("Enter the command (Type of details): ");
            input = sc.nextLine() + " ";

            length_of_substring = 0;
            for (i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == ' ') {
                    sub_string = input.substring(length_of_substring, i);
                    length_of_substring = i + 1;
                    break;
                }
            }


        }
    }

}
