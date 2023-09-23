package devandroid.bruna.coversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    //Timer
    private static int SPLASH_TIME_OUT = 4000;

    private WebView wv1;
    String url;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "https://giphy.com/stickers/cenkerbulutresmi-timer-timeline-cenkerbulut-Sq3PkPeO9ZkPWvOsV1";
        wv1 = (WebView) findViewById(R.id.webView);
        wv1.loadUrl(url);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, TelaInicial.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}