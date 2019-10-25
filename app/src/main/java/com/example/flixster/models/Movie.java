package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    String title;
    String overview;
    String posterPath;
    String backdropPath;
    double rating;
    int movieID;

    public Movie() {
        // This empty constructor is needed for the Parceler library
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        posterPath = jsonObject.getString("poster_path");
        backdropPath = jsonObject.getString("backdrop_path");
        rating = jsonObject.getDouble("vote_average");
        movieID = jsonObject.getInt("id");
    }

    public static List<Movie> fromJSONArray(JSONArray movieJSONArray) throws JSONException {
        // This function is expecting a JSON array, and from the JSON array the function will iterate through
        // the array and expect to find a JSON object through each iteration. At each iteration, it will take only
        // the "title", "overview", and "posterPath" from each JSON object, and create a new Movie class instance to hold
        // the data. All of the new instances will then be added to the Array Movie.
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJSONArray.length(); i++){
            movies.add(new Movie(movieJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public int getMovieID() {
        return movieID;
    }
}
