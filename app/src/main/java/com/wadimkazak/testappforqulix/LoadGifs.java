package com.wadimkazak.testappforqulix;

import android.net.Uri;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Wadim on 13.02.2018.
 */

public class LoadGifs {
    private static final String TAG = "LoadGifs";
    private static final String API_KEY = "5NaMWYMATh5scKPQnKNjL1uzvpGYm54a";

    public String getJSONString(String UrlSpec) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(UrlSpec)
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }

    public String fetchItems(){
        String jsonString = "";
        try {
            String url = Uri.parse("https://api.giphy.com/v1/gifs/trending")
                    .buildUpon()
                    .appendQueryParameter("api_key", API_KEY)
                    .build().toString();
             jsonString = getJSONString(url);
            JSONObject jsonObject = new JSONObject(jsonString);

        }catch (IOException e){
            Log.e(TAG, "Load error", e);
        }catch (JSONException e){
            Log.e(TAG, "JSON error", e);
        }
       return jsonString;
    }


}
