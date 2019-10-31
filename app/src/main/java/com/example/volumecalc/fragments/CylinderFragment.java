package com.example.volumecalc.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.volumecalc.R;
import com.example.volumecalc.util.CalculateResult;

public class CylinderFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public CylinderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cylinder, container, false);
        final EditText radius = view.findViewById(R.id.edit_radius_cylinder);
        final EditText height = view.findViewById(R.id.edit_height_cylinder);
        final Button submit = view.findViewById(R.id.submit_cylinder);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener!=null){
                    String radiusString = radius.getText().toString();
                    String heightString = height.getText().toString();
                    if (!TextUtils.isEmpty(radiusString) && !TextUtils.isEmpty(heightString)) {
                        int option = CalculateResult.cylinder;
                        Double radius = Double.parseDouble(radiusString);
                        Double height = Double.parseDouble(heightString);
                        CalculateResult cr = new CalculateResult(option, radius, height);
                        mListener.onCylinderResult(cr.getIndex());
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCylinderResult(float index);
    }
}
