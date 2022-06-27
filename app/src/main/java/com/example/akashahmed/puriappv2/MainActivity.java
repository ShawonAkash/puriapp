package com.example.akashahmed.puriappv2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    Button plusbtn,minusbtn;
    TextView totalPuri;
    int counter =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusbtn = (Button)findViewById(R.id.increase);
        minusbtn = (Button)findViewById(R.id.decrease);
        totalPuri = (TextView)findViewById(R.id.puri_count);

    }
    public void countIN(View view) {
        counter++;
        totalPuri.setText(Integer.toString(counter));
    }

    public void countDE(View view) {
        counter--;

        if(counter<0){
            Toast.makeText(this, "Enter Item you want to buy", Toast.LENGTH_SHORT).show();
            counter = 0;
        }
        else {
            totalPuri.setText(Integer.toString(counter));
        }
    }
    public void NextButton(View v){
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }

    public void selectItem(View view){

        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.mama1:
                if(checked){
                    selection.add("mama1@gmail.com");
                }
                else{

                    selection.remove("mama1@gmail.com");
                }
                break;

            case R.id.mama2:
                if(checked){
                    selection.add("mama2@gmail.com");
                }
                else{
                    selection.remove("mama2@gmail.com");
                }
                break;

            case R.id.mama3:
                if(checked){
                    selection.add("mama3@gmail.com");
                }
                else{
                    selection.remove("mama3@gmail.com");
                }
                break;
        }
    }

    public void finalSelection(View view){
        String final_selection = "";

        for(String Selections:selection){
            final_selection = final_selection+Selections+"\n";
        }

        int total_puri = Integer.parseInt(totalPuri.getText().toString());
        int total_price = total_puri*5;
        Intent in = new Intent(this, SecondActivity.class);
        in.putExtra("TOTAL_PRICE",total_price);
        in.putExtra("EMAIL_KEY",final_selection);
        this.startActivity(in);
    }
}
