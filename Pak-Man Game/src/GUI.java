//Created by Petrit Krasniqi

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JPanel implements ActionListener, KeyListener {


    //creating a JFrame called frame
    private JFrame frame = new JFrame("Pak-Man");


    private Characters pakmanCharacter = new Characters(10, 10, "images//right.png"); /* This is inserting an image onto the JFrame
                                                                                    I got help with this code from
                                                                                   https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel     */

    private Characters ghostCharacter = new Characters(900, 430, "images//ghostleft.png"); /* This is inserting an image onto the JFrame
                                                                                    I got help with this code from
                                                                                   https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel     */

    //// constructor
    public GUI() {

        //set the frame default properties -- got some help with this from the vehicle project


        frame.setLocation(120, 50);
        frame.setSize(1000, 560);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);


        pakmanCharacter.setName("Pacman");
        //pakManCharacter.setLayout(null);
        pakmanCharacter.setSize(pakmanCharacter.getPreferredSize());
        pakmanCharacter.setBackground(Color.BLACK);
        pakmanCharacter.setLocation(pakmanCharacter.getxPosition(), pakmanCharacter.getyPosition());
        ImageIcon img = new ImageIcon(pakmanCharacter.getImage());


        contentPane.add(pakmanCharacter);

        ghostCharacter.setName("Ghost");
        //ghostCharacter.setLayout(null);
        ghostCharacter.setSize(ghostCharacter.getPreferredSize());
        ghostCharacter.setBackground(Color.BLACK);
        ghostCharacter.setLocation(ghostCharacter.getxPosition(), ghostCharacter.getyPosition());

        contentPane.add(ghostCharacter);

        frame.addKeyListener(this);
        frame.getContentPane().add(contentPane);
        frame.setVisible(true);
    }


    public void checkBoundaries() {
        if (pakmanCharacter.getxPosition() < -1 || pakmanCharacter.getxPosition() >= 930 || pakmanCharacter.getyPosition() < -1 || pakmanCharacter.getyPosition() >= 456
                || ghostCharacter.getxPosition() < -1 || ghostCharacter.getxPosition() >= 930 || ghostCharacter.getyPosition() <= -2 || ghostCharacter.getyPosition() >= 455) {
            JOptionPane.showMessageDialog(null, "Game over .... You hit a wall!");

            gameover();
        }
    }

    public void gameover() {


        String name = JOptionPane.showInputDialog("Please enter your name: ");

        JOptionPane.showMessageDialog(null, "Sorry " + name + " you lost ......");

        System.exit(0);
    }


    /*This is a java paint method used to draw the images
    * I got help with this code from  https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
     */
    public void paint(Graphics g) {
        pakmanCharacter.drawCharacters(g);
        ghostCharacter.drawCharacters(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //System.out.println("key pressed");

        if (e.getKeyCode() == KeyEvent.VK_UP) {

            pakmanCharacter.setyPosition(pakmanCharacter.getyPosition() - 12);
            pakmanCharacter.setImage("images//up.png");
            while (true) {
                checkBoundaries();
                break;
            }


        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {


            pakmanCharacter.setyPosition(pakmanCharacter.getyPosition() + 12);
            pakmanCharacter.setImage("images//down.png");
            while (true) {
                checkBoundaries();
                break;
            }


        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            pakmanCharacter.setxPosition(pakmanCharacter.getxPosition() + 12);
            pakmanCharacter.setImage("images//right.png");
            while (true) {
                checkBoundaries();
                break;
            }


        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //xPosition += -10;

            pakmanCharacter.setxPosition(pakmanCharacter.getxPosition() - 12);
            pakmanCharacter.setImage("images//left.png");
            while (true) {
                checkBoundaries();
                break;
            }
            //ghost1.setxPosition(ghost1.getxPosition() - 10);


        }

        if (e.getKeyCode() == KeyEvent.VK_W) {
            ghostCharacter.setyPosition(ghostCharacter.getyPosition() - 12);
            ghostCharacter.setImage("images//ghostup.png");
            while (true) {
                checkBoundaries();
                break;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            ghostCharacter.setyPosition(ghostCharacter.getyPosition() + 12);
            ghostCharacter.setImage("images//ghostdown.png");
            while (true) {
                checkBoundaries();
                break;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            ghostCharacter.setxPosition(ghostCharacter.getxPosition() + 12);
            ghostCharacter.setImage("images//ghostright.png");
            while (true) {
                checkBoundaries();
                break;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            ghostCharacter.setxPosition(ghostCharacter.getxPosition() - 12);
            ghostCharacter.setImage("images//ghostleft.png");
            while (true) {
                checkBoundaries();
                break;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {


        if (e.getKeyCode() == KeyEvent.VK_UP) {

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        }

    }


}
