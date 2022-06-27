package com.example.akashahmed.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.t1);
    }
    public void sendButton(view v) {
        intent i=new Intent();
        i.setAction (Intent.Action_Send);
        i.setType("Text/plain");
        String[] arr={""}
        i.putExtra(Intent.EXTRA_EMAIL.arr);
        i.putExtra(Intent.EXTRA_SUBJECT,)
    }


}
