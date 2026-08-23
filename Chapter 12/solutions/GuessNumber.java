import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessNumber extends JFrame {
   private static final Random RANDOM = new Random();

   private final JLabel promptLabel = new JLabel(
      "<html>I have a number between 1 and 1000. Can you guess my number?<br>" +
      "Please enter your first guess.</html>");
   private final JLabel feedbackLabel = new JLabel(" ", JLabel.CENTER);
   private final JTextField guessField = new JTextField(8);
   private final JButton newGameButton = new JButton("New Game");

   private int answer;
   private int lastDistance = Integer.MAX_VALUE;

   public GuessNumber() {
      super("Guess the Number");
      setLayout(new BorderLayout());

      guessField.addActionListener(event -> checkGuess());
      newGameButton.addActionListener(event -> startNewGame());

      JPanel inputPanel = new JPanel(new FlowLayout());
      inputPanel.add(guessField);
      inputPanel.add(newGameButton);

      add(promptLabel, BorderLayout.NORTH);
      add(feedbackLabel, BorderLayout.CENTER);
      add(inputPanel, BorderLayout.SOUTH);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(420, 180);
      setLocationRelativeTo(null);
      startNewGame();
   }

   private void startNewGame() {
      answer = RANDOM.nextInt(1000) + 1;
      lastDistance = Integer.MAX_VALUE;
      guessField.setEditable(true);
      guessField.setText("");
      feedbackLabel.setText(" ");
      getContentPane().setBackground(Color.WHITE);
      guessField.requestFocusInWindow();
   }

   private void checkGuess() {
      try {
         int guess = Integer.parseInt(guessField.getText().trim());
         if (guess < 1 || guess > 1000) {
            feedbackLabel.setText("Enter a number between 1 and 1000");
            return;
         }

         int distance = Math.abs(guess - answer);

         if (guess == answer) {
            feedbackLabel.setText("Correct!");
            guessField.setEditable(false);
            getContentPane().setBackground(Color.WHITE);
            return;
         }

         feedbackLabel.setText(guess > answer ? "Too High" : "Too Low");
         Color warmth = distance < lastDistance ? Color.RED : Color.BLUE;
         getContentPane().setBackground(warmth);
         lastDistance = distance;
      }
      catch (NumberFormatException exception) {
         feedbackLabel.setText("Please enter a valid integer");
      }
      finally {
         guessField.selectAll();
      }
   }

   public static void main(String[] args) {
      GuessNumber frame = new GuessNumber();
      frame.setVisible(true);
   }
}
