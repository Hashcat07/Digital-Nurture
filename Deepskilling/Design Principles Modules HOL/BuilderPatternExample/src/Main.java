public class Main {
    static void main() {
        Computer work=new Computer.Builder().setRam("8GB").setCpu("Intel i5").setStorage("512GB SSD").setWifi(false).build();

        Computer gaming=new Computer.Builder().setRam("32GB").setCpu("Intel i9").setStorage("2TB SSD").setWifi(true).build();

        System.out.println(work);
        System.out.println(gaming);
    }

}
