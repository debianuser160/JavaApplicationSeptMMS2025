import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EventDisplay extends JFrame implements ActionListener, ItemListener,
   ListSelectionListener, MouseListener, MouseMotionListener, KeyListener {

   private final JTextArea log = new JTextArea(12, 50);

   public EventDisplay() {
      super("Event Display");
      setLayout(new BorderLayout());

      JButton button = new JButton("Action Button");
      button.addActionListener(this);
      button.addKeyListener(this);

      JCheckBox checkBox = new JCheckBox("Check Box");
      checkBox.addItemListener(this);

      JComboBox<String> comboBox = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});
      comboBox.addItemListener(this);

      JList<String> list = new JList<>(new String[]{"Red", "Green", "Blue"});
      list.setVisibleRowCount(3);
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      list.addListSelectionListener(this);

      JPanel controls = new JPanel(new GridLayout(1, 4, 8, 8));
      controls.add(button);
      controls.add(checkBox);
      controls.add(comboBox);
      controls.add(new JScrollPane(list));

      log.setEditable(false);
      log.setFocusable(false);

      add(controls, BorderLayout.NORTH);
      add(new JScrollPane(log), BorderLayout.CENTER);

      addMouseListener(this);
      addMouseMotionListener(this);
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
   }

   private void log(String message) {
      log.append(message + System.lineSeparator());
      log.setCaretPosition(log.getDocument().getLength());
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      log(event.toString());
   }

   @Override
   public void itemStateChanged(ItemEvent event) {
      log(event.toString());
   }

   @Override
   public void valueChanged(ListSelectionEvent event) {
      log(event.toString());
   }

   @Override
   public void mouseClicked(MouseEvent event) {
      log(event.toString());
   }

   @Override
   public void mousePressed(MouseEvent event) {
      log(event.toString());
   }

   @Override
   public void mouseReleased(MouseEvent event) {
      log(event.toString());
   }

   @Override
   public void mouseEntered(MouseEvent event) {
      log(event.toString());
   }

   @Override
   public void mouseExited(MouseEvent event) {
      log(event.toString());
   }

   @Override
   public void mouseDragged(MouseEvent event) {
      log(event.toString());
   }

   @Override
   public void mouseMoved(MouseEvent event) {
      log(event.toString());
   }

   @Override
   public void keyTyped(KeyEvent event) {
      log(event.toString());
   }

   @Override
   public void keyPressed(KeyEvent event) {
      log(event.toString());
   }

   @Override
   public void keyReleased(KeyEvent event) {
      log(event.toString());
   }

   public static void main(String[] args) {
      EventDisplay frame = new EventDisplay();
      frame.setVisible(true);
   }
}
