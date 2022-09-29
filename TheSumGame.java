import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TheSumGame implements ActionListener
{
   private static final int EASYMODE = 10;
   private static final int HARDMODE = 1000;
   
   private JFrame mainFrame = null;
   private JLabel label1 = null;
   private JLabel label2 = null;
   private JLabel label3 = null;
   private JLabel label4 = null;
   private JLabel label5 = null;
   private JLabel label6 = null;
   private JButton guessButton = null;
   private JTextField answerField = null;
   
   private JCheckBox hardMode = null;
   
   private Random rand;
   private int num1;
   private int num2;
   private int answer;
   private int score;
   
   private ArrayList<Integer> answers;

   public static void main(String[] args)
   {
      TheSumGame x = new TheSumGame();
   }
   
   public TheSumGame()
   {
      answers = new ArrayList<Integer>();
      
      rand = new Random();
      num1 = rand.nextInt(EASYMODE);    
      num2 = rand.nextInt(EASYMODE);
      answer = num1 + num2;
      
      score = 0;
      setupFrame();
      mainFrame.setVisible(true);
   }
   
   public void setupFrame()
   {
      mainFrame = new JFrame();
      mainFrame.setTitle("Guessing Game");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(new Dimension(500,700));
      mainFrame.setLocation(new Point(1000,100));
      mainFrame.setLayout(null);
      
      hardMode = new JCheckBox();
      hardMode.setBounds(300, 10, 25,25);
      hardMode.addActionListener(this);
      mainFrame.add(hardMode);
      
      label1 = new JLabel();
      label1.setText("What the is the sum of:");
      label1.setBounds(10,10,200,25);
      mainFrame.add(label1);
      
      label2 = new JLabel();
      label2.setText("" + num1);
      label2.setBounds(10,35,50,25);
      mainFrame.add(label2);

      label3 = new JLabel();
      label3.setText("+");
      label3.setBounds(70,35,20,25);
      mainFrame.add(label3);
      
      label4 = new JLabel();
      label4.setText("" + num2);
      label4.setBounds(100,35,200,25);
      mainFrame.add(label4);
      
      guessButton = new JButton();
      guessButton.setText("Guess");
      guessButton.setBounds(50, 70, 100,25);
      guessButton.addActionListener(this);
      mainFrame.add(guessButton);
      
      answerField = new JTextField();
      answerField.setText("Put answer here");
      answerField.setBounds(50,105,100,25);
      mainFrame.add(answerField);
      
      label5 = new JLabel();
      label5.setText("Score: ");
      label5.setBounds(0, 140, 100, 25);
      mainFrame.add(label5);
      
      label6 = new JLabel();
      label6.setText("0");
      label6.setBounds(110, 140, 100, 25);
      mainFrame.add(label6);
      
   }
   
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == guessButton) guessPressed();
      if (e.getSource() == hardMode) resetQuestion();
      
   }
   
   private void guessPressed()
   {
    
     String ans = answerField.getText();
     int possibleAns = -1;
     try
     {
        possibleAns = Integer.parseInt(ans);
     }
     catch (Exception e)
     {
        possibleAns = -1;
     }
     
     if (possibleAns == answer)
     {
         score++;
     }
     else
     {
         score--;
         
     }
     label6.setText("" + score);
     resetQuestion();
      

   }
   
   private void resetQuestion()
   {
      if (!hardMode.isSelected())
      {
         num1 = rand.nextInt(EASYMODE);    
         num2 = rand.nextInt(EASYMODE);
      }
      else
      {
         num1 = rand.nextInt(HARDMODE);    
         num2 = rand.nextInt(HARDMODE);
      }
      answer = num1 + num2;
      
      label2.setText("" + num1);
      label4.setText("" + num2);
   }
}