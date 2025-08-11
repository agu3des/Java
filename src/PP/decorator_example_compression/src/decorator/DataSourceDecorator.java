package decorator;

/**
 * Decorador Base.
 * Este possui um campo para referenciar um “objeto envolvido”. O tipo do campo deve ser declarado
 * como do tipo da interface Component, para que possa conter ambos os componentes concretos 
 * e até outro  decorador.
 * 
 * O decorador base delega todas as operações para o objeto envolvido
 * 
 * @author Alex Cunha
 *
 */
public class DataSourceDecorator implements DataSource {

    private DataSource wrapee;

    DataSourceDecorator(DataSource source) {
        this.wrapee = source;
    }

    @Override
    public void writeData(String data) {
        wrapee.writeData(data);
    }

    @Override
    public String readData() {
        return wrapee.readData();
    }

}
