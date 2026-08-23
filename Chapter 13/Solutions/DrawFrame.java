import java.awt.BorderLayout;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DrawFrame extends JFrame {
    private final DrawPanel drawPanel = new DrawPanel();
    private final JComboBox<String> shapeComboBox =
            new JComboBox<>(new String[]{"Line", "Rectangle", "Oval"});
    private final JCheckBox filledCheckBox = new JCheckBox("Filled");
    private final JCheckBox gradientCheckBox = new JCheckBox("Use gradient");
    private final JButton color1Button = new JButton("1st Color");
    private final JButton color2Button = new JButton("2nd Color");
    private final JTextField widthField = new JTextField("3", 3);
    private final JTextField dashLengthField = new JTextField("10", 3);
    private final JCheckBox dashedCheckBox = new JCheckBox("Dashed");

    private Color color1 = Color.BLACK;
    private Color color2 = Color.WHITE;

    public DrawFrame() {
        super("Exercise 13.31: Drawing Application with Java 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel shapePanel = new JPanel();
        shapePanel.add(new JLabel("Shape:"));
        shapePanel.add(shapeComboBox);
        shapePanel.add(filledCheckBox);

        JPanel java2dPanel = new JPanel();
        java2dPanel.add(gradientCheckBox);
        java2dPanel.add(color1Button);
        java2dPanel.add(color2Button);
        java2dPanel.add(new JLabel("Width:"));
        java2dPanel.add(widthField);
        java2dPanel.add(new JLabel("Dash length:"));
        java2dPanel.add(dashLengthField);
        java2dPanel.add(dashedCheckBox);

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(shapePanel);
        topPanel.add(java2dPanel);

        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        ActionListener settingsListener = e -> applySettings();
        gradientCheckBox.addActionListener(settingsListener);
        dashedCheckBox.addActionListener(settingsListener);
        widthField.addActionListener(settingsListener);
        dashLengthField.addActionListener(settingsListener);

        shapeComboBox.addActionListener(e -> drawPanel.setShapeType(shapeComboBox.getSelectedIndex()));
        filledCheckBox.addActionListener(e -> drawPanel.setFilled(filledCheckBox.isSelected()));

        color1Button.addActionListener(e -> chooseColor(true));
        color2Button.addActionListener(e -> chooseColor(false));

        applySettings();
    }

    private void chooseColor(boolean firstColor) {
        Color selected = JColorChooser.showDialog(this,
                firstColor ? "Choose the first color" : "Choose the second color",
                firstColor ? color1 : color2);
        if (selected == null) {
            return;
        }
        if (firstColor) {
            color1 = selected;
        } else {
            color2 = selected;
        }
        applySettings();
    }

    private void applySettings() {
        Paint paint;
        if (gradientCheckBox.isSelected()) {
            paint = new GradientPaint(0, 0, color1, 50, 50, color2, true);
        } else {
            paint = color1;
        }

        float width = parsePositiveFloat(widthField.getText(), 3.0f);
        Stroke stroke;
        if (dashedCheckBox.isSelected()) {
            float dashLength = parsePositiveFloat(dashLengthField.getText(), 10.0f);
            float[] dashes = {dashLength};
            stroke = new BasicStroke(width, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND, 10, dashes, 0);
        } else {
            stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        }

        drawPanel.setCurrentPaint(paint);
        drawPanel.setCurrentStroke(stroke);
    }

    private float parsePositiveFloat(String text, float fallback) {
        try {
            float value = Float.parseFloat(text.trim());
            return value > 0 ? value : fallback;
        } catch (NumberFormatException e) {
            return fallback;
        }
    }
}
