import javax.swing.*;
import java.awt.*;


public class LearnGUI
{
   public static void main(String [] args)
   {
      JFrame myFrame = new JFrame();
      myFrame.setVisible(true);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setTitle("FIRST GUI PROGRAM");
      myFrame.setSize(new Dimension(800,500));
      myFrame.setLocation(50, 50);
      myFrame.setBackground(Color.RED);
      myFrame.setResizable(false);
      //
      JButton button1 = new JButton();
      button1.setText("Press me");
      myFrame.add(button1);
      
      JButton button2 = new JButton();
      button2.setText("No!! Press me");
      myFrame.add(button2);
   }
}