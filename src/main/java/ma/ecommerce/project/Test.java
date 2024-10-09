package ma.ecommerce.project;

import ma.ecommerce.project.javaws.Animal;
import ma.ecommerce.project.javaws.Chat;
import ma.ecommerce.project.javaws.Chien;

public class Test {
    public static void main(String[] args) {
        Chat chat = new Chat("chatton",2,6);

        System.out.println(chat.computeAge());
    }
}
