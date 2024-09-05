package com.example.atry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button button;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        et1 = findViewById(R.id.etuser);
        et2 = findViewById(R.id.etpass);
        button = findViewById(R.id.btn);
        t1 = findViewById(R.id.tv);

        String username = "pogi@ko";
        String password = "pogiako123";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un = et1.getText().toString();
                String pw = et2.getText().toString();

                if (un.equals(username) && pw.equals(password)) {
                    t1.setText("LOGIN SUCCESSFUL!");
                    Intent i = new Intent(MainActivity.this, nextlogin.class);
                    startActivity(i);
                } else {
                    t1.setText("LOGIN FAILED! TRY AGAIN");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}