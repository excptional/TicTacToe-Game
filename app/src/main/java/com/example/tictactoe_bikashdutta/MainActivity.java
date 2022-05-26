package com.example.tictactoe_bikashdutta;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};


    int winPositions[][] = { {0,1,2}, {3,4,5}, {6,7,8},
                                {0,3,6}, {1,4,7}, {2,5,8},
                                {0,4,8}, {2,4,6}};
    boolean gameActive = true;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt((String) img.getTag());
        if(gameState[(tappedImage)] == 2 && gameActive){
            gameState[(tappedImage)] = activePlayer;
            img.setTranslationZ(-1000f);
            if(activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Now O's Turn....Tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Now X's Turn....Tap to play");
            }
            img.animate().translationZBy(1000f).setDuration(500);
        }
        for(int winPosition[] : winPositions){

            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2){
                gameActive = false;
                View b = findViewById(R.id.mybutton);
                b.setVisibility(View.VISIBLE);
                if(gameState[winPosition[0]] == 0) {
                    TextView status = findViewById(R.id.status);
                    status.setText("'X' has win....Reset the game");
                }else{
                    TextView status = findViewById(R.id.status);
                    status.setText("'O' has win....Reset the game");
                }
            }
            if((gameState[winPosition[0]] != gameState[winPosition[1]] ||
                    gameState[winPosition[1]] != gameState[winPosition[2]] ||
                    gameState[winPosition[0]] != gameState[winPosition[2]]) &&
                    gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2 &&
                    gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 &&
                    gameState[7] != 2 && gameState[8] != 2 ){
                    gameActive = false;
                    View b = findViewById(R.id.mybutton);
                    b.setVisibility(View.VISIBLE);
                    TextView status = findViewById(R.id.status);
                    status.setText("It's a draw....Reset the game");
            }
        }
    }

    public void reset(View view){

        gameActive = true;
        activePlayer = 0;
        for(int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("Tap to start the game....");
        View b = findViewById(R.id.mybutton);
        b.setVisibility(View.GONE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}