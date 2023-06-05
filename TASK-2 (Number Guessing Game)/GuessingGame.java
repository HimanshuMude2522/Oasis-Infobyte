/** 
* @ Himanshu Mude
**/
   
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;  //text field for user's guess
	private JLabel lblOutput;  // label for too high/too low output
	private int theNumber;
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		
	
		try {			
		
			//	check the guess for too high/too low
			int guess = Integer.parseInt(guessText);
			
			if (guess < theNumber) {
				message = guess + " Was low. Guess again.";
				lblOutput.setText(message);
			}
			else if(guess > theNumber){
				message = guess + " Was high. Guess again.";
				lblOutput.setText(message);
			}
			else if(guess == theNumber){ //guessed correctly
				message = guess + " Was right! You win. Play again.";
				lblOutput.setText(message);
				newGame();
			}
			else{
				message = guess + "Couldn't understand. Try again.";
				lblOutput.setText(message);
				newGame();
			}
		
		}catch(Exception e) {
			lblOutput.setText("Couldn't understand. Try again.");
		  } finally {
			//this focuses the text field
			txtGuess.requestFocus();
			txtGuess.selectAll();
		  }        
	
	}
	
	public void newGame() { // create a new random number between 1-100
		theNumber = (int)(Math.random() * 100 + 1);
	}
	
	public GuessingGame() {
		setBackground(new Color(107, 173, 223));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(107, 173, 223));
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("NUMBER GUESSING GAME");
		lblTitle.setBounds(15, 47, 534, 45);
		lblTitle.setForeground(new Color(	1, 25, 63));
		lblTitle.setFont(new Font("serif", Font.BOLD, 38));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(107, 173, 223));
		panel.setBounds(0, 90, 634, 150);
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setBounds(42, 39, 500, 100);
		lblGuessANumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setBounds(480, 80, 45, 25);
		txtGuess.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
		panel.add(txtGuess);
		txtGuess.setHorizontalAlignment(SwingConstants.LEFT);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("GUESS");
		btnGuess.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnGuess.setForeground(new Color(210, 180, 134));
		btnGuess.setBackground(new Color(1, 25, 63));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(210, 243, 156, 52);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Try to guess a number");
		lblOutput.setToolTipText("Guess a number between 1 and 100");
		lblOutput.setBackground(new Color(153, 204, 255));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(45, 330, 500, 50);
		lblOutput.setFont(new Font("Arial Black", Font.BOLD, 22));
		getContentPane().add(lblOutput);
	}
	
	public static void main(String[] args) {
		
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(600, 450));
		theGame.setVisible(true);
	}
}
