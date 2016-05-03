package com.example.hdu.qingyinongnong.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hdu.qingyinongnong.R;

public class MyDataActivity extends AppCompatActivity {

    private RelativeLayout mMyDataHeadIconRelativeLayout, mMyDataNameRelativeLayout,
            mMyDataSignRelativeLayout, mMyDataPhoneNumberRelativeLayout,
            mMyDataMailboxRelativeLayout, mMyDataLocationRelativeLayout;

    private TextView mMyDataNameTextView, mMyDataSignTextView, mMyDataPhoneNumberTextView,
            mMyDataMailboxTextView, mMyDataLocationTextView;

    private final static int CHANGE_NAME_REQUEST_CODE = 1;
    private final static int CHANGE_SIGN_REQUEST_CODE = 2;
    private final static int CHANGE_PHONE_NUMBER_REQUEST_CODE = 3;
    private final static int CHANGE_MAILBOX_REQUEST_CODE = 4;
    private final static int CHANGE_LOCATION_REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data_page);

        mMyDataHeadIconRelativeLayout = (RelativeLayout) findViewById(
                R.id.my_data_head_icon_relative_layout);
        mMyDataHeadIconRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyDataActivity.this, GetHeadIconActivity.class);
                startActivity(intent);
            }
        });

        mMyDataNameRelativeLayout = (RelativeLayout) findViewById(
                R.id.my_data_name_relative_layout);
        mMyDataNameRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyDataActivity.this, ChangeMySomeDataActivity.class);
                mMyDataNameTextView = (TextView) findViewById(R.id.my_name);
                intent.putExtra("content", mMyDataNameTextView.getText().toString());
                intent.putExtra("request_code", CHANGE_NAME_REQUEST_CODE);
                startActivityForResult(intent, CHANGE_NAME_REQUEST_CODE);
            }
        });

        mMyDataSignRelativeLayout = (RelativeLayout) findViewById(
                R.id.my_data_sign_relative_layout);
        mMyDataSignRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyDataActivity.this, ChangeMySomeDataActivity.class);
                mMyDataSignTextView = (TextView) findViewById(R.id.my_sign);
                intent.putExtra("content", mMyDataSignTextView.getText().toString());
                intent.putExtra("request_code", CHANGE_SIGN_REQUEST_CODE);
                startActivityForResult(intent, CHANGE_SIGN_REQUEST_CODE);
            }
        });

        mMyDataPhoneNumberRelativeLayout = (RelativeLayout) findViewById(
                R.id.my_data_phone_number_relative_layout);
        mMyDataPhoneNumberRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyDataActivity.this, ChangeMySomeDataActivity.class);
                mMyDataPhoneNumberTextView = (TextView) findViewById(R.id.my_phone_number);
                intent.putExtra("content", mMyDataPhoneNumberTextView.getText().toString());
                intent.putExtra("request_code", CHANGE_PHONE_NUMBER_REQUEST_CODE);
                startActivityForResult(intent, CHANGE_PHONE_NUMBER_REQUEST_CODE);
            }
        });

        mMyDataMailboxRelativeLayout = (RelativeLayout) findViewById(
                R.id.my_data_mailbox_relative_layout);
        mMyDataMailboxRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyDataActivity.this, ChangeMySomeDataActivity.class);
                mMyDataMailboxTextView = (TextView) findViewById(R.id.my_mailbox);
                intent.putExtra("content", mMyDataMailboxTextView.getText().toString());
                intent.putExtra("request_code", CHANGE_MAILBOX_REQUEST_CODE);
                startActivityForResult(intent, CHANGE_MAILBOX_REQUEST_CODE);
            }
        });

        mMyDataLocationRelativeLayout = (RelativeLayout) findViewById(
                R.id.my_data_location_relative_layout);
        mMyDataLocationRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyDataActivity.this, GetLocationActivity.class);
                mMyDataLocationTextView = (TextView) findViewById(R.id.my_location);
//                intent.putExtra("content", mMyDataLocationTextView.getText().toString());
//                intent.putExtra("request_code", CHANGE_LOCATION_REQUEST_CODE);
                startActivityForResult(intent, CHANGE_LOCATION_REQUEST_CODE);
//                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data != null) {
            Bundle bundle = data.getExtras();
            switch (requestCode) {
                case CHANGE_NAME_REQUEST_CODE:
                    mMyDataNameTextView.setText(bundle.getString("content"));
                    break;
                case CHANGE_SIGN_REQUEST_CODE:
                    mMyDataSignTextView.setText(bundle.getString("content"));
                    break;
                case CHANGE_PHONE_NUMBER_REQUEST_CODE:
                    mMyDataPhoneNumberTextView.setText(bundle.getString("content"));
                    break;
                case CHANGE_MAILBOX_REQUEST_CODE:
                    mMyDataMailboxTextView.setText(bundle.getString("content"));
                    break;
                case CHANGE_LOCATION_REQUEST_CODE:
                    mMyDataLocationTextView.setText(bundle.getString("content"));
                    break;
            }
        }

    }

}
