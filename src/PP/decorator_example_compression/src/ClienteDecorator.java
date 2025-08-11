import decorator.CompressionDecorator;
import decorator.DataSource;
import decorator.DataSourceDecorator;
import decorator.EncryptionDecorator;
import decorator.FileDataSource;

public class ClienteDecorator {
    
	public static void main(String[] args) {
		String fileName = "D:/temp/OutputDemoOriginal.txt";
		
        String salaryRecords = "Modelo,Preco\nOnix,82500\nCruze,151600\nEquinox,211890\nTracker,120990";
        
        FileDataSource fds = new FileDataSource(fileName);
        System.out.println("----- writeData() --------");
        fds.writeData(salaryRecords);
        System.out.println("------ readData() --------");
        System.out.println(fds.readData());
        System.out.println();
        
        fds.setName( fileName );
        EncryptionDecorator ed = new EncryptionDecorator( fds );
        System.out.println("----- EncryptionDecorator --------");
        System.out.println("----- writeData() --------");
        ed.writeData(salaryRecords); // Dados são salvos criptografados
        System.out.println("------ readData() --------");
        System.out.println(ed.readData()); // Dados são lidos descriptografados
        System.out.println();
        
        fds.setName( fileName );       
        // Combinando decoradores
        DataSourceDecorator encoded = new CompressionDecorator( ed );        
        // decorador com compressão e encryptação
        encoded.writeData(salaryRecords); // Dados são encriptografados e comprimido
        DataSource plain = new FileDataSource( fileName );

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords); // Dados em string, normais
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData()); // Aqui traz os dados já criptografados como um char[] bytes (não mostra os dados reais)
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData()); //// Dados são encriptografados e comprimido
    }
}
