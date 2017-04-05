// Hangman
// Hamandishe Mathivha
// 20 October 2016
// 17:31

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Hangman extends JFrame implements ActionListener 
{
   private String difficulty;
   int guesses;
   private JLabel picLabel = new JLabel();
   private String word;
   private String secretDisplay = "";
   private JPanel outputPanel;
   private char[] guessedLetters;
   private JTextField secret;
   private JPanel guessPanel;
   //private JLabel options;
   //private JLabel available;
   private JPanel miniPanel;
   private JTextField input;
   
   public Hangman(String difficulty)
   {
      super("Hangman");
      
      this.difficulty = difficulty;
      intializeWord();
      
      // functionality
      if(difficulty.equals("EASY"))
      {
         guesses = 10;
      }
      else if(difficulty.equals("MEDIUM"))
      {
         guesses = 6;
      }
      else if(difficulty.equals("HARD"))
      {
         guesses = 3;
      }
      else
         System.out.println("ERROR OCCURED");
   
      this.setSize(800, 500);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BorderLayout());
      
      
      // guess panel
      this.guessPanel = new JPanel();
      this.guessPanel.setLayout(new FlowLayout());
      
      JLabel guessLabel = new JLabel("Guess a letter:");
      guessPanel.add(guessLabel);
      
      input = new JTextField(30);
      input.addActionListener(this);
      guessPanel.add(input);
      
      
      // output panel
      this.outputPanel = new JPanel();
      this.outputPanel.setLayout(new FlowLayout());
      
      //mini panel
      miniPanel = new JPanel();
      miniPanel.setLayout(new GridLayout(3, 1));
      
      this.secret = new JTextField(this.word.length());
      
      for (int i = 0; i < this.word.length(); i++)
      {
         char c = this.word.charAt(i);
         
         if(Character.isLetter(c))
            this.secretDisplay += "_";
         else
            this.secretDisplay += Character.toString(c);            
      }   
         
      this.secret.setText(this.secretDisplay);
      this.secret.setEditable(false);
      
   
      //options = new JLabel("a b c d e f g h i j k l m n o p q r s t u v w x y z");
      //available = new JLabel("Available letters");
      
      miniPanel.add(this.secret);
      //miniPanel.add(available);
      //miniPanel.add(options);
      
      miniPanel.setBackground(Color.GREEN);
      
      outputPanel.add(miniPanel);
      updatePic();
      
      outputPanel.setBackground(Color.GREEN);
      guessPanel.setBackground(Color.GREEN);
      
      this.add(outputPanel, BorderLayout.CENTER);
      this.add(guessPanel, BorderLayout.SOUTH);
      
      
      

   }
   
   public void updatePic()
   {
      String iconName = "";
      if(guesses == 10)
         iconName = "state1.GIF";
      else if(guesses == 9)
         iconName = "state2.GIF";
      else if(guesses == 8)
         iconName = "state3.GIF";
      else if(guesses == 7)
         iconName = "state4.GIF";
      else if(guesses == 6)
         iconName = "state5.GIF";
     else if(guesses == 5)
        iconName = "state6.GIF";
     else if(guesses == 4)
         iconName = "state7.GIF";
     else if(guesses == 3)
         iconName = "state8.GIF";
     else if(guesses == 2)
         iconName = "state9.GIF";
     else if(guesses == 1)
         iconName = "state10.GIF";
     else if(guesses == 0)
     {
         iconName = "state11.GIF";
         guessPanel.setVisible(false);
         
         ImageIcon youlose = new ImageIcon("youlose.png");
         JLabel Lose = new JLabel(youlose, SwingConstants.CENTER);
         
         this.add(Lose, BorderLayout.SOUTH);
         
         LoseWindow loss = new LoseWindow(this.word);
         loss.setVisible(true);
     }
     else
     {
         System.out.println("Error occurred");
     }
         
     
     this.picLabel.setVisible(false);
     
     ImageIcon icon = new ImageIcon(iconName);
     picLabel = new JLabel(icon, SwingConstants.CENTER);
     this.outputPanel.add(picLabel);
     
     this.guesses -= 1; 
     
   }
   
   public void intializeWord()
   {
      Random rand = new Random();
      
      int r = rand.nextInt(77613);
      
         try
         {
            WordList wl = WordList.readFromFile("dictionary.txt");
            
            String initword = "";
            boolean wordValid = true;
            
            Iterator it = wl.iterator(); 
            
            int i = 0;
            
            while(i < r)
            {
               initword = it.next().toString();
               i += 1;
            }
            
            this.word = initword;
            this.guessedLetters = new char[this.word.length()];
               
         }
         catch (IOException e)
         {
            System.out.println("Mistake happened");
         } 
   
   }
   
   public void actionPerformed(ActionEvent event)
   {
      String entry = event.getActionCommand();
      String temp = "";
      
      
      if(entry.length() == 1)
      {
         char c = entry.charAt(0);
         
         
         if(Character.isLetter(c))
         {
            if(this.word.indexOf(c) >= 0 && this.secretDisplay.indexOf(c) == -1)
            {
               for(int i = 0; i < this.word.length(); ++i)
               {
                  if(this.word.charAt(i) != this.secretDisplay.charAt(i) && this.word.charAt(i) == c)
                  {
                  
                     temp += Character.toString(c);
                  }
                  else
                  {
                 
                     temp += Character.toString(this.secretDisplay.charAt(i));
                  }  
                  
               }
               
               this.secretDisplay = temp;
               this.secret.setText(this.secretDisplay);
               
               
                 
            }
            else if(this.word.indexOf(c) >= 0 && this.secretDisplay.indexOf(c) >= 0)
            {
               // insert label that says "You're guess
               
            
            
            }
            else
            {
               updatePic();
               
            }
         }
         
         else
         {
            

         }
         
         this.input.setText("");
         
         
      }
      else
      {
         
         
      }
      
      if(this.word.equals(this.secretDisplay))
      {
         String iconName = "state11.GIF";
         guessPanel.setVisible(false);
         
         ImageIcon youwin = new ImageIcon("youwin.png");
         JLabel Win = new JLabel(youwin, SwingConstants.CENTER);
         
         this.add(Win, BorderLayout.SOUTH);
         
         WinWindow gui = new WinWindow();
         gui.setVisible(true);
      }

   }
   
   public static void main(String[] args)
   {
      HangmanSetUp gui = new HangmanSetUp();
      gui.setVisible(true);
   }
}
   
      