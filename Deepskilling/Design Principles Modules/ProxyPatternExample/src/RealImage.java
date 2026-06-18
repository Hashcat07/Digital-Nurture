public class RealImage implements Image{
    private final String fileName;

    public RealImage(String fileName){
        this.fileName=fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading Image form Server: "+fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying: "+fileName);
    }
}
