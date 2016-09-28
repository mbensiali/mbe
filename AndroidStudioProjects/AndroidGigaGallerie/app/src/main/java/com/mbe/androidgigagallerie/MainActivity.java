package com.mbe.androidgigagallerie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.mbe.androidgigagallerie.metier.Photo;
import com.mbe.androidgigagallerie.metier.Tag;

public class MainActivity extends AppCompatActivity {

    private TextView statusView;
    private ListView itemsView;
    private RequestQueue fileAttenteRequetes;
    private ArrayAdapter<String> itemsAdapter;

    Spinner tagLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //statusView = (TextView)findViewById(R.id.statusText);
        itemsView = (ListView)findViewById(R.id.listViewItems);
        fileAttenteRequetes = Volley.newRequestQueue(this);
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        itemsView.setAdapter(itemsAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        tagLists = (Spinner) findViewById(R.id.taglist);
        String url = "http://10.0.2.2:8080/gigaGallerie/tag/liste";
        GsonRequest<Tag[]> request = new GsonRequest<>(
                url,
                Tag[].class,
                null,
                new Response.Listener<Tag[]>() {

                    @Override
                    public void onResponse(Tag[] response) {
                        itemsAdapter.clear();
                        for (Tag t: response){
                            itemsAdapter.add(t.toString());
                        }
                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        statusView.setText("erreur de la requete: " + error.getMessage());
                    }
                });
        fileAttenteRequetes.add(request);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tagLists.setAdapter(adapter);

    }

    public void getJsonImages(View v) {
        // petit piege, si l'emulateur est un genymotion, l'adresse est 10.0.3.2
        // cela correspond au localhost de la machine hote
        // en effet, le localhost sur l'emulateur est le terminal mobile lui-même!
        String url = "http://10.0.2.2:8080/gigaGallerie/photo/liste";
        GsonRequest<Photo[]> request = new GsonRequest<>(
                url,
                Photo[].class,
                null,
                new Response.Listener<Photo[]>() {
                    @Override
                    public void onResponse(Photo[] response) {
                        itemsAdapter.clear();
                        for (Photo p : response) {
                            itemsAdapter.add(p.toString());
                        }
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        statusView.setText("erreur de la requete: " + error.getMessage());
                    }
                });
        fileAttenteRequetes.add(request);
    }

}
