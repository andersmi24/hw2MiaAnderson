/**
 * Main Activity for 15-Square puzzle
 * This class finds all the buttons adds them to the arraylist and sets listeners for them
 *
 * @author Mia Anderson
 * @version 10/1/2021
 */
package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public BoardView boardV;
    public BoardController boardC;

    /**
     * This method calls on preliminary methods to create the board and
     * arraylist of buttons. Also sets up the reset button
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardV = new BoardView();
        boardC = new BoardController(boardV);

        boardV.createBoard();
        createArrList(boardV, boardC);
        boardV.setButtonsText(boardV.buttonsArr);


        Button resetButton = (Button) findViewById(R.id.reset);
        resetButton.setOnClickListener(boardC);
    }

    /**
     * This methods finds all of the buttons and adds them to the button arraylist.
     * It also sets onClick listeners for all of the buttons.
     *
     * @param boardV
     * @param boardC
     */
    public void createArrList(BoardView boardV, BoardController boardC){
        Button r0c0 = (Button) findViewById(R.id.button1);
        boardV.buttonsArr.add(r0c0);
        r0c0.setOnClickListener(boardC);

        Button r0c1 = (Button) findViewById(R.id.button2);
        boardV.buttonsArr.add(r0c1);
        r0c1.setOnClickListener(boardC);

        Button r0c2 = (Button) findViewById(R.id.button3);
        boardV.buttonsArr.add(r0c2);
        r0c2.setOnClickListener(boardC);

        Button r0c3 = (Button) findViewById(R.id.button4);
        boardV.buttonsArr.add(r0c3);
        r0c3.setOnClickListener(boardC);

        Button r1c0 = (Button) findViewById(R.id.button5);
        boardV.buttonsArr.add(r1c0);
        r1c0.setOnClickListener(boardC);

        Button r1c1 = (Button) findViewById(R.id.button6);
        boardV.buttonsArr.add(r1c1);
        r1c1.setOnClickListener(boardC);

        Button r1c2 = (Button) findViewById(R.id.button7);
        boardV.buttonsArr.add(r1c2);
        r1c2.setOnClickListener(boardC);

        Button r1c3 = (Button) findViewById(R.id.button8);
        boardV.buttonsArr.add(r1c3);
        r1c3.setOnClickListener(boardC);

        Button r2c0 = (Button) findViewById(R.id.button9);
        boardV.buttonsArr.add(r2c0);
        r2c0.setOnClickListener(boardC);

        Button r2c1 = (Button) findViewById(R.id.button10);
        boardV.buttonsArr.add(r2c1);
        r2c1.setOnClickListener(boardC);

        Button r2c2 = (Button) findViewById(R.id.button11);
        boardV.buttonsArr.add(r2c2);
        r2c2.setOnClickListener(boardC);

        Button r2c3 = (Button) findViewById(R.id.button12);
        boardV.buttonsArr.add(r2c3);
        r2c3.setOnClickListener(boardC);

        Button r3c0 = (Button) findViewById(R.id.button13);
        boardV.buttonsArr.add(r3c0);
        r3c0.setOnClickListener(boardC);

        Button r3c1 = (Button) findViewById(R.id.button14);
        boardV.buttonsArr.add(r3c1);
        r3c1.setOnClickListener(boardC);

        Button r3c2 = (Button) findViewById(R.id.button15);
        boardV.buttonsArr.add(r3c2);
        r3c2.setOnClickListener(boardC);

        Button r3c3 = (Button) findViewById(R.id.button16);
        boardV.buttonsArr.add(r3c3);
        r3c3.setOnClickListener(boardC);

    }
}