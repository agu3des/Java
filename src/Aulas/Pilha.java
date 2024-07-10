import java.util.ArrayList;
//classe genérica, vira uma lista de qualquer coisa

public class Pilha<T> {
    private ArrayList<T> dados = new ArrayList<>(); 
                    //<T> o usuário que irá dizer o que quer
    public void empilhar(T s) {
        dados.add(s); //adicionar um elemento na lista
    }

    public void desempilhar() throws Exception{
        if(! this.estaVazia()){
            dados.remove(dados.size()-1);
        }
        throw new Exception("A pilha está vazia.");
    }

    public boolean estaVazia() {
        return dados.isEmpty();
    }
    
    public T topo() {
        if (!estaVazia()) {
            return dados.get(dados.size() - 1);
        } else {
            return null;
        }
    }
    
    public void esvaziar() {
        dados.clear();
    }

    public int tamanho() {
        return dados.size();
    }

    public String toString() {
        return "Pilha" + dados.toString();
    }
}