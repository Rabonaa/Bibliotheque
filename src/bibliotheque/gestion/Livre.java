package bibliotheque.gestion;
/**
 * Représente un livre de la bibliothèque.
 * <p>Chaque livre a un titre, un auteur, un ISBN, une année de publication,
 * et un statut indiquant s'il est disponible ou emprunté.</p>
 * <p>Un compteur statique permet de suivre le nombre total de livres créés.</p>
 */
public class Livre {

    /** Titre du livre */
    private String titre;

    /** Auteur du livre */
    private String auteur;

    /** Code ISBN du livre */
    private String isbn;

    /** Année de publication */
    private int anneePublication;

    /** Indique si le livre est disponible pour emprunt */
    private boolean disponible;

    /** Compteur global de livres créés */
    private static int compteurLivres = 0;

    /**
     * Constructeur complet pour créer un livre.
     * Le livre est disponible par défaut et le compteur est incrémenté.
     *
     * @param titre Titre du livre
     * @param auteur Auteur du livre
     * @param isbn Code ISBN
     * @param anneePublication Année de publication (doit être positive)
     */
    public Livre(String titre, String auteur, String isbn, int anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.anneePublication = anneePublication;
        this.disponible = true;

        compteurLivres++;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    /** @return le titre du livre */
    public String getTitre() { return titre; }

    /** @return l'auteur du livre */
    public String getAuteur() { return auteur; }

    /** @return le code ISBN */
    public String getIsbn() { return isbn; }

    /** @return l'année de publication */
    public int getAnneePublication() { return anneePublication; }

    /** @return true si le livre est disponible, false sinon */
    public boolean isDisponible() { return disponible; }

    /**
     * Modifie le titre du livre si non vide.
     * @param titre Nouveau titre
     */
    public void setTitre(String titre) {
        if (titre != null && !titre.isEmpty())
            this.titre = titre;
    }

    /**
     * Modifie l'auteur du livre si non vide.
     * @param auteur Nouveau nom d'auteur
     */
    public void setAuteur(String auteur) {
        if (auteur != null && !auteur.isEmpty())
            this.auteur = auteur;
    }

    /**
     * Modifie l'année de publication si positive.
     * @param annee Nouvelle année
     */
    public void setAnneePublication(int annee) {
        if (annee > 0)
            this.anneePublication = annee;
    }

    /** @return le nombre total de livres créés */
    public static int getCompteurLivres() {
        return compteurLivres;
    }

    /**
     * Marque le livre comme emprunté.
     * Affiche un message d'erreur si le livre n'était pas disponible.
     */
    public void emprunter() {
        if (!disponible) {
            System.out.println("Erreur : Le livre est déjà emprunté !");
        } else {
            disponible = false;
            System.out.println("Livre emprunté avec succès.");
        }
    }

    /**
     * Marque le livre comme retourné.
     * Affiche un message d'erreur si le livre était déjà disponible.
     */
    public void retourner() {
        if (disponible) {
            System.out.println("Erreur : Le livre n'était pas emprunté !");
        } else {
            disponible = true;
            System.out.println("Livre retourné avec succès.");
        }
    }

    /**
     * Retourne les informations du livre sous forme lisible,
     * avec son statut (DISPONIBLE ou EMPRUNTÉ).
     * @return représentation textuelle du livre
     */
    @Override
    public String toString() {
        String statut;
        if (disponible) {
            statut = "DISPONIBLE";
        } else {
            statut = "EMPRUNTÉ";
        }
        return "\"" + titre + "\" par " + auteur +
                " (" + anneePublication + ") - " + statut;
    }
}