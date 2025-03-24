package com.example.week10;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class JsonUtils {
    public static String loadjson(Context context, int resourceID){
        StringBuilder stringbuilder = new StringBuilder();
        int resourceId = 0;
        try (InputStream inputstream = context.getResources().openRawResource(resourceId);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream))){

            String line;
            while ((line = reader.readLine()) != null){
                stringbuilder.append(line);
                //movies.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringbuilder.toString();
    }
    public static List<Movie>loadMoviesFromjson(Context context, int resourceID) throws JSONException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        String jsonContent = loadjson(context,resourceID);
        JSONObject jsonObject = new JSONObject(jsonContent);

        String title = "no title found";
        int year = 0;
        String genre = "no genre found";
        String poster = "no poster data found";

        if (jsonObject.has("title")) {
            title = jsonObject.getString("title");
        }
        if (jsonObject.has("year")) {
            year = jsonObject.getInt("year");
        }
        if (jsonObject.has("genre")) {
            genre = jsonObject.getString("genre");
        }
        if (jsonObject.has("poster")) {
            poster = jsonObject.getString("poster");
        }

        // Create a new Movie object and add it to the list
        Movie movie = new Movie(title, year, genre, poster);
        movies.add(movie);

        return movies;
    }
    private static void handlejsonException(Exception ex){

    }
}
