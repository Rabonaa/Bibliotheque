package bibliotheque.tests;

import bibliotheque.gestion.Livre;
import bibliotheque.gestion.Date;
import bibliotheque.gestion.Emprunt;
import bibliotheque.utilisateurs.Etudiant;

public class TestSystemeBase {
    public static void main(String[] args){
        Livre livre1 = new Livre("Le monde", "Mark", "BZNE", 2026);
        Etudiant etu1 = new Etudiant("Grand", "bob", "Mathématiques", "2 rue ICI");
        Date today = new Date(28, 5, 2026);
        System.out.println(livre1);
        Emprunt emprunt1 = new Emprunt(livre1, etu1, today, 30);
        System.out.println(emprunt1.getDateRetourPrevue());
        System.out.println(livre1);
        System.out.println(etu1);
        System.out.println(today);
        System.out.println(emprunt1);
        System.out.println(emprunt1.estEnRetard(new Date(30, 7, 2026)));
        System.out.println(emprunt1.calculerJoursRetard(new Date(30, 7, 2026)));
        emprunt1.cloturerEmprunt(today);
        System.out.println(livre1);


    }
}
