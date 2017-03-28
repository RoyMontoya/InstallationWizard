package com.example.rmontoya.installationwizardfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rmontoya.installationwizardfragment.fragments.StartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeWizardFragment();
    }

    private void initializeWizardFragment() {
        StartFragment fragment = new StartFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment)
                .addToBackStack(StartFragment.NAME)
                .commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}