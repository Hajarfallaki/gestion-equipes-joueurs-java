package ma.enset.tpjdbcorm.dao.entities;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EquipeDaoImpl implements EquipeDAO{
    private Connection connection;
    // Constructor to initialize the connection
    public EquipeDaoImpl() {
        this.connection = SignletonConnexionDB.getConnection();
    }
    @Override
    public void save(Equipe equipe) {
        try {
            String query = "INSERT INTO equipe (nom, ville) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, equipe.getNom());
            pstmt.setString(2, equipe.getVille());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(Equipe equipe) {
        try {
            String query = "UPDATE equipe SET nom = ?, ville = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, equipe.getNom());
            pstmt.setString(2, equipe.getVille());
            pstmt.setLong(3, equipe.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteById(int id) {
        try {
            String query = "DELETE FROM equipe WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Equipe findById(int id) {
        Equipe equipe = null;
        try {
            String query = "SELECT * FROM equipe WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                equipe = new Equipe(rs.getInt("id"), rs.getString("nom"), rs.getString("ville"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipe;
    }
    @Override
    public List<Equipe> findAll() {
        List<Equipe> equipes = new ArrayList<>();
        try {
            String query = "SELECT * FROM equipe";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                equipes.add(new Equipe(rs.getInt("id"), rs.getString("nom"), rs.getString("ville")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipes;
    }
}
