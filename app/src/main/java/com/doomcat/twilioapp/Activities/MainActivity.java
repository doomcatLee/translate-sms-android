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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends Activity implements View.OnClickListener {

    @Bind(R.id.userNameEditText1)
    EditText mUserNameEditText;

    @Bind(R.id.passwordEditText1)
    EditText mPasswordEditText;

    @Bind(R.id.signUpTextView)
    TextView mSignUp;

    @Bind(R.id.logInButton)
    Button mLogInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AppService service = new AppService();
        mSignUp.setOnClickListener(this);
        mLogInButton.setOnClickListener(this);

        Typeface titleFont = Typeface.createFromAsset(getAssets(),"fonts/Drifttype.ttf");
        Typeface robotoFont = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Light.ttf");

        TextView[] fonts = {mUserNameEditText, mPasswordEditText};
        service.setFonts(fonts,robotoFont);
    }

    @Override
    public void onClick(View v){
        AppService service = new AppService();

        if (v == mLogInButton){
            if (service.isInputEmpty(mUserNameEditText, mPasswordEditText,mPasswordEditText)){
                String message = "Please complete all the input fields";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }else{
                getWindow().setExitTransition(new Explode());
                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                String userName = mUserNameEditText.getText().toString();
                intent.putExtra("userName", userName);
                startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(this).toBundle());
            }
        }
        if (v == mSignUp){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}
