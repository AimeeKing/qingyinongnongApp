package com.example.hdu.qingyinongnong.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Aimee on 2016/4/16.
 */
public class Singleton {
    public static Singleton mInstance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context context;

    private Singleton(Context context)
    {
        this.context = context;
        requestQueue = getRequestQueue();
        imageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache(){
                    private final LruCache<String,Bitmap>
                            cache = new LruCache<String,Bitmap>(20);
                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url,bitmap);
                    }



                });
    }

    public static synchronized Singleton getmInstance(Context mcontext)
    {
        if(context == null)
        {
            mInstance = new Singleton(mcontext);
        }
        return mInstance;
    }

    private RequestQueue getRequestQueue() {
        if(null==requestQueue)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public  <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader()
    {
        return imageLoader;
    }
}
