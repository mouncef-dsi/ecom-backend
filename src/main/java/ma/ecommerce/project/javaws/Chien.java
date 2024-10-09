package ma.ecommerce.project.javaws;

public class Chien implements Animal {

    private String nom;
    private int age;

    public Chien(String nom, int age) {
        this.nom = nom;
        this.age = age;
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

    @Override
    public String son() {
        return "Haw";
    }
}
