package com.xfy.sample.animcheckable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xfy.shareview.animcheckableview.AnimCheckableGroupView;
import com.xfy.shareview.animcheckableview.IAnimView;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by XiongFangyu on 16/8/4.
 */
public class SampleActivity extends Activity {

    private static final String CHOOSE_STRING = "choose index : %d , choose color : %d , choose drawable : %s";

    private static final int CLICK_COUNT = 5;

    @Bind(R.id.anim_checkable)
    AnimCheckableGroupView animCheckable;
    @Bind(R.id.message)
    TextView message;
    @Bind(R.id.orientation_message)
    TextView orientationMessage;

    private int[] colors = new int[]{
            Color.BLACK,
            Color.BLUE,
            Color.CYAN,
            Color.DKGRAY,
            Color.GRAY,
            Color.GREEN,
            Color.LTGRAY,
            Color.MAGENTA,
            Color.RED,
            Color.YELLOW
    };

    private int[] orientations = new int[]{
            AnimCheckableGroupView.VERTICAL_DOWN,
            AnimCheckableGroupView.VERTICAL_UP,
            AnimCheckableGroupView.HORIZONTAL_RIGHT,
            AnimCheckableGroupView.HORIZONTAL_LEFT
    };

    private Random random;

    private int checkedIndex = -1;

    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sample_activity);
        ButterKnife.bind(this);

        animCheckable.setChildCheckListener(new AnimCheckableGroupView.ChildCheckListener() {
            @Override
            public void onChecked(IAnimView v, boolean checked) {
                if (checked){
                    checkedIndex = v.getIndex();
                    message.setText(String.format(CHOOSE_STRING,checkedIndex,v.getColor(),v.getDrawable()));
                }
            }
        });
        animCheckable.addDrawables(getResources().getDrawable(R.drawable.me));
        animCheckable.addColors(new int[]{Color.YELLOW,Color.GREEN});
        animCheckable.setCheck(0,true,false);
        orientationMessage.setText(getOrientationString(0));
    }

    @OnClick({R.id.add, R.id.delete, R.id.show, R.id.change, R.id.message})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                if (random == null)
                    random = new Random();
                animCheckable.addColor(colors[Math.abs(random.nextInt() % colors.length)]);
                break;
            case R.id.delete:
                if (checkedIndex >= 0){
                    animCheckable.removeViewByIndex(checkedIndex);
                }
                break;
            case R.id.show:
                if (animCheckable.getVisibility() == View.VISIBLE){
                    animCheckable.setVisibility(View.GONE);
                }else {
                    animCheckable.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.change:
                if (random == null)
                    random = new Random();
                final int index = Math.abs(random.nextInt() % orientations.length);
                animCheckable.setOrientation(orientations[index]);
                orientationMessage.setText(getOrientationString(index));
                break;
            case R.id.message:
                clickCount ++;
                if (clickCount == CLICK_COUNT){
                    clickCount = 0;
                    startActivity(new Intent(this,TestInterpolator.class));
                }
                break;
        }
    }

    private String getOrientationString(int index){
        switch (index){
            case 0:
                return "vertical down";
            case 1:
                return "vertical up";
            case 2:
                return "horizontal right";
            case 3:
                return "horizontal left";
            default:
                return "unknown";
        }
    }
}
