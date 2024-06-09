package com.example.blablacar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.blablacar.models.Utilisateur;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonRegister;
    private Button buttonLogout;
    private ListView listView;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.login);
        buttonRegister = findViewById(R.id.register);
        buttonLogout = findViewById(R.id.logout);
        listView = findViewById(R.id.listView);

        buttonRegister.setOnClickListener((v) -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            finish();
        });

        buttonLogin.setOnClickListener((v) -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });

        buttonLogout.setOnClickListener((v) -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            finish();
        });

        /*HashMap<String, Object> map = new HashMap<>();
        map.put("email", "qsdwaer@blablacar.com");
        map.put("mpd", "qsdwaer");
        map.put("nom", "Qsd Waer");

        FirebaseDatabase.getInstance()
                        .getReference()
                        .child("Utilisateurs")
                        .child("9")
                        .setValue(map);*/
    }

}
