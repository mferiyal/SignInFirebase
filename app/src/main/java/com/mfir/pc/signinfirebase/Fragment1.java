package com.mfir.pc.signinfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment{


    View tampilan;
    TextView email;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tampilan = inflater.inflate(R.layout.fragment1_layout,container, false);
        email = tampilan.findViewById(R.id.textviewemail);
        try {
            String tangkap = getArguments().getString("pengenal");
            email.setText(tangkap);
        }
        catch (Exception e) {

        }


        return tampilan;
    }
}
