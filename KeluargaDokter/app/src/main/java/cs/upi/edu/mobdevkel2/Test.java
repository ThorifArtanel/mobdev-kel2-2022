package cs.upi.edu.mobdevkel2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test extends Fragment {
    ApiService apiService;
    Button btnTest;

    public Test() {
        // Required empty public constructor
    }

    public static Test newInstance() {
        Test fragment = new Test();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        apiService = ApiClient.getClient().create(ApiService.class);
        btnTest = (Button) getActivity().findViewById(R.id.btnTest);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] displayResponse = {""};
                Call<ModelGuide> call = apiService.doGetGuides("5");
                call.enqueue(new Callback<ModelGuide>() {
                    @Override
                    public void onResponse(Call<ModelGuide> call, Response<ModelGuide> response) {
                        Log.d("TAG",response.code()+"");

                        ModelGuide resource = response.body();
                        assert resource != null;
                        String content = resource.getContent();
                        String desc = resource.getDesc();
                        String iconUrl = resource.getIconUrl();
                        String title = resource.getTitle();

                        displayResponse[0] += content + desc + iconUrl + title;

                    }

                    @Override
                    public void onFailure(Call<ModelGuide> call, Throwable t) {
                        call.cancel();
                    }
                });

                Toast toast = Toast.makeText(v.getContext(), displayResponse[0],Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}