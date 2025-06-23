
public class ChessGame {

    public static void main(String[] args) {
        System.out.println("Welcome to Simple Chess!");
        System.out.println("This is a basic chessboard setup.");

        String[][] board = new String[8][8];
        initializeBoard(board);
        printBoard(board);
    }

    public static void initializeBoard(String[][] board) {
        // Initialize empty spaces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ".";
            }
        }

        // Setup pawns
        for (int j = 0; j < 8; j++) {
            board[1][j] = "P"; // White pawns
            board[6][j] = "p"; // Black pawns
        }

        // Setup other pieces
        String[] whitePieces = {"R", "N", "B", "Q", "K", "B", "N", "R"};
        String[] blackPieces = {"r", "n", "b", "q", "k", "b", "n", "r"};

        board[0] = whitePieces;
        board[7] = blackPieces;
    }

    public static void printBoard(String[][] board) {
        for (int i = 7; i >= 0; i--) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
