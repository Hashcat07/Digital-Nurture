package Upskilling.java;

public class InheritanceDemo {

    static class Animal {
        void speak() {
            System.out.println("Some generic animal sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void speak() {
            System.out.println("Bark");
        }
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();

        a.speak();
        d.speak();
    }
}