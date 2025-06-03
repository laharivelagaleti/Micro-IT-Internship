import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        int moves = 0;

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (!isValidMove(move)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            placeMove(move, currentPlayer);
            moves++;

            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (moves == 9) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean isValidMove(int pos) {
        int[] coordinates = positionToCoordinates(pos);
        return board[coordinates[0]][coordinates[1]] == ' ';
    }

    public static void placeMove(int pos, char symbol) {
        int[] coordinates = positionToCoordinates(pos);
        board[coordinates[0]][coordinates[1]] = symbol;
    }

    public static int[] positionToCoordinates(int pos) {
        switch (pos) {
            case 1: return new int[]{0, 0};
            case 2: return new int[]{0, 2};
            case 3: return new int[]{0, 4};
            case 4: return new int[]{2, 0};
            case 5: return new int[]{2, 2};
            case 6: return new int[]{2, 4};
            case 7: return new int[]{4, 0};
            case 8: return new int[]{4, 2};
            case 9: return new int[]{4, 4};
            default: return new int[]{-1, -1};
        }
    }

    public static boolean checkWinner(char symbol) {
        // Rows, columns and diagonals
        return (board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) ||
               (board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) ||
               (board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) ||
               (board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) ||
               (board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) ||
               (board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) ||
               (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) ||
               (board[0][4] == symbol && board[2][2] == symbol && board[4][0] == symbol);
    }
}
