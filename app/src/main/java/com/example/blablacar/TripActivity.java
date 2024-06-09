package com.example.blablacar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blablacar.models.Trajet;

import java.util.ArrayList;
import java.util.List;

public class TripActivity extends AppCompatActivity {

    private Button buttonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        buttonBack = findViewById(R.id.buttonBack);

        // Initialisez la liste des trajets
        List<Trajet> trajets = new ArrayList<>();

        trajets.add(new Trajet("12:20","12:50",12));
        trajets.add(new Trajet("12:20","12:50",11));


        CustomAdapter adapter = new CustomAdapter(this, trajets);

        // Trouvez la ListView dans le layout principal et associez-lui l'adaptateur
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TripActivity.this, ResearchActivity.class));
                finish();
            }
        });

    }

}
