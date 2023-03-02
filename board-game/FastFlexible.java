/**
 * This class represents creating a specific piece type fast flexible piece inherited from piece class and describing it properties.
 *
 * Author: Harsh Kurjibhai Patel
 * Id: B00881655
 */

import java.awt.*;

public class FastFlexible extends FastPiece {
    public FastFlexible(String Name, String Colour, Point position) {
        super(Name, Colour, position);
    }


    /**
     * This method moves the piece in n number of steps either up or down.
     *
     * @param direction : direction of movement.
     * @return new location of moved piece.
     */
    public Point move(String direction, int n) {
        if (direction.equalsIgnoreCase("up")) {
            if (position.getX() - n > 0 && position.getX() - n < 8) {
                if (position.getY() > 0 && position.getY() < 8) {
                    position.setLocation(position.getX() - n, position.getY());
                } else {
                    return position;
                }
            }
            else
            {
                System.out.println("out of bounds");
            }

        }
        if (direction.equalsIgnoreCase("down")) {
            if (position.getX() + n >= 0 && position.getX() + n < 7) {
                if (position.getY() >= 0 && position.getY() < 8) {
                    position.setLocation(position.getX() + n, position.getY());
                } else {
                    return position;
                }
            }

        }
        return position;
    }

    public String toString() {
        return super.toString() + "F";
    }
}

