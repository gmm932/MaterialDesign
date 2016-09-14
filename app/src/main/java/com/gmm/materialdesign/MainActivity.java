package com.gmm.materialdesign;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

import com.gmm.materialdesign.leafloading.LeafLoadingActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.img_text);

        imageView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                // get the center for the clipping circle
                int cx = (imageView.getLeft() +imageView.getRight())/2;
                int cy = (imageView.getTop() + imageView.getTop())/2;

                // get the final radius for the clipping circle
                int finalRadius = Math.max(imageView.getWidth(), imageView.getHeight());

                Animator anim =
                        ViewAnimationUtils.createCircularReveal(imageView, cx, cy, 0, finalRadius);
                anim.start();
            }
        });

        findViewById(R.id.bt_valueanimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PropertyAnimationActivity.class));
            }
        });
        findViewById(R.id.bt_wave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
        findViewById(R.id.bt_leaf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LeafLoadingActivity.class));
            }
        });

    }
}
