package com.example.catetin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catetin.R;
import com.example.catetin.model.ScreenItem;

import java.util.List;

public class IntroViewPager extends PagerAdapter {

    Context mContext;
    List<ScreenItem> mListScreen;

    public IntroViewPager(Context mContext, List<ScreenItem> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutScreen = (View) inflater.inflate(R.layout.layout_screen, null);


        ImageView imageSlide = layoutScreen.findViewById(R.id.intro_img);
        TextView description = layoutScreen.findViewById(R.id.intro_description);

        description.setText(mListScreen.get(position).getDescription());
        imageSlide.setImageResource(mListScreen.get(position).getScreenImage());

        container.addView(layoutScreen);

        return layoutScreen;
    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {


        container.removeView((View) object);
    }
}
