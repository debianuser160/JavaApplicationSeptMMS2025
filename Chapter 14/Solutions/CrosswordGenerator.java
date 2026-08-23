import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrosswordGenerator {

    private static final int ROWS = 15;
    private static final int COLUMNS = 22;
    private static final int HORIZONTAL = 1;
    private static final int VERTICAL = 2;

    private static final char[][] grid = new char[ROWS][COLUMNS];
    private static final int[][] directions = new int[ROWS][COLUMNS];
    private static final List<String> words = new ArrayList<>();
    private static final List<String> placements = new ArrayList<>();

    public static void main(String[] args) {
        String[] candidateWords = {"crossword", "generator", "string", "arrays",
            "letters", "grid", "words", "clues", "down", "across", "puzzle"};

        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        List<String> unplaced = new ArrayList<>(Arrays.asList(candidateWords).subList(1, candidateWords.length));
        placeFirst(candidateWords[0]);

        boolean progress = true;
        while (progress && !unplaced.isEmpty()) {
            progress = false;
            java.util.Iterator<String> iterator = unplaced.iterator();
            while (iterator.hasNext()) {
                String word = iterator.next();
                if (tryPlaceWord(word)) {
                    iterator.remove();
                    progress = true;
                }
            }
        }
        for (String word : unplaced) {
            System.out.printf("Could not place: %s%n", word);
        }

        printGrid();
        System.out.println("\nPlacements:");
        for (String placement : placements) {
            System.out.println(placement);
        }
    }

    private static void placeFirst(String word) {
        int row = ROWS / 2;
        int column = (COLUMNS - word.length()) / 2;
        layWord(word, row, column, HORIZONTAL);
        placements.add(String.format("Across (%d,%d): %s", row + 1, column + 1, word));
    }

    private static boolean tryPlaceWord(String word) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (grid[r][c] == '.') {
                    continue;
                }
                for (int k = 0; k < word.length(); k++) {
                    if (word.charAt(k) != grid[r][c]) {
                        continue;
                    }
                    int mask = directions[r][c];

                    if (mask == VERTICAL && canLayHorizontally(word, r, c - k)) {
                        layWord(word, r, c - k, HORIZONTAL);
                        placements.add(String.format("Across (%d,%d): %s",
                                r + 1, c - k + 1, word));
                        return true;
                    }
                    if (mask == HORIZONTAL && canLayVertically(word, r - k, c)) {
                        layWord(word, r - k, c, VERTICAL);
                        placements.add(String.format("Down   (%d,%d): %s",
                                r - k + 1, c + 1, word));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean canLayHorizontally(String word, int row, int startColumn) {
        if (row < 0 || row >= ROWS || startColumn < 0
                || startColumn + word.length() > COLUMNS) {
            return false;
        }
        if (startColumn > 0 && grid[row][startColumn - 1] != '.') {
            return false;
        }
        if (startColumn + word.length() < COLUMNS
                && grid[row][startColumn + word.length()] != '.') {
            return false;
        }

        for (int k = 0; k < word.length(); k++) {
            char existing = grid[row][startColumn + k];
            if (existing == '.') {
                if ((directions[row][startColumn + k] & HORIZONTAL) != 0
                        || !verticalNeighborsEmpty(row, startColumn + k)) {
                    return false;
                }
            } else if (existing != word.charAt(k)
                    || (directions[row][startColumn + k] & VERTICAL) == 0
                    || (directions[row][startColumn + k] & HORIZONTAL) != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean canLayVertically(String word, int startRow, int column) {
        if (column < 0 || column >= COLUMNS || startRow < 0
                || startRow + word.length() > ROWS) {
            return false;
        }
        if (startRow > 0 && grid[startRow - 1][column] != '.') {
            return false;
        }
        if (startRow + word.length() < ROWS
                && grid[startRow + word.length()][column] != '.') {
            return false;
        }

        for (int k = 0; k < word.length(); k++) {
            char existing = grid[startRow + k][column];
            if (existing == '.') {
                if ((directions[startRow + k][column] & VERTICAL) != 0
                        || !horizontalNeighborsEmpty(startRow + k, column)) {
                    return false;
                }
            } else if (existing != word.charAt(k)
                    || (directions[startRow + k][column] & HORIZONTAL) == 0
                    || (directions[startRow + k][column] & VERTICAL) != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean verticalNeighborsEmpty(int row, int column) {
        boolean above = row == 0 || grid[row - 1][column] == '.';
        boolean below = row == ROWS - 1 || grid[row + 1][column] == '.';
        return above && below;
    }

    private static boolean horizontalNeighborsEmpty(int row, int column) {
        boolean left = column == 0 || grid[row][column - 1] == '.';
        boolean right = column == COLUMNS - 1 || grid[row][column + 1] == '.';
        return left && right;
    }

    private static void layWord(String word, int row, int column, int orientation) {
        for (int k = 0; k < word.length(); k++) {
            int r = orientation == HORIZONTAL ? row : row + k;
            int c = orientation == HORIZONTAL ? column + k : column;
            grid[r][c] = word.charAt(k);
            directions[r][c] |= orientation;
        }
        words.add(word);
    }

    private static void printGrid() {
        for (int r = 0; r < ROWS; r++) {
            StringBuilder line = new StringBuilder();
            for (int c = 0; c < COLUMNS; c++) {
                line.append(grid[r][c] == '.' ? '#' : grid[r][c]);
            }
            System.out.println(line);
        }
    }
}
