package com.example.android.quizappproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    static int totalPoints;
    RadioButton questionOneAnswerTwo;
    RadioButton questionTwoAnswerThree;
    RadioButton questionThreeAnswerTrue;
    RadioButton questionFourAnswerTrue;
    EditText questionSixEditText;
    CheckBox questionFiveAnswerOne;
    CheckBox questionFiveAnswerFour;
    CheckBox questionFiveAnswerTwo;
    CheckBox questionFiveAnswerThree;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionOneAnswerTwo = findViewById(R.id.questionOneAnswerTwo_radio);
        questionTwoAnswerThree = findViewById(R.id.questionTwoAnswerThree_radio);
        questionThreeAnswerTrue = findViewById(R.id.questionThreeAnswerTrue_radio);
        questionFourAnswerTrue = findViewById(R.id.questionFourAnswerTrue_radio);
        questionFiveAnswerOne = findViewById(R.id.questionFiveAnswerOne_checkbox);
        questionFiveAnswerFour = findViewById(R.id.questionFiveAnswerFour_checkbox);
        questionFiveAnswerTwo = findViewById(R.id.questionFiveWrongAnswer_checkbox);
        questionFiveAnswerThree = findViewById(R.id.questionFiveWrongAnswer1_checkbox);
        questionSixEditText = findViewById(R.id.questionSix_editText);

    }

    /**
      *This method is called when score button is clicked. Calculates correct answers.
      */

    public void submitAnswers(View v) {

        if(questionOneAnswerTwo.isChecked()) {
            totalPoints ++;
        }
        if(questionTwoAnswerThree.isChecked()) {
            totalPoints ++;
        }
        if(questionThreeAnswerTrue.isChecked()) {
            totalPoints ++;
        }
        if(questionFourAnswerTrue.isChecked()) {
            totalPoints ++;
        }
        if((questionFiveAnswerOne.isChecked()) && (questionFiveAnswerFour.isChecked())) {
            totalPoints ++;
        }
        if ((questionFiveAnswerTwo.isChecked()) && (questionFiveAnswerThree.isChecked())) {
            totalPoints = 0;
        }

        String questionSixString = questionSixEditText.getText().toString();
        if(questionSixString.equals("I Love Dolphins")) {
            totalPoints ++;
        }


        // Show score message as a toast
        String messageZero = getResources().getString(R.string.toast0);
        String lessPoints = getResources().getString(R.string.toast1);
        String messageLess = String.format(lessPoints, totalPoints);
        String mediumPoints = getResources().getString(R.string.toast2);
        String messageMedium = String.format(mediumPoints, totalPoints);
        String highPoints = getResources().getString(R.string.toast3);
        String messageHigh = String.format(highPoints, totalPoints);

        if(totalPoints == 0) {
            Toast.makeText(this, messageZero, Toast.LENGTH_LONG).show();
        } else if(totalPoints <3) {
            Toast.makeText(this, messageLess, Toast.LENGTH_LONG).show();
        } else if(totalPoints == 3 || totalPoints == 4) {
            Toast.makeText(this, messageMedium, Toast.LENGTH_LONG).show();
        } else if(totalPoints >= 5) {
            Toast.makeText(this, messageHigh, Toast.LENGTH_LONG).show();
        }
    }


    /**
     * This method is called when the Reset(Try again) button is clicked
     */
    public void resetAnswers(View v) {
        totalPoints = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
