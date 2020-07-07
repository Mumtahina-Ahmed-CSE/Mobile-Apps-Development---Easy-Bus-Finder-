package com.example.ahsan.easybusfinder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Bus_Information_Activity extends AppCompatActivity {

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference busRef=db.collection("BusList");
    private TextView textViewdata,textViewDataId;

    FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
    DocumentReference bus1Ref = rootRef.collection("BusList").document("01");
    DocumentReference bus2Ref = rootRef.collection("BusList").document("02");
    DocumentReference bus3Ref = rootRef.collection("BusList").document("03");
    DocumentReference bus4Ref = rootRef.collection("BusList").document("04");
    DocumentReference bus5Ref = rootRef.collection("BusList").document("05");
    DocumentReference bus6Ref = rootRef.collection("BusList").document("06");
    DocumentReference bus7Ref = rootRef.collection("BusList").document("07");
    DocumentReference bus8Ref = rootRef.collection("BusList").document("08");
    DocumentReference bus10Ref = rootRef.collection("BusList").document("10");
    DocumentReference bus11Ref = rootRef.collection("BusList").document("11");

    String totalData="",data1="",data2="",data3="",data4="",data5="",data6="",data7="",data8="",data10="",data11="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_information);
        textViewdata=findViewById(R.id.text_view_bus_info);
    }
    @Override
    protected void onStart() {
        super.onStart();

        busRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {


            }
        });

        bus1Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data1+=entry.getKey()+"\n";
                        Log.d("mmmmmmmmm", entry.getKey());

                    }

                }
            }
        });

        bus2Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data2+=entry.getKey()+"\n";
                        

                    }

                }
            }
        });
        bus3Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data3+=entry.getKey()+"\n";
                        

                    }

                }
            }
        });
        bus4Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data4+=entry.getKey()+"\n";
                        

                    }

                }
            }
        });
        bus5Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data5+=entry.getKey()+"\n";
                        

                    }

                }
            }
        });
        bus6Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data6+=entry.getKey()+"\n";
                        

                    }

                }
            }
        });
        bus7Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data7+=entry.getKey()+"\n";
                        

                    }

                }
            }
        });
        bus8Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data8+=entry.getKey()+"\n";
                        

                    }

                }
            }
        });

        bus10Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data10+=entry.getKey()+"\n";
                        

                    }

                }
            }
        });
        bus11Ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    Map<String, Object> map = task.getResult().getData();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());
                        data11+=entry.getKey()+"\n";
                        

                    }

                }
                textViewdata.setText("<<<          01 No bus         >>>  \n"+data1+
                        "<<<          02 No bus         >>>  \n"+data2+
                        "<<<          03 No bus         >>>  \n"+data3+
                        "<<<          04 No bus         >>>  \n"+data4+
                        "<<<          05 No bus         >>>  \n"+data5+
                        "<<<          06 No bus         >>>  \n"+data6+
                        "<<<          07 No bus         >>>  \n"+data7+
                        "<<<          08 No bus         >>>  \n"+data8+
                        "<<<          10 No bus         >>>  \n"+data10+
                        "<<<          11 No bus         >>>  \n"+data11);
            }

        });


    }

}