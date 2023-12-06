package com.example.dogies;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DeskripsiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        Button btnWhatsApp = findViewById(R.id.btnWhatsApp);

        btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsAppChat(); // Panggil metode untuk membuka chat WhatsApp
            }
        });

        ImageView gambarImageView = findViewById(R.id.gambarImageView);
        TextView judulTextView = findViewById(R.id.judulTextView);
        TextView deskripsiTextView = findViewById(R.id.deskripsiTextView);

        int cardNumber = getIntent().getIntExtra("cardNumber", 0);

        int gambarResId = R.drawable.dogiesrev; // Gambar default
        String judul = "Judul Produk";
        String deskripsi = "Deskripsi Produk";

        switch (cardNumber) {
            case 1:
                gambarResId = R.drawable.dogies1;
                judul = "Dolly Aegis (Mickey)";
                deskripsi = "Dolly Ageis adalah gantungan kunci boneka yang berbentuk hewan yakni anjing dimana boneka tersebut dilengkapi oleh noisy alarm yang bertujuan untuk memperoleh perhatian orang disekitar ketika korban merasa terancam akibat adanya tindakan yang mengarah kepada tindakan pelecehan seksual. Noisy alarm tersebut dapat muncul apabila boneka tersebut ditarik sehingga mengeluarkan suara yang akan menarik perhatian orang lain.";
                break;
            case 2:
                gambarResId = R.drawable.dogies2;
                judul = "Dolly Aegis (Valerie)";
                deskripsi = "Dolly Ageis adalah gantungan kunci boneka yang berbentuk hewan yakni anjing dimana boneka tersebut dilengkapi oleh noisy alarm yang bertujuan untuk memperoleh perhatian orang disekitar ketika korban merasa terancam akibat adanya tindakan yang mengarah kepada tindakan pelecehan seksual. Noisy alarm tersebut dapat muncul apabila boneka tersebut ditarik sehingga mengeluarkan suara yang akan menarik perhatian orang lain.";
                break;
            case 3:
                gambarResId = R.drawable.dogies3;
                judul = "Dolly Aegis (Archie)";
                deskripsi = "Dolly Ageis adalah gantungan kunci boneka yang berbentuk hewan yakni anjing dimana boneka tersebut dilengkapi oleh noisy alarm yang bertujuan untuk memperoleh perhatian orang disekitar ketika korban merasa terancam akibat adanya tindakan yang mengarah kepada tindakan pelecehan seksual. Noisy alarm tersebut dapat muncul apabila boneka tersebut ditarik sehingga mengeluarkan suara yang akan menarik perhatian orang lain.";
                break;
        }

        gambarImageView.setImageResource(gambarResId);
        judulTextView.setText(judul);
        deskripsiTextView.setText(deskripsi);
    }
    private void openWhatsAppChat() {
        // Gantilah nomor telepon WhatsApp dan pesan dengan yang sesuai
        String phoneNumber = "6285692402008"; // Gantilah dengan nomor WhatsApp yang diinginkan
        String message = "Halo, saya tertarik dengan produk ini";

        // Buat URI untuk memulai obrolan WhatsApp
        Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + message);

        // Buka obrolan WhatsApp dengan URI yang telah dibuat
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}