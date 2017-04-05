// practice
// Hamandishe Mathivha
// 20 October 2016
// 19:50

import java.io.*;

public class Practice
{
   public static void main(String[] args)
   {
      int n = 0;
      String lett;
      
      try
      {
         WordList wl = WordList.readFromFile("dictionary.txt");
         
         
         for (Word w : wl)
         {
            n += 1;
            lett = Integer.toString(n) + "." + w;
            
            System.out.println(lett);
         }
         
      }
      catch (IOException e)
      {
         System.out.println("Mistake happened");
      }
      
   }
} 