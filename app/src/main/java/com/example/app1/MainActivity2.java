package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Intent intent;
    String Election_Name = "";
    EditText editText4,editText1,editText2,editText3;
    TextView textView,textView1;
    Button Submit;
    public static String[] election_names = {"Gram Panchayat Elections","Zila Panchayat Sadasya Elections","Municipality Elections","Municipal Corporation Elections","Nagar Panchayat Sadasya Elections","State Assembly Elections"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        all_variables();

        Submit = findViewById(R.id.Submit1);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() || editText3.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();
                    } else {

                        MainActivity.State_Name = editText1.getText().toString();
                        MainActivity.District_Name = editText2.getText().toString();



                    if (Election_Name.equals(election_names[0])){
                        MainActivity.Blocks_Name = editText3.getText().toString();
                        MainActivity.Gram_Panchayat_Name = editText4.getText().toString();

                    }else if (Election_Name.equals(election_names[1])){
                        MainActivity.Ward_Name = editText3.getText().toString();



                    }else if (Election_Name.equals(election_names[2]) || Election_Name.equals(election_names[3]) || Election_Name.equals(election_names[4])) {
                        MainActivity.Ward_Name = editText3.getText().toString();
                        MainActivity.Area_Name = editText4.getText().toString();


                    }else {
                        MainActivity.Constituency_Name = editText3.getText().toString();

                    }
                }



            }
        });





    }

    private void all_variables() {
        editText1 = findViewById(R.id.candidate_state);
        editText2 = findViewById(R.id.candidate_district);
        editText3 = findViewById(R.id.edit_text);
        editText4 = findViewById(R.id.edit_text1);

        textView = findViewById(R.id.text_view1);
        textView1 = findViewById(R.id.text_view2);


        intent = getIntent();
        Election_Name = intent.getStringExtra("election_name");


        editText1.setText(MainActivity.State_Name);
        editText2.setText(MainActivity.District_Name);

        if (Election_Name.equals(election_names[0])){
            textView.setText(R.string.Block_Name);
            textView1.setText(R.string.Gram_Panchayat_Name);
            editText3.setText(MainActivity.Blocks_Name);
            editText4.setText(MainActivity.Gram_Panchayat_Name);


        }else if (Election_Name.equals(election_names[1])){
            textView.setText(R.string.Ward_Name);
            editText4.setAlpha(0);
            editText4.setText("");
            editText3.setText(MainActivity.Ward_Name);

        }else if (Election_Name.equals(election_names[2]) || Election_Name.equals(election_names[3]) || Election_Name.equals(election_names[4])){
            textView.setText(R.string.Area_Name);
            textView1.setText(R.string.Ward_Name);
            editText4.setText(MainActivity.Ward_Name);
            editText3.setText(MainActivity.Area_Name);

        }else {
            editText4.setAlpha(0);
            editText4.setText("");
            textView.setText(R.string.Constituency_Name);
            editText3.setText(MainActivity.Constituency_Name);
        }



    }
}