
package com.shadowcorridor.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        try {
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );

            WebView web = new WebView(this);

            WebSettings settings = web.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);

            web.setWebViewClient(new WebViewClient());
            web.setBackgroundColor(0xff050608);

            setContentView(web);
            web.loadUrl("file:///android_asset/index.html");

        } catch (Exception e) {
            TextView error = new TextView(this);
            error.setText("Shadow Corridor Error:\n" + e.toString());
            error.setTextColor(0xffff0000);
            setContentView(error);
        }
    }
}
