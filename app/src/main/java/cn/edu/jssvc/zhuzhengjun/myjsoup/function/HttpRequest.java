package cn.edu.jssvc.zhuzhengjun.myjsoup.function;

import android.graphics.Bitmap;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import java.io.UnsupportedEncodingException;

public class HttpRequest {

    public static void get(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest request = new StringRequest(0, str, listener, errorListener);
        MyApplication.queue.add(request);
    }

    public static void Bitmap(String str, Response.Listener<Bitmap> listener, Response.ErrorListener errorListener) {
        ImageRequest request = new ImageRequest(str, listener, 0, 0, Bitmap.Config.RGB_565, errorListener);
        MyApplication.queue.add(request);
    }

    public static void get2(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        MyStringRequest request = new MyStringRequest(str, listener, errorListener);
        MyApplication.queue.add(request);
    }

    public static class MyStringRequest extends StringRequest {

        public MyStringRequest(String url, Response.Listener<String> listener,Response.ErrorListener errorListener) {
            super(url, listener, errorListener);
        }
        @Override
        protected Response<String> parseNetworkResponse(NetworkResponse response) {
            String str = null;
            try {
                str = new String(response.data, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return Response.success(str,
                    HttpHeaderParser.parseCacheHeaders(response));
        }
    }

}
