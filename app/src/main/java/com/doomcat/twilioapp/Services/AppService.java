package com.doomcat.twilioapp.Services;

import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;

public class AppService {

    public AppService(){

    }

    public void setFonts(TextView[] views, Typeface font){
        for (TextView i: views){
            i.setTypeface(font);
        }
    }

    public Boolean isInputEmpty(EditText a, EditText b, EditText c){
        if (a.getText().toString().length() == 0 || b.getText().toString().length() == 0 || c.getText().toString().length() == 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean passwordMatches(EditText a, EditText b){
        if (a.getText().toString().equals(b.getText().toString())){
            return true;
        }else{
            return false;
        }
    }


    public static String formatMessage(String s){
        String[] words = s.split(" ");
        String output = "text=";
        for (String i : words){
            output += i;
            output += " ";
        }
        return output;

    }
}
