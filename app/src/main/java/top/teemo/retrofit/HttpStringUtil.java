package top.teemo.retrofit;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class HttpStringUtil {

    private static final String BASE_URL = ApiService.BASE_URL;
    private static final int TIME_OUT=5;
    private Retrofit retrofit;
    private ApiService apiService;

    private HttpStringUtil() {
        /**
         * 构造函数私有化
         * 并在构造函数中进行retrofit的初始化
         */
        OkHttpClient client=new OkHttpClient();
        client.newBuilder().connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        /**
         * 由于retrofit底层的实现是通过okhttp实现的，所以可以通过okHttp来设置一些连接参数
         * 如超时等
         */
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService=retrofit.create(ApiService.class);
    }


    private static class sinalInstance {
        public static final HttpStringUtil instance = new HttpStringUtil();
    }

    public  static HttpStringUtil getInstance(){
        return sinalInstance.instance;
    }

    public void get(String url, Map map,BaseObserver<String> observer){
        apiService.stringGet(url,map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void post(String url, Map map,BaseObserver<String> observer){
        apiService.stringPost(url,map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}