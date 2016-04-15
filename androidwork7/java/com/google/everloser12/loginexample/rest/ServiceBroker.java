package com.google.everloser12.loginexample.rest;

import android.util.Log;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.everloser12.loginexample.rest.models.LoginRequest;
import com.google.everloser12.loginexample.rest.models.RegisterRequest;
import com.google.everloser12.loginexample.rest.models.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import java.io.IOException;
import java.util.Date;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
//import okhttp3.internal.framed.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by al-ev on 11.04.2016.
 */
public class ServiceBroker {
    private static ServiceBroker ourInstance = new ServiceBroker();
    private Retrofit mRetrofit;
    private Users user;

    public static ServiceBroker getInstance() {
        return ourInstance;
    }

    private ServiceBroker() {
    }


    public Retrofit getRetrofit()
    {
        if (mRetrofit == null)
        {

            OkHttpClient client = new OkHttpClient.Builder()

                    .addNetworkInterceptor(new StethoInterceptor())
                    .addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            Headers.Builder builder = request.headers().newBuilder();
                            builder.add("application-id",Constants.BAAS_API_ID);
                            builder.add("secret-key",Constants.BAAS_REST_API_KEY);
                            builder.add("application-type","REST");
                            builder.add("Content-Type","application/json");
                            request = request.newBuilder().headers(builder.build()).build();

                            return chain.proceed(request);
                        }
                    })
                    .build();

            GsonBuilder gsonBuilder = new GsonBuilder();

            gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());

            Gson gson = gsonBuilder.create();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
        }
        return mRetrofit;
    }

    public Users getUser()
    {
        return user;
    }
    public void login(LoginRequest loginRequest, final LoginCallBack callBack)
    {
        IBaasApi baasApi = getRetrofit().create(IBaasApi.class);

        Call<Users> call = baasApi.login(loginRequest);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                user = response.body();

                if (response.isSuccessful() && user != null) {
                    //ok
                    Log.d("Moi", "all ok, " + user.toString());
                    callBack.response(false);
                } else {
                    //bad
                    try {
                        Log.d("Moi", "error response body = " + response.errorBody().string());
                    } catch (IOException e) {

                    }
                    callBack.response(true);
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                // нет интернета, ошибка в коде
                Log.d("Moi", "нет интернета, ошибка в коде" + t.getMessage());
                callBack.response(true);
            }
        });
    }

    public void register(RegisterRequest registerRequest, final LoginCallBack callBack)
    {
        IBaasApi baasApi = getRetrofit().create(IBaasApi.class);

        Call<Users> call = baasApi.register(registerRequest);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                user = response.body();

                if (response.isSuccessful() && user != null) {
                    //ok
                    Log.d("Moi", "all ok, " + user.toString());
                    callBack.response(false);
                } else {
                    //bad
                    try {
                        Log.d("Moi", "error response body = " + response.errorBody().string());
                    } catch (IOException e) {

                    }
                    callBack.response(true);
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                // нет интернета, ошибка в коде
                Log.d("Moi", "нет интернета, ошибка в коде" + t.getMessage());
                callBack.response(true);
            }
        });
    }

}
class DateDeserializer implements JsonDeserializer<Date> {

    private final String[] DATE_FORMATS = new String[] {
            //Constants.DATE_FORMAT
    };

    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOF,
                            JsonDeserializationContext context) throws JsonParseException {

        try{
            long value = jsonElement.getAsLong();
            return new Date(value);

        }
        catch (Exception e)
        {}
        for (String format : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
            } catch (ParseException e) {
            }
        }
        throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }
}
