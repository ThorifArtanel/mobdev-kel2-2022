package cs.upi.edu.mobdevkel2.dokter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cs.upi.edu.mobdevkel2.R;
import cs.upi.edu.mobdevkel2.lib.api.ApiClient;
import cs.upi.edu.mobdevkel2.lib.models.AdapterGuide;
import cs.upi.edu.mobdevkel2.lib.models.Guide;
import cs.upi.edu.mobdevkel2.lib.models.ModelGuide;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDktGuide extends Fragment {
    private ProgressBar progressBar;
    private AdapterGuide adapterGuide;
    private List<Guide> guides = new ArrayList<>();
    RecyclerView.LayoutManager lmGuide;
    RecyclerView recyclerView;

    public FragmentDktGuide(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dkt_guide, parent, false);
        return v;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        recyclerView = getActivity().findViewById(R.id.rvGuide);

        // Adapter
        adapterGuide = new AdapterGuide(guides);
        recyclerView.setAdapter(adapterGuide);

        // Recycler
        lmGuide = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(lmGuide);
        recyclerView.setHasFixedSize(true);

        progressBar = getActivity().findViewById(R.id.progressBar);
        fetchGuide();

        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Toolbar tb = (Toolbar)   getActivity().findViewById(R.id.toolbar);
        tb.setNavigationIcon(null);
        tb.setTitle("Guide");

        Button btnAdd = (Button) getActivity().findViewById(R.id.btnGuide1);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentDktGuideAdd.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void fetchGuide(){
        Log.d("FetchGuide", "It is running");
        progressBar.setVisibility(View.VISIBLE);
        ApiClient.getClient().getGuide().enqueue(new Callback<ModelGuide>() {
            @Override
            public void onResponse(Call<ModelGuide> call, Response<ModelGuide> response) {
                Log.d("FetchGuide", "Success");
                if (response.isSuccessful() && response.body() != null){
                    ModelGuide modelGuide = response.body();
                    guides.addAll(modelGuide.getGuide());
                    adapterGuide.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ModelGuide> call, Throwable t) {
                Log.d("FetchGuide", "Failed");
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }
}