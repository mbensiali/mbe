package com.courtalon.todoongo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class TodoActivity extends AppCompatActivity {

    private ListView lv;
    private TacheAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        adapter = new TacheAdapter(TodoActivity.this, new ArrayList<Tache>());
        lv = (ListView) findViewById(R.id.todoView);
        lv.setAdapter(adapter);

    }

    public void ajouterTache(View v) {
        Tache t = new Tache(
                ((EditText) findViewById(R.id.editTitre)).getText().toString(),
                ((EditText) findViewById(R.id.editContexte)).getText().toString(),
                Integer.parseInt(((EditText) findViewById(R.id.editPriorite)).getText().toString()),
                new Date());
        adapter.add(t);
    }

    public void viderTaches(View v) {
        adapter.clear();
    }

    public void terminerTache(View v) {
        Tache t = (Tache) v.getTag();
        adapter.remove(t);
    }


    @Override
    public void onResume() {
        super.onResume();
        //Intent intent = getIntent();
        String jsonTaches = "[]";
        try {
            // j'ecris un fichier dans l'espace privé de cette application
            FileInputStream f = getApplicationContext().openFileInput("taches");
            Scanner reader = new Scanner(f);
            jsonTaches = reader.nextLine();
            reader.close();
        } catch (FileNotFoundException e) {
            Log.i("info", "pas de tweet sauvegardés");
        }
        if (jsonTaches != null && !jsonTaches.isEmpty()) {

            Gson gson = new Gson();
            //Type listType = new TypeToken<ArrayList<Tweet>>() {}.getType();

            // je deserialise le tableau de taches
            Tache[] tacheArray = gson.fromJson(jsonTaches, Tache[].class);
            // je reconvertit mon tableau en ArrayList
            ArrayList<Tache> taches = new ArrayList<>(Arrays.asList(tacheArray));

            adapter.addAll(taches);
        }
        /*prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        authorName = prefs.getString("name", "moi");
        avatarColor = prefs.getInt("color", Color.RED);*/



        /*Bundle b = intent.getBundleExtra("tweets");
        if ( b != null) {
            ArrayList<CharSequence> pseudos = b.getCharSequenceArrayList("pseudos");
            ArrayList<CharSequence> textes = b.getCharSequenceArrayList("textes");
            ArrayList<Integer> couleurs = b.getIntegerArrayList("couleurs");
            for (int i = 0; i < pseudos.size(); i++) {
                Tweet t = new Tweet(couleurs.get(i),
                        pseudos.get(i).toString(),
                        textes.get(i).toString()
                );
                adapter.add(t);
            }
        }*/
        Log.i("cycleVie", "appel de onResume de notre application");


    }

    @Override
    public void onPause() {
        super.onPause();
        //Intent intent = getIntent();

        Gson gson = new Gson();
        ArrayList<Tache> taches = new ArrayList<>();
        for (int i = 0; i < adapter.getCount(); i++) {
            taches.add(adapter.getItem(i));
        }
        // transformation de la collection en chaine json
        String jsontaches = gson.toJson(taches);
        Log.i("json", jsontaches);
        // sauvegarde de celle ci dans notre intent
        //intent.putExtra("tweets", jsontweets);
        try {
            // j'ecris un fichier dans l'espace privé de cette application
            FileOutputStream f = getApplicationContext().openFileOutput("taches", MODE_PRIVATE);
            PrintWriter pw = new PrintWriter(f);
            pw.print(jsontaches);
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Log.i("cycleVie", "appel de onPause de notre application");
    }
}