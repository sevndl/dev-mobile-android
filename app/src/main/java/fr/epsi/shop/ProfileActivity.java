package fr.epsi.shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ProfileActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity, String title, String photo) {
        Intent intent = new Intent(activity, ProfileActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("photo", photo);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String title = getIntent().getExtras().getString("title","");
        String photo = getIntent().getExtras().getString("photo","");
        showBack();
        setTitle(title);

        ImageView imageView = findViewById(R.id.photo);
        int id_photo = getResources().getIdentifier(photo, "drawable", getPackageName());
        imageView.setImageResource(id_photo);
    }
}