package com.example.sayed.fragment18;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String welcomeMessage;
    private Bundle mesBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesBundle = new Bundle();
        mesBundle.putString("msg", "Welcome To First Fragment");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentOne fm1 = new FragmentOne();
        fm1.setArguments(mesBundle);
        ft.add(R.id.fragmentContainer, fm1);
        ft.addToBackStack(null);
        ft.commit();

    }

    public void changeFragment(View view) {
        Fragment fragment = null;
        switch (view.getId()){
            case R.id.frgOneBtId:
                welcomeMessage = "Welcome From One";
                fragment = new FragmentOne();
                break;
            case R.id.frgTwoBtId :
                welcomeMessage = "Welcome From Two";
                fragment = new FragmentTwo();
                break;
            case R.id.frgThreeBtId:
                welcomeMessage = "Welcome From Three";
                fragment = new FragmentThree();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction  ft = fm.beginTransaction();
        mesBundle.putString("msg", welcomeMessage);
        ft.replace(R.id.fragmentContainer, fragment);
        ft.setTransitionStyle(R.style.TextAppearance_AppCompat_Display1);
        fragment.setArguments(mesBundle);
        ft.addToBackStack(null);
        ft.commit();

    }
}
