
// Write a JFrame app that plays "guess the number". (This driver instantiates a new object of JFrame (GuessGameFrame))
//GuessGame.java
import javax.swing.JFrame;              //required for exit on close
public class GuessGame                  //main function which creates JFrame Object
{
    public static void main(String[] args)
    {
        GuessGameFrame guessGame = new GuessGameFrame();    //instantiate new object
        guessGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit
        guessGame.setSize(350, 100);            //set my frame size
        guessGame.setVisible(true);         //visibility
    }
}
