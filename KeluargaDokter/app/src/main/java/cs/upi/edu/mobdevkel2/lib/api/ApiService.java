package cs.upi.edu.mobdevkel2.lib.api;

import cs.upi.edu.mobdevkel2.lib.models.ModelGuide;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("guide?")
    Call<ModelGuide> doGetGuides(@Query("limit") String limit);

}