package ma.ecommerce.project;

import ma.ecommerce.project.javaws.Animal;
import ma.ecommerce.project.javaws.Chat;
import ma.ecommerce.project.javaws.Chien;

public class Test {
    public static void main(String[] args) {
        Animal chien = new Chien("luna",10);
        Animal chat = new Chat("chatton",2,4);

        System.out.println(chien.son());
        System.out.println(chat.son());
    }
}
