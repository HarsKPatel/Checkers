/**
 * This class represents creating a specific piece type fast piece inherited from piece class and describing it properties.
 *
 * Author: Harsh Kurjibhai Patel
 * Id: B00881655
 */

import java.awt.*;

public class FastPiece extends Piece {
    public FastPiece(String Name, String Colour, Point position) {
        super(Name, Colour, position);
    }

    /**
     * This method moves the piece in n number of steps either left or right.
     *
     * @param direction : direction of movement.
     * @return new location of moved piece.
     */
    public Point move(String direction, int n) {
        if (direction.equalsIgnoreCase("right")) {
            if (position.getX() >= 0 && position.getX() < 8) {
                if (position.getY() + n >= 0 && position.getY() + n < 7) {
                    position.setLocation(position.getX(), position.getY() + n);
                }
                else
                {
                    System.out.println("out of bounds");
                }
            } else {
                return position;
            }
        }
        if (direction.equalsIgnoreCase("left")) {
            if (position.getX() >= 0 && position.getX() < 8) {
                if (position.getY() - n > 0 && position.getY() - n < 8) {
                    position.setLocation(position.getX(), position.getY() - n);
                }
                else{
                    System.out.println("out of bounds");
                }
            } else {
                return position;
            }
        }
        return position;
    }

    public String toString() {
        return super.toString() + "F";
    }

}
