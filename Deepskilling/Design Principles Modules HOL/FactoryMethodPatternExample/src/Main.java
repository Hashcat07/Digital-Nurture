public class Main {
    static void main() {
        DocumentFactory factory;

        factory=new WordDocumentFactory();
        factory.createDocument().open();

        factory=new PdfDocumentFactory();
        factory.createDocument().open();

        factory=new ExcelDocumentFactory();
        factory.createDocument().open();
    }
}
