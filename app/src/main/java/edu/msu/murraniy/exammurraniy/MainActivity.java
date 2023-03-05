package edu.msu.murraniy.exammurraniy;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Constants used to determine the current state
     * NEWLETTER: State where the player enters a new letter
     * GUESSING: State where the player guesses the letter
     * LOSE: State where the player guessed the wrong letter
     */
    private final static int NEWLETTER = 0;
    private final static int GUESSING = 1;
    private final static int LOSE = 2;

    /**
     * Variable for the center textview
     */
    private TextView center;

    /**
     * Variable for the current state int
     */
    private int current_state = 0;

    /**
     * Variable for the current guess
     */
    private int guess = 0;

    /**
     * Variable for the current letter string
     */
    private String code = "";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        center = findViewById(R.id.centerBox);
    }

    public void OnA(View view){
        if(current_state == GUESSING){

            if('A' == code.charAt(guess)){
                guess += 1;
                center.setText(String.valueOf(guess + 1));
                if(guess == code.length()){
                    current_state = NEWLETTER;
                    guess = 0;
                    center.setBackgroundColor(0xff0000ff);
                    center.setText("");
                }

            }else{
                current_state = LOSE;
                center.setBackgroundColor(0xffff0000);
                center.setText(String.valueOf(code.charAt(guess)));
            }

        }else if(current_state == NEWLETTER){
            code += "A";
            current_state = GUESSING;
            guess = 0;
            center.setBackgroundColor(0xff00ff00);
            center.setText("1");
        }
    }

    public void OnB(View view){
        if(current_state == GUESSING){

            if('B' == code.charAt(guess)){
                guess += 1;
                center.setText(String.valueOf(guess + 1));
                if(guess == code.length()){
                    current_state = NEWLETTER;
                    guess = 0;
                    center.setBackgroundColor(0xff0000ff);
                    center.setText("");
                }

            }else{
                current_state = LOSE;
                center.setBackgroundColor(0xffff0000);
                center.setText(String.valueOf(code.charAt(guess)));
            }

        }else if(current_state == NEWLETTER){
            code += "B";
            current_state = GUESSING;
            guess = 0;
            center.setBackgroundColor(0xff00ff00);
            center.setText("1");
        }
    }

    public void OnC(View view){
        if(current_state == GUESSING){

            if('C' == code.charAt(guess)){
                guess += 1;
                center.setText(String.valueOf(guess + 1));
                if(guess == code.length()){
                    current_state = NEWLETTER;
                    guess = 0;
                    center.setBackgroundColor(0xff0000ff);
                    center.setText("");
                }

            }else{
                current_state = LOSE;
                center.setBackgroundColor(0xffff0000);
                center.setText(String.valueOf(code.charAt(guess)));
            }

        }else if(current_state == NEWLETTER){
            code += "C";
            current_state = GUESSING;
            guess = 0;
            center.setBackgroundColor(0xff00ff00);
            center.setText("1");
        }
    }

    public void OnD(View view){
        if(current_state == GUESSING){

            if('D' == code.charAt(guess)){
                guess += 1;
                center.setText(String.valueOf(guess + 1));
                if(guess == code.length()){
                    current_state = NEWLETTER;
                    guess = 0;
                    center.setBackgroundColor(0xff0000ff);
                    center.setText("");
                }

            }else{
                current_state = LOSE;
                center.setBackgroundColor(0xffff0000);
                center.setText(String.valueOf(code.charAt(guess)));
            }

        }else if(current_state == NEWLETTER){
            code += "D";
            current_state = GUESSING;
            guess = 0;
            center.setBackgroundColor(0xff00ff00);
            center.setText("1");
        }
    }

    public void OnStart(View view){
        if(code.length() == 0){
            current_state = NEWLETTER;
            guess = 0;
            center.setBackgroundColor(0xff0000ff);
            center.setText("");
        }else{
            current_state = GUESSING;
            guess = 0;
            center.setBackgroundColor(0xff00ff00);
            center.setText("1");
        }
    }

    public void OnNew(View view){
        code = "";
        current_state = NEWLETTER;
        guess = 0;
        center.setBackgroundColor(0xff0000ff);
        center.setText("");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("guess", guess);
        savedInstanceState.putInt("state", current_state);
        savedInstanceState.putString("code", code);

        String centerString = center.getText().toString();
        ColorDrawable cd = (ColorDrawable)center.getBackground();
        int centerColor = cd.getColor();

        savedInstanceState.putString("centerS", centerString);
        savedInstanceState.putInt("centerC", centerColor);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        guess = savedInstanceState.getInt("guess");
        current_state = savedInstanceState.getInt("state");
        code = savedInstanceState.getString("code");

        center.setText(savedInstanceState.getString("centerS"));
        center.setBackgroundColor(savedInstanceState.getInt("centerC"));
    }
}