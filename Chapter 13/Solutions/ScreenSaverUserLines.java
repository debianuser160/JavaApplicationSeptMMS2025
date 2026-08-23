import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ScreenSaverUserLines extends JPanel implements ActionListener {
    private static final int DEFAULT_LINES = 100;
    private final Random random = new Random();
    private final Timer timer;
    private final JTextField lineCountField = new JTextField(String.valueOf(DEFAULT_LINES), 5);
    private volatile int numberOfLines = DEFAULT_LINES;

    public ScreenSaverUserLines() {
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < numberOfLines; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            g.drawLine(random.nextInt(width), random.nextInt(height),
                    random.nextInt(width), random.nextInt(height));
        }
    }

    private class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                numberOfLines = Math.max(1, Integer.parseInt(lineCountField.getText().trim()));
            } catch (NumberFormatException e) {
                numberOfLines = DEFAULT_LINES;
                lineCountField.setText(String.valueOf(DEFAULT_LINES));
            }
        }
    }

    public static void main(String[] args) {
        ScreenSaverUserLines panel = new ScreenSaverUserLines();

        JPanel controls = new JPanel();
        controls.add(new JLabel("Lines before clearing:"));
        controls.add(panel.lineCountField);

        JFrame frame = new JFrame("Exercise 13.20: Screen Saver for a Random Number of Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(controls, BorderLayout.SOUTH);
        panel.lineCountField.addActionListener(panel.new TextFieldHandler());
        frame.setSize(450, 450);
        frame.setVisible(true);
    }
}
