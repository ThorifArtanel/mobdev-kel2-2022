package cs.upi.edu.mobdevkel2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface ApiService {

    @GET("guide?")
    Call<ModelGuide> doGetGuides(@Query("limit") String limit);

}