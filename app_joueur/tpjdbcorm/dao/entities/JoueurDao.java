package ma.enset.tpjdbcorm.dao.entities;

import java.util.List;

public interface JoueurDao extends Dao<Joueur>{
    List<Joueur> findAll();         // Récupérer tous les joueurs
    Joueur findById(int id);
    void save(Joueur joueur);       // Ajouter un joueur
    void update(Joueur joueur);     // Mettre à jour un joueur
    void deleteById(int id);       // Supprimer un joueur

}
