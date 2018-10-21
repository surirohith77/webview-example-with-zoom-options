package rs.com.webv;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NetworkerrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networkerror);
    }

    public void checkin(View view) {
        ConnectivityManager cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni == null){
            finish();
            startActivity(new Intent(this,NetworkerrorActivity.class));
        }
        else {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
