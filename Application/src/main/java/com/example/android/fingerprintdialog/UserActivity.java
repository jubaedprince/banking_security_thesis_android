package com.example.android.fingerprintdialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    public void balanceTransfer(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void creditClicked(View v){
        Intent intent = new Intent(this, CreditActivity.class);
        startActivity(intent);

    }
}
