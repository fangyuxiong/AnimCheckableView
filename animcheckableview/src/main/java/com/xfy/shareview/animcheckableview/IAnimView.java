package com.xfy.shareview.animcheckableview;


import android.graphics.drawable.Drawable;

/**
 * Created by XiongFangyu on 16/7/25.
 *
 * {@link AnimCheckableGroupView}中的子view
 *
 */
public interface IAnimView {

    int getIndex();

    int getColor();

    void setColor(int color);

    Drawable getDrawable();

    void setDrawable(Drawable drawable);

    boolean isChecked();
}
