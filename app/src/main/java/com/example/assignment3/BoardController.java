/**
 * BoardController
 * This class controls the board, more specifically controls clicks to the
 * board and how handle the clicks
 *
 * @author Mia Anderson
 * @version 10/1/21
 */

package com.example.assignment3;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class BoardController implements View.OnClickListener{

    public BoardView boardV;

    /**
     * BoardController Constructor
     * Contains an instance of BoardView
     *
     * @param boardView
     */
    public BoardController(BoardView boardView){
        boardV = boardView;
    }


    /**
     * onClick uses switch statement to decipher what button was clicked then based on the
     * button clicked sends the row and column values of that button to the switchButtons
     * to determine if the button should be switch with the empty button
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        int row;
        int col;
        //found how to know what button is clicked from:
        //https://stackoverflow.com/questions/3412180/how-to-determine-which-button-pressed-on-android
        switch(view.getId()) {

            case R.id.reset:
                //if reset button is clicked, calls on reset method
                boardV.reset();
                break;
            case R.id.button1:
                row = 0;
                col = 0;
                switchButtons(row, col);
                break;
            case R.id.button2:
                row = 0;
                col = 1;
                switchButtons(row, col);
                break;
            case R.id.button3:
                row = 0;
                col = 2;
                switchButtons(row, col);
                break;
            case R.id.button4:
                row = 0;
                col = 3;
                switchButtons(row, col);
                break;
            case R.id.button5:
                row = 1;
                col = 0;
                switchButtons(row, col);
                break;
            case R.id.button6:
                row = 1;
                col = 1;
                switchButtons(row, col);
                break;
            case R.id.button7:
                row = 1;
                col = 2;
                switchButtons(row, col);
                break;
            case R.id.button8:
                row = 1;
                col = 3;
                switchButtons(row, col);
                break;
            case R.id.button9:
                row = 2;
                col = 0;
                switchButtons(row, col);
                break;
            case R.id.button10:
                row = 2;
                col = 1;
                switchButtons(row, col);
                break;
            case R.id.button11:
                row = 2;
                col = 2;
                switchButtons(row, col);
                break;
            case R.id.button12:
                row = 2;
                col = 3;
                switchButtons(row, col);
                break;
            case R.id.button13:
                row = 3;
                col = 0;
                switchButtons(row, col);
                break;
            case R.id.button14:
                row = 3;
                col = 1;
                switchButtons(row, col);
                break;
            case R.id.button15:
                row = 3;
                col = 2;
                switchButtons(row, col);
                break;
            case R.id.button16:
                row = 3;
                col = 3;
                switchButtons(row, col);
                break;
        }

    }

    /**
     * This method checks if above, below, left, and right of the button clicked and
     * if the empty button is in one of those positions, switches the the values that
     * the buttons display
     *
     * @param row
     * @param col
     */
    public void switchButtons(int row, int col){
        //covert 2d array values to position in buttons array list
        int arrLPos = getArrLPosition(row, col);

        int posClicked = boardV.boardArr[row][col];

        if(posClicked != -1){
            //if -1 this is the empty space and should not be clicked
            /**
             * External Citation
             * Date: September 30
             * Problem:Could not get my buttons to flip value
             *
             * Resource:Went to tutor and realized I needed to change bounds checks
             */

            //checks if empty button is on top of button clicked
            if((row - 1 > -1)) { //check bounds
                if (boardV.boardArr[row - 1][col] == -1) {
                    //swap board array values
                    int temp = boardV.boardArr[row][col];
                    boardV.boardArr[row][col] = boardV.boardArr[row - 1][col];
                    boardV.boardArr[row - 1][col] = temp;

                    //swap button text
                    CharSequence tempString = boardV.buttonsArr.get(arrLPos).getText();
                    boardV.buttonsArr.get(arrLPos).setText(boardV.buttonsArr.get(arrLPos - 4).getText());
                    boardV.buttonsArr.get(arrLPos - 4).setText(tempString);

                }
            }
            //checks if empty button is below button clicked
            if(row + 1 < 4) {
                if( boardV.boardArr[row+1][col]== -1){
                    //swap board array values
                    int temp = boardV.boardArr[row][col];
                    boardV.boardArr[row][col] = boardV.boardArr[row+1][col];
                    boardV.boardArr[row+1][col] = temp;

                    //swap button text
                    CharSequence tempString = boardV.buttonsArr.get(arrLPos).getText();
                    boardV.buttonsArr.get(arrLPos).setText(boardV.buttonsArr.get(arrLPos+4).getText());
                    boardV.buttonsArr.get(arrLPos+4).setText(tempString);

                }
            }
            //checks if empty button is to the left of button clicked
            if(col - 1 > -1){
                if(boardV.boardArr[row][col-1] == -1){
                    //swap board array values
                    int temp = boardV.boardArr[row][col];
                    boardV.boardArr[row][col] = boardV.boardArr[row][col-1];
                    boardV.boardArr[row][col-1] = temp;

                    //swap button text
                    CharSequence tempString = boardV.buttonsArr.get(arrLPos).getText();
                    boardV.buttonsArr.get(arrLPos).setText(boardV.buttonsArr.get(arrLPos-1).getText());
                    boardV.buttonsArr.get(arrLPos-1).setText(tempString);

                }
            }
            //checks if empty button is to the right of button clicked
            if(col + 1 < 4){
                if(boardV.boardArr[row][col+1] == -1){
                    //swap board array values
                    int temp = boardV.boardArr[row][col];
                    boardV.boardArr[row][col] = boardV.boardArr[row][col+1];
                    boardV.boardArr[row][col+1] = temp;

                    //swap button text
                    CharSequence tempString = boardV.buttonsArr.get(arrLPos).getText();
                    boardV.buttonsArr.get(arrLPos).setText(boardV.buttonsArr.get(arrLPos+1).getText());
                    boardV.buttonsArr.get(arrLPos+1).setText(tempString);

                }
            }

        }
        //after each click call on check correct to see if ALL buttons are in the correct spots
        //Assuming the assignment whats the color of the buttons to change if ALL buttons
        //are positioned correctly
        checkCorrect();

    }

    /**
     * Converts the board 2D array to the position within the buttons Array List
     * The buttons array list is 1D and size 16 so this conversion is neccessary
     *
     * @param int r
     * @param int c
     * @return int position
     */
    public int getArrLPosition(int r, int c){
        int position = r * 4 + c;
        return position;
    }

    /**
     * This method checks if all of the buttons on the board are in their correct positions
     * and if they are turns the buttons green
     *
     */
    public void checkCorrect(){
        boolean isCorrect = true;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if((boardV.boardArr[i][j] != boardV.solutionArr[i][j])){
                    isCorrect = false;
                }
            }
        }

        /**
         * External Citation:
         * Date: September 30
         * Problem: Did not know how to change the buttons color to green
         *
         * Resource: Went to tutoring and was taught how to do this
         *
         */
        if(isCorrect) {
            for(int i = 0; i < 16; i++){
                //change buttons color to green
                boardV.buttonsArr.get(i).setBackgroundColor(Color.GREEN);
            }
        }
    }


    }


