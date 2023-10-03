//Classe DataAdaptee - Pattern Adapter-Objet
class DataAdaptee{
    public void PrintAdaptee(){
        System.out.println("Je suis de la classe DataAdaptee");
    }
}
//Classe DataAdapterAbstract - Pattern Adapter-Objet
abstract class DataAdapterAbstract{
    public abstract void Print(); }

//Classe DataAdapterConcrete - Pattern Adapter-Objet
class DataAdapterConcrete extends DataAdapterAbstract{
    private DataAdaptee aDataAdaptee;
    public DataAdapterConcrete(){
        aDataAdaptee = new DataAdaptee(); }
    public void Print(){    aDataAdaptee.PrintAdaptee();}}


//Classe AdapterDemo - Pattern Adapter-Objet
public class AdapterDemo{
    private DataAdapterAbstract aDataTarget;
    public AdapterDemo(){
        aDataTarget = new DataAdapterConcrete();
        aDataTarget.Print();
    }
    public static void main(String [] args){
        new AdapterDemo();}}