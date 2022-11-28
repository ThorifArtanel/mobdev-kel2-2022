package cs.upi.edu.mobdevkel2.dokter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cs.upi.edu.mobdevkel2.R;
import cs.upi.edu.mobdevkel2.lib.api.ApiClient;
import cs.upi.edu.mobdevkel2.lib.models.AdapterGuide;
import cs.upi.edu.mobdevkel2.lib.models.AdapterHomeGuide;
import cs.upi.edu.mobdevkel2.lib.models.Guide;
import cs.upi.edu.mobdevkel2.lib.models.ModelGuide;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDktHome extends Fragment {
    BottomNavigationView bnv;
    ProgressBar progressBar;
    AdapterHomeGuide adapterHomeGuide;
    List<Guide> guideList = new ArrayList<>();

    public FragmentDktHome() {
        // Required empty public constructor
    }

    public static FragmentDktHome newInstance() {
        FragmentDktHome fragment = new FragmentDktHome();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_dkt_home, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Recycler
        RecyclerView recyclerView = getActivity().findViewById(R.id.rvHomeGuide);
        RecyclerView.LayoutManager lmHomeGuide = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lmHomeGuide);
        recyclerView.setHasFixedSize(true);

        // Adapter
        adapterHomeGuide = new AdapterHomeGuide(guideList);
        recyclerView.setAdapter(adapterHomeGuide);

        progressBar = getActivity().findViewById(R.id.progressBar);

        fetchHomeGuide();

        Toolbar tb = (Toolbar)   getActivity().findViewById(R.id.toolbar);
        tb.setNavigationIcon(null);
        tb.setTitle("Beranda");

        LinearLayout btnLansia = (LinearLayout) getActivity().findViewById(R.id.btnHomePasien);
        btnLansia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bnv = getActivity().findViewById(R.id.botNav);
                bnv.setSelectedItemId(R.id.mLansia);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentDktLansia.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

        LinearLayout btnGuide = (LinearLayout) getActivity().findViewById(R.id.btnHomeGuide);
        btnGuide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bnv = getActivity().findViewById(R.id.botNav);
                bnv.setSelectedItemId(R.id.mGuide);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentDktGuide.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

        LinearLayout btnHelp = (LinearLayout) getActivity().findViewById(R.id.btnHomeHelp);
        btnHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentDktHomeHelp.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void fetchHomeGuide(){
        progressBar.setVisibility(View.VISIBLE);
        ApiClient.getClient().getGuide().enqueue(new Callback<ModelGuide>() {
            @Override
            public void onResponse(Call<ModelGuide> call, Response<ModelGuide> response) {
                if (response.isSuccessful() && response.body() != null){
                    ModelGuide modelGuide = response.body();
                    guideList.addAll(modelGuide.getGuide());
                    adapterHomeGuide.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ModelGuide> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }
}