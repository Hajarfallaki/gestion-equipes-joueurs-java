package ma.enset.tpjdbcorm.dao.entities;
import java.io.Serializable;
public class Equipe implements Serializable {
    private int id;
    private String nom;
    private String ville;

    // Constructeurs
    public Equipe() {}
    public Equipe(int id, String nom, String ville) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
    }
    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}

