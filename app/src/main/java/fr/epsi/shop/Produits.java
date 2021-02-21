package fr.epsi.shop;

import org.json.JSONObject;

import java.io.Serializable;

public class Produits implements Serializable {

    private String name;
    private String description;
    private String picture_url;

    public Produits(JSONObject o) {
        this.name = o.optString("name", "Erreur");
        this.description = o.optString("description", "Erreur");
        this.picture_url = o.optString("picture_url", "Erreur");
    }

    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public String getPicture_url() { return this.picture_url; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPictureUrl(String picture_url) { this.picture_url = picture_url; }

}
