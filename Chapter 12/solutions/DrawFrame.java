import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFrame extends JFrame {
   private static final Color[] COLORS = {
      Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
      Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
      Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

   private final DrawPanel drawPanel;

   public DrawFrame() {
      super("Java Drawings");

      JLabel statusLabel = new JLabel("(0, 0)");
      drawPanel = new DrawPanel(statusLabel);

      JButton undoButton = new JButton("Undo");
      undoButton.addActionListener(event -> drawPanel.clearLastShape());

      JButton clearButton = new JButton("Clear");
      clearButton.addActionListener(event -> drawPanel.clearDrawing());

      String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray",
         "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red",
         "White", "Yellow"};
      JComboBox<String> colorCombo = new JComboBox<>(colorNames);
      colorCombo.addItemListener(event -> {
         if (event.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            drawPanel.setCurrentColor(COLORS[colorCombo.getSelectedIndex()]);
         }
      });

      String[] shapeNames = {"Line", "Oval", "Rectangle"};
      JComboBox<String> shapeCombo = new JComboBox<>(shapeNames);
      shapeCombo.addItemListener(event -> {
         if (event.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            drawPanel.setShapeType(shapeCombo.getSelectedIndex());
         }
      });

      JCheckBox filledCheckBox = new JCheckBox("Filled");
      filledCheckBox.addItemListener(event ->
         drawPanel.setFilledShape(event.getStateChange() == java.awt.event.ItemEvent.SELECTED));

      JPanel topPanel = new JPanel(new FlowLayout());
      topPanel.add(undoButton);
      topPanel.add(clearButton);
      topPanel.add(colorCombo);
      topPanel.add(shapeCombo);
      topPanel.add(filledCheckBox);

      setLayout(new BorderLayout());
      add(topPanel, BorderLayout.NORTH);
      add(drawPanel, BorderLayout.CENTER);
      add(statusLabel, BorderLayout.SOUTH);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600, 450);
      setLocationRelativeTo(null);
   }

   public static void main(String[] args) {
      DrawFrame frame = new DrawFrame();
      frame.setVisible(true);
   }
}
