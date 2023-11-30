package com.example.myapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MusicBottomSheetFragment extends BottomSheetDialogFragment {

    private View rootView;
    private LinearLayout topLinear,expendedLinear;
    BottomSheetBehavior bottomSheetBehavior;
    private BottomNavigationView bottomNavigation;
    private FrameLayout frameLayout;
    int peekHeight;


    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        topLinear = rootView.findViewById(R.id.layout_top);
        expendedLinear = rootView.findViewById(R.id.layout_expanded);

        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) getDialog();

        if (bottomSheetDialog != null) {
            bottomSheetDialog.setOnShowListener(dialogInterface -> {
                BottomSheetDialog dialog = (BottomSheetDialog) dialogInterface;
                setupBottomSheet(dialog);
            });
        }
    }

    private void setupBottomSheet(BottomSheetDialog dialog) {
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) getView().getParent());

        ViewTreeObserver vto = topLinear.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                topLinear.getViewTreeObserver().removeOnPreDrawListener(this);

                peekHeight = topLinear.getHeight();
                bottomSheetBehavior.setPeekHeight(peekHeight);
                bottomSheetBehavior.setHideable(false);
                bottomSheetBehavior.setFitToContents(false);
                return true;
            }
        });

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                handleBottomSheetState(newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                handleSlideOffset(slideOffset);
            }
        });

        dialog.getWindow().setDimAmount(0);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setElevation(getResources().getDimension(R.dimen.bottom_sheet_elevation)); // Установите ресурс с размером элевации
        }

        dialog.show();
    }

    private void handleBottomSheetState(int newState) {
        if (newState == BottomSheetBehavior.STATE_EXPANDED) {
            topLinear.setVisibility(View.GONE);
            expendedLinear.setVisibility(View.VISIBLE);
            animateBottomNavigationView(true);
        } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
            topLinear.setVisibility(View.VISIBLE);
            expendedLinear.setVisibility(View.GONE);
            animateBottomNavigationView(false);
        } else if (newState == BottomSheetBehavior.STATE_HALF_EXPANDED) {
            topLinear.setVisibility(View.GONE);
            expendedLinear.setVisibility(View.VISIBLE);
            BottomSheetBehavior.from((View) getView().getParent()).setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    private void handleSlideOffset(float slideOffset) {
        float topAlpha = 1 - slideOffset;
        float expandedAlpha = slideOffset;

        topLinear.setAlpha(topAlpha);
        expendedLinear.setAlpha(expandedAlpha);

        if (topLinear.getVisibility() == View.VISIBLE && !topLinear.isActivated()) {
            expendedLinear.setVisibility(View.VISIBLE);
        } else if (expendedLinear.getVisibility() == View.VISIBLE && !expendedLinear.isActivated()) {
            topLinear.setVisibility(View.VISIBLE);
        }

        float imageSize = 100;
        float targetSize = 300;
        float currentSize = imageSize + (targetSize - imageSize) * slideOffset;
        expendedLinear.findViewById(R.id.notsimple_image).setLayoutParams(
                new LinearLayout.LayoutParams((int) currentSize, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    private void animateBottomNavigationView(boolean isShow) {
        View bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigation);

        int height = bottomNavigationView.getHeight();

        if (isShow) {
            bottomNavigationView.animate().translationY(0).setDuration(300);
        } else {
            bottomNavigationView.animate().translationY(height).setDuration(300);
        }
    }
}