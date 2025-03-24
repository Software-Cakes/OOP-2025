package com.example.w10assignment;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView movieTitle, movieYear, movieGenre;
    private ImageView moviePoster;

    public MovieViewHolder(View itemView) {
        super(itemView);
        moviePoster = itemView.findViewById(R.id.moviePoster);
        movieTitle = itemView.findViewById(R.id.movieTitle);
        movieYear = itemView.findViewById(R.id.movieYear);
        movieGenre = itemView.findViewById(R.id.movieGenre);
    }

    public void bind(Movie movie) {
        movieTitle.setText(movie.getTitle());
        movieYear.setText(String.valueOf(movie.getYear()));
        movieGenre.setText(movie.getGenre());

        @SuppressLint("DiscouragedApi") int imageResource = itemView.getResources().getIdentifier(
                movie.getPosterResource(), "drawable", itemView.getContext().getPackageName()
        );

        Log.d("MovieViewHolder", "Poster Resource: " + movie.getPosterResource() + ", Resource ID: " + imageResource);

        if (imageResource == 0) {
            moviePoster.setImageResource(R.drawable.default_poster);
        } else {
            moviePoster.setImageResource(imageResource);
        }
    }
}