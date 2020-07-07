package com.example.ahsan.easybusfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;

public class bus_suggestion extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference busRef = db.collection("BusList");
    private TextView textViewdata;



    String sLocation, eLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_suggestion);
        textViewdata = findViewById(R.id.text_view_bus_sugg);

        sLocation = getIntent().getStringExtra("start");
        eLocation = getIntent().getStringExtra("end");
    }


    @Override
    protected void onStart() {
        super.onStart();
        busRef.whereEqualTo(sLocation, true).whereEqualTo(eLocation, true).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (e != null) return;
                String data = "";
                for(QueryDocumentSnapshot snapshot : queryDocumentSnapshots){
                    data += snapshot.getId()+" No. Bus \n";

                }
                textViewdata.setText("You can go "+"from "+sLocation+" to "+ eLocation+" by the following buses\n\n"+data);
            }
        });

    }
}