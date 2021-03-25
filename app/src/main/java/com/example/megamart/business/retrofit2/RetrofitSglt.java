package com.example.megamart.business.retrofit2;

import android.util.Base64;

import com.example.megamart.AppConstants;
import com.example.megamart.business.retrofit2.services.WoocommerceApi;

import java.io.UnsupportedEncodingException;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSglt {
    private static RetrofitSglt mInstance;
    private retrofit2.Retrofit mRetrofit;

    private RetrofitSglt() {
        mRetrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(AppConstants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitSglt getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitSglt();
        }
        return mInstance;
    }

    public WoocommerceApi getJSONApi() {
        return mRetrofit.create(WoocommerceApi.class);
    }

    public static String getAuthToken() {
        byte[] data = new byte[0];
        try {
            data = (AppConstants.API_USER_NAME + ":" + AppConstants.API_USER_PASS).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}

