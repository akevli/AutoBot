package com.example.autobot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v4.app.*;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    // SMS Manager API &
    private EditText txtMobile;
    private EditText txtMessage;
    private EditText numberofmsg;
    private Button btnSms;
    private TextView loading;
    private ProgressBar progressBar;
    private int increment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMobile = (EditText)findViewById(R.id.mblTxt);
        txtMessage = (EditText)findViewById(R.id.msgTxt);
        btnSms = (Button)findViewById(R.id.btnSend);
        loading = (TextView)findViewById(R.id.loading);
        loading.setVisibility(View.INVISIBLE);
        btnSms.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            progressBar.setProgress(0);
            loading.setVisibility(View.VISIBLE);
            loading.setText("In Progress");
            smsSend();
            progressBar.setProgress(100);
        }
        });
        /*numberofmsg = (EditText)findViewById(R.id.nmbrMsg);
        String value = numberofmsg.getText().toString();
        try {
            final int numValue = Integer.parseInt(value);
            if (numValue >= 0) {
                btnSms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            for (int i = 0; i < numValue; i++) {
                                SmsManager smgr = SmsManager.getDefault();
                                smgr.sendTextMessage(txtMobile.getText().toString(), null, txtMessage.getText().toString(), null, null);
                                if (i == (numValue - 1)) {
                                    Toast.makeText(MainActivity.this, i + " SMS Messages Sent Successfully.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "SMS Sent: " + i, Toast.LENGTH_SHORT).show();
                                }
                            }
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "SMS Failed to Send. Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                Toast.makeText(MainActivity.this, "Negative Numerical Input. Pleas input a positive number.", Toast.LENGTH_SHORT).show();

            }
        }
        catch (Exception e) {
            Toast.makeText(MainActivity.this, "Invalid Numerical Input. Pleas try again", Toast.LENGTH_SHORT).show();
        }*/


        /*Button button = (Button) findViewById(R.id.Enter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchMainAction();
            }
        });*/


    }
    private void smsSend() {
        txtMobile = (EditText)findViewById(R.id.mblTxt);
        txtMessage = (EditText)findViewById(R.id.msgTxt);
        btnSms = (Button)findViewById(R.id.btnSend);
        numberofmsg = (EditText)findViewById(R.id.nmbrMsg);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        String value = numberofmsg.getText().toString();
        try {
            final int numValue = Integer.parseInt(value);
            //increment = 100 / numValue;
            //final int inc = increment;
            if (numValue >= 0) {
                for (int i = 1; i <= numValue; i++) {
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(txtMobile.getText().toString(), null, txtMessage.getText().toString(), null, null);
                    //progressBar.setProgress(increment);
                    //increment += inc;
                    if (i == (numValue)) {
                        Toast.makeText(MainActivity.this, i + " SMS Messages Sent Successfully.", Toast.LENGTH_SHORT).show();
                        loading.setText("Complete");
                    } else {
                        Toast.makeText(MainActivity.this, "SMS Sent: " + i, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "SMS Failed to Send. Please try again", Toast.LENGTH_SHORT).show();
        }
    }

    /*private void LaunchMainAction() {
        Intent intent = new Intent(this, MainAction.class);
        startActivity(intent);
    }*/
}
