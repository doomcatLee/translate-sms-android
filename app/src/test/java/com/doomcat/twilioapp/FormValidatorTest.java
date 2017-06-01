package com.doomcat.twilioapp;

import android.os.Build;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;


import android.widget.EditText;

import com.doomcat.twilioapp.Activities.MainActivity;

import org.junit.Before;
import org.robolectric.Robolectric;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)


public class FormValidatorTest {

    private MainActivity activity;
    private EditText mUserNameEditText;
    private EditText mPasswordEditText;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        mUserNameEditText = (EditText) activity.findViewById(R.id.userNameEditText1);
        mPasswordEditText = (EditText) activity.findViewById(R.id.passwordEditText1);
    }

//
//    @Test
//    public void testIfFormValidatorInstantiates(){
//        FormValidator fv1 = new FormValidator();
//        System.out.println(fv1.spitText());
//    }
//    @Test
//    public void TestIsEmpty(){
//        FormValidator fv1 = new FormValidator();
//        String userName = "";
//        String password = "";
//        assertTrue(fv1.isEmpty(userName, password));
//
//    }

}