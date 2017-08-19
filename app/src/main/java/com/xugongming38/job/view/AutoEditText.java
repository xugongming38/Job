package com.xugongming38.job.view;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

import com.xugongming38.job.R;

/**
 * Created by dell on 2017/6/25.
 */

public class AutoEditText extends android.support.v7.widget.AppCompatEditText implements TextWatcher, View.OnFocusChangeListener {
    private Drawable deleteIcon;

    public AutoEditText(Context context) {
        super(context, null);
    }

    public AutoEditText(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.editTextStyle);
    }

    public AutoEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        deleteIcon = getResources().getDrawable(R.drawable.ic_clear_blue_grey_900_18dp);
        setDeleteIconVisible(false);
        addTextChangedListener(this);
        setOnFocusChangeListener(this);
    }

    private void setDeleteIconVisible(boolean isVisible) {
        Drawable drawable = isVisible ? deleteIcon : null;
        setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
//                这里自动判断
        setDeleteIconVisible(text.length() > 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (deleteIcon != null && event.getAction() == MotionEvent.ACTION_UP) {
            boolean clearable = event.getX() > (getWidth() - getPaddingRight() - deleteIcon.getIntrinsicWidth()) &&
                    event.getX() < (getWidth() - getCompoundPaddingRight());
            if (clearable) {
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            setDeleteIconVisible(getText().length() > 0);
        } else {
            setDeleteIconVisible(false);
        }
    }


    public static TranslateAnimation getShakeAnimation(int count) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 10, 0, 0);
        translateAnimation.setInterpolator(new CycleInterpolator(count));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }

    public void startShakeAnimation() {
        startAnimation(getShakeAnimation(3));
    }
}