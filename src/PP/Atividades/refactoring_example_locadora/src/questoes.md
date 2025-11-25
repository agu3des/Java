# Tarefa 1

### De acordo com o programa apresentado:
- **Quais as fragilidades que podem ser encontradas com relação a más práticas de programação ou princípios de design OO que não estão sendo contemplados?**
- **O sistema está pronto quando uma nova classificação de filme for adicionada?**
- **E quando houver reajuste de preço?**
- **O código está pronto para executar facilmente um novo esquema de pontos de alugador frequente?**

---

## GRASP

### Como é aplicado?

A classe `Cliente` está criando objetos do tipo `Aluguel` no método `main`. Embora a criação de objetos esteja concentrada no `main` (o que pode ser razoável para testes simples), o padrão **Creator** sugere que a classe mais próxima dos objetos a serem criados seja a responsável por essa criação.

### Por que isso está "parcialmente aplicado"?

O padrão está parcialmente aplicado porque a classe `Cliente` pode ser vista como um candidato para ser a "criadora" de objetos do tipo `Aluguel`, mas a maneira como isso é feito no `main` não reflete totalmente uma boa prática de design. O ideal seria que a responsabilidade pela criação de `Aluguel` fosse melhor distribuída.

---

### Information Expert (Especialista em Informação)

#### Como é violado?

A classe `Cliente` tem que entender detalhes de como calcular o valor do aluguel de DVDs de tipos diferentes (normal, lançamento, infantil), além de calcular pontos para "alugador frequente". No entanto, a classe `Cliente` não deveria conhecer as regras de precificação — isso é um detalhe interno do tipo `DVD` ou da classe `Aluguel`, que é onde essas regras devem ser tratadas.

Portanto, o cálculo de valor e pontos deveria estar encapsulado em classes como `DVD` ou até mesmo em um tipo de estratégia separada, não dentro de `Cliente`.

---

### Low Coupling / High Cohesion (Baixo Acoplamento / Alta Coesão)

#### Como é violado?

A classe `Cliente` está fortemente acoplada a `DVD` e `Aluguel`, pois ela conhece diretamente os tipos de `DVD` e precisa calcular o valor do aluguel com base no tipo de `DVD`. Além disso, a lógica de cálculo está espalhada no próprio `Cliente`, o que prejudica a coesão da classe.

---

### Polymorphism (GoF)

#### Como é violado?

A lógica de precificação está utilizando um `switch-case` no método `extrato()` da classe `Cliente`, onde o tipo de `DVD` é comparado diretamente e o valor é calculado com base nisso. Esse é um exemplo clássico de violação do **polimorfismo**, pois o código não está usando a capacidade de polimorfismo para delegar o cálculo de preço a objetos diferentes com comportamentos distintos.

---

## SOLID

### S (Single Responsibility Principle - SRP)

#### Como é violado?

A classe `Cliente` está cuidando de várias responsabilidades, incluindo:

- Armazenar alugueis.
- Calcular valores dos alugueis.
- Calcular pontos de fidelidade.
- Gerar o extrato completo.

---

### O (Open/Closed Principle - OCP)

#### Como é violado?

Toda vez que adicionar um novo tipo de `DVD`, será necessário modificar a classe `Cliente` para adicionar mais uma condição ao `switch-case` dentro do método `extrato()`. Ou seja, a classe não está fechada para modificações.

---

### L (Liskov Substitution Principle - LSP)

Não há herança no código, então esse princípio **não se aplica diretamente**.

---

### I (Interface Segregation Principle - ISP)

Não há uso de interfaces, portanto esse princípio **não se aplica diretamente**.

---

### D (Dependency Inversion Principle - DIP)

#### Como é violado?

A classe `Cliente` depende diretamente de implementações concretas de `DVD` e `Aluguel`. O correto seria depender de **abstrações** (interfaces), e não de detalhes específicos.

---

# Tarefa `refactoring1-1`

## Identificar blocos coesos:

- Cálculo do valor de cada aluguel.
- Cálculo dos pontos de alugador frequente.

