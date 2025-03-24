package com.example.w10assignment;
import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static List<Movie> loadMoviesFromJson(Context context) {
        List<Movie> movies = new ArrayList<>();
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.movies);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            JSONArray movieArray = new JSONArray(jsonBuilder.toString());

            for (int i = 0; i < movieArray.length(); i++) {
                JSONObject movieObject = movieArray.optJSONObject(i);
                if (movieObject == null) {
                    Log.w("JsonUtils", "Skipping null movie object.");
                    continue;
                }

                String title = movieObject.isNull("title") ? "Unknown Title" : movieObject.optString("title", "Unknown Title");
                String yearString = movieObject.optString("year", "Unknown Year");
                String genre = movieObject.optString("genre", "Unknown Genre");
                String posterResource = movieObject.optString("poster", "default_poster");

                if (!yearString.matches("\\d+")) {
                    yearString = "Unknown Year";
                }

                movies.add(new Movie(title, yearString, genre, posterResource));
            }
        } catch (IOException | JSONException e) {
            Log.e("JsonUtils", "Error reading JSON data", e);
            return null;
        }
        return movies;
    }
}