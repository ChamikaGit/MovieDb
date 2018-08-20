package com.chamika.fidenz.moviedb.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chamika.fidenz.moviedb.Adapter.DataAdapter;
import com.chamika.fidenz.moviedb.Models.MovieResults;
import com.chamika.fidenz.moviedb.R;
import com.chamika.fidenz.moviedb.Services.API.Sync.GetMovieSync;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetMovieSync.GetHeroCallback {

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    public GetMovieSync getMovieSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loadJASON();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }

    public void loadJASON() {


        getMovieSync = new GetMovieSync(this, this);
        getMovieSync.getMoviesretrofit();


    }


    @Override
    public void onMovieFound(boolean status, ArrayList<MovieResults.ResultsBean> response) {

        if (status && response != null) {

            //progressDialog.dismiss();
            adapter = new DataAdapter(response, getBaseContext());
            recyclerView.setAdapter(adapter);
        } else {
            Toast.makeText(getApplicationContext(), "Error loading data", Toast.LENGTH_LONG).show();
        }
    }
}
