package com.example.akashahmed.puriappv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Akash Ahmed on 05-Feb-18.
 */

public class SecondActivity extends AppCompatActivity {
    TextView orderdetails,text;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        orderdetails = (TextView)findViewById(R.id.email);
        confirm = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.price);

        int total_puri = getIntent().getIntExtra("TOTAL_PRICE",0);
        String receiveemail = getIntent().getStringExtra("EMAIL_KEY");
        text.setText("Total Amount is  "+String.valueOf(total_puri)+ " Tk");
        orderdetails.setText("Your order will be mailed to: "+receiveemail);
         //orderdetails.setText("You have to pay "+String.valueOf(total_puri)+ " Tk and "+"" + " Your order will be mailed to: "+receiveemail);
    }

    public void sendMethod(View view){
        int total_puri = getIntent().getIntExtra("TOTAL_PRICE",0);
        String receiveemail = getIntent().getStringExtra("EMAIL_KEY");
        Intent in = new Intent();
        in.setAction(Intent.ACTION_SEND);
        in.setType("text/plain");
        String [] arr = {receiveemail};
        in.putExtra(Intent.EXTRA_EMAIL,arr);
        in.putExtra(Intent.EXTRA_SUBJECT, "You have an delivery of "+(total_puri/10)+" puri and Your bill is "+ String.valueOf(total_puri)+" Tk.");
        //in.putExtra(Intent.EXTRA_SUBJECT,"Order");
        //in.putExtra(Intent.EXTRA_TEXT,"You have an delivery of "+(total_puri/10)+" puri.");

        if(in.resolveActivity(getPackageManager()) != null){
            startActivity(in);
        }
    }
}