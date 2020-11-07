package com.example.marketlist;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBase {

    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private Context context;

    public FireBase(){

    }

    public static void inicializarFireBase(Context context){

        FirebaseApp.initializeApp(context);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
