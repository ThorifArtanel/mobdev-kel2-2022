package cs.upi.edu.mobdevkel2;

import com.loopj.android.http.*;

public class ApiMainClient {
//   https://mockend.com/ThorifArtanel/mockend/
    private static final String BASE_URL = "https://catfact.ninja/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
