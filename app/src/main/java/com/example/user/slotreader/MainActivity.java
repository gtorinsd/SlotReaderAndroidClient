package com.example.user.slotreader;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private Vector<String> mTextChars = new Vector<>();
    private Vector<TextSwitcherStruct> mTextSwitchers = new Vector<>();


    int mCurrentIndex;
    private final int mTextSwitchersCount = 5;

    private Application m_App;
    private Context m_Context;
    private LinearLayout mBoardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_Context = this;
        m_App = (Application) this.getApplicationContext();
        mBoardLayout = (LinearLayout) findViewById(R.id.boardLayout);

        initTextArray();
        initTextSwitchers(mTextSwitchers);
    }

    private void initTextArray() {
        for(int i = 'A'; i <= 'Z'; i++) {
            mTextChars.add("" + (char) i);
        }
    }

    private void initTextSwitchers(Vector<TextSwitcherStruct> v) {
        int x = 0;
        for(int i = 0; i < mTextSwitchersCount; i++) {

            TextSwitcher textSwitcher = new TextSwitcher(m_Context);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            textSwitcher.setLayoutParams(params);

            Animation slideInLeftAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
            Animation slideOutRightAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

            textSwitcher.setInAnimation(slideInLeftAnimation);
            textSwitcher.setOutAnimation(slideOutRightAnimation);
            textSwitcher.setY(130);

            textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    TextView textView = new TextView(MainActivity.this);
                    //textView.setTextSize(30);

                    TypedValue typedValue = new TypedValue();
                    getResources().getValue(R.dimen.TextSwitchertextSize, typedValue, true);
                    float f = typedValue.getFloat();
                    textView.setTextSize(f);


                    textView.setTextColor(Color.WHITE);
                    textView.setGravity(Gravity.CENTER_HORIZONTAL);
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                    textView.setShadowLayer(10, 10, 10, Color.BLACK);
                    return textView;
                }
            });

            textSwitcher.setText(mTextChars.elementAt(mCurrentIndex));
            mBoardLayout.addView(textSwitcher);
            v.add(new TextSwitcherStruct(textSwitcher));
        }
    }
}
