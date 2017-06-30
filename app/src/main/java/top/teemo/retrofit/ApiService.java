package top.teemo.retrofit;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import top.teemo.kaiyan.mdeol.KaiYanBean;


/**
 * Created by Administrator on 2017/6/30.
 */

public interface ApiService<T> {
    public static final String BASE_URL="http://baobab.kaiyanapp.com/";
    @FormUrlEncoded
    @POST
    Observable<KaiYanBean> executePost(@FieldMap Map<String,String> parameters);
    @GET
    Observable<KaiYanBean> executeGet(@QueryMap Map<String,String> parameters);


    @FormUrlEncoded
    @POST
    Observable<String> stringPost(@Url String url, @FieldMap Map<String,String> parameters);

    @GET
    Observable<String> stringGet(@Url String url, @QueryMap Map<String,String> parameters);

    @GET("api/v4/tabs/selected")
    Observable<KaiYanBean> getKaiYanBean(@QueryMap Map<String,String> parameters);





}

