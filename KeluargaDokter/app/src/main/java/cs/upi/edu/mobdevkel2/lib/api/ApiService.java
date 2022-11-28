package cs.upi.edu.mobdevkel2.lib.api;

import java.util.List;

import cs.upi.edu.mobdevkel2.lib.models.ModelGuide;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("dokter/guide")
    Call<ModelGuide> getGuide();
}