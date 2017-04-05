// WordSearch
// Hamandishe Mathivha
// 20 October 2016
// 08:37

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WordSearch extends JFrame implements ActionListener 
{
   private String pattern;
   private JTextArea MatchesArea;
   
   public WordSearch()
   {
      // seting up window
      super("Word Puzzle Solver");
      this.setSize(600, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BorderLayout());
      
      // PatternPanel
      JPanel PatternPanel = new JPanel();
      PatternPanel.setLayout(new FlowLayout());
      
      JLabel PatternLabel = new JLabel("Pattern");
      
      
      JTextField PatternField = new JTextField(30);
      PatternField.addActionListener(this);
      
      PatternPanel.add(PatternLabel);
      PatternPanel.add(PatternField);
      
      this.add(PatternPanel, BorderLayout.NORTH);
      
      // MatchesPanel
      JPanel MatchesPanel = new JPanel();
      MatchesPanel.setLayout(new FlowLayout());
      
      JLabel MatchesLabel = new JLabel("Matches");
      MatchesArea = new JTextArea(20, 30);
      MatchesArea.setLineWrap(true);
      
      JScrollPane MatchesScroll = new JScrollPane(MatchesArea);
      
      MatchesPanel.add(MatchesLabel);
      MatchesPanel.add(MatchesScroll);
      
      this.add(MatchesPanel, BorderLayout.CENTER);
      
   }
   
   public void actionPerformed(ActionEvent event)
   {
      Pattern pattern = new Pattern(event.getActionCommand());
      String output = "";
      
      
      try
      {
         WordList wl = WordList.readFromFile("dictionary.txt");
         
         
         for (Word w : wl)
         {
            if(pattern.matches(w))
            {
               output += w.toString() + "\n";
            }
         }
         
         //MatchesArea = new JTextArea(20, 30);
         MatchesArea.setText(output);
      }
      catch (IOException e)
      {
         System.out.println("Mistake happened");
      }
      
   }
   
   // main
   public static void main(String[] args)
   {
      WordSearch gui = new WordSearch();
      gui.setVisible(true);
   }
   
}
      
      
        
      
      
      
      
      
      