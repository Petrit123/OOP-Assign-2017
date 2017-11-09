/* Created by Petrit Krasinqi
* this class to create player with the ghost character
 */

import javax.swing.*;
import java.awt.*;

public class Ghosts {

    //Player2 Attributes
    private int xPosition;
    private int yPosition;
    private String ghost; // this was set as a string because the path of the image is declared as a string

    //This is a getter which returns the value of a private variable
    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    //This is a getter which returns the value of a private variable
    public int getyPosition() {
        return yPosition;
    }

    //This is a setter used to control changes to a variable
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    //This is a getter which returns the value of a private variable
    public String getGhost() {
        return ghost;
    }

    //This is a setter used to control changes to a variable
    public void setGhost(String ghost) {
        this.ghost = ghost;
    }


    //Constructs player2 with a position on the window and picture of their character.
    public Ghosts(int xPosition, int yPosition, String ghost){
        setxPosition(xPosition);
        setyPosition(yPosition);
        setGhost(ghost);
    }

    //no args constructor with no parameters to create a default player2
    public Ghosts(){
        this(0,0,null);
    }


   public void createGhosts(Graphics g){
       ImageIcon img = new ImageIcon(ghost);
       g.drawImage(img.getImage(),getxPosition(),getyPosition(),null);
   }
}
