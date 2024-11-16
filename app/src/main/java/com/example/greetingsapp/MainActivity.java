package com.example.greetingsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Création des variables des composants
        EditText myEditText = findViewById(R.id.myEditText1);
        Button myButton = findViewById(R.id.myBtn1);

        // Création du listener pour le bouton
        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View btnView) {
               Button button = (Button) btnView;
               String result = "Welcome "+ myEditText.getText().toString() + " to our App";
               Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        };

        // Liaison du listener au button
        myButton.setOnClickListener(btnListener);
    }
}