---

## Criar novos métodos:

### Método para calcular o valor de um aluguel:

```java
private double calcularValorDeAluguel(Aluguel aluguel) {
    double valorTotal = 0.0;

    switch(aluguel.getDVD().getCodigoDePreco()) {
        case DVD.NORMAL: 
            valorTotal += 2.0;
            if(aluguel.getDiasAlugado() > 2) {
                valorTotal += (aluguel.getDiasAlugado() - 2) * 1.5;
            }
            break;
        case DVD.LANÇAMENTO: 
            valorTotal += aluguel.getDiasAlugado() * 3.00;
            break;
        case DVD.INFANTIL: 
            valorTotal += 1.5;
            if(aluguel.getDiasAlugado() > 3) {
                valorTotal += (aluguel.getDiasAlugado() - 3) * 1.5;
            }
            break;
    }
    return valorTotal;
}
```

---

### Método para calcular pontos de alugador frequente:

```java
private int calcularPontosDeAlugadorFrequente(Aluguel aluguel) {
    int pontos = 1;
    if(aluguel.getDVD().getCodigoDePreco() == DVD.LANÇAMENTO && aluguel.getDiasAlugado() > 1) {
        pontos++;
    }
    return pontos;
}
```

---

### Refatorar a classe `Cliente`:

- Mover a lógica de cálculo de valor e pontos para métodos dedicados.
- Deixar o método `extrato()` mais limpo.

---

# Tarefa `refactoring1-2`

### Alterar nome da variável para algo mais sugestivo:

```java
private double calcularValorDeAluguel(Aluguel aluguel) {
    double valorTotal = 0.0; // Renomeado de valorCorrente
    // Lógica permanece igual
    return valorTotal;
}
```

---

# Tarefa `refactoring2-1`

### Mover o método `calcularValorDeAluguel()` para a classe `Aluguel`:

```java
public class Aluguel {
    // Atributos e construtor

    public double calcularValorDeAluguel() {
        double valorTotal = 0.0;
        // Lógica de cálculo
        return valorTotal;
    }
}
```

---

### Classe `Cliente`, método `extrato()`:

```java
double valorCorrente = cada.calcularValorDeAluguel();
```

---

# Tarefa `refactoring2-2`

### Refatorar o método `extrato()`:

```java
public String extrato() {
    final String fimDeLinha = System.getProperty("line.separator");
    double valorTotal = 0.0;
    int pontosDeAlugadorFrequente = 0;
    String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

    for (Aluguel cada : dvdsAlugados) {
        double valorCorrente = cada.calcularValorDeAluguel();
        pontosDeAlugadorFrequente += calcularPontosDeAlugadorFrequente(cada);
        resultado += "\t" + cada.getDVD().getTitulo() + "\t R$ " + valorCorrente + fimDeLinha;
        valorTotal += valorCorrente;
    }

    resultado += "Valor total pago: R$ " + valorTotal + fimDeLinha;
    resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";

    return resultado;
}
```

---

# Tarefa `refactoring2-3`

### Mover o cálculo de pontos de alugador frequente para `Aluguel`:

```java
public int calcularPontosDeAlugadorFrequente() {
    int pontos = 1;
    if(dvd.getCodigoDePreco() == DVD.LANÇAMENTO && diasAlugado > 1) {
        pontos++;
    }
    return pontos;
}
```

No método `extrato()`:

```java
pontosDeAlugadorFrequente += cada.calcularPontosDeAlugadorFrequente();
```

---

# Tarefa `refactoring2-4`

### Criar novos métodos na classe `Cliente`:

```java
public double getValorTotal() {
    double valorTotal = 0.0;
    for (Aluguel cada : dvdsAlugados) {
        valorTotal += cada.calcularValorDeAluguel();
    }
    return valorTotal;
}

public int getPontosTotaisDeAlugadorFrequente() {
    int totalPontos = 0;
    for (Aluguel cada : dvdsAlugados) {
        totalPontos += cada.calcularPontosDeAlugadorFrequente();
    }
    return totalPontos;
}
```

