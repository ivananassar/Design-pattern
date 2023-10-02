
abstract class ObjetBase {
        protected ObjetBase suivant;
        private String descriptionParDefaut() { return "description par defaut";}
        protected abstract String description();
        public String getDescription()
        {
            String resultat;
            resultat=this.description();
            if(resultat!=null)
                return resultat;
            if (suivant!=null)
                return suivant.getDescription();
            else return this.descriptionParDefaut();
        }
        public void setSuivant(ObjetBase suivant) {this.suivant = suivant;}
    }
class Vehicule extends ObjetBase {
    String description;
    public Vehicule(String description) {
        this.description=description;
    }
    protected String description(){ return description;}
}
class Modele extends ObjetBase {
    String nom_modele, description;
    public Modele(String nom_modele,String description)
    {this.nom_modele=nom_modele;this.description=description;}
    protected String description() {
        if (nom_modele !=null &&description!=null) return
                "modele"+nom_modele+ ":"+description;
        else return null;
    }}


class Marque extends ObjetBase {
    String nom_marque, nom_modele, description;
    public Marque(String nom_marque, String nom_modele, String
            description)
    {this.description=description;this.nom_marque=nom_marque;this.nom_modele=nom_modele;}
    protected String description()
    {String description1=nom_modele+description;
        if (nom_marque!=null&& nom_modele!=null && description!=null)
            return "marque"+nom_marque+":"+description1;
        else return null;
    }
}


public class Cos{
    public static void main(String args[]){
        ObjetBase vehicule1 = new Vehicule ("Auto++ kt500 vehicule d'occasion en bon etat");
        System.out.println(vehicule1.getDescription());
        ObjetBase modele1=new Modele("kt400", "Le vehicule spacieux et confortable");
        ObjetBase vehicule2 = new Vehicule(null);
        vehicule2.setSuivant(modele1);
        System.out.println(vehicule2.getDescription());
        ObjetBase marque1=new Marque("Auto++","La marque des autos", "de grande qualite");
        ObjetBase modele2=new Modele("kt700", null);
        modele2.setSuivant(marque1);
        ObjetBase vehicule3= new Vehicule(null);
        vehicule3.setSuivant(modele2);
        System.out.println(vehicule3.getDescription());
        ObjetBase vehicule4= new Vehicule(null);
        System.out.println(vehicule4.getDescription());
    }}