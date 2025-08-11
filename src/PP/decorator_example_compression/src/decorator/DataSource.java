package decorator;

/**
 * "Component" do padrão Decorator
 * Declara a interface comum tanto para os envoltórios (wrappers) como para os objetos envolvidos
 * @author alexs
 *
 */
public interface DataSource {
    public void writeData(String data);
    public String readData();
}
