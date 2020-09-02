package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ThrowOnExtraProperties;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public Button submit,agenda,profile,political_background_history;
    public EditText Name,Age,Gender,Political_Experience,Political_Party;
    DatabaseReference reference;
    FirebaseDatabase database;
    int gram_panchayat_candidate_id,zila_panchayat_candidate_id,municipal_corporation_candidate_id,state_assembly_elections_id;
    Member member;
    int candidate_id,maxid;
    final int[] get_id = new int[1];

    Candidate candidate;
    Spinner Type_of_election;
    String Name_of_election;
    public static String[] election_names = {"Gram Panchayat Elections","Zila Panchayat Sadasya Elections","Municipality Elections","Municipal Corporation Elections","Nagar Panchayat Sadasya Elections","State Assembly Elections"};
    public static String Fathers_Name="",Mothers_Name="",Spouse_Name="",Educational_Qualification="",Hobbies="";
    public static String State_Name="",District_Name="",Gram_Panchayat_Name="",Blocks_Name="",Constituency_Name="",Area_Name="",Ward_Name = "",Net_worth = "";
    public static String Audio_recording_url = "Default",Profile_Photo_Url = "Default";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        all_variables();
        Type_of_elections();


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);

            }
        });

        political_background_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (Name.getText().toString().isEmpty() || Age.getText().toString().isEmpty() ||
                        Gender.getText().toString().isEmpty() ||
                        Political_Experience.getText().toString().isEmpty()
                        || Political_Party.getText().toString().isEmpty()
                        || State_Name.isEmpty() || District_Name.isEmpty() ||
                        Fathers_Name.isEmpty() || Mothers_Name.isEmpty() ||
                        Spouse_Name.isEmpty() || Educational_Qualification.isEmpty() ||
                        Hobbies.isEmpty() ||  Net_worth.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();

                }else {

                    Put_in_database();

                }


            }
        });


    }

    private void all_variables(){
        member = new Member();
        candidate = new Candidate();


        Name = findViewById(R.id.candidate_Name);
        Age = findViewById(R.id.candidate_Age);
        Gender = findViewById(R.id.candidate_Gender);
        Political_Experience = findViewById(R.id.Political_Experience);
        Political_Party = findViewById(R.id.Political_Party);
        Type_of_election = findViewById(R.id.Election_Type);


        submit = findViewById(R.id.submit);
        agenda = findViewById(R.id.agenda);
        profile = findViewById(R.id.Profile);
        political_background_history = findViewById(R.id.Political_background_history);



    }

    private void Type_of_elections(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.TypeofElections,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Type_of_election.setAdapter(adapter);
        Type_of_election.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> adapterView, View view, int i, long l) {
                Name_of_election = adapterView.getSelectedItem().toString();

                agenda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                        if (adapterView.getSelectedItem().toString().equals(election_names[0])){
                            intent.putExtra("election_name",adapterView.getSelectedItem().toString());

                        }else if (adapterView.getSelectedItem().toString().equals(election_names[1])){
                            intent.putExtra("election_name",adapterView.getSelectedItem().toString());

                        }else if (adapterView.getSelectedItem().toString().equals(election_names[2]) || adapterView.getSelectedItem().toString().equals(election_names[3]) || adapterView.getSelectedItem().toString().equals(election_names[4]) ){
                            intent.putExtra("election_name",adapterView.getSelectedItem().toString());


                        }else {
                            intent.putExtra("election_name",adapterView.getSelectedItem().toString());

                        }
                        startActivity(intent);

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
    }

    private void Put_in_database() {

        reference = FirebaseDatabase.getInstance().getReference().child("Users");


        member.setState(State_Name);
        member.setDistrict(District_Name);
        member.setElectionType(Name_of_election);

        candidate.setName(Name.getText().toString());
        candidate.setAge(Age.getText().toString());
        candidate.setGender(Gender.getText().toString());
        candidate.setPolitical_Experience(Political_Experience.getText().toString());
        candidate.setPolitical_Party(Political_Party.getText().toString());
        candidate.setFathers_Name(Fathers_Name);
        candidate.setMothers_Name(Mothers_Name);
        candidate.setSpouse_Name(Spouse_Name);
        candidate.setEducational_Qualification(Educational_Qualification);
        candidate.setHobbies(Hobbies);
        candidate.setAudio_Recording_Url(Audio_recording_url);
        candidate.setProfile_Photo_Url(Profile_Photo_Url);







        if (Name_of_election.equals(election_names[0])){

            member.setBlock(Blocks_Name);
            member.setGram_Panchayat(Gram_Panchayat_Name);

            get_Value(reference.child("India").child(member.getState()).child(member.getDistrict()).child(member.getElectionType()).child(member.getBlock()).child(member.getGram_Panchayat()).child("Candidate"));



        }else if (Name_of_election.equals(election_names[1])){

            member.setWard(Ward_Name);

            get_Value( reference.child("India").child(member.getState()).child(member.getDistrict()).child(member.getElectionType()).child(member.getWard()).child("Candidate"));


        }else if (Name_of_election.equals(election_names[2]) || Name_of_election.equals(election_names[3]) || Name_of_election.equals(election_names[4])){

            member.setWard(Ward_Name);
            member.setArea(Area_Name);

            get_Value(reference.child("India").child(member.getState()).child(member.getDistrict()).child(member.getElectionType()).child(member.getArea()).child(member.getWard()).child("Candidate"));



        }else if (Name_of_election.equals(election_names[5])){

            member.setConstituency(Constituency_Name);

            get_Value(reference.child("India").child(member.getState()).child(member.getDistrict()).child(member.getElectionType()).child(member.getConstituency()).child("Candidate"));


        }

        Name.setText("");
        Age.setText("");
        Gender.setText("");
        Political_Party.setText("");
        Political_Experience.setText("");
        State_Name = "";
        District_Name = "";
        Blocks_Name = "";
        Gram_Panchayat_Name = "";
        Ward_Name = "";
        Area_Name = "";
        Constituency_Name = "";
        Fathers_Name = "";
        Mothers_Name = "";
        Spouse_Name = "";
        Educational_Qualification = "";
        Hobbies = "";
        Net_worth = "";




    }

    public void get_Value(final DatabaseReference reference) {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               maxid =  (int) dataSnapshot.getChildrenCount();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference.child(String.valueOf(maxid)).setValue(candidate);


    }





}