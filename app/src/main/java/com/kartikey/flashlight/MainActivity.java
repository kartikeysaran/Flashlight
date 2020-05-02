package com.kartikey.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Camera camera;
    ImageView bulbglow,bulb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bulb = findViewById(R.id.bulb);

        bulbglow = findViewById(R.id.bulbglow);

        camera = Camera.open();
        bulbglow.setVisibility(View.GONE);

        final Camera.Parameters parameters = camera.getParameters();
        bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bulbglow.setVisibility(View.VISIBLE);

                bulb.setVisibility(View.GONE);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();

            }
        });
        bulbglow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bulb.setVisibility(View.VISIBLE);
                bulbglow.setVisibility(View.GONE);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.stopPreview();


            }
        });


    }


}
