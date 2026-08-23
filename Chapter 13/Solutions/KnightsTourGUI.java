import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class KnightsTourGUI extends JFrame {
    private static final int SIZE = 8;
    private static final int[] ROW_MOVES = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] COLUMN_MOVES = {1, 2, 2, 1, -1, -2, -2, -1};

    private final JLabel[][] cells = new JLabel[SIZE][SIZE];
    private final int[][] board = new int[SIZE][SIZE];
    private final List<int[]> moves = new ArrayList<>();
    private final Timer timer;
    private final JLabel statusLabel = new JLabel("Press Start New Tour", SwingConstants.CENTER);
    private int stepIndex;

    public KnightsTourGUI() {
        super("Exercise 13.24: Knight's Tour");
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(SIZE, SIZE));
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                JLabel cell = new JLabel("", SwingConstants.CENTER);
                cell.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
                cell.setPreferredSize(new Dimension(60, 60));
                cell.setOpaque(true);
                cell.setBackground((row + column) % 2 == 0 ? Color.WHITE : new Color(200, 200, 200));
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cells[row][column] = cell;
                boardPanel.add(cell);
            }
        }

        JButton startButton = new JButton("Start New Tour");
        startButton.addActionListener(e -> startTour());
        timer = new Timer(200, e -> showNextMove());

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(startButton, BorderLayout.NORTH);
        southPanel.add(statusLabel, BorderLayout.SOUTH);

        add(boardPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void startTour() {
        timer.stop();
        clearBoard();

        List<int[]> path = findTour();
        moves.clear();
        if (path != null) {
            moves.addAll(path);
        }
        stepIndex = 0;

        if (moves.isEmpty()) {
            statusLabel.setText("No tour could be found.");
        } else {
            timer.start();
        }
    }

    private void clearBoard() {
        for (int[] boardRow : board) {
            Arrays.fill(boardRow, 0);
        }
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                cells[row][column].setText("");
                cells[row][column].setBackground((row + column) % 2 == 0 ? Color.WHITE : new Color(200, 200, 200));
            }
        }
    }

    private List<int[]> findTour() {
        List<int[]> bestPath = null;

        for (int attempt = 0; attempt < 200; attempt++) {
            for (int[] boardRow : board) {
                Arrays.fill(boardRow, 0);
            }
            List<int[]> path = attemptTour();
            if (path.size() == SIZE * SIZE) {
                return path;
            }
            if (bestPath == null || path.size() > bestPath.size()) {
                bestPath = path;
            }
        }
        return bestPath;
    }

    private List<int[]> attemptTour() {
        List<int[]> path = new ArrayList<>();
        int randomStart = (int) (Math.random() * SIZE * SIZE);
        int currentRow = randomStart / SIZE;
        int currentColumn = randomStart % SIZE;

        board[currentRow][currentColumn] = 1;
        path.add(new int[]{currentRow, currentColumn});

        for (int moveNumber = 2; moveNumber <= SIZE * SIZE; moveNumber++) {
            int bestRow = -1;
            int bestColumn = -1;
            int bestDegree = Integer.MAX_VALUE;

            for (int k = 0; k < ROW_MOVES.length; k++) {
                int nextRow = currentRow + ROW_MOVES[k];
                int nextColumn = currentColumn + COLUMN_MOVES[k];

                if (!isValid(nextRow, nextColumn) || board[nextRow][nextColumn] != 0) {
                    continue;
                }
                int degree = accessibility(nextRow, nextColumn);
                if (degree < bestDegree || (degree == bestDegree && Math.random() < 0.5)) {
                    bestDegree = degree;
                    bestRow = nextRow;
                    bestColumn = nextColumn;
                }
            }

            if (bestRow == -1) {
                break;
            }
            board[bestRow][bestColumn] = moveNumber;
            path.add(new int[]{bestRow, bestColumn});
            currentRow = bestRow;
            currentColumn = bestColumn;
        }
        return path;
    }

    private boolean isValid(int row, int column) {
        return row >= 0 && row < SIZE && column >= 0 && column < SIZE;
    }

    private int accessibility(int row, int column) {
        int count = 0;
        for (int k = 0; k < ROW_MOVES.length; k++) {
            int nextRow = row + ROW_MOVES[k];
            int nextColumn = column + COLUMN_MOVES[k];
            if (isValid(nextRow, nextColumn) && board[nextRow][nextColumn] == 0) {
                count++;
            }
        }
        return count;
    }

    private void showNextMove() {
        if (stepIndex >= moves.size()) {
            timer.stop();
            announceResult();
            return;
        }

        int[] square = moves.get(stepIndex);
        stepIndex++;
        JLabel cell = cells[square[0]][square[1]];
        cell.setText(String.valueOf(stepIndex));
        cell.setBackground(new Color(255, 215, 100));

        if (stepIndex == moves.size()) {
            timer.stop();
            announceResult();
        }
    }

    private void announceResult() {
        if (moves.size() == SIZE * SIZE) {
            if (isKnightMove(moves.get(moves.size() - 1), moves.get(0))) {
                statusLabel.setText(String.format("Full closed tour of all %d squares found!", SIZE * SIZE));
            } else {
                statusLabel.setText(String.format("Full tour of all %d squares found!", SIZE * SIZE));
            }
        } else {
            statusLabel.setText(String.format("No full tour found; knight visited %d squares.", moves.size()));
        }
    }

    private boolean isKnightMove(int[] from, int[] to) {
        int rowDifference = Math.abs(from[0] - to[0]);
        int columnDifference = Math.abs(from[1] - to[1]);
        return (rowDifference == 2 && columnDifference == 1)
                || (rowDifference == 1 && columnDifference == 2);
    }

    public static void main(String[] args) {
        KnightsTourGUI application = new KnightsTourGUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
