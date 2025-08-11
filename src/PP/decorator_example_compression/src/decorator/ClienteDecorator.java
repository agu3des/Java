package decorator;

public class ClienteDecorator {
    public static void main(String[] args) {
    	String path = "D:/temp/";
        String salaryRecords = "Modelo,Preco\nOnix,82500\nCruze,151600\nEquinox,211890\nTracker,120990";
        DataSourceDecorator encoded = new CompressionDecorator(
                                         new EncryptionDecorator(
                                             new FileDataSource(path + "OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource( path + "OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
