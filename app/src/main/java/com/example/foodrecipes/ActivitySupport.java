package com.example.foodrecipes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ActivitySupport extends AppCompatActivity {

    public static final String EMAIL = "azamatnsr@gmail.com";

    TextInputEditText editText1;
    TextInputEditText editText2;
    TextInputEditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Support");
        actionBar.setDisplayHomeAsUpEnabled(true);

        editText1 = findViewById(R.id.support_name);
        editText2 = findViewById(R.id.support_title);
        editText3 = findViewById(R.id.support_description);

        Button button = findViewById(R.id.support_b);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    public void sendMessage(){
        if(!isConnected(this)){
            showCustomDialog();
        }

        String name = editText1.getText().toString();
        String title = editText2.getText().toString();
        String message = editText3.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"azamatnsr@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, name + "\n" + message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an app to send email"));
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySupport.this);
        builder.setMessage("Please connect to the internet to proceed further")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
    }

    private boolean isConnected(ActivitySupport activitySupport) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activitySupport.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiCon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileCon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiCon != null && wifiCon.isConnected() || (mobileCon != null && mobileCon.isConnected()))){
            return true;
        }
        else{
            return false;
        }
    }
}