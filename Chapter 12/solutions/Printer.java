import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Printer {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Printer");

      JComboBox<String> printerCombo =
         new JComboBox<>(new String[]{"MyPrinter"});
      ButtonGroup qualityGroup = new ButtonGroup();
      JRadioButton highButton = new JRadioButton("High", true);
      JRadioButton mediumButton = new JRadioButton("Medium");
      JRadioButton lowButton = new JRadioButton("Low");
      qualityGroup.add(highButton);
      qualityGroup.add(mediumButton);
      qualityGroup.add(lowButton);

      JCheckBox imageCheck = new JCheckBox("Image");
      JRadioButton selectionButton = new JRadioButton("Selection");
      JRadioButton allImageButton = new JRadioButton("All");
      ButtonGroup imageGroup = new ButtonGroup();
      imageGroup.add(selectionButton);
      imageGroup.add(allImageButton);

      JCheckBox textCheck = new JCheckBox("Text");
      JRadioButton textAllButton = new JRadioButton("All");

      JCheckBox codeCheck = new JCheckBox("Code");
      JRadioButton appletButton = new JRadioButton("Applet");

      JPanel options = new JPanel(new GridLayout(3, 2, 8, 8));
      JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      imagePanel.add(imageCheck);
      imagePanel.add(selectionButton);
      imagePanel.add(allImageButton);
      JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      textPanel.add(textCheck);
      textPanel.add(textAllButton);
      JPanel codePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      codePanel.add(codeCheck);
      codePanel.add(appletButton);
      options.add(imagePanel);
      options.add(textPanel);
      options.add(codePanel);

      JPanel topRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
      topRow.add(new JLabel("Printer:"));
      topRow.add(printerCombo);
      topRow.add(new JButton("Setup..."));

      JPanel bottomRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
      bottomRow.add(new JLabel("Print Quality:"));
      bottomRow.add(highButton);
      bottomRow.add(mediumButton);
      bottomRow.add(lowButton);
      bottomRow.add(new JCheckBox("Print to File"));

      JPanel buttonColumn = new JPanel(new GridLayout(3, 1, 4, 12));
      buttonColumn.add(new JButton("OK"));
      buttonColumn.add(new JButton("Cancel"));
      buttonColumn.add(new JButton("Help"));

      JPanel center = new JPanel(new BorderLayout());
      center.add(options, BorderLayout.WEST);
      center.add(buttonColumn, BorderLayout.EAST);

      frame.setLayout(new BorderLayout());
      frame.add(topRow, BorderLayout.NORTH);
      frame.add(center, BorderLayout.CENTER);
      frame.add(bottomRow, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
