// CISP 401 Fall 2017 Brinder Dhaliwal SID # 1106290
//Assignment 5 Description......
// .........................................
// Write a JFrame app that plays "guess the number". Application chooses number at random between 1-1000.
//GuessGameFrame.java

import java.awt.FlowLayout;             //necessary classes imported from Java Api for dealing with JFrame Components
import java.awt.event.ActionListener;   
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;          //for guess text field
import javax.swing.JLabel;              //for prompt/message labels
import javax.swing.JButton;             //for new game button
import java.awt.Color;                  //needed for background changes
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;   //for mouse licks
import java.awt.event.MouseEvent;       
import java.util.Random;                //for generating random number
import java.util.ArrayList;             //for arraylist for guess tracker

public class GuessGameFrame extends JFrame  //extends JFrame, all variables and methods defined
{
    private JTextField guessInputJTextField;        //input field for user
    private final JLabel prompt1JLabel;     //guessing prompt
    private final JLabel prompt2JLabel;     //correct answer
    private final JLabel messageJLabel;     //too high,toolow,correct
    private final JButton newGameJButton;   //used for new game
    private String string;
    private int guess;                      //used when converting string to integer
    private int trialCount;                 //keeps track of number of trials
    private ArrayList<Integer> guessTracker = new ArrayList<Integer>();     //used for guessed number count
    private int guessCount;                 //used as second guesscounter
    private int n;                          //new random number is stored in n

    
    public GuessGameFrame()         //class GuessGameFrame constructor
    {
        super("Guessing Game");     //top of app
        setLayout(new FlowLayout());        //set layout type
        trialCount=1;                           //start trial count at 1
        getContentPane().setBackground(Color.MAGENTA);      //magenta first
        int [] guessTracker;            //array for arrayList 
        
        prompt1JLabel = new JLabel("I have a number between 1 and 1000.");  //construct label
        
        add(prompt1JLabel);         //add label to JFrame
        
        prompt2JLabel = new JLabel("Can you guess my number? Enter your first Guess: ");    //construct label
        add(prompt2JLabel);         //add prompt to JFrame
        
        guessInputJTextField = new JTextField(4);   //construct JTextField
        add(guessInputJTextField);                  //add to JFrame
        
        messageJLabel = new JLabel("Guess result appears here.");   //construct Label
        add(messageJLabel);                                         //add to JFrame
              
        newGameJButton = new JButton("New Game");               //construct button
        add(newGameJButton);                                    //add to JFrame

        GuessHandler handler = new GuessHandler();    //register event handlers
        guessInputJTextField.addActionListener(handler);        //for user input
   
        GuessHandler clicker = new GuessHandler();  //for mouse actions
        newGameJButton.addMouseListener(clicker);

        theGame();          //call theGame to generate new function

    }

        private class GuessHandler implements ActionListener, MouseListener  //private inner class for event handling
        {
            @Override                                           //process Guess Game events
            public void actionPerformed(ActionEvent event)
            {
            if (event.getSource() == guessInputJTextField)      //user pressed enter in input field
                for(int i=0;i<guessCount;i++)       
                   guessCount=0;                    //initialize guess count
                   guess = Integer.parseInt(guessInputJTextField.getText());      //assign entered number to guess
                {
                   guessTracker.add(guess);         //add each element to array list
                   guessCount++;                    //increament guessCount
                   react();                     //call react function to react to guess number entered
                }
            }
            
            @Override
            public void mouseClicked(MouseEvent event)      //case of a mouse event
            {
            if (event.getSource() == newGameJButton)        //case of user pressing new game button
               
              getContentPane().setBackground(Color.YELLOW); //set background to yellow
              guessInputJTextField.setText("");             //empty
              trialCount=1;
              prompt1JLabel.setText("I have a number between 1 and 1000.");
              prompt2JLabel.setText("Can you guess my number? Enter your first Guess: ");
              messageJLabel.setText("Guess result appears here.");
              theGame();                                // call to generate new random number
            }
            
            @Override                               //necessary when implementing mouse Listener /mouse event
            public void mouseExited(MouseEvent event)
            {
               String string = "";                  //setting empty string
            }
            
            @Override
            public void mouseEntered(MouseEvent event)  //necessary when implementing mouse Listener /mouse event
            {
               String string = "";
            }
           
            @Override
            public void mouseReleased(MouseEvent event) //necessary when implementing mouse Listener /mouse event
            {
               String string = "";
            }
            
            @Override
            public void mousePressed(MouseEvent event)  //necessary when implementing mouse Listener /mouse event
            {
               String string = "";
            }
            
        }        


    public void theGame()   //provides new random number
    {
        Random rand = new Random();     //uses random class from Java Api
        n = rand.nextInt(1000) + 1;     //range 1-1000
    }
    
    public GuessGameFrame react()           //react to new guess being entered 
    {      

        for (int i=0;i<guessTracker.size();i++)
        {
            prompt1JLabel.setText("Guessed Number(s): ");       //at this stage, number guessed should be displayed at top of window
            prompt1JLabel.setText(prompt1JLabel.getText() + guessTracker.get(i));   //use array list to get each guess 

        }
            trialCount++;                   //increment trial count
            prompt2JLabel.setText("Can you guess my number? Enter guess number " + trialCount +": ");   
            paint (n);                              //call paint to change background depending on high/low
                
            return null;
    }
    
    public GuessGameFrame paint (int n)         //changes JFrame background color
    {
        int diff;                               //my equivelent to lastDistance variables
        int Difference;
        
            if (guess > n)                      //if guess is larger than random number, change to red
            {
                messageJLabel.setText("The guess was too HIGH. Try a lower number.");
                getContentPane().setBackground(Color.RED);
                diff = guess - n;
                Difference = Math.abs(diff);
            } 
            else                                //too low, change to red
            {
                messageJLabel.setText("The guess was too LOW. Try a higher number.");
                getContentPane().setBackground(Color.RED);
                diff = n - guess;
                Difference = Math.abs(diff);

            }
            if (Difference >= 30 && guess < n)                  //way off, low
            {
                messageJLabel.setText("The guess was too LOW. Try a higher number.");
                getContentPane().setBackground(Color.ORANGE);       //change to orange

            }
            if (Difference >= 30 && guess > n)                  //way off, high
            {
                messageJLabel.setText("The guess was too HIGH. Try a higher number.");
                getContentPane().setBackground(Color.ORANGE);           //ghange to orange
            }
            if (Difference <= 15 && guess < n)              //getting warmer but too low
            {
                messageJLabel.setText("The guess was too LOW. Try a higher number.");
                getContentPane().setBackground(Color.RED);
                }
            if (Difference <= 15 && guess > n)              //getting warmer but too high
            {
                messageJLabel.setText("The guess was too HIGH. Try a higher number.");
                getContentPane().setBackground(Color.RED);
            }

            if (guess == n)                     //correct guess
            {
                getContentPane().setBackground(Color.GREEN);        //change background to green
                String guessString = "After " + Integer.toString(trialCount-1) + " trials, you got the number " + n + " correct.";  //correct messages
                prompt1JLabel.setText(guessString);     
                prompt2JLabel.setText("You are great! Try again? Click " + "New Game"+ " button");  //correct mesages
                messageJLabel.setText("Correct!");              //correctg messages
            }
            return null;       
    }    
}

