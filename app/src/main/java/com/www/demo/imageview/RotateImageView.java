package com.www.demo.imageview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

/**
 * 旋转的音乐卡碟
 *
 * @author HH on 2018/1/5.
 *
 */

public class RotateImageView extends AppCompatImageView {

    /**
     * 旋转中
     */
    public static final int STATE_ROTATING = 1;

    /**
     * 暂停
     */
    public static final int STATE_PAUSE = 2;

    /**
     * 停止
     */
    public static final int STATE_STOP = 3;


    private ObjectAnimator animator;
    private int state;

    public RotateImageView(Context context) {
        super(context);
        init();
    }

    public RotateImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        state = STATE_STOP;
        animator = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f);
        animator.setDuration(4000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.RESTART);
    }


    public void start() {
        if (state == STATE_STOP) {
            state = STATE_ROTATING;
            animator.start();

        } else if (state == STATE_PAUSE) {
            state = STATE_ROTATING;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                animator.resume();
            } else {
                animator.start();
            }

        } else if (state == STATE_ROTATING) {
            state = STATE_PAUSE;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                animator.pause();
            } else {
                animator.cancel();
            }
        }
    }

    public void stop() {
        state = STATE_STOP;
        animator.end();
    }
}
