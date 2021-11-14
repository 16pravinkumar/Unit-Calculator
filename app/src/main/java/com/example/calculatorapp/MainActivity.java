package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaring Variables
    Spinner sp1,sp2;
    EditText ed1;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting element by their id
        ed1=findViewById(R.id.txt_demo);
        sp1=findViewById(R.id.txt_from);
        sp2=findViewById(R.id.txt_to);
        b1=findViewById(R.id.button);
        t1=findViewById(R.id.txt_result);


        // Setting data in from spinner
        String[] from = {"Miles","Acre"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        //Setting data in to spinner
        String[] to = {"Kms","Bigha"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        // Setting onClick listner on Convert button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;

                // Getting entered amount from frontend
                Double amount = Double.parseDouble(ed1.getText().toString());

                // Checking cases and returning calculated value
                if(sp1.getSelectedItem().toString() == "Miles" && sp2.getSelectedItem().toString() == "Kms"){
                    tot= amount*1.609344;
                    t1.setText(tot.toString() + "kms");

                }
                else if(sp1.getSelectedItem().toString() == "Acre" && sp2.getSelectedItem().toString() == "Bigha"){
                    tot= amount*1.6133;
                    t1.setText(tot.toString() + "Bigha");

                }
            }
        });

    }
}