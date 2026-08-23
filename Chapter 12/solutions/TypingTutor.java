import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TypingTutor extends JFrame {
   private final Map<Integer, JButton> keyButtons = new HashMap<>();
   private final Map<JButton, Color> originalColors = new HashMap<>();
   private final JTextArea typedText = new JTextArea(6, 50);
   private boolean shiftDown;

   public TypingTutor() {
      super("Typing Application");
      setLayout(new BorderLayout());

      String[][] rows = {
         {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "Backspace"},
         {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"},
         {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "Enter"},
         {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "Shift"},
         {"Space"}
      };

      JPanel keyboard = new JPanel(new GridLayout(rows.length, 1, 4, 4));
      for (String[] row : rows) {
         JPanel rowPanel = new JPanel(new GridLayout(1, row.length, 2, 2));
         boolean duplicate = false;
         for (String label : row) {
            if ("Shift".equals(label)) {
               if (duplicate) {
                  continue;
               }
               duplicate = true;
            }
            JButton button = new JButton(label);
            originalColors.put(button, button.getBackground());
            keyButtons.put(keyCodeFor(label), button);
            rowPanel.add(button);
         }
         keyboard.add(rowPanel);
      }

      typedText.setEditable(false);

      add(new JScrollPane(typedText), BorderLayout.NORTH);
      add(keyboard, BorderLayout.CENTER);

      addKeyListener(new java.awt.event.KeyAdapter() {
         @Override
         public void keyPressed(java.awt.event.KeyEvent event) {
            shiftDown = event.getKeyCode() == java.awt.event.KeyEvent.VK_SHIFT || shiftDown;
            highlight(event.getKeyCode(), true);
         }

         @Override
         public void keyReleased(java.awt.event.KeyEvent event) {
            if (event.getKeyCode() == java.awt.event.KeyEvent.VK_SHIFT) {
               shiftDown = false;
            }
            highlight(event.getKeyCode(), false);
         }

         @Override
         public void keyTyped(java.awt.event.KeyEvent event) {
            char character = event.getKeyChar();
            if (character == '\b') {
               String text = typedText.getText();
               if (!text.isEmpty()) {
                  typedText.setText(text.substring(0, text.length() - 1));
               }
            }
            else if (!Character.isISOControl(character)) {
               typedText.append(String.valueOf(character));
            }
         }
      });

      setFocusable(true);
      setFocusTraversalKeysEnabled(false);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
   }

   private static int keyCodeFor(String label) {
      return switch (label) {
         case "~" -> java.awt.event.KeyEvent.VK_BACK_QUOTE;
         case "-" -> java.awt.event.KeyEvent.VK_MINUS;
         case "=" -> java.awt.event.KeyEvent.VK_EQUALS;
         case "[" -> java.awt.event.KeyEvent.VK_OPEN_BRACKET;
         case "]" -> java.awt.event.KeyEvent.VK_CLOSE_BRACKET;
         case "\\" -> java.awt.event.KeyEvent.VK_BACK_SLASH;
         case ";" -> java.awt.event.KeyEvent.VK_SEMICOLON;
         case "'" -> java.awt.event.KeyEvent.VK_QUOTE;
         case "," -> java.awt.event.KeyEvent.VK_COMMA;
         case "." -> java.awt.event.KeyEvent.VK_PERIOD;
         case "/" -> java.awt.event.KeyEvent.VK_SLASH;
         case "Backspace" -> java.awt.event.KeyEvent.VK_BACK_SPACE;
         case "Tab" -> java.awt.event.KeyEvent.VK_TAB;
         case "Caps" -> java.awt.event.KeyEvent.VK_CAPS_LOCK;
         case "Enter" -> java.awt.event.KeyEvent.VK_ENTER;
         case "Shift" -> java.awt.event.KeyEvent.VK_SHIFT;
         case "Space" -> java.awt.event.KeyEvent.VK_SPACE;
         default -> java.awt.event.KeyEvent.getExtendedKeyCodeForChar(label.charAt(0));
      };
   }

   private void highlight(int keyCode, boolean pressed) {
      JButton button = keyButtons.get(keyCode);
      if (button != null) {
         button.setBackground(pressed ? Color.YELLOW : originalColors.get(button));
      }
   }

   public static void main(String[] args) {
      TypingTutor frame = new TypingTutor();
      frame.setVisible(true);
   }
}
