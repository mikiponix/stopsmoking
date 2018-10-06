package mikiponix.io.stopsmoking;

import android.support.v7.app.AppCompatActivity;

public class Login {

    private String key;
    private String loginText;

    public Login(){

    }


    public Login(String key, String loginText){
        this.key = key;
        this.loginText = loginText;

    }


    public String getKey(){
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public String getLoginText(){
        return loginText;
    }

    public void setLoginText(String loginText){
        this.loginText = loginText;
    }


}


