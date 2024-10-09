package ma.ecommerce.project.javaws;

public abstract class Felin {
    // elle peut avoir des methodes abstraites et des methodes concrètes


    abstract int getPoilLongueur();

    public int computeAge(){ // méthode concrète
        if(getPoilLongueur()>5 && getPoilLongueur()<10){
            return 3;
        }
        else if(getPoilLongueur()>10){
            return 7;
        }
        return 10;
    }
}
