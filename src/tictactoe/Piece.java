/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author HLC
 */
public class Piece {
    private String type;
    private int row;
    private int col;
    
    public Piece(String type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
   
    public int getCol() {
        return col;
    }

    public String getType() {
        return type;
    }
}
