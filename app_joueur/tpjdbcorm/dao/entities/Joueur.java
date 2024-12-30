package ma.enset.tpjdbcorm.dao.entities;
import java.io.Serializable;
public class Joueur implements Serializable {
    private int id;
    private String nom;
    private String position;
    private int numero;
    private int equipeId;
    // Constructeurs
    public Joueur() {}
    public Joueur(int id, String nom, String position, int numero, int equipeId) {
        this.id = id;
        this.nom = nom;
        this.position = position;
        this.numero = numero;
        this.equipeId = equipeId;
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
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public long getEquipeId() {
        return equipeId;
    }
    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }
}
