import Animals.Zoo;

import javax.swing.*;

public class App
{
    public static void main( String[] args )
    {
        JFrame frame1 = new MainForm();
        frame1.setLocationRelativeTo ( null );
        frame1.setVisible(true);
        Zoo ab = new Zoo();
    }

}
