package com.example.rmontoya.installationwizardfragment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rmontoya.installationwizardfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    public static final String NAME = "start";

    public StartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_start, container, false);
        Button startButton = (Button) fragmentView.findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInstallationFragment();
            }
        });
        return fragmentView;
    }

    private void showInstallationFragment() {
        InstallationFragment fragment = new InstallationFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(InstallationFragment.NAME)
                .commit();
    }


}
