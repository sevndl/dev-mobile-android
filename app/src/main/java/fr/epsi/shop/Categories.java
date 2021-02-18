package fr.epsi.shop;

import org.json.JSONObject;

public class Categories {

    private String title;
    private String products_url;

    public Categories(JSONObject o) {
        this.title = o.optString("title", "Erreur");
        this.products_url = o.optString("products_url", "Erreur");
    }

    public String getTitle() { return this.title; }
    public String getProduitsUrl() { return this.products_url; }

    public void setTitle(String title) { this.title = title; }
    public void setProduitsUrl(String produitsUrl) { this.products_url = produitsUrl; }

}
