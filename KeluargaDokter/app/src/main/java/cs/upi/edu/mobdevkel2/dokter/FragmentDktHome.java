package cs.upi.edu.mobdevkel2.dokter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cs.upi.edu.mobdevkel2.R;

public class FragmentDktHome extends Fragment {
    BottomNavigationView bnv;

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
}