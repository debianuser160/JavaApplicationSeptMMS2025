import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TortoiseAndHareGUI extends JPanel implements ActionListener {
    private static final int RACE_LENGTH = 300;
    private final Random random = new Random();
    private final Timer timer = new Timer(150, this);
    private int tortoisePosition = 1;
    private int harePosition = 1;
    private String message = "The race is on!";

    public TortoiseAndHareGUI() {
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        moveTortoise();
        moveHare();
        tortoisePosition = Math.max(1, Math.min(RACE_LENGTH, tortoisePosition));
        harePosition = Math.max(1, Math.min(RACE_LENGTH, harePosition));

        if (tortoisePosition >= RACE_LENGTH && harePosition >= RACE_LENGTH) {
            message = "It's a tie!";
            timer.stop();
        } else if (tortoisePosition >= RACE_LENGTH) {
            message = "TORTOISE WINS!!! YAY!!!";
            timer.stop();
        } else if (harePosition >= RACE_LENGTH) {
            message = "Hare wins. Yuch.";
            timer.stop();
        } else if (tortoisePosition == harePosition) {
            message = "OUCH!!!";
        } else {
            message = "";
        }
        repaint();
    }

    private void moveTortoise() {
        int roll = 1 + random.nextInt(10);
        if (roll <= 5) {
            tortoisePosition += 3;
        } else if (roll <= 7) {
            tortoisePosition -= 6;
        } else {
            tortoisePosition += 1;
        }
    }

    private void moveHare() {
        int roll = 1 + random.nextInt(10);
        if (roll <= 2) {
            harePosition += 0;
        } else if (roll <= 4) {
            harePosition += 9;
        } else if (roll == 5) {
            harePosition -= 12;
        } else if (roll <= 8) {
            harePosition += 1;
        } else {
            harePosition -= 2;
        }
    }

    public void startRace() {
        tortoisePosition = 1;
        harePosition = 1;
        message = "The race is on!";
        timer.start();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height);
        int centerX = width;
        int centerY = height;

        g.setColor(Color.BLACK);
        g.drawArc(width - 2 * radius, height - 2 * radius, 2 * radius, 2 * radius, 90, 90);

        drawContestant(g, tortoisePosition, Color.ORANGE.darker(), -14, "Tortoise");
        drawContestant(g, harePosition, Color.GRAY, 14, "Hare");
        g.setColor(Color.BLACK);
        g.drawString(String.format("Tortoise: %d   Hare: %d   Race length: %d",
                tortoisePosition, harePosition, RACE_LENGTH), 10, 20);
        if (!message.isEmpty()) {
            g.drawString(message, width / 2 - 60, height / 4);
        }
    }

    private void drawContestant(Graphics g, int position, Color color,
            double offsetPixels, String label) {
        int radius = Math.min(getWidth(), getHeight());
        int centerX = getWidth();
        int centerY = getHeight();
        double t = position / (double) RACE_LENGTH;
        double theta = Math.toRadians(180 - 90 * t);
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);

        int x = (int) Math.round(centerX + (radius + offsetPixels) * cosTheta);
        int y = (int) Math.round(centerY - (radius + offsetPixels) * sinTheta);

        g.setColor(color);
        g.fillOval(x - 7, y - 7, 14, 14);
        g.drawString(label, x - 18, y + 24);
    }

    public static void main(String[] args) {
        TortoiseAndHareGUI racePanel = new TortoiseAndHareGUI();

        JButton startButton = new JButton("Start New Race");
        startButton.addActionListener(e -> racePanel.startRace());

        JFrame frame = new JFrame("Exercise 13.25: Tortoise and Hare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(racePanel, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);
        frame.setSize(700, 550);
        frame.setVisible(true);

        racePanel.startRace();
    }
}
