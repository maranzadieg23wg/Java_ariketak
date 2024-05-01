package API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class API {


    private static String api = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YWE0ZjRhMDgzZTMyZjg4MjM5ZmYzZGE3NjVlNmQyOCIsInN1YiI6IjY2MzIyYmFiMDA2YjAxMDEyZDFkMTZiMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.jPQm_oheJ0dTUtVu8vSXEwrpAdZjyC8aHkf53CDsTIo";

    private static final OkHttpClient client = new OkHttpClient();




    static Response pelikulaLortu(String izena) throws IOException {

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

    }

    public static String pelikulaIMG (String izena) throws IOException {
        Response erantzuna = pelikulaLortu(izena);

        String eran = erantzuna.body().string();

        JSONObject json =  new JSONObject(eran);

        JSONArray results = json.getJSONArray("results");

        JSONObject movie = results.getJSONObject(0);

        String posterPath = movie.getString("poster_path");

        posterPath = "http://image.tmdb.org/t/p/w500"+posterPath;
        return posterPath;


    }




}
