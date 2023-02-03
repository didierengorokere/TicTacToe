import java.util.Scanner;

public class TicTacToe {
    static final int ROWS = 3, COLS = 3;
    static int[][] grid = new int[ROWS][COLS];
    static int turn = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            printGrid();
            System.out.println("Player " + turn + " turn. Enter row and column separated by a space:");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            if (row >= 0 && row < ROWS && col >= 0 && col < COLS && grid[row][col] == 0) {
                grid[row][col] = turn;
                if (checkWin(row, col)) {
                    System.out.println("Player " + turn + " wins!");
                    playing = false;
                } else if (checkDraw()) {
                    System.out.println("Draw.");
                    playing = false;
                } else {
                    turn = turn == 1 ? 2 : 1;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static void printGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(grid[i][j] == 0 ? "-" : grid[i][j] == 1 ? "X" : "O");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(int row, int col) {
        int player = grid[row][col];
        return (grid[row][0] == player && grid[row][1] == player && grid[row][2] == player) ||
                (grid[0][col] == player && grid[1][col] == player && grid[2][col] == player) ||
                (row == col && grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) ||
                (row + col == 2 && grid[0][2] == player && grid[1][1] == player && grid[2][0] == player);
    }

    public static boolean checkDraw() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
