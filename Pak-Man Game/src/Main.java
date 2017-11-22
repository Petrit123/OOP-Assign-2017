import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    private JFrame menu = new JFrame("Pak-Man");

    public Main(){

        menu.setLocation(450, 200);
        menu.setSize(1000, 560);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel(new ImageIcon("images//pak-man.jpg"));
        label.setSize(1000,560);
        label.setLocation(0,0);

        JButton playGame = new JButton("Play Game");
        JButton howToPlay = new JButton("How To Play");

        playGame.setFont(new Font("Impact",Font.PLAIN,40));
        playGame.setSize(300,50);
        playGame.setLocation(490,80);
        playGame.setBackground(Color.GREEN);
        playGame.setForeground(Color.black);

        howToPlay.setFont(new Font("Impact",Font.PLAIN,40));
        howToPlay.setSize(300,50);
        howToPlay.setLocation(710,470);
        howToPlay.setBackground(Color.green);
        howToPlay.setForeground(Color.BLACK);

        playGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                    GUI test = new GUI();


            }
        });

        howToPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("How To Play")){
                    JOptionPane.showMessageDialog(null,"This is a two player game where one player must avoid the ghost and collect as much coins as possible");
                }
            }
        });


        menu.setLayout(null);
        menu.add(label);
        menu.setVisible(true);
        menu.add(playGame);
        menu.add(howToPlay);
    }
}
