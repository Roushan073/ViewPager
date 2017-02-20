package com.roushan.viewpager;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewPager;
    private LinearLayout viewpager_indicator_dots;
    private int dotsCount;
    private ImageView[] dots;
    TextView start_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    skip = (TextView) findViewById(R.id.skip);
        start_skip = (TextView) findViewById(R.id.start_skip);

    //    start.setVisibility(View.GONE);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        viewpager_indicator_dots = (LinearLayout) findViewById(R.id.viewPagerIndicatorDots);

        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
        setViewPagerIndicator();

        start_skip.setOnClickListener(this);
    //    skip.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i = 0;i < 4;i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));
        }
        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot));
        if(position == 3) {
        //    skip.setVisibility(View.GONE);
            start_skip.setText("START");
        //    start.setVisibility(View.VISIBLE);
        } else {
            start_skip.setText("SKIP");
        //    start.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setViewPagerIndicator() {
        dotsCount = 4;
        dots = new ImageView[dotsCount];

        for(int i = 0;i < 4;i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );  params.setMargins(4, 0, 4, 0);

            final int presentPosition = i;
            dots[presentPosition].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    viewPager.setCurrentItem(presentPosition);
                    return true;
                }
            });
            viewpager_indicator_dots.addView(dots[i], params);
        }
        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.start_skip) {
            startActivity(new Intent(this, SecActivity.class));
            finish();
        }
    }
}
