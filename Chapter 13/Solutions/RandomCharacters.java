import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomCharacters extends JPanel {
    private static final String[] FONT_NAMES = {Font.SERIF, Font.SANS_SERIF, Font.MONOSPACED};
    private final Random random = new Random();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = Math.max(1, getWidth() - 50);
        int height = Math.max(1, getHeight() - 60);

        for (int i = 0; i < 50; i++) {
            char character = (char) (random.nextInt(94) + 33);
            Font font = new Font(FONT_NAMES[random.nextInt(FONT_NAMES.length)],
                    random.nextInt(4), 12 + random.nextInt(37));
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            g.setFont(font);
            g.setColor(color);
            g.drawString(String.valueOf(character), 10 + random.nextInt(width), 40 + random.nextInt(height));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.10: Random Characters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RandomCharacters());
        frame.setSize(450, 400);
        frame.setVisible(true);
    }
}
