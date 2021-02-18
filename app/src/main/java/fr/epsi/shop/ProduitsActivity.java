package fr.epsi.shop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProduitsActivity extends EpsiActivity {

    private ArrayList<Produits> produits;

    public static void displayActivity(EpsiActivity activity, String name) {
        Intent intent = new Intent(activity, ProduitsActivity.class);
        intent.putExtra("name", name);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        String name = getIntent().getExtras().getString("name", "");
        showBack();
        setTitle(name);

        produits = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewProduits);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProduitsAdapter produitsAdapter = new ProduitsAdapter(this, produits);
        recyclerView.setAdapter(produitsAdapter);

        String rightName = name.toLowerCase();
        String url = "https://djemam.com/epsi/" + rightName + ".json";
        WSCall wsCall = new WSCall(url, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject = new JSONObject();
                    JSONArray jsonArray = jsonObject.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Produits produit = new Produits(jsonArray.getJSONObject(i));
                        produits.add(produit);
                    }
                    produitsAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.d("url : ", url);
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(ProduitsActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}