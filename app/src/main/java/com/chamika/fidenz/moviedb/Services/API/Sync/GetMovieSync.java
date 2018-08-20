package com.chamika.fidenz.moviedb.Services.API.Sync;

import android.content.Context;

import com.chamika.fidenz.moviedb.Helpers.Const;
import com.chamika.fidenz.moviedb.Models.MovieResults;
import com.chamika.fidenz.moviedb.Services.API.ResponseInterface.GetMovies;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fidenz on 2/19/18.
 */

public class GetMovieSync {

    public static int PAGE = 1;
    public static String API_KEY = "83bce3bbda19e918262c41c903aaba25";
    public static String Lanugae = "en-US";
    public static String CATEGORY = "popular";


    private Context context;
    private GetHeroCallback callback;

    public GetMovieSync(Context context, GetHeroCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void getMoviesretrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GetMovies heroAPI = retrofit.create(GetMovies.class);

        Call<MovieResults> call = heroAPI.getMovies(CATEGORY, API_KEY, Lanugae, PAGE);

        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {

                MovieResults results =response.body();
                ArrayList<MovieResults.ResultsBean> resultsBeans =results.getResults();

                callback.onMovieFound(true,resultsBeans);
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {

                callback.onMovieFound(false,null);

            }
        });

    }

    public interface GetHeroCallback {
        void onMovieFound(boolean status, ArrayList<MovieResults.ResultsBean> response);
    }
}
