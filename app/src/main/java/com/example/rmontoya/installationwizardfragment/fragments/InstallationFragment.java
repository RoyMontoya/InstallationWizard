package com.example.rmontoya.installationwizardfragment.fragments;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rmontoya.installationwizardfragment.R;

public class InstallationFragment extends Fragment {

    public static final String NAME = "installation";

    private Button nextButton;
    private Button cancelButton;
    private ProgressBar progressBar;
    private TextView headerText;
    private TextView finishText;

    public InstallationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_installation, container, false);
        setViews(fragmentView);
        setOnClickListeners();
        startInstallationTimer();
        return fragmentView;
    }

    private void setViews(View fragmentView) {
        headerText = (TextView) fragmentView.findViewById(R.id.installation_header_text);
        finishText = (TextView) fragmentView.findViewById(R.id.installation_finish_text);
        nextButton = (Button) fragmentView.findViewById(R.id.next_button);
        cancelButton = (Button) fragmentView.findViewById(R.id.cancel_button);
        progressBar = (ProgressBar) fragmentView.findViewById(R.id.progress_bar_installation);
    }

    private void setOnClickListeners() {
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FinishFragment fragment = new FinishFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(FinishFragment.NAME)
                        .commit();
            }
        });
    }

    private void startInstallationTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                nextButton.setEnabled(true);
                changeVisibility();
            }
        };
        countDownTimer.start();
    }

    private void changeVisibility() {
        progressBar.setVisibility(View.GONE);
        finishText.setVisibility(View.VISIBLE);
        headerText.setVisibility(View.GONE);
        cancelButton.setVisibility(View.GONE);
    }

}