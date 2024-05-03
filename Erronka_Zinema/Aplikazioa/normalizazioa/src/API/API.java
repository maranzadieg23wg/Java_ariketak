package API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class API {

    //https://developer.themoviedb.org/reference/search-movie
    //https://www.kaggle.com/datasets/alessandrolobello/the-ultimate-film-statistics-dataset-for-ml?resource=download

    private static String api = "winrar";

    private static final OkHttpClient client = new OkHttpClient();




    static Response pelikulaLortu(String izena){

        try {
            izena=izena.replace(" ", "%20");

            izena = izena.replace(":", "%3A");


            Request request = new Request.Builder()
                    .url("https://api.themoviedb.org/3/search/movie?query="+izena+"&include_adult=false&language=en-US&page=1")
                    .get()
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", api)
                    .build();


            Response erantzuna = client.newCall(request).execute();

            if (!erantzuna.isSuccessful()) {
                throw new IOException("Unexpected code " + erantzuna);
            }

            return erantzuna;
        }catch (Exception e){
            return null;
        }


    }

    public static Response zuzendariaLortu(String izena) throws IOException {
        izena = izena.replace(" ", "%20");
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/search/person?query="+izena+"&include_adult=false&language=en-US&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", api)
                .build();

        return client.newCall(request).execute();
    }

    public static JSONObject jsonLortu(Response erantzuna) throws IOException {
        try {
            String eran = erantzuna.body().string();

            JSONObject json =  new JSONObject(eran);

            JSONArray results = json.getJSONArray("results");

            JSONObject movie = results.getJSONObject(0);

            return movie;
        }catch (Exception e){
            return null;
        }


    }

    public static int pelikulaID(String izena) throws IOException {
        try {
            JSONObject movie = jsonLortu(pelikulaLortu(izena));

            int posterPath = movie.getInt("id");
            return posterPath;
        }catch (Exception e){
            return 0;
        }

    }

    public static String pelikulaIMG (String izena) throws IOException {
        try {
            Response erantzuna = pelikulaLortu(izena);

            String eran = erantzuna.body().string();

            JSONObject json =  new JSONObject(eran);

            JSONArray results = json.getJSONArray("results");

            JSONObject movie = results.getJSONObject(0);

            String posterPath = movie.getString("poster_path");

            posterPath = "http://image.tmdb.org/t/p/w500"+posterPath;
            return posterPath;
        }catch (Exception e){
            return null;
        }


    }

    public static String pelikulaTrailer (String izena) throws IOException {

        try {
            int id = pelikulaID(izena);


            Request request = new Request.Builder()
                    .url("https://api.themoviedb.org/3/movie/"+id+"/videos?language=en-US")
                    .get()
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YWE0ZjRhMDgzZTMyZjg4MjM5ZmYzZGE3NjVlNmQyOCIsInN1YiI6IjY2MzIyYmFiMDA2YjAxMDEyZDFkMTZiMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.jPQm_oheJ0dTUtVu8vSXEwrpAdZjyC8aHkf53CDsTIo")
                    .build();

            Response erantzuna = client.newCall(request).execute();

            String eran = erantzuna.body().string();

            JSONObject json =  new JSONObject(eran);

            JSONArray results = json.getJSONArray("results");

            JSONObject movie = results.getJSONObject(0);

            String posterPath = movie.getString("key");

            posterPath = "https://www.youtube.com/watch?v="+posterPath;

            return posterPath;
        }catch (Exception e){
            return null;
        }

    }






}
