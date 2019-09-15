package com.example.numsum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SP = "sp";
    private static final String TOTAL = "total";
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.textTotal);

        SharedPreferences sp = getSharedPreferences(SP, MODE_PRIVATE);
        total.setText(sp.getString(TOTAL, "0"));


        final TextView current = findViewById(R.id.textCurrent);

        final Button commit = findViewById(R.id.buttonE);
        final ImageButton delete = findViewById(R.id.buttonDel);
        final ImageButton clear = findViewById(R.id.buttonClear);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textTotal = total.getText().toString();
                String textCurrent = current.getText().toString();

                if (!textCurrent.equals("")) {
                    total.setText(string(toInt(textTotal) + toInt(textCurrent)));
                    current.setText("");
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = current.getText().toString();
                if (text.length() > 0) {
                    current.setText(text.substring(0,text.length()-1));
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                total.setText("0");
            }
        });

        Button[] buttons = new Button[10];
        buttons[0] = findViewById(R.id.button0);
        buttons[1] = findViewById(R.id.button1);
        buttons[2] = findViewById(R.id.button2);
        buttons[3] = findViewById(R.id.button3);
        buttons[4] = findViewById(R.id.button4);
        buttons[5] = findViewById(R.id.button5);
        buttons[6] = findViewById(R.id.button6);
        buttons[7] = findViewById(R.id.button7);
        buttons[8] = findViewById(R.id.button8);
        buttons[9] = findViewById(R.id.button9);

        buttons[0].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("0");
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("1");
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("2");
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("3");
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("4");
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("5");
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("6");
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("7");
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("8");
            }
        });
        buttons[9].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                current.append("9");
            }
        });
    }

    protected void onStop() {
        super.onStop();

        SharedPreferences sp = getSharedPreferences(SP, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(TOTAL, total.getText().toString());

        editor.apply();
    }

    public static int toInt(String s){
        return Integer.parseInt(s);
    }
    public static String string(int i){
        return Integer.toString(i);
    }

}
