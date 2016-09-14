package com.gmm.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class PropertyAnimationActivity extends AppCompatActivity {
    private static int SCALE_ANIM_TIME = 2000;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        img = (ImageView) findViewById(R.id.img_launcher);
        AnimatorSet animatorSet = new AnimatorSet();
// 将view在x方向上从原大小放大2倍
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(img, "scaleX", 1, 2);
        scaleXAnimator.setDuration(SCALE_ANIM_TIME);
// 将view在y方向上从原大小压缩为0
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(img, "scaleY", 1, 0);
        scaleYAnimator.setDuration(SCALE_ANIM_TIME);
// 设置加速模式
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }
        });
        animatorSet.playTogether(scaleXAnimator,scaleYAnimator);
        animatorSet.start();
    }
}
