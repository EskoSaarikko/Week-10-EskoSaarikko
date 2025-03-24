package com.example.week10;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.week10.JsonUtils;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private RecyclerView movieRecycleView;

    private  MovieAdapter adapter;

    private List<Movie> movies;
    //button = findViewById.(R.id.button);

    //button.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View view) {
            // Function implementation
        //}
    //});
    JsonUtils jsonUtils = new JsonUtils();
    public void loadMoviesFromjson(){
        try{
            List<Movie> movies = new ArrayList<Movie>();
            movies = JsonUtils.loadMoviesFromjson(this, R.raw.movies);
            TextView textView = findViewById(R.id.Movie_info);
            String finallist = movies.toString();
            textView.setText(finallist);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

}