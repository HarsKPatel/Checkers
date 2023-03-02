
/**
 * This class represents creating a piece for game and giving it name,Colour and position.
 *
 * Author: Harsh Kurjibhai Patel
 * Id: B00881655
 */

import java.awt.*;

public class Piece {
    private String Name, Colour;
    Point position;

    public Piece(String Name, String Colour, Point position) {
        this.Name = Name;
        this.Colour = Colour;
        this.position = position;
    }

    //getters and setters
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setColour(String Colour) {
        this.Colour = Colour;
    }

    public void setposition(Point position) {
        if (position.getX() >= 0 && position.getX() < 8) {
            if (position.getY() >= 0 && position.getY() < 8) {
                this.position = position;
            }
        }
    }

    public String getName() {
        return this.Name;
    }

    public String getColour() {
        return this.Colour;
    }

    public Point getposition() {
        return this.position;
    }

    @Override
    public String toString() {
        return Name + Colour;
    }


}
