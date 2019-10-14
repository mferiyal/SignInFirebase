package com.mfir.pc.signinfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Fragment4 extends Fragment {

    private FirebaseAuth mAuth;
    View tampilan;
    EditText email,password;
    Button daftar;
    String TAG = "tag";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tampilan = inflater.inflate(R.layout.fragment4_layout, container, false);
        email = tampilan.findViewById(R.id.edtemail2);
        password = tampilan.findViewById(R.id.edtpassword2);
        daftar = tampilan.findViewById(R.id.btnDaftar);
        mAuth = FirebaseAuth.getInstance();
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginemail = email.getText().toString();
                String loginpassword = password.getText().toString();


                // untuk melemparkan nilai je firebase

                mAuth.createUserWithEmailAndPassword(loginemail, loginpassword)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(getActivity(),"Authentication success.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getActivity(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
        });
           }
});

return tampilan;


    }
}