package com.mfir.pc.signinfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment2 extends Fragment {

    View tampilan;
    Button signin, signup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tampilan = inflater.inflate(R.layout.fragment2_layout,container, false);
        signin = tampilan.findViewById(R.id.btnsignin);
        signup = tampilan.findViewById(R.id.btnsignup);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click signin keluar fragment signin
                FragmentManager uhu = getFragmentManager();
                FragmentTransaction ft = uhu.beginTransaction();
                ft.replace(R.id.framelayout3, new Fragment3());
                ft.commit();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click signup keluar fragment signup
                FragmentManager uhu = getFragmentManager();
                FragmentTransaction ft = uhu.beginTransaction();
                ft.replace(R.id.framelayout3, new Fragment4());
                ft.commit();
            }
        });


        return tampilan;
    }
}
