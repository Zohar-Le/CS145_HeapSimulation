import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Main class to display GUI to interact with card objects
 * @author Zohar Le
 * @version 1
 */
public class Main implements ActionListener {
   private JFrame frame;
   private JButton addButton;
   private JButton popButton;
   private JButton clearButton;
   private JLabel cardLabel;
   private JLabel lastRemovedLabel;
   private JLabel removedCardLabel;
   private CardHeap cards;
   /**
   * This is the main method.
   * @param args OS 
   */
   public static void main(String[] args) 
   {
      Main run = new Main();
   }
   /**
   * This is the default constructor.
   */
   public Main() {
      cards = new CardHeap();
      setUpGUI();      
   }
   private void setUpGUI() 
   {
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("CS 145 GUI Assignment - Truong Le");
      frame.setSize(new Dimension(750, 225));
      frame.setLocation(new Point(400, 200)); 
      frame.setLayout(null);
      frame.setVisible(true);
      // Add button
      addButton = new JButton();
      addButton.setText("Add");
      addButton.setBounds(20,100,150, 25);
      addButton.addActionListener(this);
      addButton.setActionCommand("add");
      addButton.setBackground(Color.GREEN);
      // Pop button
      popButton = new JButton();
      popButton.setText("Pop");
      popButton.setBounds(170,100,150, 25);
      popButton.addActionListener(this);
      popButton.setActionCommand("pop");
      popButton.setBackground(Color.RED);
      // Clear button
      clearButton = new JButton();
      clearButton.setText("Clear");
      clearButton.setBounds(320,100,150, 25);
      clearButton.addActionListener(this);
      clearButton.setActionCommand("clear");
      clearButton.setBackground(Color.GRAY);
      
      cardLabel = new JLabel();
      cardLabel.setText(cards.toString());
      cardLabel.setBounds(60, 30, 1000, 25);
      
      lastRemovedLabel = new JLabel();
      lastRemovedLabel.setText("Last Removed: ");
      lastRemovedLabel.setBounds(60, 60, 110, 25);
      
      removedCardLabel = new JLabel();
      removedCardLabel.setText("");
      removedCardLabel.setBounds(150, 60, 100, 25);
      
      frame.add(addButton);
      frame.add(popButton);
      frame.add(clearButton);
      frame.add(cardLabel);
      frame.add(lastRemovedLabel);
      frame.add(removedCardLabel);
   }
   /**
    * Performing the events */
   public void actionPerformed(ActionEvent e) 
   { 
      if(e.getActionCommand().equals("add")) addPressed();
      else if(e.getActionCommand().equals("pop")) popPressed();
      else if(e.getActionCommand().equals("clear")) clearPressed();
   }
   // Adding a card
   private void addPressed() {
      cards.add(new Card());
      cardLabel.setText(cards.toString());
   }
   // Popping a card
   private void popPressed() {
      if(cards.size() > 0) 
      {
         Card removedCard = cards.remove();
         cardLabel.setText(cards.toString());
         removedCardLabel.setText(removedCard.toString());
      }
   }
   // Clear 
   private void clearPressed() 
   {
      cards.clear();
      cardLabel.setText(cards.toString());
      removedCardLabel.setText("CLEARED");
   }
}