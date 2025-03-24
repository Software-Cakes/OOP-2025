package com.example.w10assignment;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView movieRecyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecyclerView = findViewById(R.id.movie_recycler_view);
        movieRecyclerView.setHasFixedSize(true);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Movie> movies = JsonUtils.loadMoviesFromJson(this);

        if (movies != null) {
            movieAdapter = new MovieAdapter(this, movies);
            movieRecyclerView.setAdapter(movieAdapter);
        } else {
            Log.e("MainActivity", "Failed to load movies from JSON.");
        }
    }
}