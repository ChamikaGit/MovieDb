package com.chamika.fidenz.moviedb.Services.API.ResponseInterface;

import com.chamika.fidenz.moviedb.Models.MovieResults;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by fidenz on 2/19/18.
 */

public interface GetMovies {


    @GET("3/movie/{category}")
    Call<MovieResults> getMovies(

            @Path("category") String category,
            @Query("api_key") String apikey,
            @Query("language") String language,
            @Query("page") int page
    );

}
