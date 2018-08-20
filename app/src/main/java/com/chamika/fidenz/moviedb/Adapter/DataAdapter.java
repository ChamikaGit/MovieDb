package com.chamika.fidenz.moviedb.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chamika.fidenz.moviedb.Models.MovieResults;
import com.chamika.fidenz.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by fidenz on 2/19/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {


    private ArrayList<MovieResults.ResultsBean> movies;
    private Context context;

    public DataAdapter(ArrayList<MovieResults.ResultsBean> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_celnew, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_moviename.setText(movies.get(position).getTitle());
        holder.tv_releasedate.setText(movies.get(position).getRelease_date());
        Picasso.with(context).load(movies.get(position).getBackdrop_path()).into(holder.imgMainImage);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_moviename,tv_releasedate,tv_date,tv_rate,tv_votecount;
        ImageView imgMainImage,imgRoundImage,imgBookmark;
        public ViewHolder(View itemView) {

            super(itemView);

            tv_moviename = itemView.findViewById(R.id.tvMoviename);
            tv_releasedate = itemView.findViewById(R.id.tvReleasedate);
            tv_date = itemView.findViewById(R.id.tvDate);
            tv_rate = itemView.findViewById(R.id.tvRate);
            tv_votecount = itemView.findViewById(R.id.tvvotecount);
            imgMainImage = itemView.findViewById(R.id.imgMain);
            imgRoundImage =itemView.findViewById(R.id.profile_image);
            imgBookmark =itemView.findViewById(R.id.imgbookmark);


        }
    }
}
