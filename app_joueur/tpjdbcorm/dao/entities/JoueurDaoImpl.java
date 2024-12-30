package ma.enset.tpjdbcorm.dao.entities;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class JoueurDaoImpl implements JoueurDao {
    private Connection connection;
    // Constructor to initialize the connection
    public JoueurDaoImpl() {
        this.connection = SignletonConnexionDB.getConnection();
    }


    @Override
    public List<Joueur> findAll() {
        List<Joueur> joueurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM joueur";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                joueurs.add(new Joueur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("position"),
                        rs.getInt("numero"),
                        rs.getInt("equipe_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueurs;
    }
    @Override
    public Joueur findById(int id) {
        Joueur joueur = null;
        try {
            String query = "SELECT * FROM joueur WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                joueur = new Joueur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("position"),
                        rs.getInt("numero"),
                        rs.getInt("equipe_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueur;
    }
    @Override
    public void save(Joueur joueur) {
        try {
            String query = "INSERT INTO joueur (nom, position, numero, equipe_id) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, joueur.getNom());
            pstmt.setString(2, joueur.getPosition());
            pstmt.setInt(3, joueur.getNumero());
            pstmt.setLong(4, joueur.getEquipeId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(Joueur joueur) {
        try {
            String query = "UPDATE joueur SET nom = ?, position = ?, numero = ?, equipe_id = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, joueur.getNom());
            pstmt.setString(2, joueur.getPosition());
            pstmt.setInt(3, joueur.getNumero());
            pstmt.setLong(4, joueur.getEquipeId());
            pstmt.setLong(5, joueur.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteById(int id) {
        try {
            String query = "DELETE FROM joueur WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
