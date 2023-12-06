package com.example.dogies;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class EbookActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        viewFlipper = findViewById(R.id.viewFlipper);

        // Inisialisasi GestureDetector
        gestureDetector = new GestureDetector(this, new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Teruskan event sentuhan ke GestureDetector
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // Deteksi gerakan geser
            if (e1.getX() < e2.getX()) {
                // Geser ke kiri (sebelumnya)
                viewFlipper.setInAnimation(EbookActivity.this, android.R.anim.slide_in_left);
                viewFlipper.setOutAnimation(EbookActivity.this, android.R.anim.slide_out_right);
                viewFlipper.showPrevious();
            } else if (e1.getX() > e2.getX()) {
                // Geser ke kanan (selanjutnya)
                viewFlipper.setInAnimation(EbookActivity.this, R.anim.slide_in_right);
                viewFlipper.setOutAnimation(EbookActivity.this, R.anim.slide_out_left);
                viewFlipper.showNext();
            }
            return true;
        }
    }
}
