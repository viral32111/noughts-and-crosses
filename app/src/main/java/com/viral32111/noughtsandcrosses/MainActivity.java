package com.viral32111.noughtsandcrosses;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    TextView playerTextview;
    Button[] buttons;
    String currentTurn="X"; // X or O

    private void setTurn(String turn){
        playerTextview.setText("Current turn: "+turn);
        currentTurn=turn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerTextview=(TextView)findViewById(R.id.playerTextview);
        setTurn(currentTurn);

        buttons = new Button[]{
                findViewById(R.id.buttonOne),
                findViewById(R.id.buttonTwo),
                findViewById(R.id.buttonThree),
                findViewById(R.id.buttonFour),
                findViewById(R.id.buttonFive),
                findViewById(R.id.buttonSix),
                findViewById(R.id.buttonSeven),
                findViewById(R.id.buttonEight),
                findViewById(R.id.buttonNine)
        };
    }

    public void resetGameButton(View view){
        for(Button button : buttons){
            button.setText("");
            button.setEnabled(true);
        }
    }

    public void buttonPress(View view){
        Button button=(Button)findViewById(view.getId());
        button.setText(currentTurn);
        button.setEnabled(false);

        if(currentTurn=="X"){
            setTurn("O");
        }else if (currentTurn=="O"){
            setTurn("X");
        }
    }
}
