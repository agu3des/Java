package decorator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

/**
 * "Concrete Component" do Padrão decorator. 
 *  É a classe de objetos que está sendo “envolvida” pelo wrapper. Ela define o comportamento básico, 
 *  que pode ser alterado pelos decoradores
 * @author Alex Cunha
 *
 */
public class FileDataSource implements DataSource {
    private String name;
    
    public FileDataSource(String name) {
        this.name = name;
    }
    
    public void setName(String newName) {
    	this.name = newName;
    }
    
    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
            System.out.println("Data saved in " + file.getName() + " by class " + this.getClass().getName());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}
