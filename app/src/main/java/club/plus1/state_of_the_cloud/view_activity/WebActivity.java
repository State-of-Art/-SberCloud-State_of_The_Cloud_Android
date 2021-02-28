package club.plus1.state_of_the_cloud.view_activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import club.plus1.state_of_the_cloud.databinding.ActivityWebBinding;
import club.plus1.state_of_the_cloud.middle_presenter.WebPresenter;

public class WebActivity extends AppCompatActivity {

    private ActivityWebBinding binding;
    private WebPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebBinding.inflate(getLayoutInflater());
        binding.webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
        setContentView(binding.getRoot());
        presenter = new WebPresenter(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart(getIntent().getExtras());
    }

    public void loadUrl(String url) {
        binding.webView.loadUrl(url);
    }
}