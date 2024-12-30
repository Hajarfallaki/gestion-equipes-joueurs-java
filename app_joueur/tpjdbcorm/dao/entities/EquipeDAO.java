package ma.enset.tpjdbcorm.dao.entities;

import java.util.List;

public interface EquipeDAO extends Dao<Equipe> {
    List<Equipe> findAll();            // Retrieve all teams
    Equipe findById(int id);          // Find a team by its ID
    void save(Equipe equipe);          // Add a new team
    void update(Equipe equipe);        // Update an existing team
    void deleteById(int id);           // Delete a team by its ID
}
