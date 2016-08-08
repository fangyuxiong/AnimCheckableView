package com.xfy.sample.animcheckable;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.xfy.shareview.animcheckableview.SuperOvershootInterpolator;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by XiongFangyu on 16/8/5.
 */
public class TestInterpolator extends Activity {

    @Bind(R.id.test)
    ImageView test;
    @Bind(R.id.message)
    TextView message;
    @Bind(R.id.first)
    SeekBar first;
    @Bind(R.id.first_msg)
    TextView firstMsg;
    @Bind(R.id.second)
    SeekBar second;
    @Bind(R.id.second_msg)
    TextView secondMsg;
    @Bind(R.id.third)
    SeekBar third;
    @Bind(R.id.third_msg)
    TextView thirdMsg;

    private SuperOvershootInterpolator interpolator;

    private ValueAnimator anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_interpolator);
        ButterKnife.bind(this);

        first.setMax(1000);
        second.setMax(1000);
        third.setMax(1000);

        first.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float value = 3 * i / (float)seekBar.getMax() + 1;
                firstMsg.setText("amplitude : " + value);
                interpolator.setAmplitude(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        second.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float value = 2 * i / (float)seekBar.getMax();
                secondMsg.setText("period : "+ value);
                interpolator.setPeriod(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        third.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float value = 20 * i / (float)seekBar.getMax() - 10;
                thirdMsg.setText("what : "+value);
                interpolator.setWhat(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        anim = ValueAnimator.ofFloat(0,500);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                message.setText("value : "+value);
                test.setTranslationX(value);
            }
        });
        interpolator = new SuperOvershootInterpolator();
        anim.setInterpolator(interpolator);

        anim.setDuration(1000);
    }

    @OnClick(R.id.do_anim)
    public void onClick() {
        anim.start();
    }
}
