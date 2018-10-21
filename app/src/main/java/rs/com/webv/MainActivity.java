package rs.com.webv;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        if (ni==null){

            finish();
            startActivity(new Intent(this,NetworkerrorActivity.class));
        }
        else {
          wv =  findViewById(R.id.wv);
          wv.loadUrl("http://jobscampuses.com/");
            WebSettings ws=wv.getSettings();
            ws.setJavaScriptEnabled(true);
            ws.setBuiltInZoomControls(true);
            ws.setDisplayZoomControls(false);
            wv.setWebViewClient(new WebViewClient());
        }


    }

    public void back(View view) {

        if (wv.canGoBack()){
            wv.goBack();
        }
    }
}
