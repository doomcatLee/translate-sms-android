package com.doomcat.twilioapp.Activities;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import com.doomcat.twilioapp.R;


public class AdminActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "AdminActivity";
    private EditText mTo;
    private EditText mBody;
    private Button mSend;
    private OkHttpClient mClient = new OkHttpClient();
    private ImageView mAlex;
    private String mLanguage;

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        Object current = parent.getItemAtPosition(pos);
        mLanguage = current.toString();
        Log.d("test", current.toString());
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mTo = (EditText) findViewById(R.id.txtNumber);
        mBody = (EditText) findViewById(R.id.txtMessage);
        mSend = (Button) findViewById(R.id.btnSend);



        //Spinners
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //So we wait for translatedText to be filled first
                    Thread.sleep(700);
                    post("http://node-senseiapp.tbztjmszwp.us-west-2.elasticbeanstalk.com/sendSMS", new  Callback(){

                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("test1", mTo.getText().toString());
                                    Log.d("test2", mBody.getText().toString());
                                    mTo.setText("");
                                    mBody.setText("");
                                    Toast.makeText(getApplicationContext(),"SMS Sent!",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    Call post(String url, Callback callback) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("To", mTo.getText().toString())
                .add("Body", mBody.getText().toString())
                .add("Language", mLanguage)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Call response = mClient.newCall(request);
        response.enqueue(callback);
        return response;
    }

}
