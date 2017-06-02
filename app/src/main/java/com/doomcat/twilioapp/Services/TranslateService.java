package com.doomcat.twilioapp.Services;

import android.provider.SyncStateContract;
import android.util.Log;

import com.doomcat.twilioapp.Credentials;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class TranslateService {



    public static void translateMessage(String message, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Credentials.TRANSLATE_API_URL).newBuilder();
        urlBuilder.query(AppService.formatMessage(message));
        urlBuilder.addQueryParameter("to",Credentials.LANGUAGE_PARAMETER);


        String url = urlBuilder.build().toString();
        Log.d("test", url);

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


}
