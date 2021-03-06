package com.twt.service.api;

import android.util.Log;

import com.google.gson.JsonElement;
import com.twt.service.bean.CommentCallback;
import com.twt.service.bean.Found;
import com.twt.service.bean.FoundDetails;
import com.twt.service.bean.Jobs;
import com.twt.service.bean.JobsList;
import com.twt.service.bean.LibSearch;
import com.twt.service.bean.Lost;
import com.twt.service.bean.LostDetails;
import com.twt.service.bean.News;
import com.twt.service.bean.NewsList;
import com.twt.service.bean.RefreshedToken;
import com.twt.service.bean.Upload;
import com.twt.service.support.UserAgent;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.mime.TypedFile;

/**
 * Created by Rex on 2015/8/1.
 */
public class ApiClient {
    private static RequestInterceptor requestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestInterceptor.RequestFacade request) {
            request.addHeader("User-Agent", UserAgent.generate());
        }
    };
    private static final String API = "http://open.twtstudio.com/api/v1";
    private static RestAdapter adapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setRequestInterceptor(requestInterceptor).setEndpoint(API).build();
    private static Api mApi = adapter.create(Api.class);


    public static void bind(String authorization, String tjuname, String tjupwd, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        params.put("tjuuname", tjuname);
        params.put("tjupasswd", tjupwd);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("tjuuname", tjuname);
        temp.put("tjupasswd", tjupwd);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.bind(authorization, params, callback);
    }

    public static void unbind(String authorization, String twtuname, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        params.put("twtuname", twtuname);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("twtuname", twtuname);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.unbindTju(authorization, params, callback);

    }

    public static void refreshToken(String authorization, Callback<RefreshedToken> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.refreshToken(authorization, params, callback);
    }

    public static void login(String twtuname, String twtpasswd, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        params.put("twtuname", twtuname);
        params.put("twtpasswd", twtpasswd);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("twtuname", twtuname);
        temp.put("twtpasswd", twtpasswd);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.login(params, callback);
    }

    public static void getGpaWithoutToken(String authorization, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getGPA(authorization, params, callback);
    }

    public static void getGpaWithToken(String authorization, String token, String captcha, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        params.put("token", token);
        params.put("captcha", captcha);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("token", token);
        temp.put("captcha", captcha);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getGPA(authorization, params, callback);
    }

    public static void postGpaEvaluate(String authorization,String token, String lessonId, String unionId, String courseId, String term, int[] fiveQ, String note, Callback<JsonElement> callback){
        RequestParams params = new RequestParams();
        params.put("lesson_id",lessonId);
        params.put("union_id",unionId);
        params.put("course_id",courseId);
        params.put("term",term);
        params.put("q1", String.valueOf(fiveQ[0]));
        params.put("q2", String.valueOf(fiveQ[1]));
        params.put("q3", String.valueOf(fiveQ[2]));
        params.put("q4", String.valueOf(fiveQ[3]));
        params.put("q5", String.valueOf(fiveQ[4]));
        params.put("note", note);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("token",token);
        temp.put("lesson_id",lessonId);
        temp.put("union_id",unionId);
        temp.put("course_id",courseId);
        temp.put("term",term);
        temp.put("q1", String.valueOf(fiveQ[0]));
        temp.put("q2", String.valueOf(fiveQ[1]));
        temp.put("q3", String.valueOf(fiveQ[2]));
        temp.put("q4", String.valueOf(fiveQ[3]));
        temp.put("q5", String.valueOf(fiveQ[4]));
        temp.put("note",note);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.postGPAEvaluate(authorization,token,params,callback);

    }

    public static void getClassTable(String authorization, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getCourse(authorization, params, callback);
    }

    public static void getImportantNewsList(int page, Callback<NewsList> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getNewsList(1, params, callback);
    }

    public static void getNoticeList(int page, Callback<NewsList> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getNewsList(2, params, callback);
    }

    public static void getViewPointList(int page, Callback<NewsList> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getNewsList(5, params, callback);
    }

    public static void getAssociationList(int page, Callback<NewsList> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getNewsList(3, params, callback);
    }

    public static void getCollegeNewslist(int page, Callback<NewsList> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getNewsList(4, params, callback);
    }

    public static void getNewsDetails(int index, Callback<News> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getNews(index, params, callback);
    }

    public static void postNewsComment(String authorization, int id, String content, String ip, Callback<CommentCallback> callback) {
        RequestParams params = new RequestParams();
        params.put("content", content);
        params.put("ip", ip);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("content", content);
        temp.put("ip", ip);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.postNewsComment(authorization, id, params, callback);
    }

    public static void getMain(Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getMain(params, callback);
    }

    public static void feedback(String ua, String content, String email, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        params.put("content", content);
        params.put("email", email);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("content", content);
        temp.put("email", email);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.feedback(ua, params, callback);
    }

    public static void getLostList(int page, Callback<Lost> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getLostList(params, callback);
    }

    public static void getFoundList(int page, Callback<Found> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getFoundList(params, callback);
    }

    public static void getLostDetails(int id, Callback<LostDetails> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getLostDetails(id, params, callback);
    }

    public static void getFoundDetails(int id, Callback<FoundDetails> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getFoundDetails(id, params, callback);
    }

    public static void getJobsList(int page, Callback<JobsList> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getJobsList(params, callback);
    }

    public static void getJobsDetails(int id, Callback<Jobs> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getJobsDetails(params, id, callback);
    }


    public static void postLost(String authorization, String title, String name, String time, String place, String phone, String content, String lost_type, String other_tag, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        params.put("title", title);
        params.put("name", name);
        params.put("time", time);
        params.put("place", place);
        params.put("phone", phone);
        params.put("content", content);
        params.put("lost_type", lost_type);
        params.put("other_tag", other_tag);
        temp.put("t", params.get("t"));
        temp.put("title", title);
        temp.put("name", name);
        temp.put("time", time);
        temp.put("place", place);
        temp.put("phone", phone);
        temp.put("content", content);
        temp.put("lost_type", lost_type);
        temp.put("other_tag", other_tag);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.postLost(authorization, params, callback);
    }

    public static void postFound(String authorization, String title, String name, String time, String place, String phone, String content, String found_pic, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        HashMap<String, String> temp = new HashMap<>();
        params.put("title", title);
        params.put("name", name);
        params.put("time", time);
        params.put("place", place);
        params.put("phone", phone);
        params.put("content", content);
        params.put("found_pic", found_pic);
        temp.put("t", params.get("t"));
        temp.put("title", title);
        temp.put("name", name);
        temp.put("time", time);
        temp.put("place", place);
        temp.put("phone", phone);
        temp.put("content", content);
        temp.put("found_pic", found_pic);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.postFound(authorization, params, callback);
    }

    public static void uploadImage(String to, File file, Callback<List<Upload>> callback) {
        TypedFile typedFile = new TypedFile("multipart/form-data", file);
        RequestParams params = new RequestParams();
        params.put("to", to);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("to", to);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.uploadImage(typedFile, params, callback);
    }

    public static void getMyLostList(String authorization, int page, Callback<Lost> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getMyLostList(authorization, params, callback);
    }

    public static void getMyFoundList(String authorization, int page, Callback<Found> callback) {
        RequestParams params = new RequestParams();
        params.put("page", page + "");
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("page", page + "");
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.getMyFoundList(authorization, params, callback);
    }

    public static void editLost(String authorization, int id, String title, String name, String time, String place, String phone, String content, int lost_type, String other_tag, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        params.put("title", title);
        params.put("name", name);
        params.put("time", time);
        params.put("place", place);
        params.put("phone", phone);
        params.put("content", content);
        params.put("lost_type", lost_type + "");
        params.put("other_tag", other_tag);
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("title", title);
        temp.put("name", name);
        temp.put("time", time);
        temp.put("place", place);
        temp.put("phone", phone);
        temp.put("content", content);
        temp.put("lost_type", lost_type + "");
        temp.put("other_tag", other_tag);
        String sign = new Sign().generate(temp);
        params.put("sign", sign);
        mApi.editLost(authorization, id, params, callback);
    }

    public static void editFound(String authorization, int id, String title, String name, String time, String phone, String place, String content, String found_pic, Callback<JsonElement> callback) {
        RequestParams params = new RequestParams();
        params.put("title", title);
        params.put("name", name);
        params.put("time", time);
        params.put("phone", phone);
        params.put("place", place);
        params.put("content", content);
        try {
            params.put("found_pic", URLEncoder.encode(found_pic, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HashMap<String, String> temp = new HashMap<>();
        temp.put("t", params.get("t"));
        temp.put("title", title);
        temp.put("name", name);
        temp.put("time", time);
        temp.put("phone", phone);
        temp.put("place", place);
        temp.put("content", content);
        temp.put("found_pic", found_pic);
        String sign = new Sign().generate(temp);
        Log.e("sign", sign);
        params.put("sign", sign);
        mApi.editFound(authorization, id, params, callback);
    }

    public static void libSearch(String title, int page , Callback<LibSearch> callback)
    {
        RequestParams params=new RequestParams();
        params.put("title",title);
        params.put("page",page+"");
        HashMap<String,String> temp=new HashMap<>();
        temp.put("t",params.get("t"));
        temp.put("title",title);
        temp.put("page",page+"");
        String sign=new Sign().generate(temp);
        params.put("sign",sign);
        mApi.libSearch(params,callback);
    }

}
