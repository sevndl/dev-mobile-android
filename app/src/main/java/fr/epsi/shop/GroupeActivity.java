package fr.epsi.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GroupeActivity extends EpsiActivity implements View.OnClickListener {

    public static void displayActivity(EpsiActivity activity, String title) {
        Intent intent = new Intent(activity, GroupeActivity.class);
        intent.putExtra("title", title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupe);

        String title = getIntent().getExtras().getString("title","");
        showBack();
        setTitle(title);

        findViewById(R.id.severinBouton).setOnClickListener(this);
        findViewById(R.id.oscarBouton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.severinBouton:
                ProfileActivity.displayActivity(this, "NANDILLON", "drawable://photo.jpg");
                break;
            case R.id.oscarBouton:
                ProfileActivity.displayActivity(this, "MADEZO", "drawable://photo2.jpg");
                break;
        }
    }


}