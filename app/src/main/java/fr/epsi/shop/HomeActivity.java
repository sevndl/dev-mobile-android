package fr.epsi.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends EpsiActivity implements View.OnClickListener {

    public static void displayActivity(SplashActivity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Accueil");
        findViewById(R.id.buttonEtudiants).setOnClickListener(this);
        findViewById(R.id.buttonCategorie).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEtudiants:
                GroupeActivity.displayActivity(this, "Groupe");
                break;
            case R.id.buttonCategorie:
                CategoriesActivity.displayActivity(this, "Rayons");
                break;
        }
    }
}