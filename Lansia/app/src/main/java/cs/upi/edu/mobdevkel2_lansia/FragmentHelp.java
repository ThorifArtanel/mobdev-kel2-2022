package cs.upi.edu.mobdevkel2_lansia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FragmentHelp extends Fragment {
    public FragmentHelp() {
        // Required empty public constructor
    }

    public static FragmentHelp newInstance() {
        FragmentHelp fragment = new FragmentHelp();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        ImageView qrCode = (ImageView) getActivity().findViewById(R.id.home_pindai1);
        qrCode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentQr.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

        Button sos = (Button) getActivity().findViewById(R.id.sos);
        sos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentHelpConfirm.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
//                countDownTimer.start();
//                timerHasStarted = true;

            }
        });

        Button detailObat = (Button) getActivity().findViewById(R.id.btnDetailObat);
        detailObat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentDetailObat.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
//                countDownTimer.start();
//                timerHasStarted = true;

            }
        });
    }
}