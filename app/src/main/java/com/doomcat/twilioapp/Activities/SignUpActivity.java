package com.doomcat.twilioapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.doomcat.twilioapp.Services.AppService;
import com.doomcat.twilioapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUpActivity extends Activity implements View.OnClickListener{

    @Bind (R.id.textView)
    TextView mTextView;

    @Bind (R.id.signUpButton)
    Button mSignUpButton;

    @Bind (R.id.userNameEditText2)
    EditText mUserNameEditText;

    @Bind (R.id.passwordEditText2)
    EditText mPasswordEditText;

    @Bind (R.id.passwordConfirmEditText2)
    EditText mPasswordConfirmEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        AppService service = new AppService();
        ButterKnife.bind(this);
        mSignUpButton.setOnClickListener(this);

        Typeface robotoFont = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Light.ttf");
        TextView[] viewList = {mUserNameEditText, mPasswordEditText, mPasswordConfirmEditText,mSignUpButton,mTextView};
        //Set the typeface fonts
        service.setFonts(viewList, robotoFont);

    }

    @Override
    public void onClick(View view){
        AppService service = new AppService();
        if (view == mSignUpButton){
            if (service.isInputEmpty(mUserNameEditText, mPasswordEditText, mPasswordConfirmEditText)){
                String message = "Please complete all the input fields";
                Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_LONG).show();
            }else if(!service.passwordMatches(mPasswordEditText, mPasswordConfirmEditText)){
                String message = "Passwords must match!";
                Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_LONG).show();
            }else{
                Intent intent = new Intent(SignUpActivity.this, AdminActivity.class);
                String userName = mUserNameEditText.getText().toString();
                intent.putExtra("userName", userName);
                startActivity(intent);
            }

        }

    }


}
