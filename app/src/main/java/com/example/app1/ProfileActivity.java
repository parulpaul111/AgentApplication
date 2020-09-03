package com.example.app1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    EditText editText,editText1,editText2,editText3,editText4,editText5;
    Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        all_variables();
        Submit = findViewById(R.id.Submit2);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty() ||editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() || editText3.getText().toString().isEmpty() || editText4.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();
                }else {
                    CandidateDataProfileActivity.Fathers_Name = editText.getText().toString();
                    CandidateDataProfileActivity.Mothers_Name = editText1.getText().toString();
                    CandidateDataProfileActivity.Spouse_Name = editText2.getText().toString();
                    CandidateDataProfileActivity.Educational_Qualification = editText3.getText().toString();
                    CandidateDataProfileActivity.Hobbies = editText4.getText().toString();
                    CandidateDataProfileActivity.Net_worth = editText5.getText().toString();
                }
            }
        });

    }

    private void all_variables() {
        editText = findViewById(R.id.candidate_Fathers_Name);
        editText1 = findViewById(R.id.candidate_mothers_name);
        editText2 = findViewById(R.id.candidate_Spouse_Name);
        editText3 = findViewById(R.id.candidates_education_qualification);
        editText4 = findViewById(R.id.candidate_hobbies);
        editText5 = findViewById(R.id.candidate_networth);

        editText.setText(CandidateDataProfileActivity.Fathers_Name);
        editText1.setText(CandidateDataProfileActivity.Mothers_Name);
        editText2.setText(CandidateDataProfileActivity.Spouse_Name);
        editText3.setText(CandidateDataProfileActivity.Educational_Qualification);
        editText4.setText(CandidateDataProfileActivity.Hobbies);
        editText5.setText(CandidateDataProfileActivity.Net_worth);
    }
}