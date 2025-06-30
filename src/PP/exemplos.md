## Exemplos 1

### 1. **Simple Factory**
```java
class Pizza {
    void prepare() { System.out.println("Preparando pizza genérica"); }
}

class Calabresa extends Pizza {
    @Override void prepare() { System.out.println("Adicionando calabresa e catupiry"); }
}

class PizzaFactory {
    static Pizza createPizza(String tipo) {
        return switch (tipo) {
            case "Calabresa" -> new Calabresa();
            default -> new Pizza();
        };
    }
}

// Uso:
Pizza minhaPizza = PizzaFactory.createPizza("Calabresa");
minhaPizza.prepare();  // Output: "Adicionando calabresa e catupiry"
```

### 2. **Null Object**
```java
interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    @Override public void log(String message) { System.out.println(message); }
}

class NullLogger implements Logger {
    @Override public void log(String message) { /* Faz nada */ }
}

// Uso:
Logger logger = isTestEnvironment ? new NullLogger() : new ConsoleLogger();
logger.log("Mensagem importante");  // Não faz nada em ambiente de teste
```

### 3. **Strategy**
```java
interface PagamentoStrategy {
    void pagar(double valor);
}

class CartaoCredito implements PagamentoStrategy {
    @Override public void pagar(double valor) { 
        System.out.println("Pagando R$" + valor + " via cartão"); 
    }
}

class Pix implements PagamentoStrategy {
    @Override public void pagar(double valor) { 
        System.out.println("Pagando R$" + valor + " via Pix"); 
    }
}

class Carrinho {
    private PagamentoStrategy estrategia;
    
    void setEstrategia(PagamentoStrategy estrategia) { this.estrategia = estrategia; }
    void checkout(double total) { estrategia.pagar(total); }
}

// Uso:
Carrinho carrinho = new Carrinho();
carrinho.setEstrategia(new Pix());
carrinho.checkout(150.50);  // Output: "Pagando R$150.5 via Pix"
```

### 4. **Bridge**
```java
// Implementação
interface Dispositivo {
    void ligar();
    void desligar();
}

class TV implements Dispositivo {
    @Override public void ligar() { System.out.println("TV ligada"); }
    @Override public void desligar() { System.out.println("TV desligada"); }
}

// Abstração
abstract class ControleRemoto {
    protected Dispositivo dispositivo;
    
    ControleRemoto(Dispositivo dispositivo) { this.dispositivo = dispositivo; }
    abstract void botaoPower();
}

class ControleBasico extends ControleRemoto {
    ControleBasico(Dispositivo dispositivo) { super(dispositivo); }
    
    @Override void botaoPower() { 
        dispositivo.ligar(); 
        dispositivo.desligar();
    }
}

// Uso:
Dispositivo minhaTV = new TV();
ControleRemoto controle = new ControleBasico(minhaTV);
controle.botaoPower();  // Output: "TV ligada" seguido de "TV desligada"
```

### 5. **Template Method**
```java
abstract class Bebida {
    final void preparar() {  // Método template
        ferverAgua();
        prepararIngrediente();
        servir();
    }
    
    abstract void prepararIngrediente();
    void ferverAgua() { System.out.println("Fervendo água"); }
    void servir() { System.out.println("Servindo na xícara"); }
}

class Cha extends Bebida {
    @Override void prepararIngrediente() { 
        System.out.println("Infundindo folhas de chá"); 
    }
}

// Uso:
Bebida meuCha = new Cha();
meuCha.preparar();  
// Output: 
// "Fervendo água"
// "Infundindo folhas de chá"
// "Servindo na xícara"
```

### 6. **Factory Method**
```java
abstract class Documento {
    abstract void abrir();
}

class PDF extends Documento {
    @Override void abrir() { System.out.println("Abrindo PDF com Acrobat"); }
}

abstract class Aplicacao {
    abstract Documento criarDocumento();
    
    void novoDocumento() {
        Documento doc = criarDocumento();
        doc.abrir();
    }
}

class AplicacaoPDF extends Aplicacao {
    @Override Documento criarDocumento() { return new PDF(); }
}

// Uso:
Aplicacao app = new AplicacaoPDF();
app.novoDocumento();  // Output: "Abrindo PDF com Acrobat"
```

