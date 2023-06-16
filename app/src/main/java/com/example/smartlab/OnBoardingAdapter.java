package com.example.smartlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class OnBoardingAdapter extends PagerAdapter {

    Context context;

    int[] images = {
            R.drawable.illus,
            R.drawable.monitot_img,
            R.drawable.notig_img,
    };
    int[] textTitles = {
            R.string.text_analyz,
            R.string.text_monitor,
            R.string.text_nf,
    };
    int[] descriptions = {
            R.string.descr_analyz,
            R.string.descr_monitor,
            R.string.descr_nf,
    };

    OnBoardingAdapter(Context context){
        this.context = context;

    }

    @Override
    public int getCount() {
        return textTitles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull View container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.onboard_screen, (ViewGroup) container, false);

        TextView textTitle = view.findViewById(R.id.textTitle);
        TextView textDescription = view.findViewById(R.id.textDescr);
        ImageView image = view.findViewById(R.id.onb1Img);

        textTitle.setText(textTitles[position]);
        textDescription.setText(descriptions[position]);
        image.setImageResource(images[position]);

        ((ViewGroup) container).addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
