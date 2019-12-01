package com.example.autobot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Button button = (Button) findViewById(R.id.Enter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchMainAction();
            }
        });*/
        Button send = findViewById(R.id.Send);
        send.setOnClickListener(v -> {
            smsFunction();
        });
    }
    private void smsFunction() {
        EditText message = findViewById(R.id.EnterMessage);
        if (!(message.getText().toString().equals(""))) {
        }
    }
    /*private void LaunchMainAction() {
        Intent intent = new Intent(this, MainAction.class);
        startActivity(intent);
    }*/
}
