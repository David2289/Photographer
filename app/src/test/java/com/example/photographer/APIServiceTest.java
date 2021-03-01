package com.example.photographer;

import com.example.photographer.business.apirest.APIService;
import com.example.photographer.business.interceptor.BasicAuthInterceptor;
import com.example.photographer.business.model.Users;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;

public class APIServiceTest {

    @BeforeClass
    public static void setUp() {

    }

    @Test
    public void testCallUsersWithCorrectCredential() throws IOException {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        String userName = "test@gmail.com";
        String password = "1234";
        BasicAuthInterceptor basicAuthInterceptor = new BasicAuthInterceptor(userName, password);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor) //httpLoggingInterceptor allows to log json body.
                .addInterceptor(basicAuthInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<Users> call = apiService.fetchUsersCall();
        Response<Users> movieResponse = call.execute();

        assertEquals(movieResponse.code(), 200);
    }


    @Test
    public void testCallUsersWithWrongCredential() throws IOException {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        String userName = "testing@gmail.com";
        String password = "12";
        BasicAuthInterceptor basicAuthInterceptor = new BasicAuthInterceptor(userName, password);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor) //httpLoggingInterceptor allows to log json body.
                .addInterceptor(basicAuthInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<Users> call = apiService.fetchUsersCall();
        Response<Users> movieResponse = call.execute();

        assertEquals(movieResponse.code(), 401);
    }

}
