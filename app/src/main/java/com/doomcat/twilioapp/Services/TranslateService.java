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


        String url = "https://api.microsofttranslator.com/v2/http.svc/Translate?appid=Bearer%20eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzY29wZSI6Imh0dHBzOi8vYXBpLm1pY3Jvc29mdHRyYW5zbGF0b3IuY29tLyIsInN1YnNjcmlwdGlvbi1pZCI6IjQxMTk3YTFkZTUyNzQ4M2VhOTNjOTU4NTMyMDc2MjVhIiwicHJvZHVjdC1pZCI6IlRleHRUcmFuc2xhdG9yLkYwIiwiY29nbml0aXZlLXNlcnZpY2VzLWVuZHBvaW50IjoiaHR0cHM6Ly9hcGkuY29nbml0aXZlLm1pY3Jvc29mdC5jb20vaW50ZXJuYWwvdjEuMC8iLCJhenVyZS1yZXNvdXJjZS1pZCI6Ii9zdWJzY3JpcHRpb25zLzNlZmE1YmFlLTNhOGMtNGNlZC1hYmMyLWRhZmM4NDEyMTEyNy9yZXNvdXJjZUdyb3Vwcy9kb29tY2F0L3Byb3ZpZGVycy9NaWNyb3NvZnQuQ29nbml0aXZlU2VydmljZXMvYWNjb3VudHMvRG9raSIsImlzcyI6InVybjptcy5jb2duaXRpdmVzZXJ2aWNlcyIsImF1ZCI6InVybjptcy5taWNyb3NvZnR0cmFuc2xhdG9yIiwiZXhwIjoxNDk4MTYwODg0fQ.01DSycgUnkU3wsSQ2SujjQwT6yY3SqsU2Dr82mBuPvY";
        String url2 = AppService.formatMessage(message);
        Log.d("translateMessage: ", url+url2);
        Request request= new Request.Builder()
                .url(url+url2)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void translateToEnglish(String message, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder()
                .build();


        String url = "https://api.microsofttranslator.com/v2/http.svc/Translate?appid=Bearer%20eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzY29wZSI6Imh0dHBzOi8vYXBpLm1pY3Jvc29mdHRyYW5zbGF0b3IuY29tLyIsInN1YnNjcmlwdGlvbi1pZCI6IjQxMTk3YTFkZTUyNzQ4M2VhOTNjOTU4NTMyMDc2MjVhIiwicHJvZHVjdC1pZCI6IlRleHRUcmFuc2xhdG9yLkYwIiwiY29nbml0aXZlLXNlcnZpY2VzLWVuZHBvaW50IjoiaHR0cHM6Ly9hcGkuY29nbml0aXZlLm1pY3Jvc29mdC5jb20vaW50ZXJuYWwvdjEuMC8iLCJhenVyZS1yZXNvdXJjZS1pZCI6Ii9zdWJzY3JpcHRpb25zLzNlZmE1YmFlLTNhOGMtNGNlZC1hYmMyLWRhZmM4NDEyMTEyNy9yZXNvdXJjZUdyb3Vwcy9kb29tY2F0L3Byb3ZpZGVycy9NaWNyb3NvZnQuQ29nbml0aXZlU2VydmljZXMvYWNjb3VudHMvRG9raSIsImlzcyI6InVybjptcy5jb2duaXRpdmVzZXJ2aWNlcyIsImF1ZCI6InVybjptcy5taWNyb3NvZnR0cmFuc2xhdG9yIiwiZXhwIjoxNDk4MTU5NzkxfQ.yQe_ZZqSOrX4DYmOaJSbY3bNmMzS2UPSkGHBatuJUa0";
        String url2 = AppService.formatMessageToEnglish(message);
        Log.d("translateMessage: ", url+url2);
        Request request= new Request.Builder()
                .url(url+url2)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


}
