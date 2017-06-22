package com.doomcat.twilioapp.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.doomcat.twilioapp.R;
import com.doomcat.twilioapp.Services.TranslateService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;


public class MessagesActivity extends Activity {
    String mTextSMS;
    String mTranslatedHolder;
    TextView mMessage;
    TextView mTranslated;
    Button mTranslate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        mMessage = (TextView) findViewById(R.id.messageTextView);
        mTranslated = (TextView) findViewById(R.id.translatedTextView);
        mTranslate = (Button) findViewById(R.id.translateButton);

        RequestQueue queue = Volley.newRequestQueue(this);

        final String url = "https://064d85aa.ngrok.io/receiveSMS";

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, (String)null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response from message: ", response.toString());
                        try{
                            JSONArray array = response.getJSONArray("convoList");

                            Log.d("onResponse: ", array.get(0).toString());
                            mTextSMS = array.get(0).toString();
                            mMessage.setText(mTextSMS);
                            mTranslated.setText(array.get(0).toString());


                        }catch(JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", "error");
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);


        mTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateService.translateToEnglish(mTextSMS, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, okhttp3.Response response) throws IOException {
                        try {
                            String jsonData = response.body().string();

                            mTranslatedHolder = jsonData.substring(68, jsonData.length() - 9);
                            Log.d("asdonResponse: " , mTranslatedHolder);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){

                }
                mTranslated.setText(mTranslatedHolder);

            }
        });
    }
}