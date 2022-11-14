package cs.upi.edu.mobdevkel2.dokter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cs.upi.edu.mobdevkel2.R;

public class FragmentDktLansiaRm extends Fragment {
    public FragmentDktLansiaRm() {
        // Required empty public constructor
    }

    public static FragmentDktLansiaRm newInstance() {
        FragmentDktLansiaRm fragment = new FragmentDktLansiaRm();
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
        return inflater.inflate(R.layout.fragment_dkt_lansia_rm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Toolbar tb = (Toolbar)   getActivity().findViewById(R.id.toolbar);
        tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        tb.setTitle("Pasien - Rekam Medis");
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentDktLansia.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        Button btnRMAdd = (Button) getActivity().findViewById(R.id.btnAddRM);
        btnRMAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentDktLansiaRmAdd.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}