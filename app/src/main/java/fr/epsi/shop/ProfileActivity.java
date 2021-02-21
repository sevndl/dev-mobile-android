package fr.epsi.shop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends EpsiActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Etudiants etudiants = (Etudiants) getIntent().getSerializableExtra("Etudient");
        showBack();
        setTitle(etudiants.getNom() + " " + etudiants.getPrenom());

        ImageView imageView = findViewById(R.id.photo);
        int id_photo = getResources().getIdentifier(etudiants.getPhoto(), "drawable", getPackageName());
        imageView.setImageResource(id_photo);

        TextView NomEtPrenom = findViewById(R.id.NomEtPrenom);
        NomEtPrenom.setText(etudiants.getNom() + " " + etudiants.getPrenom());

        TextView email = findViewById(R.id.email);
        email.setText(etudiants.getEmail());

        TextView groupe = findViewById(R.id.groupe);
        groupe.setText(etudiants.getGroupe());

        TextView urlepsi = findViewById(R.id.urlepsi);
        urlepsi.setText("http://www.epsi.fr");
        Linkify.addLinks(urlepsi, Linkify.WEB_URLS);
    }
}