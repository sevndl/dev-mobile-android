package fr.epsi.shop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProduitsAdapter extends RecyclerView.Adapter<ProduitsAdapter.ViewHolder> {
    EpsiActivity activity;
    ArrayList<Produits> produits;

    public ProduitsAdapter(EpsiActivity activity, ArrayList<Produits> produits){
        this.activity = activity;
        this.produits = produits;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final View layoutCellProduit;
        private final ImageView imageViewProduit;
        private final TextView textViewDescription;

        public ViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.textViewName);
            layoutCellProduit = view.findViewById(R.id.layoutCellProduit);
            imageViewProduit = view.findViewById(R.id.imageViewProduit);
            textViewDescription = view.findViewById(R.id.textViewDescription);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public View getLayoutCellProduit() { return layoutCellProduit; }
        public TextView getTextViewDescription() { return textViewDescription; }
        public ImageView getImageViewProduit() { return imageViewProduit; }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_produit, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Produits produit = produits.get(position);
        holder.getTextViewName().setText(produit.getName());
        holder.getTextViewDescription().setText(produit.getDescription());
        Picasso.get().load(produit.getPicture_url()).into(holder.getImageViewProduit());
        holder.getLayoutCellProduit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProduitsActivity.displayActivity(activity, produit.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }
}

