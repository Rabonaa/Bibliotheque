package bibliotheque.utilisateurs;
public class Etudiant {
    // Attributs d'instance
    String nom;
    String prenom;
    int numeroEtudiant;
    String filiere;
    String adresse;

    // Attribut statique (partagé par tous les étudiants)
    static int compteurEtudiants = 0;

    // Constructeur complet d'initialisation
    public Etudiant(String nom, String prenom, String filiere) {
        compteurEtudiants++;
        this.numeroEtudiant = compteurEtudiants; // Numéro automatique
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
    }

    // Constructeur simplifié
    public Etudiant(String nom, String prenom) {
        this(nom, prenom, "Non spécifiée");
    }

    // Getters



    // Setters avec validation


    // Méthode statique pour accéder au compteur
    public static int getCompteurEtudiants() {
        return compteurEtudiants;
    }

    // Méthode d'instance pour afficher les informations
    public void afficherInfos() {
        System.out.println("=== Informations Étudiant ===");
        System.out.println("Numéro : " + numeroEtudiant);
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Filière : " + filiere);
        System.out.println("Adresse : " + adresse);
    }
}




