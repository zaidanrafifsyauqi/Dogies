package com.example.dogies;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterCall extends CursorAdapter {

    public AdapterCall(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameView, numberView, emailView, typeofContactView;
        ImageView mContactImageView;

        nameView = view.findViewById(R.id.textName);
        emailView = view.findViewById(R.id.textEmail);
        numberView = view.findViewById(R.id.textNumber);
        typeofContactView = view.findViewById(R.id.textTypeofContact);
        mContactImageView = view.findViewById(R.id.imageContact);

        int name = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_NAME);
        int email = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_EMAIL);
        int type = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_TYPEOFCONTACT);
        int number = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_PHONENUMBER);
        int picture = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_PICTURE);

        String contactname = cursor.getString(name);
        String contactemail = cursor.getString(email);
        String contactnumber = cursor.getString(number);
        String typeof = cursor.getString(type);

        // Periksa apakah ada URI gambar sebelum mengatur gambar
        if (picture != -1) {
            String contactpicture = cursor.getString(picture);
            if (contactpicture != null) {
                Uri imageUri = Uri.parse(contactpicture);
                mContactImageView.setImageURI(imageUri);
            } else {
                // Gambar tidak ada, atur gambar default
                mContactImageView.setImageResource(R.drawable.imgprofile); // Gantilah 'default_image' dengan sumber daya gambar default Anda
            }
        } else {
            // Gambar tidak ada, atur gambar default
            mContactImageView.setImageResource(R.drawable.imgprofile); // Gantilah 'default_image' dengan sumber daya gambar default Anda
        }

        nameView.setText(contactname);
        numberView.setText(contactnumber);
        typeofContactView.setText(typeof);
        emailView.setText(contactemail);

        ImageView buttonTelephone = view.findViewById(R.id.buttonTelephone);
        buttonTelephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = contactnumber; // Menggunakan nomor telepon yang sesuai
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                context.startActivity(intent);
            }
        });
    }

}
