import java.net.*; // for image
import javax.swing.*; // for image
import java.util.Random; //for randum numbers 
import javax.swing.JOptionPane; // for the joption pane

public class A9d_Cipher_EmadGailani_v1 // class name
{ // begining of the program
// main method 
  public static void main(String[] args)throws Exception // throws exception is for images
  { // beginning of the main  progrma
    int anotherTime= 0;
    int play=0;
    String[] begin = { "Begin" , "About" , "Exit"};
 
    do // do for the whole program
    { // beginning of do
      // the introduction screen
      final ImageIcon icon = new ImageIcon(new URL("http://jeremykun.files.wordpress.com/2012/01/cipher_jefferson.jpg")); // photo 
      play = JOptionPane.showOptionDialog(null, "" , "The Cipher Program" ,0,JOptionPane.QUESTION_MESSAGE, icon, begin, 0);
      // switch for the method of the intruduction
      switch (play) 
      { // begin of swith    
        case 0:
          begin();
          break; 
        case 1:
          about();
          break; 
        default:
          JOptionPane.showMessageDialog(null, "Bye");
          return;
      }
      
    }while(anotherTime==0);// end of do 
    JOptionPane.showMessageDialog(null, "Bye");
  } // end of the main method

// about method to tell the user about the program  
  public static void  about() 
  {
    JOptionPane.showMessageDialog(null, "this program have to modes:\n\n 1.Incode:\n    In this mode you will give a word and the pattrenand then\nthe program will give you a your word but bettween the word there will be\nrandum letter accourding to the patterb you give.\n\nDecode:\n   In this mode you will give secret word and a pattern, after you give the pattern\nthe program will eliminate pattern from the word and give you the secret word\n\nThats is, the maker of the program is Emad Al-Gailani ");
    return;
  }
  
// method to begin the program and ask him for decode and incode   
  public static void  begin() 
  {
    String[]what ={"Incode", "Decode",};
    int choose=0;
    //asking the user to pick what he wants
    choose = JOptionPane.showOptionDialog(null, "What do you want" , "choose" ,0,JOptionPane.QUESTION_MESSAGE, null, what, 0); 
    // switch for incode and decode method
    switch (choose) 
    { // begin of swith    
      case 0:
        encode();
        break; 
      case 1:
        decode();
        break; 
      default:
        System.out.println("bye");
        return;
    }
  } // end of begin method
  
  // the encode method
  public static void  encode() 
  {
    int pattern=0;
    int q = 0;
    // randum alphabet letters 
    final String alphabet = "ABCDEFGHIJKLMNOPQURSTUVWXYZ";
    final int N = alphabet.length(); // array for the alphabet letters
    //asking the user to input a word
    String userInput = JOptionPane.showInputDialog(null," please put the word");
    // asking the pattren with the ability to try and cathch
    do
    {
      try {
        String patternString = JOptionPane.showInputDialog(null," please put the pattern");
        pattern = Integer.parseInt(patternString);
      }
      // telling the user that he didnt input a number            
      catch ( Exception err ) {
        JOptionPane.showMessageDialog(null, "Invalied Input ","Try Again", JOptionPane.ERROR_MESSAGE,null); 
      }
    }while(pattern==0);
    Random rand = new Random(); // randum alpabet
    char[] array = new char[userInput.length() + pattern * (userInput.length() - 1 )]; // array for the final input
    String stringArray = ""; 
//go to each work one by one
    // for to put the randum letters in the correct order
    for(int i = 0; i < userInput.length()* 2 - 1; i++)
    {
      // if for the input
      if(i % 2 == 0)
      {
        array[q] = userInput.charAt(i/2);
        stringArray += userInput.charAt(i/2) + "";
        q++;
      }
        // else to apply the randum letter
      else
      { 
        for(int j = 0; j < pattern; j++)
        {
          array[q] = alphabet.charAt(rand.nextInt(N));
          stringArray += alphabet.charAt(rand.nextInt(N)) + "";
          q++; 
        }
      }
    }// end of main for     
    // giving the final result
    JOptionPane.showMessageDialog(null, stringArray.toUpperCase(), "The Incode word is", JOptionPane.INFORMATION_MESSAGE,null);
  } // end of method
  
// method for the decode option  
  public static void decode () 
  {
    int pattern2 =0;
    String stringArray ="";
    // asking to enter the word
    String userInput2 = JOptionPane.showInputDialog(null," please put the word");
    //asking the pattren with the ability if try and catche
    do
    {
      try {
        String patternString = JOptionPane.showInputDialog(null," please put the pattern");
        pattern2 = Integer.parseInt(patternString);
      }
      // telling the user that he didnt input a number            
      catch ( Exception err ) {
        JOptionPane.showMessageDialog(null, "Invalied Input ","Try Again", JOptionPane.ERROR_MESSAGE,null); 
      }
    }while(pattern2==0);
    
    char[] array2 = new char[((userInput2.length())- (pattern2-3))]; // the length of the array
    int j = 0; 
// for to input the word and missing the pattren    
    for(int i = 0; i <= userInput2.length(); i = i + (pattern2 + 1))
    {
      j++;
      array2[j] = userInput2.charAt(i);
      stringArray +=userInput2.charAt(i)+ "";
    }
    // final message and answer
    JOptionPane.showMessageDialog(null,stringArray.toUpperCase(), "The decode word is", JOptionPane.INFORMATION_MESSAGE,null);
  }// end decode method
}// end program