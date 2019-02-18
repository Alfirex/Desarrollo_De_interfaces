package com.example.alfirex.desarrollo_de_interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnLinearLayout, btnRelativeLayout, btnGridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinearLayout = findViewById(R.id.btnLinearLayout);
        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(view.getContext(), LinearLayout.class);
                startActivity(intento);
            }
        });

        btnRelativeLayout = findViewById(R.id.btnRelativeLayout);
        btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(view.getContext(), RelativeLayout.class);
                startActivity(intento);
            }
        });

        btnGridLayout = findViewById(R.id.btnGridLayout);
        btnGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(view.getContext(), GridLayout.class);
                startActivity(intento);
            }
        });
    }
}
