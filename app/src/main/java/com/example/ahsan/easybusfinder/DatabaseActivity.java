package com.example.ahsan.easybusfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class DatabaseActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseActivity",KEY_TITLE="title",KEY_DESCRIPTION="descrioption";

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference notebookRef=db.collection("Notebook");
    private CollectionReference busRef=db.collection("BusList");
    private EditText ed1,ed2,ed3;
    private TextView textViewdata;
    private DocumentReference noteRef=db.document("Notebook/My first note");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);
        ed3=findViewById(R.id.editText3);
        textViewdata=findViewById(R.id.text_view_data);

    }

    @Override
    protected void onStart() {
        super.onStart();

        busRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String data="";
                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){

                    Note2 note=documentSnapshot.toObject(Note2.class);
                    note.setDecumentId(documentSnapshot.getId());
                    String documentId=note.getDecumentId();
                    String Location01=note.getLocation01();
                    String Location02=note.getLocation02();
                    String Location03=note.getLocation03();
                    String Location04=note.getLocation04();
                    String Location05=note.getLocation05();
                    String Location06=note.getLocation06();
                    String Location07=note.getLocation07();
                    String Location08=note.getLocation08();
                    String Location09=note.getLocation09();
                    String Location10=note.getLocation10();
                    String Location11=note.getLocation11();
                    String Location12=note.getLocation12();
                    String Location13=note.getLocation13();
                    String Location14=note.getLocation14();
                    String Location15=note.getLocation15();
                    String Location16=note.getLocation16();
                    String Location17=note.getLocation17();

                    int priority=note.getPriority();
                    data+=documentId+" No Bus: \n"+
                            "\n"+Location01+
                            "\n"+Location02+
                            "\n"+Location03+
                            "\n"+Location04+
                            "\n"+Location05+
                            "\n"+Location06+
                            "\n"+Location07+
                            "\n"+Location08+
                            "\n"+Location09+
                            "\n"+Location10+
                            "\n"+Location11+
                            "\n"+Location12+
                            "\n"+Location13+
                            "\n"+Location14+
                            "\n"+Location15+
                            "\n"+Location16+
                            "\n"+Location17+
                            "\n \n\n";
                }
                textViewdata.setText(data);
            }
        });

    }



    public void ForAdd(View view){


    }

//    public void ForLoading(View view){
//
//        notebookRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                String data="";
//                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
//
//                    Note note=documentSnapshot.toObject(Note.class);
//                    note.setDecumentId(documentSnapshot.getId());
//                    String documentId=note.getDecumentId();
//                    String title=note.getTitle();
//                    String description=note.getDescription();
//                    int priority=note.getPriority();
//                    data+="ID: "+documentId+ "Title: "+title+"\nDescription: "+description+"\nPriority: "+priority+ "\n\n";
//                }
//                textViewdata.setText(data);
//            }
//        });
//    }
public void ForLoading(View view){


}
}
