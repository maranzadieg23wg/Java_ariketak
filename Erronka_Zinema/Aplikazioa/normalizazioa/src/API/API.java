package API;

import DB.Konexioa;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class API {

    //https://developer.themoviedb.org/reference/search-movie
    //https://www.kaggle.com/datasets/alessandrolobello/the-ultimate-film-statistics-dataset-for-ml?resource=download

    private static String api = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YWE0ZjRhMDgzZTMyZjg4MjM5ZmYzZGE3NjVlNmQyOCIsInN1YiI6IjY2MzIyYmFiMDA2YjAxMDEyZDFkMTZiMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.jPQm_oheJ0dTUtVu8vSXEwrpAdZjyC8aHkf53CDsTIo";

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
                    .addHeader("Authorization", api)
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


    public static void gehituAkt(int peliID, int azkenID, int idLokal){

        try{
            int zenbat = 7;

            Request request = new Request.Builder()
                    .url("https://api.themoviedb.org/3/movie/"+peliID+"/credits?language=en-US")
                    .get()
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", api)
                    .build();

            Response erantzuna = client.newCall(request).execute();


            String eran = erantzuna.body().string();

            JSONObject json =  new JSONObject(eran);

            if (json.has("cast")){
                JSONArray results = json.getJSONArray("cast");

                for (int i = 0; i < zenbat && i < results.length(); i++) {

                    JSONObject movie = results.getJSONObject(i);

                    String izena = movie.getString("name");
                    int gender = movie.getInt("gender");

                    String pertsonaia = movie.getString("character");
                    String url ="";
                    if (movie.isNull("profile_path")) {
                        url = null;
                    } else {
                        url = "http://image.tmdb.org/t/p/w500" + movie.getString("profile_path");
                    }



                    String[] izAbz = izena.split(" ");

                    int aktoreId =0;

                    if (izAbz.length ==1){
                        aktoreId = Konexioa.aktoreaDago(izAbz[0], null);
                    }else {
                        aktoreId = Konexioa.aktoreaDago(izAbz[0], izAbz[1]);
                    }


                    Konexioa.aktoZ++;



                    if (aktoreId == -1){

                        if (izAbz.length==1){
                            Konexioa.gehituAktorea(Konexioa.aktoZ, izAbz[0], null,gender, url);
                        }else {
                            Konexioa.gehituAktorea(Konexioa.aktoZ, izAbz[0], izAbz[1],gender, url);
                        }


                        Konexioa.lanEGin(Konexioa.aktoZ, idLokal, pertsonaia);

                    }else {
                        Konexioa.aktoZ--;
                        Konexioa.lanEGin(aktoreId, idLokal, pertsonaia);
                    }









                }
            }

        }catch (IOException| SQLException e){
            System.out.println(e.getMessage());
        }




    }






}
