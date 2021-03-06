package com.example.yago.mimifyapp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.Random;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends Activity {

    EditText input;
    ImageButton botonMimify;
    Button botonClear;
    Button botonPaste;
    ImageButton botonSpongify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.inputText);
        botonMimify = findViewById(R.id.button_mimify);
        botonClear = findViewById(R.id.button_clear);
        botonPaste = findViewById(R.id.button_copy);
        botonSpongify = findViewById(R.id.button_spongify);
        botonClear.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {


                        clear();

                    }
                }
        );
        botonPaste.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        getFromClipboard();
                    }
                }
        );

        botonMimify.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {


                        mimify();

                    }
                }
        );

        botonSpongify.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {


                        spongify();

                    }
                }
        );


    }
    public void spongify(){
        String toSpongify = input.getText().toString();
        char [] spongified_min = toSpongify.toLowerCase().toCharArray();
        char [] spongified_max = toSpongify.toUpperCase().toCharArray();
        char [] spongified = toSpongify.toCharArray();
        Random rand = new Random();

        for(int i =0;i<toSpongify.length();i++){
            int  n = rand.nextInt(2) + 1;
            if(n==1){
                spongified[i] = spongified_min[i];
            }
            if(n==2){
                spongified[i] = spongified_max[i];
            }
        }
        Intent intent = new Intent(this, MimifiedActivity.class);
        String hecho = String.valueOf(spongified);
        intent.putExtra("EXTRA_MESSAGE", hecho);
        startActivity(intent);
    }
    public void mimify(){
        String toMimify = input.getText().toString();
        String mimified = toMimify.replace('e','i').replace('a','i').replace('o','i').replace('u','i').replace('A','I').
                replace('E','I').replace('O','I').replace('U','I').replace('é','í').replace('á','í').
                replace('ó','í').replace('ú','í').replace('Á','Í').replace('É','Í').replace('Ó','Í').replace('Ú','Í');
        Intent intent = new Intent(this, MimifiedActivity.class);

        intent.putExtra("EXTRA_MESSAGE", mimified);
        startActivity(intent);
    }

    public void getFromClipboard(){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        input.setText(clipboard.getText());

    }
    /*
    public void onResume(){
        super.onResume();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            getFromClipboard();
    }*/
    public void clear(){
        input.setText("");
    }
}
