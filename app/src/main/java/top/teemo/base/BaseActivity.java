package top.teemo.base;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/6/6.
 */

public class BaseActivity extends AppCompatActivity{
    public static final int SUCCESS=1;
    public static final int FAIL=0;
    public void getHttps(String baseUrl, Map map, final Handler mHandler, final int flag){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        GetService getService = retrofit.create(GetService.class);
        Call<String> result=getService.get(map);
        result.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Message msg = Message.obtain();
                msg.what=SUCCESS;
                msg.arg1=flag;
                msg.obj=response.body();
                mHandler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Message msg = Message.obtain();
                msg.what=FAIL;
                msg.arg1=flag;
                msg.obj=t.getMessage();
                mHandler.sendMessage(msg);
            }
        });

    }
    public void postHttps(String baseUrl, Map map, final Handler mHandler, final int flag){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<String> result=postService.post(map);
        result.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Message msg = Message.obtain();
                msg.what=SUCCESS;
                msg.arg1=flag;
                msg.obj=response.body();
                mHandler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Message msg = Message.obtain();
                msg.what=FAIL;
                msg.arg1=flag;
                msg.obj=t.getMessage();
                mHandler.sendMessage(msg);
            }
        });

    }
    public interface GetService {
        @GET("get")
        Call<String> get(@QueryMap Map<String, String> options);
    }
    public interface PostService {
        @POST("post")
        Call<String> post(@FieldMap Map<String, String> fields);
    }

}

