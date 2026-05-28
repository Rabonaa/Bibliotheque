package bibliotheque.tests;
import bibliotheque.utilisateurs.Etudiant;

public class TestEtudiant {
    public static void main(String[] args){
        Etudiant e1 = new Etudiant ("boss", "michel", "Physique", "ICI");
        e1.afficherInfos();

        Etudiant e2 = new Etudiant("bobby", "bob");
        String filiere2 = e2.getFiliere();
        String adresse2 = e2.getAdresse();
        System.out.println(filiere2 + " " + adresse2);

        e2.setFiliere("caca");
        e2.setAdresse(" ");
        System.out.println(e2.getFiliere() + " " + e2.getAdresse());
        System.out.println(e1.getNumeroEtudiant() + " " + e2.getNumeroEtudiant() + "\t nb: " + Etudiant.getCompteurEtudiants());

    }

}
