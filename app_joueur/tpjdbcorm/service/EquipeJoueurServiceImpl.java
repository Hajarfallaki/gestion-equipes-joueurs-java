package ma.enset.tpjdbcorm.service;
import ma.enset.tpjdbcorm.dao.entities.*;
import java.util.List;

public class EquipeJoueurServiceImpl implements IEquipeJoueurService {
    private final EquipeDAO equipeDao = new EquipeDaoImpl();
    private final JoueurDao joueurDao = new JoueurDaoImpl();

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeDao.findAll();
    }

    @Override
    public List<Joueur> getJoueursByEquipe(int equipeId) {
        return joueurDao.findAll()
                .stream()
                .filter(joueur -> joueur.getEquipeId() == equipeId)
                .toList();
    }

    @Override
    public void addEquipe(Equipe equipe) {
        equipeDao.save(equipe);
    }

    @Override
    public void addJoueurToEquipe(Joueur joueur, int equipeId) {
        joueur.setEquipeId(equipeId);
        joueurDao.save(joueur);
    }

    @Override
    public void removeEquipe(int equipeId) {
        // Supprimer tous les joueurs associés avant de supprimer l'équipe
        joueurDao.findAll()
                .stream()
                .filter(joueur -> joueur.getEquipeId() == equipeId)
                .forEach(joueur -> joueurDao.deleteById(joueur.getId()));
        equipeDao.deleteById(equipeId);
    }

    @Override
    public void removeJoueur(int joueurId) {
        joueurDao.deleteById(joueurId);
    }


}

