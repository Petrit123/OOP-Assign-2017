import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

//JB - This class enables the use of key-bindings to link certain key presses with certain components
//on a GUI and, through the use of a HashMap data structure, keeps track of all the key presses/releases
//that have occurred, overcoming the issue with the KeyListener class where multiple simultaneous
//key presses cause known problems and mess up multi-player games

public class KeyboardAnimation implements ActionListener
{
    private final static String PRESSED = "pressed ";
    private final static String RELEASED = "released ";

    private JComponent component;
    private  Timer timer;
    private Map<String, Point> pressedKeys = new HashMap<String, Point>();
    boolean gameOn = true;


    public KeyboardAnimation(JComponent component, int delay)
    {
        this.component = component;

        timer = new Timer(delay, this);
        timer.setInitialDelay( 0 );
    }

    /*
    *  &param keyStroke - see KeyStroke.getKeyStroke(String) for the format of
    *                     of the String. Except the "pressed|released" keywords
    *                     are not to be included in the string.
    */
    public void addAction(String keyStroke, int deltaX, int deltaY)
    {
        //  Separate the key identifier from the modifiers of the KeyStroke

        int offset = keyStroke.lastIndexOf(" ");
        String key = offset == -1 ? keyStroke :  keyStroke.substring( offset + 1 );
        String modifiers = keyStroke.replace(key, "");

        //  Get the InputMap and ActionMap of the component

        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();

        //  Create Action and add binding for the pressed key

        Action pressedAction = new AnimationAction(key, new Point(deltaX, deltaY));
        String pressedKey = modifiers + PRESSED + key;
        KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(pressedKey);
        inputMap.put(pressedKeyStroke, pressedKey);
        actionMap.put(pressedKey, pressedAction);

        //  Create Action and add binding for the released key

        Action releasedAction = new AnimationAction(key, null);
        String releasedKey = modifiers + RELEASED + key;
        KeyStroke releasedKeyStroke = KeyStroke.getKeyStroke(releasedKey);
        inputMap.put(releasedKeyStroke, releasedKey);
        actionMap.put(releasedKey, releasedAction);
    }

    //  Invoked whenever a key is pressed or released

    private void handleKeyEvent(String key, Point moveDelta)
    {
        //  Keep track of which keys are pressed
        //System.out.println("Key pressed");

        if (moveDelta == null)
            pressedKeys.remove( key );
        else
            pressedKeys.put(key, moveDelta);

        //  Start the Timer when the first key is pressed

        if (pressedKeys.size() == 1)
        {
            timer.start();
        }

        //  Stop the Timer when all keys have been released

        if (pressedKeys.size() == 0)
        {
            timer.stop();
        }

        //added by JB - alter image on Pacman when left arrow key is pressed
        if(key.equals("LEFT"))
        {
            //System.out.println(component.getClass());

            Images p = (Images) component;
            p.setPakManImageFile("images//left.png");
        }

        else if(key.equals("RIGHT"))
        {
            //System.out.println(component.getClass());

            Images p = (Images) component;
            p.setPakManImageFile("images//right.png");
        }

        else if(key.equals("UP"))
        {
            //System.out.println(component.getClass());

            Images p = (Images) component;
            p.setPakManImageFile("images//up.png");
        }

        else if(key.equals("DOWN"))
        {
            //System.out.println(component.getClass());

            Images p = (Images) component;
            p.setPakManImageFile("images//down.png");
        }

        else if(key.equals("W"))
        {
            //System.out.println(component.getClass());

            Images g = (Images) component;
            g.setPakManImageFile("images//ghostup.png");
        }

        else if(key.equals("S"))
        {
            //System.out.println(component.getClass());

            Images g = (Images) component;
            g.setPakManImageFile("images//ghostdown.png");
        }

        else if(key.equals("D"))
        {
            //System.out.println(component.getClass());

            Images g = (Images) component;
            g.setPakManImageFile("images//ghostright.png");
        }

        else if(key.equals("A"))
        {
            //System.out.println(component.getClass());

            Images g = (Images) component;
            g.setPakManImageFile("images//ghostleft.png");
        }


    }



    //  Invoked when the Timer fires

    public void actionPerformed(ActionEvent e)
    {
        moveComponent();
    }

    //  Move the component to its new location

    private void moveComponent()
    {
        //if(component.getName().equals("Pacman"))
        //	System.out.println("Pacman being moved!!!");

        //added by JB to make sure game ends when wall it hit, based on your checkBoundaries() method

        Dimension parentSize = component.getParent().getSize(); //the containing JPanel (the main content-pane) for this component is the "parent" here
        int parentWidth  = parentSize.width;
        int parentHeight = parentSize.height;

        if(component.getLocation().getX() <= 0 || component.getLocation().getX() >= parentWidth - component.getSize().width || component.getLocation().getY() <= 0 || component.getLocation().getY() >= parentHeight - component.getSize().height)
        {



            JOptionPane.showMessageDialog(null,"Game over .... You hit a wall!");

            gameOn = false; //make the game stop using a boolean (otherwise key presses keep getting handled)

            GUI.endGame(); //calling your endGame() method (made it static to be able to access it)

            timer.stop();

        }

            GUI.collisionCheck();

            GUI.addHighScore();

            GUI.ghostCoinCheck();


        //  Calculate new move based on the sum of the X and Y delta values

        int deltaX = 0;
        int deltaY = 0;

        for (Point delta : pressedKeys.values())
        {
            deltaX += delta.x;
            deltaY += delta.y;
        }

        //Determine the next X and Y positions for this component

        int nextX = (int)component.getLocation().getX() + deltaX;

        int nextY = (int)component.getLocation().getY() + deltaY;

        component.setLocation(nextX, nextY); // now move the component to the appropriate place


    }


    //  Action to keep track of the key and a Point to represent the movement
    //  of the component. A null Point is specified when the key is released.

    private class AnimationAction extends AbstractAction implements ActionListener
    {
        private Point moveDelta;

        public AnimationAction(String key, Point moveDelta)
        {
            super(key);
            //System.out.println("AnimationAction called");

            this.moveDelta = moveDelta;
        }

        public void actionPerformed(ActionEvent e)
        {
            if(gameOn) //added by JB - stop handling any key presses once game is over
                handleKeyEvent((String)getValue(NAME), moveDelta);
        }


    }
}
