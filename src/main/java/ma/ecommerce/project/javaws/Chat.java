package ma.ecommerce.project.javaws;

public class Chat extends Felin implements Animal{

    private String nom;
    private int age;
    private int poilLongueur;

    public Chat(String nom, int age, int poilLongueur) {
        this.nom = nom;
        this.age = age;
        this.poilLongueur = poilLongueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoilLongueur() {
        return poilLongueur;
    }

    public void setPoilLongueur(int poilLongueur) {
        this.poilLongueur = poilLongueur;
    }

    @Override
    public String son() {
        return "Miaou";
    }
}
