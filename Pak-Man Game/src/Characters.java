import javax.swing.*;
import java.awt.*;

public class Characters  extends JPanel{

    //Character Attributes
    private int xPosition;
    private int yPosition;
    private String imagePath; // this was set as a string because the path of the image is declared as a string



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
    public String getImage() {
        return imagePath;
    }

    //This is a setter used to control changes to a variable
    public void setImage(String imagePath) {
        this.imagePath = imagePath;
    }

    //Constructs player1 with an position on the window and picture of their character.
    public Characters(int xPosition, int yPosition, String imagePath){
        setxPosition(xPosition);
        setyPosition(yPosition);
        setImage(imagePath);

    }

    public void drawCharacters(Graphics g){
        ImageIcon img = new ImageIcon(imagePath);
        g.drawImage(img.getImage(),getxPosition(),getyPosition(),null);
    }

}
