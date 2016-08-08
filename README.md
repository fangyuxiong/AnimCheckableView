# AnimCheckableView
一个有添加、删除、选择等功能的View，效果图：
<img src="pic/add.gif" width="45%">
<img src="pic/check.gif" width="45%">
<img src="pic/delete.gif" width="45%">
<img src="pic/show.gif" width="45%">

# Usage
layout.xml

``` 
	<com.xfy.shareview.animcheckableview.AnimCheckableGroupView
		android:layout_width="wrap_content"
		android:layout_heigth="wrap_content"
		app:acgv_style="@style/Anim_Checkable_Group_View_Style"/>
```
styles.xml

```
	<style name="Anim_Checkable_Group_View_Style">
		<item name="acgv_orientation">vertical_down</item>
		<item name="acgv_show_anim_duration">700</item>
		<item name="acgv_show_anim_delay">100</item>
		<item name="acgv_check_anim_duration">500</item>
		<item name="acgv_outside_width">3dp</item>
		<item name="acgv_radius">15dp</item>
		<item name="acgv_padding">5dp</item>
		<item name="acgv_checked_radius">20dp</item>
		<item name="acgv_outside_color">#ffffff</item>
		<item name="acgv_draw_outside">true</item>
	</style>

```
activity.java

```
	int[] colors = new int[]{...}
	int[] pressColors = new int[]{...}
	
	animCheckableView.addColors(colors,pressColors);
	animCheckableView.addDrawables(
		getDrawable(R.drawable.d1),
		getDrawable(R.drawable.d2));
		
	animCheckableView.setChildCheckListener(
		new AnimCheckableGroupView.ChildCheckListener() {
            @Override
            public void onChecked(IAnimView v, boolean checked) {...}
        });
    
    
    animCheckable.setCheck(index,checked,doCheckAnim);
    
    animCheckable.removeByIndex(index);
    
    animCheckable.setVisibility(visible,doAnim);
    
    animCheckable.setOrientation(AnimCheckableGroupView.VERTICAL_DOWN);
```

## License
            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                    Version 2, December 2004

 Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>

 Everyone is permitted to copy and distribute verbatim or modified
 copies of this license document, and changing it is allowed as long
 as the name is changed.

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

  0. You just DO WHAT THE FUCK YOU WANT TO.
