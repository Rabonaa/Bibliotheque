package bibliotheque.gestion;

import bibliotheque.utilisateurs.Etudiant;
/**
 * Représente un emprunt d'un livre par un étudiant.
 * <p>
 * La classe gère les informations suivantes :
 * <ul>
 *     <li>Le livre emprunté</li>
 *     <li>L'étudiant emprunteur</li>
 *     <li>La date d'emprunt</li>
 *     <li>La date de retour prévue</li>
 *     <li>La date de retour effective</li>
 *     <li>Le statut de l'emprunt (estRendu)</li>
 * </ul>
 * <p>
 * Les méthodes permettent de clôturer un emprunt, vérifier les retards et afficher les informations.
 */
public class Emprunt {

    /** Le livre emprunté */
    private Livre livre;

    /** L'étudiant qui emprunte le livre */
    private Etudiant emprunteur;

    /** La date à laquelle le livre est emprunté */
    private Date dateEmprunt;

    /** La date prévue pour le retour du livre */
    private Date dateRetourPrevue;

    /** La date réelle de retour (null si non rendu) */
    private Date dateRetourEffective;

    /** Indique si le livre a été rendu */
    private boolean estRendu;

    /**
     * Constructeur complet.
     *
     * @param livre       le livre emprunté
     * @param emprunteur  l'étudiant qui emprunte le livre
     * @param dateEmprunt la date d'emprunt
     * @param nbJoursPret le nombre de jours de prêt
     */
    public Emprunt(Livre livre, Etudiant emprunteur, Date dateEmprunt, int nbJoursPret) {
        this.livre = livre;
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
        // à compléter
    }



    /**
     * Vérifie si l'emprunt est en retard à une date donnée.
     *
     * @param dateActuelle la date à vérifier
     * @return true si l'emprunt est en retard, false sinon
     */
    public boolean estEnRetard(Date dateActuelle) {

        // à compléter
    }

    /**
     * Calcule le nombre de jours de retard à une date donnée.
     *
     * @param dateActuelle la date à vérifier
     * @return le nombre de jours de retard (0 si aucun retard)
     */
    public int calculerJoursRetard(Date dateActuelle) {
        // à compléter
    }
    /**
     * Clôture l'emprunt avec la date de retour effective.
     * <p>
     * Met à jour le statut de l'emprunt et le statut du livre.
     * Affiche un message si le retour est en retard.
     *
     * @param dateRetour la date de retour effective
     */
    public void cloturerEmprunt(Date dateRetour) {
        // à compléter
    }

    // -------------------- Getters --------------------

    /** @return le livre emprunté */


    /** @return l'étudiant emprunteur */


    /** @return la date d'emprunt */


    /** @return la date de retour prévue */


    /** @return la date de retour effective, ou null si non rendu */


    /** @return true si l'emprunt a été rendu */


    // -------------------- toString --------------------

    /**
     * Retourne une représentation textuelle de l'emprunt.
     * <p>
     * Format attendu :
     * <pre>
     * Emprunt de "<titre>" par <nomEtudiant> - Du <dateEmprunt> au <dateRetourPrevue> [EN COURS|RENDU] (retard si applicable)
     * </pre>
     *
     * @return chaîne descriptive de l'emprunt
     */
    @Override
    public String toString() {
        String statut;
        if (estRendu) {
            statut = "RENDU";
        } else {
            statut = "EN COURS";
        }

        String retard = "";
        if (estRendu && dateRetourEffective.estApres(dateRetourPrevue)) {
            int jours = dateRetourEffective.differenceEnJours(dateRetourPrevue);
            retard = " (retard de " + jours + " jour(s))";
        }

        return "Emprunt de \"" + livre.getTitre() + "\" par " +
                emprunteur.getNom() +
                " - Du " + dateEmprunt +
                " au " + dateRetourPrevue +
                " [" + statut + "]" + retard;
    }
}