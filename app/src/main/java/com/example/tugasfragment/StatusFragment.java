package com.example.tugasfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatusFragment#} factory method to
 * create an instance of this fragment.
 */
public class StatusFragment extends Fragment {

    private Fragment rFragment;

    Button btnStatus;
    FrameLayout flMainFrame;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        btnStatus = view.findViewById(R.id.btn_status);
        flMainFrame = view.findViewById(R.id.fl_mainFrame);
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getParentFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.fl_mainFrame,new CheckStatusFragment(),CheckStatusFragment.class.getSimpleName())
                        .commit();
            }
        });
        return view;
    }
}