package com.hbbsolution.mproduction.utils.components;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


/**
 * Created by buivu on 08/10/2016.
 */
public class IconTextView extends AppCompatTextView {

    public IconTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setType(context);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public IconTextView(Context context) {
        super(context);
        setType(context);
    }

    private void setType(Context context) {
        Typeface typeFaceFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(this, typeFaceFont);
    }
}