package bibliotheque.utilisateurs;
import java.util.Arrays;
import java.util.List;

public class Etudiant {
    // Attributs d'instance
    private String nom;
    private String prenom;
    private int numeroEtudiant;
    private String filiere;
    private String adresse;

    // Attribut statique (partagé par tous les étudiants)
    private static int compteurEtudiants = 0;

    // Constructeur complet d'initialisation
    public Etudiant(String nom, String prenom, String filiere, String adresse) {
        compteurEtudiants++;
        this.numeroEtudiant = compteurEtudiants; // Numéro automatique
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.adresse = adresse;
    }

    // Constructeur simplifié
    public Etudiant(String nom, String prenom) {
        this(nom, prenom, "Non spécifiée", "Non renseignee");
    }

    // Getters
    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public int getNumeroEtudiant() {
        return this.numeroEtudiant;
    }

    public String getFiliere() {
        return this.filiere;
    }

    public String getAdresse() {
        return this.adresse;
    }

    // Setters avec validation
    public void setNom(String nom) {
        if (nom != null && !nom.isEmpty())
            this.nom = nom;
        return;
    }

    public void setPrenom(String prenom) {
        if (prenom != null && !prenom.isEmpty())
            this.prenom = prenom;
        return;
    }

    public void setNumeroEtudiant(int num) {
        this.numeroEtudiant = num;
    }

    public void setFiliere(String filiere) {
        String[] tab = {"Informatique", "Mathématiques", "Physique", "Non spécifiee"};
        List<String> liste = Arrays.asList(tab);
        if (liste.contains(filiere))
            this.filiere = filiere;
        return;
    }

    public void setAdresse(String adresse) {
        if (!adresse.isEmpty())
            this.adresse = adresse;
        return;
    }

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

    @Override
    public String toString() {
        return "Etudiant = { numero etudiant : " + numeroEtudiant + ", nom : " + nom + ", prenom : " + prenom + ", filiere : " + filiere + ", adresse : " + adresse + "}";
    }

    @Override
    public boolean equals ( Object obj ) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Etudiant autre = (Etudiant) obj;
        if (this.numeroEtudiant == autre.numeroEtudiant) return true;
    }
}




