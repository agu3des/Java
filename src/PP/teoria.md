## Parte 1 - Padrões Iniciais 

### Tabela Comparativa 

| Critério | Simple Factory | Null Object | Strategy | Bridge | Template Method | Factory Method |
|----------|----------------|-------------|----------|--------|-----------------|----------------|
| **Objetivo** | Encapsular criação de objetos | Evitar uso de `null` | Encapsular algoritmos | Separar abstração/implementação | Definir esqueleto de algoritmo | Delegar criação a subclasses |
| **Tipo** | Criacional | Comportamental | Comportamental | Estrutural | Comportamental | Criacional |
| **Instanciação** | Método estático | Objeto nulo | Injeção de estratégias | Separação de camadas | Subclasses implementam | Método abstrato |
| **DI** | Opcional | Comum | Essencial | Sim | Não necessária | Sim |
| **Herança** | Opcional | Opcional | Interface comum | Hierarquia dupla | Subclasse obrigatória | Hierarquia necessária |
| **Extensibilidade** | Média | Alta | Alta | Alta | Média | Alta |
| **Aplicação** | Centralização | Eliminar null checks | Comportamentos variáveis | Variações independentes | Algoritmo com partes variáveis | Controle de instanciação |
| **Vantagens** | Simplicidade | Código limpo | Flexibilidade | Desacoplamento | Reuso | Encapsulamento |
| **Desvantagens** | Pouca flexibilidade | Pode ocultar erros | Mais classes | Complexidade | Rígido | Mais classes |



## Parte 2 - Padrões Adicionados

### Tabela Comparativa

| Critério | Abstract Factory | Observer | State | Chain of Responsibility | Mediator | Adapter |
|----------|------------------|----------|-------|--------------------------|----------|---------|
| **Objetivo** | Criar famílias de objetos | Notificar mudanças | Gerenciar estados | Encadeamento de handlers | Centralizar comunicação | Adaptar interfaces |
| **Tipo** | Criacional | Comportamental | Comportamental | Comportamental | Comportamental | Estrutural |
| **Instanciação** | Fábricas de produtos | Registro de observers | Transição de estados | Cadeia dinâmica | Mediador central | Wrapper |
| **DI** | Sim | Sim | Sim | Sim | Sim | Sim |
| **Herança** | Hierarquia dupla | Assinatura comum | Estados compartilhados | Interface comum | Interface mediador | Herança/composição |
| **Extensibilidade** | Alta | Alta | Alta | Alta | Média | Alta |
| **Aplicação** | Produtos relacionados | Atualizações em cascata | Máquinas de estado | Processamento sequencial | Sistemas complexos | Integração legada |
| **Vantagens** | Consistência | Baixo acoplamento | Elimina condicionais | Flexibilidade | Organização | Reuso |
| **Desvantagens** | Complexidade | Notificações excessivas | Muitas classes | Fluxo obscuro | Ponto único de falha | Overhead |

