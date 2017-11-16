/* Created by Petrit Krasinqi
* this class to create player with the pakman character
 */

import javax.swing.*;
import java.awt.*;

public class PakMan extends JPanel {


    //Player1 Attributes
    private int xPosition;
    private int yPosition;
    private String pakManImageFile; // this was set as a string because the path of the image is declared as a string


    //private ImageIcon background = new ImageIcon("images//background.jpg");


    //This is a getter which returns the value of a private variable
    public int getxPosition() {
        return xPosition;
    }

    //This is a setter used to control changes to a variable
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
    public String getPakManImageFile() {
        return pakManImageFile;
    }

    //This is a setter used to control changes to a variable
    public void setPakManImageFile(String pakManImageFile) {
        this.pakManImageFile = pakManImageFile;
    }

    //Constructs player1 with an position on the window and picture of their character.
    public PakMan(int xPosition, int yPosition, String pakManImageFile) {
        setxPosition(xPosition);
        setyPosition(yPosition);
        setPakManImageFile(pakManImageFile);

    }

    //no args constructor with no parameters to create a default player1
    public PakMan() {
        this(0, 0, null);
    }


    //the following added by JB to paint the Pacman image onto itself (it "is" a JPanel)

    public void paintComponent(Graphics g) {
        //System.out.println("called paintComponent() on Pacman");
        super.paintComponent(g);

        ImageIcon img = new ImageIcon(getPakManImageFile());
        //System.out.println(getxPosition() + "  " + getyPosition());
        g.drawImage(img.getImage(), getxPosition() - 10, getyPosition() - 10, this);
        g.drawImage(img.getImage(),getxPosition() - 900, getyPosition() - 430,this);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }

}
