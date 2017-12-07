package com.example.crack_jack.movielistingapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by CRACK-JACK on 07-12-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    public MovieAdapter(Context mContext, ArrayList<MovieModel> movieModels) {

    }

    MovieAdapter(Activity mActivity) {

    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        MovieViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void addMovieItem (MovieModel item) {}
}
