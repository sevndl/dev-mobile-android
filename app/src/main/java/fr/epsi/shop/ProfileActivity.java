package fr.epsi.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity, String title, String photo) {
        Intent intent = new Intent(activity, ProfileActivity.class);
        intent.putExtra("title", title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String title = getIntent().getExtras().getString("title","");
        showBack();
        setTitle(title);

        ImageView imageView = findViewById(R.id.photo);



    }
}