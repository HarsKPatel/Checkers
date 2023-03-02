/**
 * This class represents creating a specific piece type slow piece inherited from piece class and describing it properties.
 *
 * Author: Harsh Kurjibhai Patel
 * Id: B00881655
 */

import java.awt.*;

public class SlowPiece extends Piece {
    //Constructor
    public SlowPiece(String Name, String Colour, Point position) {

        super(Name, Colour, position);
    }

    /**
     * This method moves the piece one step either left or right.
     *
     * @param direction : direction of movement.
     * @return new location of moved piece.
     */
    public Point move(String direction) {
        if (direction.equalsIgnoreCase("right")) {
            if (position.getX() >= 0 && position.getX() < 8) {
                if (position.getY() >= 0 && position.getY() < 7) {
                    position.setLocation(position.getX(), position.getY() + 1);
                }
                else{
                    System.out.println("out of bounds");
                }
            }
        }
        if (direction.equalsIgnoreCase("left")) {
            if (position.getY() >= 0 && position.getY() < 8) {
                if (position.getY() > 0 && position.getY() < 8) {
                    position.setLocation(position.getX(), position.getY() - 1);
                }

            }
        }
        return position;
    }

    public String toString() {
        return super.toString() + "S";
    }
}

