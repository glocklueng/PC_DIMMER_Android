package de.phoenixstudios.pc_dimmer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Setup extends Fragment implements View.OnClickListener{
/*
    private static final String ARG_PARAM1 = "param_setup_1";
    private static final String ARG_PARAM2 = "param_setup_2";
    private String mParam1;
    private String mParam2;
*/

    private CallbackToMain mCallbackToMain;

    public Setup() {
        // Required empty public constructor
    }

    public static Setup newInstance(String param1, String param2) {
        Setup fragment = new Setup();
/*
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setup, container, false);

        view.findViewById(R.id.connectBtn).setOnClickListener(this);
        view.findViewById(R.id.disconnectBtn).setOnClickListener(this);
        view.findViewById(R.id.syncBtn).setOnClickListener(this);
        view.findViewById(R.id.loadpresetbtn).setOnClickListener(this);
        view.findViewById(R.id.savepresetbtn).setOnClickListener(this);
        view.findViewById(R.id.deletepresetbtn).setOnClickListener(this);
        view.findViewById(R.id.savesettingsbtn).setOnClickListener(this);
        view.findViewById(R.id.fadetimeEdit).setOnClickListener(this);

        return view;
    }

    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        mCallbackToMain.SetupCallbackToMain(R.layout.fragment_setup);
    }

    @Override
    public void onClick(View v) {
        mCallbackToMain.SetupCallbackToMain(v.getId());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof CallbackToMain) {
            mCallbackToMain = (CallbackToMain) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbackToMain = null;
    }

    public interface CallbackToMain {
        void SetupCallbackToMain(int Cmd); // call self-defined function in main-program
    }
}
