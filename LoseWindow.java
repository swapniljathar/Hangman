// lose window
// Hamandishe Mathivha
// 21 October 2016
// 10:59

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LoseWindow extends JFrame implements ActionListener
{
   public LoseWindow(String word)
   {
      super("You Lose");
      this.setSize(300, 150);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new GridLayout(2,1));
      
      // text panel
      JPanel textPanel = new JPanel();
      JLabel text = new JLabel("You lost :( \nThe word was " + word );
      
      textPanel.add(text);
      
      // button panel
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(1, 2));
      
      // buttons
      JButton playButton = new JButton("PLAY AGAIN");
      playButton.addActionListener(this);
      buttonPanel.add(playButton);
      
      JButton quitButton = new JButton("QUIT");
      quitButton.addActionListener(this);
      buttonPanel.add(quitButton);
      
      
      this.add(textPanel);
      this.add(buttonPanel);
   }
   
   public void actionPerformed(ActionEvent event)
   {
      String button  = event.getActionCommand();
      
      if(button.equals("PLAY AGAIN"))
      {
         HangmanSetUp gui = new HangmanSetUp();
         gui.setVisible(true);
      }
      else
         System.exit(0);
   }
   
}
