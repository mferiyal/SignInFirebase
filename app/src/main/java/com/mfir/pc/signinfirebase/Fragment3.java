package com.mfir.pc.signinfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Fragment3 extends Fragment {

    private FirebaseAuth mAuth;
    View tampilan;
    EditText inputemail, inputpass;
    Button buttonSignIn;
    String TAG = "tag";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tampilan = inflater.inflate(R.layout.fragment3_layout,container, false);
        inputemail = tampilan.findViewById(R.id.edtemail);
        inputpass = tampilan.findViewById(R.id.edtpassword);
        buttonSignIn = tampilan.findViewById(R.id.btnmasuk);
        mAuth = FirebaseAuth.getInstance();
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = inputemail.getText().toString();
                String password = inputpass.getText().toString();

                //untuk sign in firebase
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(getActivity(), "Authentication success.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getActivity(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
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




    }
});  return tampilan;
    }

}