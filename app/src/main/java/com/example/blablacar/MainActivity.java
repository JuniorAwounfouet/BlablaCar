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

    private Button buttonResearch;
    private AutoCompleteTextView departEditText;
    private AutoCompleteTextView destinationEditText;
    private ArrayAdapter<String> adapter;

    private Button buttonLogin;
    private Button buttonRegister;
    private Button buttonLogout;
    private ListView listView;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonResearch = findViewById(R.id.buttonResearch);
        departEditText = findViewById(R.id.depart);
        destinationEditText = findViewById(R.id.destination);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        departEditText.setAdapter(adapter);
        destinationEditText.setAdapter(adapter);

        departEditText.setOnItemClickListener((parent, view, position, id) -> {
            String selectedAddress = (String) parent.getItemAtPosition(position);
            // Do something with the selected address
        });

        destinationEditText.setOnItemClickListener((parent, view, position, id) -> {
            String selectedAddress = (String) parent.getItemAtPosition(position);
            // Do something with the selected address
        });

        departEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString();
                if (!query.isEmpty()) {
                    AddressSearcher.searchAddress(MainActivity.this, query, addresses -> {
                        adapter.clear();
                        for (Address address : addresses) {
                            adapter.add(address.getAddressLine(0));
                        }
                        adapter.notifyDataSetChanged();
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        destinationEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString();
                if (!query.isEmpty()) {
                    AddressSearcher.searchAddress(MainActivity.this, query, addresses -> {
                        adapter.clear();
                        for (Address address : addresses) {
                            adapter.add(address.getAddressLine(0));
                        }
                        adapter.notifyDataSetChanged();
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        buttonResearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Research.class));
                finish();
            }
        });

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

        ArrayList<String> list = new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, list);
        listView.setAdapter(adapter);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("utilisateurs");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for (DataSnapshot s : snapshot.getChildren()) {
                    Utilisateur utilisateur = s.getValue(Utilisateur.class);
                    String txt = utilisateur.getNom() + " : " + utilisateur.getEmail();

                    list.add(txt);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
