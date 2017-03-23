package com.example.rmontoya.installationwizardfragment.fragments;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.rmontoya.installationwizardfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstallationFragment extends Fragment {

    public static final String NAME = "installation";

    private Button nextButton;
    private Button cancelButton;
    private ProgressBar progressBar;

    public InstallationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_installation, container, false);
        nextButton = (Button) fragmentView.findViewById(R.id.next_button);
        cancelButton = (Button) fragmentView.findViewById(R.id.cancel_button);
        progressBar = (ProgressBar) fragmentView.findViewById(R.id.progress_bar_installation);
        setOnClickListeners();
        startInstallationTimer();
        return fragmentView;
    }

    private void setOnClickListeners() {
        //TODO set click listeners
    }

    private void startInstallationTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                nextButton.setEnabled(true);
                progressBar.setVisibility(View.GONE);
            }
        };
        countDownTimer.start();
    }

}
