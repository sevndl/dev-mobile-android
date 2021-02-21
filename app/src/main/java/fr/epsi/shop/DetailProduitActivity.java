package fr.epsi.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class DetailProduitActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity, Produits produit) {
        Intent intent = new Intent(activity, DetailProduitActivity.class);
        intent.putExtra("name", produit.getName());
        intent.putExtra("produit", produit);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produit);
        Produits produit = (Produits) getIntent().getSerializableExtra("produit");
        String name = getIntent().getExtras().getString("name");
        showBack();
        setTitle(name);

        ImageView imageViewProduitDetail = findViewById(R.id.imageViewProduitDetail);
        Picasso.get().load(produit.getPicture_url()).into(imageViewProduitDetail);

        TextView textViewDescriptionDetail = findViewById(R.id.textViewDescriptionDetail);
        textViewDescriptionDetail.setText(produit.getDescription());
    }
}