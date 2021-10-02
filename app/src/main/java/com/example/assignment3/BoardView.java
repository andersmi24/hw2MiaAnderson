/**
 * BoardView
 * This class controlls how the board looks, such as setting the buttons and
 * creating the board
 *
 * @author Mia Anderson
 * @version 10/1/21
 */
package com.example.assignment3;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.widget.Button;
import android.graphics.Canvas;
import java.util.ArrayList;

public class BoardView {

    public ArrayList<Button> buttonsArr;
    public int[][] boardArr;
    public int[][] solutionArr;
    public Paint green;

    /**
     * BoardView Constructor initializes boardArr, solutionArr, and buttonsArr
     */
    public BoardView(){
        super();

        boardArr = new int[4][4];
        solutionArr = new int[][]{{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12,}, {13, 14, 15, 16}};
        buttonsArr = new ArrayList<Button>(16);

    }

    /**
     * This method creates a random board by first settings all postions on the
     * board to to -1 then random selecting 15 out of the 16 to set to a number
     * 1-15. The remaining position that contains the -1 will be the "empty" sqaure.
     */
    public void createBoard(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                //first set all positions on the board to -1
                boardArr[i][j] = -1;
            }
        }
        for(int i = 1; i <= 15; i++){
            //randomly select 15 positions on the board to set to the numbers
            //1-15
            int randRow = (int) ((4)*Math.random());
            int ranCol = (int) ((4)*Math.random());

            if(boardArr[randRow][ranCol] == -1){
                //if postion has not been set to a number yet
                boardArr[randRow][ranCol] = i;
            }
            else{
                //if position has been set to a number reset counter minus 1 and try
                //again until position is found that equals -1
                i--;
            }
        }
    }

    /**
     * This method sets the text on the buttons based on the boardArr[][] value
     * @param ArrayList</Button> buttonsArr
     */
    public void setButtonsText(ArrayList<Button> buttonsArr){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(boardArr[i][j] == -1){
                    //-1 is the empty button
                    //gets the buttons from the button array list
                    this.buttonsArr.get((i*4) + j).setText("");
                }
                else{
                    //sets button's text based on boardArr[][] value at that position
                    this.buttonsArr.get((i*4) + j).setText("" + boardArr[i][j]);
                }
            }

        }
    }

    /**
     * Calls on createBoard() then setButtonsText() to reset then board
     * when reset button is clicked
     */
    public void reset(){
        this.createBoard();
        this.setButtonsText(buttonsArr);
    }

}
