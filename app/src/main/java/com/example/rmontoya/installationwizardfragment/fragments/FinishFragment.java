package com.example.rmontoya.installationwizardfragment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rmontoya.installationwizardfragment.R;

public class FinishFragment extends Fragment {

    public static final String NAME = "finish";
    private Button exitButton;
    private Button backButton;

    public FinishFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_finish, container, false);
        setViews(fragmentView);
        setOnClickListeners();
        return fragmentView;
    }

    private void setViews(View fragmentView) {
        exitButton = (Button) fragmentView.findViewById(R.id.exit_wizard_button);
        backButton = (Button) fragmentView.findViewById(R.id.back_button);
    }

    private void setOnClickListeners() {
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack(StartFragment.NAME, 0);
            }
        });
    }

}