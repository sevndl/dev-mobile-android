package fr.epsi.shop;

import android.content.Intent;
import android.os.Bundle;

public class CategoriesActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity, String title) {
        Intent intent = new Intent(activity, CategoriesActivity.class);
        intent.putExtra("title", title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        String title = getIntent().getExtras().getString("title","");
        showBack();
        setTitle(title);
    }
}