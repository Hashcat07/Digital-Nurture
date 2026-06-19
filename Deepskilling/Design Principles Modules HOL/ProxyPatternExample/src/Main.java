public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("my_photo.jpg");

        System.out.println("First call:");
        image.display();

        System.out.println("\nSecond call:");
        image.display();
    }
}