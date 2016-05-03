package com.example.hdu.qingyinongnong.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.utils.Singleton;

public class MenuContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_content);
        final ImageView menuContentImg = (ImageView) findViewById(R.id.menucontent_img);
        String url = "http://img.hb.aicdn.com/ffe0782a583d4db7749f289ca559b09f688cc61685702-F2BNUY_fw658";
        //            http://img.hb.aicdn.com/8f4a8bd0d207dd9da775fe01bbba1f16990b2d53c5805-SYnSZX_fw658
        ImageRequest menuContentRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                int nh = (int)(response.getHeight()*(menuContentImg.getWidth()*1.0/response.getWidth()));
                Bitmap scaled = Bitmap.createScaledBitmap(response,menuContentImg.getWidth(),nh,true);
                menuContentImg.setImageBitmap(scaled);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                menuContentImg.setImageResource(R.drawable.page_menu_6);
            }
        });
        Singleton.getmInstance(getApplicationContext()).addToRequestQueue(menuContentRequest);
    }
}
