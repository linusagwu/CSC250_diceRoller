package com.example.csc250_diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView qtyTV;
    private TextView selectedDieTV;
    private String currentQtyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.qtyTV = this.findViewById(R.id.qtyTV);
        this.selectedDieTV = this.findViewById(R.id.selectedDieTV);
        this.qtyTV.setText("");
        this.currentQtyText = "";
    }
    private String extractNumberOfSides (String diceType)
    {
        // take something that looks like "D4" and return "4"
        String answer = "";
        for(int i = 1; i <  diceType.length(); i++)
        {
            answer += diceType.charAt(i);
        }
        return answer;
    }
    public void onRollButtonPressed(View v)
    {
        //get the qty as an int
        String qtyString = this.qtyTV.getText().toString();
        int qtyInt = Integer.parseInt(qtyString);
        int[] theRolls = new int[qtyInt];

        //get the number of sides as an int
        String fullDiceString = this.selectedDieTV.getText().toString(); //LIKE "D4" or "D6"
        String trimmedDiceString = this.extractNumberOfSides(fullDiceString);
        // string trimmedDiceString = fullDiceString(1);
        int numberOfSides = Integer.parseInt(trimmedDiceString);
         Random r = new Random();



    }
    public void diceButtonPressed(View v)
    {
        this.selectedDieTV.setText(v.getTag().toString());
    }

    public void clearButtonPressed(View v) {
        this.currentQtyText = "";
        this.qtyTV.setText(this.currentQtyText);

    }

    public void qtyButtonpressed(View v)
    {
        Button b = (Button) v;

        if(this.currentQtyText.length() == 0 && b.getText().equals("0"))
        {
            return;
        }
        this.currentQtyText += b.getText();
        this.qtyTV.setText(this.currentQtyText);
    }
}