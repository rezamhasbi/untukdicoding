package com.example.untukdicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class detail extends AppCompatActivity {
    ImageView reza_detail;
    TextView nama_detail,email_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        reza_detail = findViewById(R.id.reza_detail);
        nama_detail = findViewById(R.id.nama_detail);
        email_detail = findViewById(R.id.email_detail);

        Bundle bundle = getIntent().getExtras();
        nama_detail.setText(bundle.getString("nama"));
        email_detail.setText(bundle.getString("email"));

        Glide.with(this)
                .load(bundle.get("foto"))
                .apply(new RequestOptions().override(350,550))
                .into(reza_detail);

    }
}
