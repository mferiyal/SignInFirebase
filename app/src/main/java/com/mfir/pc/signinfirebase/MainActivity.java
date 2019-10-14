package com.mfir.pc.signinfirebase;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // untuk menampilkan Fragment

        FragmentManager fox = getSupportFragmentManager();
        FragmentTransaction bukalem = fox.beginTransaction();
        bukalem.add(R.id.framelayout1, new Fragment1());
        bukalem.add(R.id.framelayout2, new Fragment2());
        bukalem.add(R.id.framelayout3, new Fragment3());
        bukalem.commit();





    }
}
