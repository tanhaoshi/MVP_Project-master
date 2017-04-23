package fussen.yu.news.utils.network;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Fussen on 2016/12/1.
 */

public interface NetService {

    /**
     *  FormUrlEncoded注解:
     用于修饰Field注解和FieldMap注解
     使用该注解,表示请求正文将使用表单网址编码。字段应该声明为参数，并用@Field注释或FieldMap注释。
     使用FormUrlEncoded注解的请求将具
     ”application / x-www-form-urlencoded”
     MIME类型。字段名称和值将先进行UTF-8进行编码,再根据RFC-3986进行URI编码.
     * @param url
     * @param params
     * @return
     */

    @POST()
    @FormUrlEncoded
    Observable<ResponseBody> postRequest(
            @Url() String url,
            @FieldMap Map<String, String> params);

    @POST()
    Observable<ResponseBody> postRequest(
            @Url() String url
    );

    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> postForm(
            @Url() String url,
            @FieldMap Map<String, Object> params);


    @POST("{url}")
    Observable<ResponseBody> executePostBody(
            @Path("url") String url,
            @Body Object object);


    @POST()
    Observable<ResponseBody> postJson(
            @Url() String url,
            @Body RequestBody jsonBody);


    @Multipart
    @POST
    Observable<ResponseBody> uploadFlie(
            @Url String fileUrl,
            @Part MultipartBody.Part filePart);


    @Multipart
    @POST()
    Observable<ResponseBody> uploadFiles(
            @Url() String url,
            @PartMap() Map<String, RequestBody> maps);


    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Url String fileUrl);
}
