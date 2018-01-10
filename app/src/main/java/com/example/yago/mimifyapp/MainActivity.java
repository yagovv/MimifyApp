package com.example.yago.mimifyapp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText input;
    EditText output;
    Button botonMimify;
    Button botonCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.inputText);
        output = (EditText)findViewById(R.id.outputText);
        botonMimify = (Button)findViewById(R.id.button_mimify);
        botonCopy = (Button)findViewById(R.id.button_clipboard);

        botonMimify.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        mimify();
                    }
                }
        );

        botonCopy.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        copyToClipboard();
                    }
                }
        );



    }

    public void mimify(){
        String toMimify = input.getText().toString();
        String mimified = toMimify.replace('e','i').replace('a','i').replace('o','i').replace('u','i').replace('A','I').
                replace('E','I').replace('O','I').replace('U','I').replace('é','í').replace('á','í').
                replace('ó','í').replace('ú','í').replace('Á','Í').replace('É','Í').replace('Ó','Í').replace('Ú','Í');
        output.setText(mimified);
    }
    public void copyToClipboard(){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("mimified",output.getText());
        clipboard.setPrimaryClip(clip);
    }
    public void getFromClipboard(){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        input.setText(clipboard.getText());

    }
    public void onResume(){
        super.onResume();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        if(output.getText()!=clipboard.getText()) {
            getFromClipboard();
        }
    }
}
