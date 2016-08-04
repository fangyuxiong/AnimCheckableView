package com.xfy.shareview.animcheckableview;

import android.view.animation.Interpolator;

/**
 * Created by XiongFangyu on 16/7/22.
 * 超级弹跳模式~
 * {@link android.view.animation.OvershootInterpolator}只弹跳一次
 * 这个会跳很多次
 */
public class SuperOvershootInterpolator implements Interpolator {
    
    private double amplitude;
    
    private double period;

    public SuperOvershootInterpolator(double amplitude, double period){
        this.amplitude = amplitude;
        this.period = period;
    }

    @Override
    public float getInterpolation(float input) {
        if (input == 0 || input == 1) return input;

        double pi2 = Math.PI * 2;
        double s = period / pi2 * Math.asin(1 / amplitude);
        return (float) (amplitude * Math.pow(2, -6 * input) * Math.sin((input - s) * pi2 / period) + 1);
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public void setPeriod(double period) {
        this.period = period;
    }
}
