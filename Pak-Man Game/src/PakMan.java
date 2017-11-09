/* Created by Petrit Krasinqi
* this class to create player with the pakman character
 */

import javax.swing.*;
import java.awt.*;

public class PakMan extends JPanel {


    //Player1 Attributes
    private int xPosition;
    private int yPosition;
    private String pakMan; // this was set as a string because the path of the image is declared as a string


    private ImageIcon background = new ImageIcon("images//background.jpg");


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
    public String getPakMan() {
        return pakMan;
    }

    //This is a setter used to control changes to a variable
    public void setPakMan(String pakMan) {
        this.pakMan = pakMan;
    }

    //Constructs player1 with an position on the window and picture of their character.
    public PakMan(int xPosition, int yPosition, String pakMan){
        setxPosition(xPosition);
        setyPosition(yPosition);
        setPakMan(pakMan);

    }

    //no args constructor with no parameters to create a default player1
    public PakMan(){
        this(0,0,null);
    }

    public void createPakMan(Graphics g){
        ImageIcon img = new ImageIcon(pakMan);
        //System.out.println(getxPosition() + "  " + getyPosition());
        g.drawImage(img.getImage(),getxPosition(),getyPosition(),null);
        //addKeyListener(this);

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        repaint();
//        xPosition += 0;
//        yPosition +=  0;
//    }
//
//
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        //System.out.println("hi");
//
//
//        if( e.getKeyCode() == KeyEvent.VK_UP){
//            yPosition += 10;
//
//
//
//        }
//
//        if( e.getKeyCode() == KeyEvent.VK_DOWN){
//            yPosition += -10;
//
//
//        }
//
//        if( e.getKeyCode() == KeyEvent.VK_RIGHT){
//
//            xPosition += 10;
//
//
//
//        }
//
//        if( e.getKeyCode() == KeyEvent.VK_LEFT){
//           xPosition += -10;
//
//
//        }
//
//        repaint();
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//        int code = e.getKeyCode();
//
//        System.out.println("hi");
//
//        if(code == KeyEvent.VK_UP){
//            yPosition += 0;
//        }
//
//        if(code == KeyEvent.VK_DOWN){
//            yPosition += 0;
//        }
//
//        if(code == KeyEvent.VK_RIGHT){
//            //xPosition += 0;
//        }
//
//        if(code == KeyEvent.VK_LEFT){
//            xPosition += 0;
//        }
//
//    }

//    public void paint(Graphics g){
//        g.drawImage(background.getImage(),0,0,null);
//       createPakMan(g);
//        //ghost1.createGhosts(g);
//  }



}
