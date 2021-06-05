package fr.theo.narutostream.fragments;

public class Episode {
    String titre;
    String description;
    String duree;
    String numero;
    String saison;

    public Episode(String titre, String description, String duree, String numero, String saison) {
        this.titre = titre;
        this.description = description;
        this.duree = duree;
        this.numero = numero;
        this.saison = saison;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }
}
