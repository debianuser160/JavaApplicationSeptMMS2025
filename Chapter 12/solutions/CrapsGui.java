import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.security.SecureRandom;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrapsGui extends JFrame {
   private static final SecureRandom RANDOM = new SecureRandom();

   private enum Status { CONTINUE, WON, LOST }

   private final JButton rollButton = new JButton("Roll Dice");
   private final JTextField die1Field = new JTextField(4);
   private final JTextField die2Field = new JTextField(4);
   private final JTextField sumField = new JTextField(4);
   private final JTextField pointField = new JTextField(4);

   private Status gameStatus = Status.CONTINUE;
   private int point;

   public CrapsGui() {
      super("Craps");

      for (JTextField field : new JTextField[]{die1Field, die2Field, sumField, pointField}) {
         field.setEditable(false);
         field.setHorizontalAlignment(JTextField.CENTER);
      }

      rollButton.addActionListener(event -> roll());

      JPanel fieldsPanel = new JPanel(new GridLayout(1, 8, 6, 6));
      fieldsPanel.add(new JLabel("Die 1", JLabel.CENTER));
      fieldsPanel.add(die1Field);
      fieldsPanel.add(new JLabel("Die 2", JLabel.CENTER));
      fieldsPanel.add(die2Field);
      fieldsPanel.add(new JLabel("Sum", JLabel.CENTER));
      fieldsPanel.add(sumField);
      fieldsPanel.add(new JLabel("Point", JLabel.CENTER));
      fieldsPanel.add(pointField);

      setLayout(new BorderLayout());
      add(rollButton, BorderLayout.NORTH);
      add(fieldsPanel, BorderLayout.CENTER);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
   }

   private void roll() {
      int die1 = 1 + RANDOM.nextInt(6);
      int die2 = 1 + RANDOM.nextInt(6);
      int sum = die1 + die2;

      die1Field.setText(String.valueOf(die1));
      die2Field.setText(String.valueOf(die2));
      sumField.setText(String.valueOf(sum));

      if (gameStatus == Status.CONTINUE) {
         switch (sum) {
            case 7:
            case 11:
               gameStatus = Status.WON;
               pointField.setText("");
               break;
            case 2:
            case 3:
            case 12:
               gameStatus = Status.LOST;
               pointField.setText("");
               break;
            default:
               gameStatus = Status.CONTINUE;
               point = sum;
               pointField.setText(String.valueOf(point));
               break;
         }
      }
      else {
         if (sum == point) {
            gameStatus = Status.WON;
         }
         else if (sum == 7) {
            gameStatus = Status.LOST;
         }
         if (gameStatus != Status.CONTINUE) {
            pointField.setText("");
         }
      }

      String message = switch (gameStatus) {
         case WON -> "You win. Roll again to play a new game.";
         case LOST -> "You lose. Roll again to play a new game.";
         default -> "Point is " + point + ". Roll again.";
      };
      setTitle(message);

      if (gameStatus != Status.CONTINUE) {
         gameStatus = Status.CONTINUE;
         point = 0;
      }
   }

   public static void main(String[] args) {
      CrapsGui frame = new CrapsGui();
      frame.setVisible(true);
   }
}
