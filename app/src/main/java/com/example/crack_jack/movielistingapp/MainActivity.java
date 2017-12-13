package com.example.crack_jack.movielistingapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = MainActivity.this;

//      Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MovieAdapter movieAdapter = new MovieAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(movieAdapter);

//      Get and Load Data

        try {
            JSONObject jo = null;
            try {
                jo = new JSONObject(loadJSONFromAsset());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray moviesArray = jo.getJSONArray("results");

            for (int i = 0, s = moviesArray.length(); i < s; i++) {
                JSONObject movie = moviesArray.getJSONObject(i);

                String movieName = movie.getString("title");
                String releaseDate = movie.getString("release_date");
                String rating = movie.getString("vote_average");

                String imageURI = "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path");

                // use these variables to load to the MovieAdapter ;
                movieAdapter.addMovieItem(new MovieModel(movieName, releaseDate, imageURI, rating));

            }


        } catch (Exception e) {

        }

    }

    private String loadJSONFromAsset() {

        String movieJSON = "";

        try {
            InputStream is = getResources().openRawResource(R.raw.movie);

            int size = is.available();

            byte[] buff = new byte[size];

            is.read(buff);
            is.close();

            movieJSON = new String(buff, "UTF-8");


        } catch (IOException e) {
            e.printStackTrace();
        }

        return movieJSON;
    }
}
