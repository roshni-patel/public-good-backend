package com.kroger.api;

import java.io.IOException;
// import com.squareup.okhttp3.MediaType;
// import com.squareup.okhttp3.OkHttpClient;
// import com.squareup.okhttp3.Request;
// import com.squareup.okhttp3.RequestBody;
// import com.squareup.okhttp3.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class KrogerAPI {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url("https://api.kroger.com/v1/products?filter.brand={{BRAND}}&filter.term={{TERM}}&filter.locationId={{LOCATION_ID}}")
            .get()
            .addHeader("Accept", "application/json")
            .addHeader("Authorization", "Bearer {{TOKEN}}")
            .build();
        
        Response response = client.newCall(request).execute(); 
    }
}
