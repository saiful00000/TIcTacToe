package com.example.tictactoe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    EditText player1Et, player2Et;

    int[][] table = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    boolean[][] alreadyClicked = {{false, false, false}, {false, false, false}, {false, false, false}};

    boolean playerState = true;
    int totalbite = 0;


    String playerOneName = "Player One";
    String playerTwoName = "Player Two";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Et = findViewById(R.id.player1_et_id);
        player2Et = findViewById(R.id.player2_et_id);
        playerOneName = player1Et.getText().toString();
        playerTwoName = player2Et.getText().toString();

        btn = findViewById(R.id.btnid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(getAsString());
            }
        });

    }

    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.r0c0_imgview_id:
                imageView1 = findViewById(v.getId());
                clickOperation(0,0, imageView1);
                checkGameState();
                break;
            case R.id.r0c1_imgview_id:
                imageView2 = findViewById(v.getId());
                clickOperation(0,1, imageView2);
                checkGameState();
                break;
            case R.id.r0c2_imgview_id:
                imageView3 = findViewById(v.getId());
                clickOperation(0,2, imageView3);
                checkGameState();
                break;
            case R.id.r1c0_imgview_id:
                imageView4 = findViewById(v.getId());
                clickOperation(1,0, imageView4);
                checkGameState();
                break;
            case R.id.r1c1_imgview_id:
                imageView5 = findViewById(v.getId());
                clickOperation(1,1, imageView5);
                checkGameState();
                break;
            case R.id.r1c2_imgview_id:
                imageView6 = findViewById(v.getId());
                clickOperation(1,2, imageView6);
                checkGameState();
                break;
            case R.id.r2c0_imgview_id:
                imageView7 = findViewById(v.getId());
                clickOperation(2,0, imageView7);
                checkGameState();
                break;
            case R.id.r2c1_imgview_id:
                imageView8 = findViewById(v.getId());
                clickOperation(2,1, imageView8);
                checkGameState();
                break;
            case R.id.r2c2_imgview_id:
                imageView9 = findViewById(v.getId());
                clickOperation(2,2, imageView9);
                checkGameState();
                break;
        }

    }

    public void openDialog(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Restart",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetEveryThing();
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void resetEveryThing() {
        table = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        alreadyClicked= new boolean[][]{{false,false,false},{false,false,false},{false,false,false}};
        playerState = true;
        totalbite = 0;
        imageView1 = findViewById(R.id.r0c0_imgview_id);
        imageView2 = findViewById(R.id.r0c1_imgview_id);
        imageView3 = findViewById(R.id.r0c2_imgview_id);
        imageView4 = findViewById(R.id.r1c0_imgview_id);
        imageView5 = findViewById(R.id.r1c1_imgview_id);
        imageView6 = findViewById(R.id.r1c2_imgview_id);
        imageView7 = findViewById(R.id.r2c0_imgview_id);
        imageView8 = findViewById(R.id.r2c1_imgview_id);
        imageView9 = findViewById(R.id.r2c2_imgview_id);

        imageView1.setImageResource(0);
        imageView2.setImageResource(0);
        imageView3.setImageResource(0);
        imageView4.setImageResource(0);
        imageView5.setImageResource(0);
        imageView6.setImageResource(0);
        imageView7.setImageResource(0);
        imageView8.setImageResource(0);
        imageView9.setImageResource(0);
    }

    String getAsString() {
        String s = "";
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                int a = table[i][j];
                s += " " + a;
            }
        }
        return s;
    }

    public int getWinner() {
        // check for possition one
        if (table[0][0] != 0) {
            if (table[0][0] == table[0][1] && table[0][0] == table[0][2])
                return table[0][0];
            if (table[0][0] == table[1][0] && table[0][0] == table[2][0])
                return table[0][0];
            if (table[0][0] == table[1][1] && table[0][0] == table[2][2])
                return table[0][0];
        }


        // check frome middle
        if (table[1][1] != 0){
            if (table[1][1] == table[0][1] && table[1][1] == table[2][1])
                return table[1][1];
            if (table[1][1] == table[1][0] && table[1][1] == table[1][2])
                return table[1][1];
            if (table[1][1] == table[0][2] && table[1][1] == table[2][0])
                return table[1][1];
        }

        // check from last possition
        if (table[2][2] != 0){
            if (table[2][2] == table[1][2] && table[2][2] == table[0][2])
                return table[2][2];
            if (table[2][2] == table[2][1] && table[2][2] == table[2][0])
                return table[2][2];
        }

        return 0;
    }

    public void checkGameState() {
        if (totalbite < 4){
            return;
        }
        if (getWinner() == 0 && totalbite == 9){
            openDialog("Game Over !!");
            return;
        }
        if (getWinner() == 1) {
            openDialog("Player one is win, whith tik");
        } else if (getWinner() == 2) {
            openDialog("Player 2 is win with cross");
        }
    }

    public void clickOperation(int i, int j, ImageView imageView) {
        if (alreadyClicked[i][j] == false) {
            if (playerState == true) {
                table[i][j] = 1;
                playerState = false;
                totalbite++;
                imageView.setImageResource(R.drawable.tick);
            } else {
                table[i][j] = 2;
                playerState = true;
                totalbite++;
                imageView.setImageResource(R.drawable.redclear);
            }
            alreadyClicked[i][j] = true;
        }
    }


}// end of cllaa
