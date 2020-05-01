package com.paulodantas.whereareyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView trabalho, autor;
    private ImageView imagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        inicializarComponentes();
        inicializarAnimacao();

        int SPLASHSCREEN = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(login);
                finish();
            }
        }, SPLASHSCREEN);

    }

    private void inicializarAnimacao() {

        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        imagem.setAnimation(topAnim);
        trabalho.setAnimation(bottomAnim);
        autor.setAnimation(bottomAnim);
    }

    private void inicializarComponentes() {

        imagem = findViewById(R.id.imageView);
        trabalho = findViewById(R.id.textAuthor);
        autor = findViewById(R.id.textJob);
    }
}
