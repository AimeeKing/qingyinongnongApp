package com.example.hdu.qingyinongnong.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdu.qingyinongnong.R;

public class RegisterActivity extends Activity {

    private Button mGetIdentifyingCode;
    private ImageView mReturnImageView;
    private TextView mReturnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mReturnImageView = (ImageView) findViewById(R.id.return_image_view);
        mReturnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mReturnTextView = (TextView) findViewById(R.id.return_text_view);
        mReturnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
