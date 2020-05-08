package com.example.subhadiproy.imageslider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    private SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        sliderLayout = (SliderLayout)findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, news.class);
                startActivity(i);
            }
        });

    }

    private void setSliderViews(){

        for(int i=0;i<=3;i++){

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i){

                case 0:
                    sliderView.setImageDrawable(R.drawable.image_1);
                    sliderView.setDescription("One");
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.image_2);
                    sliderView.setDescription("Two");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.image_3);
                    sliderView.setDescription("Three");
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.image_4);
                    sliderView.setDescription("Four");
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("setDescription" +(i+1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);

        }

    }
}
