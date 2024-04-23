package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    Button button;
    FrameLayout frameLayout;
    private MusicBottomSheetFragment musicBottomSheetFragment;
    FragmentTransaction mainFragmentTransaction;
    private FragmentManager mainFragmentManager;
    private FirstFragment one;
    Fragment selectedFragment = null;
    LinearLayout topLinear,expendedLinear;
    BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout bottomSheetContainer;
    private View bottomSheetView;
    private BottomNavigationView bottomNavigation;
    private FrameLayout container1;
    private BottomSheetDialog bottomSheetDialog;
    private TextView bottomSheetContent;
    private PopupWindow popupWindow;
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        MusicBottomSheetFragment bottomSheetFragment = new MusicBottomSheetFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());


    }


    public void openBottomSheet() {
    }
}