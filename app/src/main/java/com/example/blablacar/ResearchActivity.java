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
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ResearchActivity extends AppCompatActivity {

    private Button buttonBack;
    private Button buttonResearch;
    private AutoCompleteTextView departEditText;
    private AutoCompleteTextView destinationEditText;
    private ArrayAdapter<String> adapter;
    private Button buttonDiconnect;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.research_activity);

        //buttonBack = findViewById(R.id.buttonBack);

        buttonDiconnect = findViewById(R.id.buttonDisconnect);
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
                    AddressSearcher.searchAddress(ResearchActivity.this, query, addresses -> {
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
                    AddressSearcher.searchAddress(ResearchActivity.this, query, addresses -> {
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
                //startActivity(new Intent(MainActivity.this, Research.class));
                //finish();
            }
        });
        buttonDiconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ResearchActivity.this, MainActivity.class));
                finish();

            }
        });

//        buttonBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ResearchActivity.this, MainActivity.class));
//                finish();
//            }
//        });

    }

}
