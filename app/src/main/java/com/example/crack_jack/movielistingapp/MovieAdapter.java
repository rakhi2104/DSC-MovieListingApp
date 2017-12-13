package com.example.crack_jack.movielistingapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CRACK-JACK on 07-12-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieModel> movieModels = new ArrayList<>();
    private Activity mActivity;

    public MovieAdapter(Context mContext, ArrayList<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }

    MovieAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        MovieModel movieModel = movieModels.get(position);

        holder.bindTo(movieModel);

    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public void addMovieItem(MovieModel item) {
        movieModels.add(item);
        notifyItemInserted(movieModels.size());
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private TextView movieName, releaseDate, movieRating;
        private ImageView movieImage;

        MovieViewHolder(View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.imageView);

            movieName = itemView.findViewById(R.id.movie_title);
            movieRating = itemView.findViewById(R.id.movie_rating);
            releaseDate = itemView.findViewById(R.id.movie_release);

        }

        public void bindTo(MovieModel movieModel) {

            movieName.setText(movieModel.movieName);
            movieRating.setText("Rating : " + movieModel.rating);
            releaseDate.setText(movieModel.releaseDate);

            Glide.with(super.itemView).load(movieModel.ImageURI).into(movieImage);

        }
    }
}
