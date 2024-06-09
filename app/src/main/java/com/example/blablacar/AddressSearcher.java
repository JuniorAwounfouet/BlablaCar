package com.example.blablacar;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressSearcher {

    public interface OnAddressFoundListener {
        void onAddressFound(List<Address> addresses);
    }

    public static void searchAddress(final Context context, final String query, final OnAddressFoundListener listener) {
        new AsyncTask<Void, Void, List<Address>>() {
            @Override
            protected List<Address> doInBackground(Void... voids) {
                Geocoder geocoder = new Geocoder(context);
                List<Address> addresses = new ArrayList<>();
                try {
                    addresses = geocoder.getFromLocationName(query, 10);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return addresses;
            }

            @Override
            protected void onPostExecute(List<Address> addresses) {
                super.onPostExecute(addresses);
                if (listener != null) {
                    listener.onAddressFound(addresses);
                }
            }
        }.execute();
    }

}
