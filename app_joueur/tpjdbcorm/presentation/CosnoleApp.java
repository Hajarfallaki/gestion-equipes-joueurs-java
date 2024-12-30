package ma.enset.tpjdbcorm.presentation;
import ma.enset.tpjdbcorm.dao.entities.Equipe;
import ma.enset.tpjdbcorm.dao.entities.Joueur;
import ma.enset.tpjdbcorm.service.EquipeJoueurServiceImpl;
import ma.enset.tpjdbcorm.service.IEquipeJoueurService;
import java.util.Scanner;

public class CosnoleApp {
    private static final IEquipeJoueurService service = new EquipeJoueurServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne
            switch (choix) {
                case 1 -> afficherEquipes();
                case 2 -> rechercherEquipe();
                case 3 -> ajouterEquipe();
                case 4 -> supprimerEquipe();
                case 5 -> afficherJoueursEquipe();
                case 6 -> ajouterJoueur();
                case 7 -> afficherJoueurs();
                case 8 -> supprimerJoueur();
                case 0 -> {
                    System.out.println("Au revoir !");
                    System.exit(0);
                }
                default -> System.out.println("Choix invalide !");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nMenu :");
        System.out.println("1. Afficher la liste des équipes");
        System.out.println("2. Rechercher des équipes par mot clé");
        System.out.println("3. Ajouter une équipe");
        System.out.println("4. Supprimer une équipe");
        System.out.println("5. Afficher la liste des joueurs d'une équipe");
        System.out.println("6. Ajouter un joueur");
        System.out.println("7. Afficher la liste des joueurs");
        System.out.println("8. Supprimer un joueur");
        System.out.println("9. Imprimer les informations d’un joueur dans un fichier PDF");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void afficherEquipes() {
        service.getAllEquipes().forEach(equipe ->
                System.out.println(equipe.getId() + " - " + equipe.getNom() + " (" + equipe.getVille() + ")"));
    }

    private static void rechercherEquipe() {
        System.out.print("Mot clé : ");
        String motCle = scanner.nextLine();
        service.getAllEquipes().stream()
                .filter(equipe -> equipe.getNom().contains(motCle) || equipe.getVille().contains(motCle))
                .forEach(equipe ->
                        System.out.println(equipe.getId() + " - " + equipe.getNom() + " (" + equipe.getVille() + ")"));
    }

    private static void ajouterEquipe() {
        System.out.print("Nom de l'équipe : ");
        String nom = scanner.nextLine();
        System.out.print("Ville de l'équipe : ");
        String ville = scanner.nextLine();
        service.addEquipe(new Equipe(0, nom, ville));
        System.out.println("Équipe ajoutée avec succès !");
    }

    private static void supprimerEquipe() {
        System.out.print("ID de l'équipe à supprimer : ");
        int id = (int) scanner.nextLong();
        service.removeEquipe(id);
        System.out.println("Équipe supprimée avec succès !");
    }

    private static void afficherJoueursEquipe() {
        System.out.print("ID de l'équipe : ");
        int equipeId = (int) scanner.nextLong();
        service.getJoueursByEquipe(equipeId).forEach(joueur ->
                System.out.println(joueur.getId() + " - " + joueur.getNom() + " (" + joueur.getPosition() + ", #" + joueur.getNumero() + ")"));
    }

    private static void ajouterJoueur() {
        System.out.print("Nom du joueur : ");
        String nom = scanner.nextLine();
        System.out.print("Position : ");
        String position = scanner.nextLine();
        System.out.print("Numéro : ");
        int numero = scanner.nextInt();
        System.out.print("ID de l'équipe : ");
        int equipeId = (int) scanner.nextLong();
        service.addJoueurToEquipe(new Joueur(0, nom, position, numero, equipeId), equipeId);
        System.out.println("Joueur ajouté avec succès !");
    }

    private static void afficherJoueurs() {
        service.getAllEquipes().forEach(equipe -> {
            System.out.println("Équipe : " + equipe.getNom());
            service.getJoueursByEquipe(equipe.getId()).forEach(joueur ->
                    System.out.println(joueur.getId() + " - " + joueur.getNom() + " (" + joueur.getPosition() + ", #" + joueur.getNumero() + ")"));
        });
    }

    private static void supprimerJoueur() {
        System.out.print("ID du joueur à supprimer : ");
        int id = (int) scanner.nextLong();
        service.removeJoueur(id);
        System.out.println("Joueur supprimé avec succès !");
    }


}
