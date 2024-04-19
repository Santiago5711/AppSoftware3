package com.example.mylogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

        EditText correo,clave;
        private Button material;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
            correo = findViewById(R.id.correo);
            clave = findViewById(R.id.clave);
            material = findViewById(R.id.material);
        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdd myDB = new bdd(MainActivity.this);
                myDB.añadir_usuario(correo.getText().toString().trim(),clave.getText().toString().trim());

            }
        });








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}