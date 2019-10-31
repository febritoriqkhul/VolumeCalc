package com.example.volumecalc.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.volumecalc.R;
import com.example.volumecalc.fragments.ConeFragment;
import com.example.volumecalc.fragments.CylinderFragment;
import com.example.volumecalc.fragments.ResultFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        ConeFragment.OnFragmentInteractionListener,
        CylinderFragment.OnFragmentInteractionListener,
        ResultFragment.OnFragmentInteractionListener{

    private ConeFragment coneFragment;
    private CylinderFragment cylinderFragment;
    private ResultFragment resultFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        coneFragment = new ConeFragment();
        cylinderFragment = new CylinderFragment();
        resultFragment = new ResultFragment();
        loadFragment(new ConeFragment());

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_cone:
                fragment = new ConeFragment();
                break;
            case R.id.action_cylinder:
                fragment = new CylinderFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onConeResult(float index) {
        resultFragment.setInformation(String.format("Volume is %.2f cm3", index));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .commit();
    }

    @Override
    public void onCylinderResult(float index) {
        resultFragment.setInformation(String.format("Volume is %.2f cm3", index));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onTryAgainButtonClicked(String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, coneFragment)
                .commit();
    }
}
