package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author HLC
 */
public class GUI extends JFrame{
    private JFrame frame;
    private JButton[] button;
    private Board board;
    private int rows;
    private int cols;

    public GUI(int r, int c) {
        frame = new JFrame();
        button = new JButton[r * c];
        board = new Board(r, c);
        rows = r;
        cols = c;
        
        for (int i = 0; i < r * c; i++) {
            button[i] = new JButton();
            button[i].setFont(new Font("Monospace", Font.BOLD, 75));
            button[i].addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < button.length; i++) {
                        if (e.getSource().equals(button[i])) {
                            if (board.notPiece(i%r, i/c)) {
                                if (board.getTurn() % 2 == 0) {
                                    board.addPiece(new Piece("X", i%r, i/c), i%r, i/c);
                                    button[i].setText("X");
                                    button[i].setForeground(Color.red);
                                } else {
                                    board.addPiece(new Piece("O", i%r, i/c), i%r, i/c);
                                    button[i].setText("O");
                                    button[i].setForeground(Color.GREEN);
                                }
                                
                                if (board.isWinner()) {                                    
                                    showConfirmation(board.getWinner());
                                } else if (board.isTie()) {
                                    showConfirmation("Nobody");
                                } else {
                                    board.play();
                                }
                            }
                        }
                    }
                }
            });
            frame.add(button[i]);
        }
        
        frame.setLayout(new GridLayout(r, c));
        frame.setSize(r * 200 + 20, c * 200 + 20);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void showConfirmation(String winner) {
        int selectedOption = JOptionPane.showConfirmDialog(null, 
        winner + " wins!\nWant to play again?", 
        "Game Over", 
        JOptionPane.YES_NO_OPTION); 

        if (selectedOption == JOptionPane.YES_OPTION) {
            board = new Board(rows, cols);
            
            for (int i = 0; i < button.length; i++) {
                button[i].setText("");
            }
        } else if (selectedOption == JOptionPane.NO_OPTION) {
            System.exit(0);
        }   
    }
}
