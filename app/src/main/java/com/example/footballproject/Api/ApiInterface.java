package com.example.footballproject.Api;

import com.example.footballproject.Models.premierleague.plmatches.PlMatch;
import com.example.footballproject.Models.premierleague.plstanding.Plstanding;
import com.example.footballproject.Models.premierleague.team.TeamDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


//    @GET("post")
//    Call<Post> getPosts(
//            @Query("category") int cid
//    );
//
//    @GET("category")
//    Call<Category> getCategorys();
    @GET("competitions/2021/matches")
    Call<PlMatch> getMatches(
            @Header("X-Auth-Token") String token
    );

    @GET("competitions/2021/standings")
    Call<Plstanding> getStandings(
            @Query("standingType") String type,
            @Header("X-Auth-Token") String token
    );

    @GET("teams/{id}")
    Call<TeamDetail> getTeamDetail(
            @Path("id") int id,
            @Header("X-Auth-Token") String token
    );

    //Today, Yesterday, Tomorrow Fragment
    @GET("matches")
    Call<PlMatch> getHomeMatches(
            @Query("competitions") String competition,
            @Query("dateFrom") String dateFrom,
            @Query("dateTo") String dateTo,
            @Header("X-Auth-Token") String token
    );
}