### 7. **Abstract Factory**
```java
interface GUIFactory {
    Botao criarBotao();
    Janela criarJanela();
}

class WindowsFactory implements GUIFactory {
    @Override public Botao criarBotao() { return new WindowsBotao(); }
    @Override public Janela criarJanela() { return new WindowsJanela(); }
}

class MacFactory implements GUIFactory {
    @Override public Botao criarBotao() { return new MacBotao(); }
    @Override public Janela criarJanela() { return new MacJanela(); }
}

// Uso:
GUIFactory factory = new MacFactory();
Botao botao = factory.criarBotao();  // Retorna um botão no estilo Mac
```

### 8. **Observer**
```java
import java.util.ArrayList;
import java.util.List;

class SensorTemperatura {
    private List<Observer> observers = new ArrayList<>();
    private double temperatura;
    
    void addObserver(Observer o) { observers.add(o); }
    
    void setTemperatura(double temp) {
        this.temperatura = temp;
        notificarObservers();
    }
    
    private void notificarObservers() {
        for (Observer o : observers) {
            o.atualizar(temperatura);
        }
    }
}

interface Observer {
    void atualizar(double temperatura);
}

class Display implements Observer {
    @Override public void atualizar(double temp) {
        System.out.println("Temperatura atual: " + temp + "°C");
    }
}

// Uso:
SensorTemperatura sensor = new SensorTemperatura();
sensor.addObserver(new Display());
sensor.setTemperatura(25.5);  // Output: "Temperatura atual: 25.5°C"
```

### 9. **State**
```java
interface EstadoPorta {
    void abrir();
    void fechar();
}

class PortaAberta implements EstadoPorta {
    @Override public void abrir() { System.out.println("Porta já está aberta"); }
    @Override public void fechar() { System.out.println("Fechando porta"); }
}

class PortaFechada implements EstadoPorta {
    @Override public void abrir() { System.out.println("Abrindo porta"); }
    @Override public void fechar() { System.out.println("Porta já está fechada"); }
}

class Porta {
    private EstadoPorta estado = new PortaFechada();
    
    void setEstado(EstadoPorta estado) { this.estado = estado; }
    void abrir() { estado.abrir(); }
    void fechar() { estado.fechar(); }
}

// Uso:
Porta porta = new Porta();
porta.abrir();  // Output: "Abrindo porta"
porta.fechar(); // Output: "Fechando porta"
```

### 10. **Chain of Responsibility**
```java
abstract class Aprovador {
    protected Aprovador proximo;
    
    void setProximo(Aprovador proximo) { this.proximo = proximo; }
    abstract void processarPedido(double valor);
}

class Gerente extends Aprovador {
    @Override void processarPedido(double valor) {
        if (valor <= 1000) {
            System.out.println("Aprovado pelo Gerente");
        } else if (proximo != null) {
            proximo.processarPedido(valor);
        }
    }
}

class Diretor extends Aprovador {
    @Override void processarPedido(double valor) {
        if (valor <= 5000) {
            System.out.println("Aprovado pelo Diretor");
        } else {
            System.out.println("Requer aprovação do Conselho");
        }
    }
}

// Uso:
Aprovador gerente = new Gerente();
Aprovador diretor = new Diretor();
gerente.setProximo(diretor);

gerente.processarPedido(800);   // Output: "Aprovado pelo Gerente"
gerente.processarPedido(2500);  // Output: "Aprovado pelo Diretor"
gerente.processarPedido(10000); // Output: "Requer aprovação do Conselho"
```

### 11. **Mediator**
```java
interface MediatorChat {
    void enviar(String msg, Colega remetente);
}

class Colega {
    protected MediatorChat mediator;
    
    Colega(MediatorChat m) { this.mediator = m; }
}

class Usuario extends Colega {
    Usuario(MediatorChat m) { super(m); }
    
    void enviar(String msg) { mediator.enviar(msg, this); }
    void receber(String msg) { System.out.println("Mensagem recebida: " + msg); }
}

class ChatRoom implements MediatorChat {
    @Override public void enviar(String msg, Colega remetente) {
        System.out.println("Mensagem enviada por " + remetente.getClass().getSimpleName());
        // Lógica para distribuir mensagens
    }
}

// Uso:
MediatorChat chat = new ChatRoom();
Usuario user1 = new Usuario(chat);
user1.enviar("Olá pessoal!");  // Output: "Mensagem enviada por Usuario"
```

