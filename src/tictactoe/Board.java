package tictactoe;

/**
 *
 * @author HLC
 */
public class Board {
    private Piece[][] board;
    private int rows;
    private int cols;
    private int turn = 0;
    private String winner;
    
    public Board(int rows, int cols) {
        board = new Piece[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }
    
    public void play() {
        turn++;
    }
    
    public int getTurn() {
        return turn;
    }
    
    public void addPiece(Piece piece, int row, int col) {
        board[row][col] = piece;
    }
    
    public boolean isWinner() {
        for (int r = 0; r < rows; r++) { // check columns
            int countX = 0;
            int countO = 0;
            
            for (int c = 0; c < cols; c++) {
                if (board[r][c] != null) {
                    if (board[r][c].getType() == "X") {
                        countX++;
                    } else {
                        countO++;
                    }
                }
            }
            
            if (countX == cols) {
                winner = "Player1";
                return true;
            } else if (countO == cols) {
                winner = "Player2";
                return true;
            }
        }
        
        for (int r = 0; r < rows; r++) { // check rows
            int countX = 0;
            int countO = 0;
            
            for (int c = 0; c < cols; c++) {
                if (board[c][r] != null) {
                    if (board[c][r].getType() == "X") {
                        countX++;
                    } else {
                        countO++;
                    }
                }
            }
            
            if (countX == rows) {
                winner = "Player1";
                return true;
            } else if (countO == rows) {
                winner = "Player2";
                return true;
            }
        }
        
        int[] counts = new int[4];
        
        for (int a = 0; a < rows; a++) { // check diagonals
            if (board[a][a] != null) {
                if (board[a][a].getType() == "X") {
                    counts[0]++;
                } else {
                    counts[1]++;
                }
            }
            
            if (board[a][cols-1-a] != null) {
                if (board[a][cols-1-a].getType() == "X") {
                    counts[2]++;
                } else {
                    counts[3]++;
                }
            }
        }
        
        if (counts[0] == rows || counts[2] == rows) {
            winner = "Player1";
            return true;
        } else if (counts[1] == rows || counts[3] == rows) {
            winner = "Player2";
            return true;
        }
        
        return false;
    }
    
    public boolean isTie() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == null) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public String getWinner() {
        return winner;
    }
    
    public boolean notPiece(int row, int col) {
        return board[row][col] == null;
    }
}