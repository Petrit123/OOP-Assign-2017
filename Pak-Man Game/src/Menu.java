//Created by Petrit Krasniqi

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Menu extends JPanel implements ActionListener, KeyListener {

    //creating a JFrame called frame
    private JFrame frame = new JFrame("Pak-Man");

    private ImageIcon background = new ImageIcon("images//background.jpg"); /* This is inserting an image onto the JFrame
                                                                                    I got help with this code from
                                                                                   https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel     */

   private PakMan pakman = new PakMan(10,10,"images//right.png"); /* This is inserting an image onto the JFrame
                                                                                    I got help with this code from
                                                                                   https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel     */

   private Ghosts ghost1 = new Ghosts(900,430,"images//ghostleft.png"); /* This is inserting an image onto the JFrame
                                                                                    I got help with this code from
                                                                                   https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel     */

   //// constructor
    public Menu(){

        //set the frame default properties -- got some help with this from the vehicle project
        frame.add(this);
        frame.setLocation(500,200);
        frame.setSize(1000,560);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);


    }


    /*This is a java paint method used to draw the images
    * I got help with this code from  https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
     */
    public void paint(Graphics g){
        g.drawImage(background.getImage(),0,0,null);
        pakman.createPakMan(g);
        ghost1.createGhosts(g);
    }




   @Override
    public void actionPerformed(ActionEvent e) {
     //   repaint();
        // += 0;
       // yPosition +=  0;
    }



    @Override
   public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        if( e.getKeyCode() == KeyEvent.VK_UP){

            pakman.setyPosition(pakman.getyPosition() - 12);
            pakman.setPakMan("images//up.png");
            //ghost1.setyPosition(ghost1.getyPosition() - 10);




        }

        if( e.getKeyCode() == KeyEvent.VK_DOWN){
            //yPosition += -10;

            pakman.setyPosition(pakman.getyPosition() + 12);
            pakman.setPakMan("images//down.png");
            //ghost1.setyPosition(ghost1.getyPosition() + 10);

        }

        if( e.getKeyCode() == KeyEvent.VK_RIGHT){

            pakman.setxPosition(pakman.getxPosition() + 12);
            pakman.setPakMan("images//right.png");
            //ghost1.setxPosition(ghost1.getxPosition() + 10);

        }

        if( e.getKeyCode() == KeyEvent.VK_LEFT){
            //xPosition += -10;

            pakman.setxPosition(pakman.getxPosition() - 12);
            pakman.setPakMan("images//left.png");
            //ghost1.setxPosition(ghost1.getxPosition() - 10);


        }

        if(e.getKeyCode()  == KeyEvent.VK_W){
            ghost1.setyPosition(ghost1.getyPosition()-12);
            ghost1.setGhost("images//ghostleft.png");
        }

        if(e.getKeyCode() == KeyEvent.VK_S){
            ghost1.setyPosition(ghost1.getyPosition()+ 12);
            ghost1.setGhost("images//ghostdown.png");
        }

        if(e.getKeyCode() == KeyEvent.VK_D){
            ghost1.setxPosition(ghost1.getxPosition()+ 12);
            ghost1.setGhost("images//ghostright.png");
        }

        if(e.getKeyCode()  == KeyEvent.VK_A){
            ghost1.setxPosition(ghost1.getxPosition()- 12);
            ghost1.setGhost("images//ghostleft.png");
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        //System.out.println("hi");

        if(code == KeyEvent.VK_UP){
            //yPosition += 0;
        }

        if(code == KeyEvent.VK_DOWN){
            //yPosition += 0;
        }

        if(code == KeyEvent.VK_RIGHT){
            //xPosition += 0;
        }

        if(code == KeyEvent.VK_LEFT){
            //xPosition += 0;
        }

    }


}
