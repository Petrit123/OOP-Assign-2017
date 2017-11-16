//Created by Petrit Krasniqi

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel /*implements ActionListener, KeyListener*/ {


        //creating a JFrame called frame
        private JFrame frame = new JFrame("Pak-Man");


        private PakMan pakman = new PakMan(10, 10, "images//right.png"); /* This is inserting an image onto the JFrame
                                                                                    I got help with this code from
                                                                                   https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel     */

        private PakMan ghost = new PakMan(900,430,"images//ghostright.png");


    //// constructor
    public GUI() {

        //set the frame default properties -- got some help with this from the vehicle project

        frame.setLocation(450, 200);
        frame.setSize(1000, 560);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);


        /*JLabel pakManLabel = new JLabel(new ImageIcon("images//right.png"));
        pakManLabel.setName("Ghost");
        pakManLabel.setSize( pakManLabel.getPreferredSize() );
        pakManLabel.setLocation(10, 10);

        contentPane.add( pakManLabel );*/

        pakman.setName("Pacman");
        pakman.setLayout(null);
        pakman.setSize(pakman.getPreferredSize());
        pakman.setBackground(Color.BLACK);
        pakman.setLocation(pakman.getxPosition(), pakman.getyPosition());



        contentPane.add(pakman);

        ghost.setName("Ghost");
        ghost.setLayout(null);
        ghost.setSize(ghost.getPreferredSize());
        ghost.setBackground(Color.BLACK);
        ghost.setLocation(ghost.getxPosition(), ghost.getyPosition());


        /*JLabel ghostLabel = new JLabel( new ImageIcon("images//ghostleft.png"));
        ghostLabel.setName("Ghost");
        ghostLabel.setSize( ghostLabel.getPreferredSize() );
        ghostLabel.setLocation(900, 430);
        contentPane.add( ghostLabel );*/


        contentPane.add(ghost);



        //Added by JB to solve the issue which exists when using multiple key-presses with the KeyListener interface
        //This solution uses what are called "key-bindings" through a class called KeyboardAnimation
        //The animation of pacman is associated with the arrow keys (the numbers listed are x/y delta values which
        //decide how many pixels pacman will move each time he is drawn on screen)
        //Its a similar story for the ghost component

        KeyboardAnimation pacManAnimation = new KeyboardAnimation(pakman, 24);

        pacManAnimation.addAction("LEFT", -3,  0);
        pacManAnimation.addAction("RIGHT", 3,  0);
        pacManAnimation.addAction("UP",    0, -3);
        pacManAnimation.addAction("DOWN",  0,  3);

        KeyboardAnimation ghostAnimation = new KeyboardAnimation(ghost, 24);

        ghostAnimation.addAction("A", -3,  0);
        ghostAnimation.addAction("D",  3,  0);
        ghostAnimation.addAction("W",  0, -3);
        ghostAnimation.addAction("S",  0,  3);


        frame.getContentPane().add(contentPane);
        frame.setVisible(true);






    }



//    public void checkBoundaries() {
//        if (pakmanCharacter.getxPosition() < -1 || pakmanCharacter.getxPosition() >= 930 || pakmanCharacter.getyPosition() < -1 || pakmanCharacter.getyPosition() >= 456
//                || ghostCharacter.getxPosition() < -1 || ghostCharacter.getxPosition() >= 930 || ghostCharacter.getyPosition() <= -2 || ghostCharacter.getyPosition() >= 455) {
//            JOptionPane.showMessageDialog(null, "Game over .... You hit a wall!");
//
//            gameover();
//        }
//    }
//
    public static void gameover() {


        String name = JOptionPane.showInputDialog("Please enter your name: ");

        JOptionPane.showMessageDialog(null, "Sorry " + name + " you lost ......");

        System.exit(0);
    }
//
//
//    /*This is a java paint method used to draw the images
//    * I got help with this code from  https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
//     */
//    public void paint(Graphics g) {
//        pakmanCharacter.drawCharacters(g);
//        ghostCharacter.drawCharacters(g);
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//        //System.out.println("key pressed");
//
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//
//            pakmanCharacter.setyPosition(pakmanCharacter.getyPosition() - 12);
//            pakmanCharacter.setImage("images//up.png");
//            while (true) {
//                checkBoundaries();
//                break;
//            }
//
//
//        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//
//
//            pakmanCharacter.setyPosition(pakmanCharacter.getyPosition() + 12);
//            pakmanCharacter.setImage("images//down.png");
//            while (true) {
//                checkBoundaries();
//                break;
//            }
//
//
//        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//
//            pakmanCharacter.setxPosition(pakmanCharacter.getxPosition() + 12);
//            pakmanCharacter.setImage("images//right.png");
//            while (true) {
//                checkBoundaries();
//                break;
//            }
//
//
//        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            //xPosition += -10;
//
//            pakmanCharacter.setxPosition(pakmanCharacter.getxPosition() - 12);
//            pakmanCharacter.setImage("images//left.png");
//            while (true) {
//                checkBoundaries();
//                break;
//            }
//            //ghost1.setxPosition(ghost1.getxPosition() - 10);
//
//
//        }
//
//        if (e.getKeyCode() == KeyEvent.VK_W) {
//            ghostCharacter.setyPosition(ghostCharacter.getyPosition() - 12);
//            ghostCharacter.setImage("images//ghostup.png");
//            while (true) {
//                checkBoundaries();
//                break;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_S) {
//            ghostCharacter.setyPosition(ghostCharacter.getyPosition() + 12);
//            ghostCharacter.setImage("images//ghostdown.png");
//            while (true) {
//                checkBoundaries();
//                break;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_D) {
//            ghostCharacter.setxPosition(ghostCharacter.getxPosition() + 12);
//            ghostCharacter.setImage("images//ghostright.png");
//            while (true) {
//                checkBoundaries();
//                break;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_A) {
//            ghostCharacter.setxPosition(ghostCharacter.getxPosition() - 12);
//            ghostCharacter.setImage("images//ghostleft.png");
//            while (true) {
//                checkBoundaries();
//                break;
//            }
//        }
//
//        repaint();
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//
//        }
//
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//
//        }
//
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//
//        }
//
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//
//        }
//
//    }


}
