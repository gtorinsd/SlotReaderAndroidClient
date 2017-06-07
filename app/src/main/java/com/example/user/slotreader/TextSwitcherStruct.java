package com.example.user.slotreader;

import android.content.Context;
import android.widget.TextSwitcher;

/**
 * Created by user on 07.06.2017.
 */

public class TextSwitcherStruct {
    public TextSwitcher mTextSwitcher;
    public int mLetterCurrentIndex;

    public TextSwitcherStruct(TextSwitcher textSwitcher) {
        mTextSwitcher = textSwitcher;
        mLetterCurrentIndex = 0;
    }
}
