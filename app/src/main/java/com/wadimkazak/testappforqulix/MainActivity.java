package com.wadimkazak.testappforqulix;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextView);
        AsyncLoadGif asyncLoadGif = new AsyncLoadGif();
        asyncLoadGif.execute();

    }

    public class AsyncLoadGif extends AsyncTask<Void, Void, String>{
        @Override
        protected String doInBackground(Void... voids) {
            LoadGifs loadGifs = new LoadGifs();

            return loadGifs.fetchItems();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }
    }
}
