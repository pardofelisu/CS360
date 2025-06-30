package com.example.tashieventtrackerreal;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import com.example.tashieventtrackerreal.R;
import android.widget.*;







public class MainActivity extends AppCompatActivity {

   //


    public void onLoginClick(View view) {
        // Handle login button click
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void onRegisterClick(View view) {
        // Handle register button click
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onExitClick(View view) {
        // Handle exit button click
        Toast.makeText(this, "Exiting the app", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void onEventTrackerClick(View view) {
        // Handle event tracker button click
        Intent intent = new Intent(this, EventTrackerActivity.class);
        startActivity(intent);
    }
    public void onLoginPageClick(View view) {
        // Handle login page button click
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

//displays event database
    public void onEventDatabaseClick(View view) {
        // Handle event database button click
        Intent intent = new Intent(this, EventTrackerActivity.class);
        startActivity(intent);
    }
    //displays notifications
    public void onNotificationsClick(View view) {
        // Handle notifications button click
        Intent intent = new Intent(this, notifications.class);
        startActivity(intent);
    }





}