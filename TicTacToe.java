import java.util.*;

public class TicTacToe {

    // Variablen, die benötigt werden
    final int board[][] = new int[3][3];
    boolean spielerX = true; // Spieler X beginnt standardmäßig
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }

    // Methode, um das Spielfeld zu drucken
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char symbol = '-';
                if (board[i][j] == 1) {
                    symbol = 'X';
                } else if (board[i][j] == 2) {
                    symbol = 'O';
                }
                System.out.print(" | " + symbol);
            }
            System.out.println(" | ");
        }
    }

    // Methode, um den Gewinner zu überprüfen
    public int checkWinner() {
        // Horizontale, vertikale und diagonale Gewinnbedingungen prüfen
        for (int i = 0; i < 3; i++) {
            // Horizontale Reihen
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return board[i][0];
            }
            // Vertikale Reihen
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
                return board[0][i];
            }
        }
        // Diagonalen
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
            return board[0][2];
        }
        return 0; // Kein Gewinner
    }

    // Methode, um zu prüfen, ob das Spielfeld voll ist (Unentschieden)
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false; // Es gibt noch freie Felder
                }
            }
        }
        return true; // Das Spielfeld ist voll
    }

    // Methode, um das Spiel zu spielen
    public void playGame() {
        System.out.println("Willkommen zu Tic Tac Toe!");
        printBoard();

        while (true) {
            if (spielerX) {
                System.out.println("Spieler X ist am Zug. Geben Sie die Zeile und Spalte ein (1-3): ");
            } else {
                System.out.println("Spieler O ist am Zug. Geben Sie die Zeile und Spalte ein (1-3): ");
            }

            int row = s.nextInt() - 1;
            int col = s.nextInt() - 1;

            // Prüfen, ob der Zug gültig ist
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != 0) {
                System.out.println("Ungültiger Zug. Versuchen Sie es erneut.");
                continue;
            }

            // Setzen des Zuges auf das Spielfeld
            if (spielerX) {
                board[row][col] = 1;
            } else {
                board[row][col] = 2;
            }

            // Spielfeld ausdrucken
            printBoard();

            // Überprüfen, ob es einen Gewinner gibt
            int winner = checkWinner();
            if (winner != 0) {
                if (winner == 1) {
                    System.out.println("Spieler X gewinnt!");
                } else {
                    System.out.println("Spieler O gewinnt!");
                }
                break;
            }

            // Überprüfen, ob das Spielfeld voll ist (Unentschieden)
            if (isBoardFull()) {
                System.out.println("Unentschieden!");
                break;
            }

            // Spieler wechseln
            spielerX = !spielerX;
        }

        System.out.println("Spiel beendet.");
    }
}
