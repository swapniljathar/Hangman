// HangmanSetUp
// Hamndishe Mathivha
// 20 October 2016
// 17:50

import javax.swing.*;import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HangmanSetUp extends JFrame implements ActionListener 
{
   
    public HangmanSetUp()
    {
      super("HangmanSetUp");
      this.setSize(300, 150);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new GridLayout(2,1));
      
      // text panel
      JPanel textPanel = new JPanel();
      JLabel text = new JLabel("Choose your difficulty");
      
      textPanel.add(text);
      
      // button panel
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(1, 3));
      
      // buttons
      JButton easyButton = new JButton("EASY");
      easyButton.addActionListener(this);
      buttonPanel.add(easyButton);
      
      JButton mediumButton = new JButton("MEDIUM");
      mediumButton.addActionListener(this);
      buttonPanel.add(mediumButton);
      
      JButton hardButton = new JButton("HARD");
      hardButton.addActionListener(this); 
      buttonPanel.add(hardButton);
      
      this.add(textPanel);
      this.add(buttonPanel);
      textPanel.setBackground(Color.BLUE);
      buttonPanel.setBackground(Color.BLUE);
   }
   
   public void actionPerformed(ActionEvent event)
   {
      String button  = event.getActionCommand();
      
      Hangman game = new Hangman(button);
      
      game.setVisible(true);
   }
   
}
   
      
      
      
      
      
      