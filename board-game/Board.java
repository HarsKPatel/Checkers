/**
 * This class describes board methods like adding,moving and displaying element or piece in board.
 *
 * Author:Harsh Kurjibhai Patel
 * Id: B00881655
 */

import java.awt.*;

public class Board {

    //created a board of 8*8 and setting all the elements null at initial stage.
    Piece[][] board = board = new Piece[8][8];


    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }

        }
    }

    /**
     * This method adds piece to board given its speed and type.
     *
     * @param Name:     name of the piece
     * @param Colour:   colour of piece.
     * @param position: position of piece
     * @param speed:    speed of the piece
     * @param movement  : movement of the piece.
     */
    public void add(String Name, String Colour, Point position, String speed, String movement) {
        if (board[position.x][position.y] == null) {
            if (speed.equalsIgnoreCase("slow") && movement.equalsIgnoreCase("flexible")) {
                Piece p = new SlowFlexible(Name, Colour, position);
                board[position.x][position.y] = p;
            }
            if (speed.equalsIgnoreCase("fast") && movement.equalsIgnoreCase("flexible")) {
                Piece p = new FastFlexible(Name, Colour, position);
                board[position.x][position.y] = p;
            }
            if (speed.equalsIgnoreCase("slow") && movement.equalsIgnoreCase("nonflexible")) {
                Piece p = new SlowPiece(Name, Colour, position);
                board[position.x][position.y] = p;
            }
            if (speed.equalsIgnoreCase("fast") && movement.equalsIgnoreCase("nonflexible")) {
                Piece p = new FastPiece(Name, Colour, position);
                board[position.x][position.y] = p;
            }
        } else {
            System.out.println("There is no space there!!!");
        }
    }

    /**
     * This method moves the piece to given number of steps and in given direction.
     *
     * @param pos:       initial position of piece
     * @param direction: the direction in which piece is to be moved.
     * @param steps      : the number of steps piece is to be moved.
     */
    public void move(Point pos, String direction, int steps) {
        if (board[pos.x][pos.y] != null) {
            if (direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right")) {
                if (steps == 1) {
                    Piece p1 = board[pos.x][pos.y];
                    SlowPiece slow_horizontal = new SlowPiece(p1.getName(), p1.getColour(), p1.getposition());
                    board[p1.getposition().x][p1.getposition().y] = null;
                    slow_horizontal.move(direction);
                    board[p1.getposition().x][p1.getposition().y] = slow_horizontal;
                } else {
                    Piece p1 = board[pos.x][pos.y];
                    FastPiece fast_horizontal = new FastPiece(p1.getName(), p1.getColour(), p1.getposition());
                    board[p1.getposition().x][p1.getposition().y] = null;
                    fast_horizontal.move(direction, steps);
                    board[p1.getposition().x][p1.getposition().y] = fast_horizontal;
                }
            } else if (direction.equalsIgnoreCase("up") || direction.equalsIgnoreCase("down")) {
                if (steps == 1) {
                    Piece p2 = board[pos.x][pos.y];
                    SlowFlexible slow_vertical = new SlowFlexible(p2.getName(), p2.getColour(), p2.getposition());
                    board[p2.getposition().x][p2.getposition().y] = null;
                    slow_vertical.move(direction);
                    board[p2.getposition().x][p2.getposition().y] = slow_vertical;
                } else {
                    Piece p2 = board[pos.x][pos.y];
                    FastFlexible fast_vertical = new FastFlexible(p2.getName(), p2.getColour(), p2.getposition());
                    board[p2.getposition().x][p2.getposition().y] = null;
                    fast_vertical.move(direction, steps);
                    board[p2.getposition().x][p2.getposition().y] = fast_vertical;
                }

            }
            System.out.println("Piece at " + "(" + pos.getX() + "," + pos.getY() + ")" + " moved " + direction + " by " + steps + " spaces");
        } else {
            System.out.println("Error: No piece at " + "(" + pos.getX() + "," + pos.getY() + ")");
        }
    }

    /**
     * This method displays the board.
     */
    public void display() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    // Used "printf("%-20s")" in order to have equal space between the piece names.
                    System.out.printf("%-20s", " - ");
                } else {
                    System.out.printf("%-20s", board[i][j]);
                }
            }
            System.out.println();
        }
    }
}
