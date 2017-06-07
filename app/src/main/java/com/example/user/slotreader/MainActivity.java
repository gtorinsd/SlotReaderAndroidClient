package com.example.user.slotreader;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private TextSwitcher mTextSwitcher;
    private Vector<String> mTextChars = new Vector<>();
    int mCurrentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextArray();

        mTextSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        initTextSwitcher();
    }

    private void initTextArray() {
        for(int i = 'A'; i <= 'Z'; i++) {
            mTextChars.add("" + (char) i);
        }
    }

    private void initTextSwitcher() {
        Animation slideInLeftAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation slideOutRightAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        mTextSwitcher.setInAnimation(slideInLeftAnimation);
        mTextSwitcher.setOutAnimation(slideOutRightAnimation);

        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(MainActivity.this);
                textView.setTextSize(30);
                textView.setTextColor(Color.RED);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setShadowLayer(10, 10, 10, Color.BLACK);
                return textView;
            }
        });

        mCurrentIndex = 0;
        mTextSwitcher.setText(mTextChars.elementAt(mCurrentIndex));
    }
}
