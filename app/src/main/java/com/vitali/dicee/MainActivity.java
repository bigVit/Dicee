package com.vitali.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final int diceArray[] = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView leftDice = findViewById(R.id.image_leftDice);
        final ImageView rightDice = findViewById(R.id.image_rightDice);
        final TextView countText = findViewById(R.id.totalCount);

        Button rollButton = findViewById(R.id.rollButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int left = updateLeftCell(new Random(), leftDice);
                int right = updateRightCell(new Random(), rightDice);
                int total = left + right + 2;
                countText.setText("You total is: " + total);
            }
        });
    }


    /**
     * @param randomNumberGenereted
     * @param leftDice
     * @return
     */
    public int updateLeftCell(Random randomNumberGenereted, ImageView leftDice){
        int numberLeft = randomNumberGenereted.nextInt(6);
        leftDice.setImageResource(diceArray[numberLeft]);
        return numberLeft;
    }


    /**
     * @param randomNumberGenereted
     * @param rightDice
     * @return
     */
    public int updateRightCell(Random randomNumberGenereted, ImageView rightDice){
        int numberRight = randomNumberGenereted.nextInt(6);
        rightDice.setImageResource(diceArray[numberRight]);
        return numberRight;
    }
}
