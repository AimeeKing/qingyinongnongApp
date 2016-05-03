package com.example.hdu.qingyinongnong.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdu.qingyinongnong.R;

public class ChangeMySomeDataActivity extends AppCompatActivity {

    private ImageView mReturnMyDataPageImageView;
    private TextView mChangeDataContentTextView, mFinishChangeMyDataTextView;
    private EditText mMySomeDataEditText;

    private int mRequestCode;

    private final static int CHANGE_NAME_REQUEST_CODE = 1;
    private final static int CHANGE_SIGN_REQUEST_CODE = 2;
    private final static int CHANGE_PHONE_NUMBER_REQUEST_CODE = 3;
    private final static int CHANGE_MAILBOX_REQUEST_CODE = 4;
    private final static int CHANGE_LOCATION_REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_my_some_data);

        mChangeDataContentTextView = (TextView) findViewById(R.id.change_data_content);
        mMySomeDataEditText = (EditText) findViewById(R.id.my_some_data_edit_text);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mRequestCode = bundle.getInt("request_code");
        System.out.println(mRequestCode);
        switch (mRequestCode) {
            case CHANGE_NAME_REQUEST_CODE:
                mChangeDataContentTextView.setText("名字");
                mMySomeDataEditText.setText(bundle.getString("content"));
                break;
            case CHANGE_SIGN_REQUEST_CODE:
                mChangeDataContentTextView.setText("签名");
                mMySomeDataEditText.setText(bundle.getString("content"));
                break;
            case CHANGE_PHONE_NUMBER_REQUEST_CODE:
                mChangeDataContentTextView.setText("手机号");
                mMySomeDataEditText.setText(bundle.getString("content"));
                break;
            case CHANGE_MAILBOX_REQUEST_CODE:
                mChangeDataContentTextView.setText("邮箱");
                mMySomeDataEditText.setText(bundle.getString("content"));
                break;
//            case CHANGE_LOCATION_REQUEST_CODE:
//                mChangeDataContentTextView.setText("所在地");
//                break;
        }

        mFinishChangeMyDataTextView = (TextView) findViewById(R.id.finish_change_my_data);
        mFinishChangeMyDataTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeMySomeDataActivity.this, MyDataActivity.class);
                intent.putExtra("content", mMySomeDataEditText.getText().toString());
                setResult(mRequestCode, intent);
                finish();
            }
        });

        mReturnMyDataPageImageView = (ImageView) findViewById(R.id.return_my_data_page_image_view);
        mReturnMyDataPageImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeMySomeDataActivity.this, MyDataActivity.class);
                startActivity(intent);
            }
        });


    }

}
