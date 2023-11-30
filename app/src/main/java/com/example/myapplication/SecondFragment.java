package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;
    Resources fragmentGameResources;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(int param1, int param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("arg1", param1);
        args.putInt("arg1", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            MainActivity activity = (MainActivity) context;
            Log.e("F", "f");
            fragmentGameResources = activity.getResources();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt("arg1");
            mParam2 = getArguments().getInt("arg1");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false);
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Button switchButton = view.findViewById(R.id.switchButton2);
        /*switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).showFirstFragment();
                }
            }
        });*/
        setTextForWaitElement();
        return view;
    }

    public void setTextForWaitElement(){
       /* if(resourcesForTranslateObjects==null){
            Log.e("CHECK",idText.toString());
            profile=new Profile();
           profile.getResourcesForTranslateObjects();
            //resourcesForTranslateObjects= profile.getResourcesForTranslateObjects();
        }*/
        Log.e("FD", "fd");
        if(fragmentGameResources!=null){
            Log.e("FDSFDS", "fdsfds");
    }
}
}