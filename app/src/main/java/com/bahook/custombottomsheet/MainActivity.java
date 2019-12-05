package com.bahook.custombottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    LinearLayout bottomSheetLayoutPlayer;
    LinearLayout layoutBottomToolbar;
    BottomSheetBehavior bottomSheetBehavior;
    RelativeLayout layoutContent;
    boolean check =true;
    float toolbarY1;
    float toolbarY2;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomSheetLayoutPlayer=findViewById(R.id.bottom_sheet_player);
        layoutContent=findViewById(R.id.layout_content);
        layoutBottomToolbar=findViewById(R.id.layout_bottom_toolbar);
        bottomSheetBehavior=BottomSheetBehavior.from(bottomSheetLayoutPlayer);
        toolbarY1=layoutBottomToolbar.getY();


       /* Display display= ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        height = display.getHeight();
       */
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //int screenWidth = displaymetrics.widthPixels;
        height = displaymetrics.heightPixels;
        Log.d("Main","1: "+height+"");
        //layoutBottomToolbar.setY(height);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                if (newState==BottomSheetBehavior.STATE_EXPANDED){
                    check=false;
                }
                if (newState==BottomSheetBehavior.STATE_COLLAPSED){
                    check=true;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float slideOffset) {
                layoutBottomToolbar.setY((slideOffset*layoutBottomToolbar.getHeight())+height-layoutBottomToolbar.getHeight());
                Log.d("Main","slideOffset 1: "+slideOffset+"");
                Log.d("Main","Y 1: " +layoutBottomToolbar.getY()+"");
               /* if (check){

                }
                else {
                    layoutBottomToolbar.setY(1-(slideOffset*100)+height);
                    Log.d("Main","slideOffset 2: "+slideOffset+"");
                    Log.d("Main","Y 2: " +layoutBottomToolbar.getY()+"");
                }*/

                /*if (check){
                    layoutBottomToolbar.setY(slideOffset);*//*.
                            y(toolbarY1).
                            yBy(slideOffset)
                            .setDuration(0).start();*//*
                    toolbarY2=layoutBottomToolbar.getY();
                }
                else {
                    *//*layoutBottomToolbar.animate().
                            y(toolbarY2).
                            yBy(-slideOffset)
                            .setDuration(0).start();*//*
                    //layoutBottomToolbar.setY(-slideOffset);
                }*/
               /* if (check){
                    layoutBottomToolbar.animate().
                            translationYBy(slideOffset*2)
                            .setDuration(0).start();
                }
                else {
                    layoutBottomToolbar.animate().
                            translationYBy(-slideOffset)
                            .setDuration(0).start();
                }*/
            }
        });
    }
}
