package com.example.yago.mimifyapp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MimifiedActivity extends Activity {
    TextView mimified;
    Button copy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimified);
        mimified = findViewById(R.id.mimified);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");

        // Capture the layout's TextView and set the string as its text
        mimified.setMovementMethod(new ScrollingMovementMethod());
        mimified.setText(message);

        copy = findViewById(R.id.copyToClipboard);
        copy.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {


                        copyToClipboard();

                    }
                }
        );
    }
    public void copyToClipboard(){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("mimified",mimified.getText());
        clipboard.setPrimaryClip(clip);
    }

}
