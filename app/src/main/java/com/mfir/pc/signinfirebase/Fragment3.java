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
import android.widget.EditText;

public class Fragment3 extends Fragment {

    View tampilan;
    EditText inputemail, inputpass;
    Button buttonSignIn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tampilan = inflater.inflate(R.layout.fragment3_layout,container, false);
        inputemail = tampilan.findViewById(R.id.edtemail);
        inputpass = tampilan.findViewById(R.id.edtpassword);
        buttonSignIn = tampilan.findViewById(R.id.btnmasuk);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputemail.getText().toString();
                String password = inputpass.getText().toString();
                // untuk melemparkan nilai ke fragment lain, bundle untuk membungkus nilai
                Bundle bundle = new Bundle();
                bundle.putString("pengenal", email);
                Fragment1 fragment1 = new Fragment1();
                fragment1.setArguments(bundle);
                //untuk melemparkan nilai ke fragment1
                FragmentManager fox = getFragmentManager();
                FragmentTransaction bukalem = fox.beginTransaction();
                bukalem.replace(R.id.framelayout1, fragment1);
                bukalem.commit();



            }
        });



        return tampilan;
    }
}
