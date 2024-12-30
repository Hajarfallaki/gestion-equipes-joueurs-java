package ma.enset.tpjdbcorm.service;
import ma.enset.tpjdbcorm.dao.entities.Equipe;
import ma.enset.tpjdbcorm.dao.entities.Joueur;
import java.util.List;

public interface IEquipeJoueurService {
    List<Equipe> getAllEquipes();
    List<Joueur> getJoueursByEquipe(int equipeId);
    void addEquipe(Equipe equipe);
    void addJoueurToEquipe(Joueur joueur, int equipeId);
    void removeEquipe(int equipeId);
    void removeJoueur(int joueurId);
}
