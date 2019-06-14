package br.com.digitalhouse.digitalhousefoods_ivan.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView splashDHFoods;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        splashDHFoods = findViewById(R.id.splash_DHFoods);

        splashDHFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 3000);

    }


    private void jump() {
        timer.cancel();
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
