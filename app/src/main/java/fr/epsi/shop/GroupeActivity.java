package fr.epsi.shop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GroupeActivity extends EpsiActivity implements View.OnClickListener {


    private Etudiants Severin = new Etudiants("NANDILLON", "Séverin", "severin.nandillon@epsi.fr", "B3 groupe 2", "photo");
    private Etudiants Oscar  = new Etudiants("MADEZO", "Oscar", "oscar.madezo@epsi.fr", "B3 groupe 2", "photo2");


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
        Context activity = getApplicationContext();
        Intent intent = new Intent(activity, ProfileActivity.class);

        switch (v.getId()){
            case R.id.severinBouton:
                intent.putExtra("Etudiant", this.Severin);
                startActivity(intent);
                break;

            case R.id.oscarBouton:
                intent.putExtra("Etudiant", this.Oscar);
                startActivity(intent);
                break;
        }
    }
}