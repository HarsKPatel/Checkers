/**
 * This class represents creating a specific piece type slow flexible piece inherited from piece class and describing it properties.
 *
 * Author: Harsh Kurjibhai Patel
 * Id: B00881655
 */

import java.awt.*;

public class SlowFlexible extends SlowPiece {
    public SlowFlexible(String Name, String Colour, Point position) {
        super(Name, Colour, position);
    }

    /**
     * This method moves the piece one step either up or down.
     * @param direction : direction of movement.
     * @return new location of moved piece.
     */
    public Point move(String direction) {
        if (direction.equalsIgnoreCase("up")) {
            if (position.getX() > 0 && position.getY() < 8) {
                if (position.getY() >= 0 && position.getY() < 8) {
                    position.setLocation(position.getX() - 1, position.getY());
                }
            }
            else
            {
                System.out.println("out of bounds");
            }

        }
        if (direction.equalsIgnoreCase("down")) {
            if (position.getX() >= 0 && position.getY() < 7) {
                if (position.getY() >= 0 && position.getY() < 8) {
                    position.setLocation(position.getX() + 1, position.getY());
                }
            }
            else
            {
                System.out.println("out of bounds");
            }
        }
        return position;
    }

    public String toString() {
        return super.toString() + "F";
    }
}
