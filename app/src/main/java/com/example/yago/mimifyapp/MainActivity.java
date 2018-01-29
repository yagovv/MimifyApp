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
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends Activity {

    EditText input;
    ImageButton botonMimify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.inputText);
        botonMimify = findViewById(R.id.button_mimify);

        botonMimify.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {


                        mimify();

                    }
                }
        );


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
    public void onResume(){
        super.onResume();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            getFromClipboard();
    }
}
