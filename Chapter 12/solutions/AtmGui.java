import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AtmGui extends JFrame {
   private enum Mode { PIN, MENU, WITHDRAW, DEPOSIT }

   private static final String PIN = "12345";

   private final JTextArea screen = new JTextArea(7, 32);
   private final StringBuilder entry = new StringBuilder();
   private final JButton removeCashButton = new JButton("Remove Cash");
   private final JButton insertEnvelopeButton = new JButton("Insert Envelope");

   private Mode mode = Mode.PIN;
   private double balance = 1000.00;
   private double pendingAmount;

   public AtmGui() {
      super("ATM");

      screen.setEditable(false);

      JPanel keypad = new JPanel(new GridLayout(4, 3, 4, 4));
      for (String label : new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "0", "Clear"}) {
         JButton key = new JButton(label);
         key.addActionListener(this::keyPressed);
         keypad.add(key);
      }

      JButton enterButton = new JButton("Enter");
      enterButton.addActionListener(this::enterPressed);

      JPanel actions = new JPanel(new GridLayout(3, 1, 4, 4));
      JButton balanceButton = new JButton("Balance");
      balanceButton.addActionListener(event -> {
         if (mode == Mode.MENU) {
            prompt(String.format("Your balance is $%.2f.", balance), mode);
         }
      });
      actions.add(balanceButton);
      JButton withdrawButton = new JButton("Withdraw");
      withdrawButton.addActionListener(event -> {
         if (mode == Mode.MENU) {
            startEntry(Mode.WITHDRAW, "Enter withdrawal amount and press Enter:");
         }
      });
      actions.add(withdrawButton);
      JButton depositButton = new JButton("Deposit");
      depositButton.addActionListener(event -> {
         if (mode == Mode.MENU) {
            startEntry(Mode.DEPOSIT, "Enter deposit amount and press Enter:");
         }
      });
      actions.add(depositButton);

      removeCashButton.setEnabled(false);
      insertEnvelopeButton.setEnabled(false);
      removeCashButton.addActionListener(event -> {
         removeCashButton.setEnabled(false);
         showMenu();
      });
      insertEnvelopeButton.addActionListener(event -> {
         insertEnvelopeButton.setEnabled(false);
         balance += pendingAmount;
         showMenu();
      });

      JPanel hardware = new JPanel(new FlowLayout());
      hardware.add(removeCashButton);
      hardware.add(insertEnvelopeButton);

      JPanel left = new JPanel(new BorderLayout(4, 4));
      left.add(new JLabel("Screen:"), BorderLayout.NORTH);
      left.add(screen, BorderLayout.CENTER);
      left.add(enterButton, BorderLayout.SOUTH);

      setLayout(new BorderLayout(8, 8));
      add(left, BorderLayout.WEST);
      add(keypad, BorderLayout.CENTER);
      add(actions, BorderLayout.EAST);
      add(hardware, BorderLayout.SOUTH);
      ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
      showPinPrompt();
   }

   private void showPinPrompt() {
      mode = Mode.PIN;
      entry.setLength(0);
      prompt("Welcome! Enter your account PIN:", Mode.PIN);
   }

   private void showMenu() {
      mode = Mode.MENU;
      prompt("Main menu. Choose a transaction above.", Mode.MENU);
   }

   private void startEntry(Mode newMode, String message) {
      entry.setLength(0);
      prompt(message, newMode);
   }

   private void prompt(String message, Mode newMode) {
      mode = newMode;
      String masked = "*".repeat(entry.length());
      screen.setText(entry.isEmpty() ? message
         : message + System.lineSeparator() + (newMode == Mode.PIN ? masked : "$" + entry));
   }

   private void keyPressed(ActionEvent event) {
      String command = event.getActionCommand();
      if ("Clear".equals(command)) {
         entry.setLength(0);
      }
      else if (entry.length() < 10) {
         entry.append(command);
      }
      switch (mode) {
         case PIN:
            prompt("Enter your account PIN:", Mode.PIN);
            break;
         case WITHDRAW:
            prompt("Enter withdrawal amount and press Enter:", Mode.WITHDRAW);
            break;
         case DEPOSIT:
            prompt("Enter deposit amount and press Enter:", Mode.DEPOSIT);
            break;
         default:
            break;
      }
   }

   private void enterPressed(ActionEvent event) {
      try {
         switch (mode) {
            case PIN:
               if (PIN.equals(entry.toString())) {
                  showMenu();
               }
               else {
                  entry.setLength(0);
                  prompt("Invalid PIN. Try again:", Mode.PIN);
               }
               break;
            case WITHDRAW:
               pendingAmount = Double.parseDouble(entry.toString());
               if (pendingAmount <= 0 || pendingAmount > balance) {
                  prompt("Invalid or insufficient amount. Try again:", Mode.WITHDRAW);
                  break;
               }
               balance -= pendingAmount;
               removeCashButton.setEnabled(true);
               screen.setText(String.format(
                  "Please take your cash: $%.2f%n%nClick Remove Cash when done.",
                  pendingAmount));
               break;
            case DEPOSIT:
               pendingAmount = Double.parseDouble(entry.toString());
               if (pendingAmount <= 0) {
                  prompt("Invalid amount. Try again:", Mode.DEPOSIT);
                  break;
               }
               insertEnvelopeButton.setEnabled(true);
               screen.setText(String.format(
                  "Insert an envelope containing $%.2f.%n%nClick Insert Envelope when done.",
                  pendingAmount));
               break;
            default:
               break;
         }
      }
      catch (NumberFormatException exception) {
         entry.setLength(0);
         prompt("Invalid numeric entry. Try again:", mode);
      }
   }

   public static void main(String[] args) {
      AtmGui frame = new AtmGui();
      frame.setVisible(true);
   }
}
