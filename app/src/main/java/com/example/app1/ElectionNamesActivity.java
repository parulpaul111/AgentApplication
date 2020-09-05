package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ElectionNamesActivity extends AppCompatActivity {
    Intent intent;
    String Election_Name = "";
    EditText editText4,editText1,editText2,editText3;
    TextView textView,textView1;
    Button Submit;
    public static String[] election_names = {"Gram Panchayat Elections","Zila Panchayat Sadasya Elections","Municipality Elections","Municipal Corporation Elections","Nagar Panchayat Sadasya Elections","State Assembly Elections"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chunnavi_mudde);

        all_variables();

        Submit = findViewById(R.id.Submit1);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() || editText3.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();
                    } else {

                        CandidateDataProfileActivity.State_Name = editText1.getText().toString();
                        CandidateDataProfileActivity.District_Name = editText2.getText().toString();



                    if (Election_Name.equals(election_names[0])){
                        CandidateDataProfileActivity.Blocks_Name = editText3.getText().toString();
                        CandidateDataProfileActivity.Gram_Panchayat_Name = editText4.getText().toString();

                    }else if (Election_Name.equals(election_names[1])){
                        CandidateDataProfileActivity.Ward_Name = editText3.getText().toString();



                    }else if (Election_Name.equals(election_names[2]) || Election_Name.equals(election_names[3]) || Election_Name.equals(election_names[4])) {
                        CandidateDataProfileActivity.Ward_Name = editText3.getText().toString();
                        CandidateDataProfileActivity.Area_Name = editText4.getText().toString();


                    }else {
                        CandidateDataProfileActivity.Constituency_Name = editText3.getText().toString();

                    }
                }



            }
        });





    }

    private void all_variables() {



        intent = getIntent();
        Election_Name = intent.getStringExtra("chunnavi_mudde");


        editText1.setText(CandidateDataProfileActivity.State_Name);
        editText2.setText(CandidateDataProfileActivity.District_Name);

        if (Election_Name.equals(election_names[0])){
            textView.setText(R.string.Block_Name);
            textView1.setText(R.string.Gram_Panchayat_Name);
            editText3.setText(CandidateDataProfileActivity.Blocks_Name);
            editText4.setText(CandidateDataProfileActivity.Gram_Panchayat_Name);


        }else if (Election_Name.equals(election_names[1])){
            textView.setText(R.string.Ward_Name);
            editText4.setAlpha(0);
            editText4.setText("");
            editText3.setText(CandidateDataProfileActivity.Ward_Name);

        }else if (Election_Name.equals(election_names[2]) || Election_Name.equals(election_names[3]) || Election_Name.equals(election_names[4])){
            textView.setText(R.string.Area_Name);
            textView1.setText(R.string.Ward_Name);
            editText4.setText(CandidateDataProfileActivity.Ward_Name);
            editText3.setText(CandidateDataProfileActivity.Area_Name);

        }else {
            editText4.setAlpha(0);
            editText4.setText("");
            textView.setText(R.string.Constituency_Name);
            editText3.setText(CandidateDataProfileActivity.Constituency_Name);
        }



    }
}