### 12. **Adapter** (Reiterando os exemplos anteriores)
```java
// Adapter de Classe
class XMLToJSONAdapter extends XMLReader implements JSONReader {
    @Override public String readJSON() { /* conversão */ }
}

// Adapter de Objeto
class LegacyPaymentAdapter implements PaymentProcessor {
    private LegacyPaymentGateway gateway;
    // Implementação com composição
}
```






## Exemplos 2


### 1. **Simple Factory**

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Square"); }
}

class ShapeFactory {
    public static Shape createShape(String type) {
        if (type.equals("circle")) return new Circle();
        if (type.equals("square")) return new Square();
        return null;
    }
}
```

---

### 2. **Null Object**

```java
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() { System.out.println("Bark"); }
}

class NullAnimal implements Animal {
    public void makeSound() { /* nada acontece */ }
}
```

---

### 3. **Strategy**

```java
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCard implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid with Credit Card"); }
}

class Paypal implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid with PayPal"); }
}
```

---

### 4. **Bridge**

```java
interface Renderer {
    void render(String shape);
}

class VectorRenderer implements Renderer {
    public void render(String shape) {
        System.out.println("Drawing " + shape + " as lines");
    }
}

abstract class Shape {
    protected Renderer renderer;
    public Shape(Renderer r) { this.renderer = r; }
    abstract void draw();
}

class Circle extends Shape {
    public Circle(Renderer r) { super(r); }
    void draw() { renderer.render("circle"); }
}
```

---

### 5. **Template Method**

```java
abstract class DataProcessor {
    final void process() {
        readData();
        processData();
        saveData();
    }

    abstract void readData();
    abstract void processData();

    void saveData() {
        System.out.println("Saving data...");
    }
}
```

---

### 6. **Factory Method**

```java
abstract class Dialog {
    abstract Button createButton();

    void renderWindow() {
        Button button = createButton();
        button.render();
    }
}

interface Button {
    void render();
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows button");
    }
}
```

---

### 7. **Abstract Factory**

```java
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}
```

---

### 8. **Observer**

```java
interface Observer {
    void update();
}

class Subject {
    List<Observer> observers = new ArrayList<>();

    void addObserver(Observer o) {
        observers.add(o);
    }

    void notifyAllObservers() {
        for (Observer o : observers)
            o.update();
    }
}
```

---

### 9. **State**

```java
interface State {
    void handle();
}

class OnState implements State {
    public void handle() { System.out.println("Light is ON"); }
}

class OffState implements State {
    public void handle() { System.out.println("Light is OFF"); }
}

class Light {
    private State state;

    void setState(State s) {
        this.state = s;
    }

    void pressSwitch() {
        state.handle();
    }
}
```

---

### 10. **Chain of Responsibility**

```java
abstract class Handler {
    protected Handler next;

    void setNext(Handler next) {
        this.next = next;
    }

    abstract void handle(String request);
}

class AuthHandler extends Handler {
    void handle(String request) {
        if (request.equals("auth"))
            System.out.println("Auth OK");
        else if (next != null)
            next.handle(request);
    }
}
```

---

### 11. **Mediator**

```java
class ChatRoom {
    void showMessage(String user, String message) {
        System.out.println(user + ": " + message);
    }
}

class User {
    private String name;
    private ChatRoom chat;

    public User(String name, ChatRoom chat) {
        this.name = name;
        this.chat = chat;
    }

    public void send(String message) {
        chat.showMessage(name, message);
    }
}
```

---

### 12. **Adapter**

```java
interface Target {
    void request();
}

class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee request");
    }
}

class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee a) {
        this.adaptee = a;
    }

    public void request() {
        adaptee.specificRequest();
    }
}
```