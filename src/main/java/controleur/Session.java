package controleur;

public class Session {
    private String typeEcran;

    public  String traiterConnexion() {
        this.typeEcran = "ECRAN_ACCUIEL";
        return "ECRAN_ACCUEIL";
    }

}
