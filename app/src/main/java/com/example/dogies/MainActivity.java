package com.example.dogies;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bdtopcoder.smart_slider.SliderAdapter;
import com.bdtopcoder.smart_slider.SliderItem;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private ActionBar actionBar;
//    private ViewPager viewPager;
    private CardView[] cardViews;
    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViews = new CardView[3];

        cardViews[0] = findViewById(R.id.card1);
        cardViews[1] = findViewById(R.id.card2);
        cardViews[2] = findViewById(R.id.card3);

        for (int i = 0; i < cardViews.length; i++) {
            final int cardNumber = i;
            cardViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDeskripsiActivity(cardNumber + 1);
                }
            });
        }

//        ViewPager2 viewPager2 = findViewById(R.id.smartSlider);
//
//        List<SliderItem> sliderItems = new ArrayList<>();
//        sliderItems.add(new SliderItem(R.drawable.contoh1,"image 1"));
//        sliderItems.add(new SliderItem(R.drawable.contoh2,"Image 2"));
//        sliderItems.add(new SliderItem(R.drawable.contoh3,"Image 3"));
//        sliderItems.add(new SliderItem(R.drawable.contoh4,"Image 4"));
//
//        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
//
//        new SliderAdapter((position, title, view) -> {
//            Toast.makeText(this, "Position: "+position+" Title: "+title, Toast.LENGTH_SHORT).show();
//        });

        View helpCenterItem = findViewById(R.id.HelpCenter);
        View RoadMapsItem = findViewById(R.id.RoadMaps);
        View Ebook = findViewById(R.id.Ebook);
        View ChatBot = findViewById(R.id.ChatBot);


        if (helpCenterItem != null) {
            helpCenterItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Buat Intent untuk pindah ke Activity lain
                    Intent intent = new Intent(MainActivity.this, CallActivity.class);

                    // Jalankan Intent
                    startActivity(intent);
                }
            });
        }
        if (RoadMapsItem !=null) {
            RoadMapsItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, RoadMapsActivity.class);

                    startActivity(intent);
                }
            });
        }
        if (Ebook !=null) {
            Ebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, EbookActivity.class);

                    startActivity(intent);
                }
            });
        }
        if (ChatBot != null) {
            ChatBot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Buat Intent untuk pindah ke Activity lain
                    Intent intent = new Intent(MainActivity.this, ChatBotActivity.class);

                    // Jalankan Intent
                    startActivity(intent);
                }
            });
        }


//        actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle("Judul Aktivitas");
//        }

//        viewPager = findViewById(R.id.viewPager);
//        loadCards();

//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////                String title = modelArrayList.get(position).getTitle();
////                actionBar.setTitle(title);
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.slide4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide1, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
    private void openDeskripsiActivity(int cardNumber) {
        Intent intent = new Intent(this, DeskripsiActivity.class);
        intent.putExtra("cardNumber", cardNumber);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about_us) {
            // Ketika item menu "About Us" diklik, buka halaman "About Us".
            Intent intent = new Intent(this, AboutusActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}