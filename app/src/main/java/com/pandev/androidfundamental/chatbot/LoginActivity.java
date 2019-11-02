package com.pandev.androidfundamental.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private Button LoginButton, PhoneLoginButton;
    private EditText UserEmail, UserPassword;
    private TextView NedNewAccountLink, ForgetPasswordLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitializeField();

    }

    private void InitializeField()
    {
        LoginButton = (Button)findViewById(R.id.login_button);
        PhoneLoginButton = (Button)findViewById(R.id.phone_login_button);
        UserEmail = (EditText)findViewById(R.id.login_email);
        UserPassword = (EditText)findViewById(R.id.login_pass);
        NedNewAccountLink = (TextView)findViewById(R.id.need_new_account_link);
        ForgetPasswordLink = (TextView)findViewById(R.id.forget_pass_link);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (currentUser != null){
            SendUserMainActivity();
        }
    }

    private void SendUserMainActivity() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }
}
