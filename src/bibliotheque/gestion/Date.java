/**
 * Représente une date simple composée d'un jour, d'un mois et d'une année.
 *
 * <p>Cette classe fournit des méthodes permettant :
 * <ul>
 *   <li>de valider une date lors de sa création</li>
 *   <li>de comparer deux dates</li>
 *   <li>de calculer une différence en jours</li>
 *   <li>d'ajouter un nombre de jours à une date</li>
 * </ul>
 *
 * <p>Pour simplifier les calculs :
 * <ul>
 *   <li>un mois est considéré comme ayant 30 jours</li>
 *   <li>une année est considérée comme ayant 360 jours</li>
 * </ul>
 *
 * <p>La classe est immutable : aucun setter n'est fourni.
 */


package bibliotheque.gestion;
public class Date {

    /** Jour de la date */
    private int jour;

    /** Mois de la date */
    private int mois;

    /** Année de la date */
    private int annee;

    /**
     * Construit une date par défaut initialisée à 01/01/2026.
     */
    public Date() {
        this(1, 1, 2026);
    }

    /**
     * Construit une date à partir du jour, du mois et de l'année.
     * Si les valeurs ne sont pas valides, la date est initialisée
     * par défaut à 01/01/2026.
     *
     * @param jour  le jour du mois
     * @param mois  le mois de l'année
     * @param annee l'année
     */
    public Date(int jour, int mois, int annee) {
        if (estAnneeValide(annee) && estMoisValide(mois) && estJourValide(jour, mois, annee)) {
            this.jour = jour;
            this.mois = mois;
            this.annee = annee;
        } else {
            System.out.println("Date invalide. Initialisation par défaut.");
            this.jour = 1;
            this.mois = 1;
            this.annee = 2026;
        }
    }

    /**
     * Constructeur par copie de la classe Date.
     * Crée une nouvelle instance en copiant les valeurs d'une autre date.
     *
     * @param autre la date à copier ; si null, la date est initialisée par défaut à 01/01/2026
     */
    public Date(Date autre) {
        if (autre != null) {
            this.jour = autre.jour;
            this.mois = autre.mois;
            this.annee = autre.annee;
        } else {
            System.out.println("Date nulle. Initialisation par défaut.");
            this.jour = 1;
            this.mois = 1;
            this.annee = 2026;
        }
    }
    /**
     * Vérifie si une année est valide.
     *
     * @param annee l'année à vérifier
     * @return true si l'année est comprise entre 1900 et 2100
     */
    private boolean estAnneeValide(int annee) {
        return annee >= 1900 && annee <= 2100;
    }

    /**
     * Vérifie si un mois est valide.
     *
     * @param mois le mois à vérifier
     * @return true si le mois est compris entre 1 et 12
     */
    private boolean estMoisValide(int mois) {
        return mois >= 1 && mois <= 12;
    }

    /**
     * Vérifie si un jour est valide selon le mois.
     *
     * @param jour  le jour
     * @param mois  le mois
     * @param annee l'année
     * @return true si le jour est valide
     */
    private boolean estJourValide(int jour, int mois, int annee) {

        int maxJour;

        switch (mois) {
            case 4: case 6: case 9: case 11:
                maxJour = 30;
                break;
            case 2:
                maxJour = 29;
                break;
            default:
                maxJour = 31;
        }

        return jour >= 1 && jour <= maxJour;
    }

    /**
     * Compare la date courante avec une autre date.
     *
     * @param autre la date à comparer
     * @return -1 si la date courante est antérieure,
     *         0 si les deux dates sont identiques,
     *         1 si la date courante est postérieure
     */
    public int comparerA(Date autre) {

        int thisTotal = annee * 360 + mois * 30 + jour;
        int autreTotal = autre.annee * 360 + autre.mois * 30 + autre.jour;

        if (thisTotal < autreTotal) return -1;
        if (thisTotal > autreTotal) return 1;
        return 0;
    }

    /**
     * Indique si la date courante est avant une autre date.
     *
     * @param autre la date à comparer
     * @return true si la date courante est antérieure
     */
    public boolean estAvant(Date autre) {
        return comparerA(autre) == -1;
    }

    /**
     * Indique si la date courante est après une autre date.
     *
     * @param autre la date à comparer
     * @return true si la date courante est postérieure
     */
    public boolean estApres(Date autre) {
        return comparerA(autre) == 1;
    }

    /**
     * Calcule la différence en jours entre deux dates.
     *
     * @param autre la date de comparaison
     * @return le nombre de jours de différence
     */
    public int differenceEnJours(Date autre) {

        int thisTotal = annee * 360 + mois * 30 + jour;
        int autreTotal = autre.annee * 360 + autre.mois * 30 + autre.jour;

        return Math.abs(thisTotal - autreTotal);
    }

    /**
     * Ajoute un nombre de jours à la date courante.
     *
     * @param nbJours nombre de jours à ajouter
     * @return une nouvelle instance de Date
     */
    public Date ajouterJours(int nbJours) {

        int total = annee * 360 + mois * 30 + jour + nbJours;

        int nouvelleAnnee = total / 360;
        total = total % 360;

        int nouveauMois = total / 30;
        int nouveauJour = total % 30;

        if (nouveauJour == 0) {
            nouveauJour = 30;
            nouveauMois--;
        }

        if (nouveauMois == 0) {
            nouveauMois = 12;
            nouvelleAnnee--;
        }

        return new Date(nouveauJour, nouveauMois, nouvelleAnnee);
    }

    /**
     * Retourne la date au format JJ/MM/AAAA.
     *
     * @return la représentation textuelle de la date
     */
    @Override
    public String toString() {
            String j = "" + jour;
            String m = "" + mois;

            if (jour < 10) {
                j = "0" + jour;
            }

            if (mois < 10) {
                m = "0" + mois;
            }

            return j + "/" + m + "/" + annee;
    }

    /**
     * Compare deux objets Date.
     *
     * @param obj objet à comparer
     * @return true si les deux dates sont identiques
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Date autre = (Date) obj;

        return jour == autre.jour &&
                mois == autre.mois &&
                annee == autre.annee;
    }

    /** @return le jour */
    public int getJour() { return jour; }

    /** @return le mois */
    public int getMois() { return mois; }

    /** @return l'année */
    public int getAnnee() { return annee; }
}
