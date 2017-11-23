/* Created by Petrit Krasinqi
* This class will create the images that appear on the JFrame
 */

import javax.swing.*;
import java.awt.*;


//Extending from the JPanel class to inherit abstract methods
public class Images extends JPanel {


    //Character Attributes
    private int xPosition; //Each image will have an x-co-ordinate on the JFrame
    private int yPosition; //Each image will have a y-co-ordinate on the JFrame
    private String pakManImageFile; // this was set as a string because it will hold the  the path of the image which is read as a string in the paintCompontent method


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

    //Constructs a character with an position on the window and picture of their character.
    public Images(int xPosition, int yPosition, String pakManImageFile) {
        setxPosition(xPosition);
        setyPosition(yPosition);
        setPakManImageFile(pakManImageFile);

    }

    //no args constructor with no parameters to create a default player1
    public Images(int xPosition, int yPosition) {
        this(0, 0, null);
    }


    //the following will paint the character image onto itself -- where the painting of the images take place

    public void paintComponent(Graphics g) {

        //This paints images on to screen
        ImageIcon img = new ImageIcon(getPakManImageFile());
        g.drawImage(img.getImage(), getxPosition() - 900, getyPosition() - 430, this);
        g.drawImage(img.getImage(), getxPosition() - 20, getyPosition() - 20, this);
        g.drawImage(img.getImage(),getxPosition() - 450,getyPosition() - 180,this);

    }

    //Overrides the getPreferredSize method -- This sets the height and width of the panels

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }
}