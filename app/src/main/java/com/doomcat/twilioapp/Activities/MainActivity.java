package com.doomcat.twilioapp.Activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.doomcat.twilioapp.Services.AppService;
import com.doomcat.twilioapp.R;
import com.doomcat.twilioapp.Services.TranslateService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {

    @Bind(R.id.startButton)
    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AppService service = new AppService();
        mStartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == mStartButton){
                getWindow().setExitTransition(new Explode());
                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(this).toBundle());
        }
    }
}
