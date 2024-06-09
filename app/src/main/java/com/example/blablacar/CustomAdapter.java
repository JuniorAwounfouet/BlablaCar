package com.example.blablacar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.credentials.webauthn.Cbor;

import com.example.blablacar.models.Trajet;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Trajet> {
    public CustomAdapter(Context context, List<Trajet> trajets){
        super(context,0,trajets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Vérifiez si une vue existante est réutilisée, sinon gonflez la vue
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.target_list, parent, false);
        }

        // Obtenez l'élément de données pour cette position
        Trajet traget = getItem(position);

        // Recherchez les vues pour remplir les données
        TextView departTextView = convertView.findViewById(R.id.depart);
        TextView arriveeTextView = convertView.findViewById(R.id.arrivee);
        TextView prixTextView = convertView.findViewById(R.id.prix);


        // Remplissez les vues avec les données de l'objet
        departTextView.setText(traget.getDepart());
        arriveeTextView.setText(traget.getArrivee());
        //prixTextView.setText((int) traget.getPrix());

        // Retournez la vue complétée pour l'afficher à l'écran
        return convertView;
    }
}
