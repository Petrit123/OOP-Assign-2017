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

    private ImageIcon background = new ImageIcon("images//background.jpg"); //This is inserting an image onto the JFrame
    //I got help with this code from
    //https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel

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
        frame.setLocation(120,50);
        frame.setSize(1000,560);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);
        //frame.getContentPane().setBackground(Color.black);
        checkBoundaries();
        ghostKill();






    }

    public void ghostKill(){
        if((ghost1.getxPosition() == pakman.getxPosition() ) && (ghost1.getyPosition()  == pakman.getyPosition())){
            gameover();
        }

       // return false;
    }

    public void checkBoundaries(){
        if(pakman.getxPosition() < -2 || pakman.getxPosition() >= 940 || pakman.getyPosition() <-2 || pakman.getyPosition() >= 478
                || ghost1.getxPosition() <-2 || ghost1.getxPosition() >= 935 || ghost1.getyPosition() < -2 || ghost1.getyPosition() >= 478){
            JOptionPane.showMessageDialog(null,"Game over .... You hit a wall!");

            gameover();
        }
    }

    public void gameover(){

//        if(ghostKill() == true){
//           String pak1 = JOptionPane.showInputDialog("Please enter pak-man's name:");
//
//           String ghostName = JOptionPane.showInputDialog("Please enter ghost's name:");
//
//           JOptionPane.showMessageDialog(null,"Sorry " + pak1 + "but " + ghostName + "killed you");
//        }

       // else {

            String name = JOptionPane.showInputDialog("Please enter your name: ");

            JOptionPane.showMessageDialog(null, "Sorry " + name + " you lost ......");

        //}

        System.exit(0);
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
        //repaint();
        // yPosition +=  0;
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //System.out.println("key pressed");

        if( e.getKeyCode() == KeyEvent.VK_UP){

            pakman.setyPosition(pakman.getyPosition() - 10);
            pakman.setPakMan("images//up.png");
            while(true) {
                checkBoundaries();
                break;
            }
            //ghost1.setyPosition(ghost1.getyPosition() - 10);




        }

        else if( e.getKeyCode() == KeyEvent.VK_DOWN){
            //yPosition += -10;

            pakman.setyPosition(pakman.getyPosition() + 10);
            pakman.setPakMan("images//down.png");
            while(true) {
                checkBoundaries();
                break;
            }
            //ghost1.setyPosition(ghost1.getyPosition() + 10);

        }

        else if( e.getKeyCode() == KeyEvent.VK_RIGHT){

            pakman.setxPosition(pakman.getxPosition() + 10);
            pakman.setPakMan("images//right.png");
            while(true) {
                checkBoundaries();
                break;
            }

            //ghost1.setxPosition(ghost1.getxPosition() + 10);

        }

        else if( e.getKeyCode() == KeyEvent.VK_LEFT){
            //xPosition += -10;

            pakman.setxPosition(pakman.getxPosition() - 10);
            pakman.setPakMan("images//left.png");
            while(true) {
                checkBoundaries();
                break;
            }
            //ghost1.setxPosition(ghost1.getxPosition() - 10);


        }

        if(e.getKeyCode()  == KeyEvent.VK_W){
            ghost1.setyPosition(ghost1.getyPosition()-10);
            ghost1.setGhost("images//ghostup.png");
            while(true) {
                checkBoundaries();
                break;
            }
        }

        else if(e.getKeyCode() == KeyEvent.VK_S){
            ghost1.setyPosition(ghost1.getyPosition()+ 10);
            ghost1.setGhost("images//ghostdown.png");
            while(true) {
                checkBoundaries();
                break;
            }
        }

        else if(e.getKeyCode() == KeyEvent.VK_D){
            ghost1.setxPosition(ghost1.getxPosition()+ 10);
            ghost1.setGhost("images//ghostright.png");
            while(true) {
                checkBoundaries();
                break;
            }
        }

        else if(e.getKeyCode()  == KeyEvent.VK_A){
            ghost1.setxPosition(ghost1.getxPosition()- 10);
            ghost1.setGhost("images//ghostleft.png");
            while(true) {
                checkBoundaries();
                break;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

        //System.out.println("hi");

        if(e.getKeyCode() == KeyEvent.VK_UP){
            //yPosition += 0;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            //yPosition += 0;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            //xPosition += 0;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            //xPosition += 0;
        }

    }



}
