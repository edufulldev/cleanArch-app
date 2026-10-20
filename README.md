# 🏛️ Java 17 — Clean Architecture

Projeto desenvolvido em **Java 17** com o objetivo de aplicar os princípios da **Clean Architecture**, promovendo a separação de responsabilidades, 
o isolamento das regras de negócio e a independência em relação a frameworks, bancos de dados e tecnologias externas.

A aplicação implementa um fluxo de gerenciamento de usuários, explorando conceitos de arquitetura de software, Domain-Driven Design (DDD), inversão de dependência, 
injeção de dependência e testes unitários.

## 🎯 Objetivos do projeto

- Compreender a importância de uma arquitetura bem definida para o desenvolvimento de sistemas eficientes, testáveis e sustentáveis.
- Aplicar os princípios da Clean Architecture para separar as regras de negócio dos detalhes de infraestrutura.
- Manter a lógica de negócio concentrada no domínio, protegendo a integridade das informações.
- Compreender as semelhanças e diferenças entre Clean Architecture, Hexagonal Architecture e Onion Architecture.
- Implementar testes unitários para validar as regras de negócio.
- Aplicar os padrões de projeto Factory e Builder na criação de objetos.
- Implementar persistência de dados utilizando Spring Data JPA.
- Compreender o fluxo de execução entre as camadas da aplicação.
- Facilitar a evolução do sistema e a substituição de tecnologias externas com impacto mínimo no domínio.

## 🧱 Fundamentos da Clean Architecture

A Clean Architecture propõe uma organização na qual as regras de negócio são independentes dos mecanismos externos utilizados pela aplicação.

O principal princípio aplicado neste projeto é a **regra de dependência**: as dependências do código devem apontar para dentro, em direção às regras de negócio mais estáveis.

### Organização conceitual das camadas

```text
┌─────────────────────────────────────┐
│           Presentation              │
│       Controller / DTO              │
├─────────────────────────────────────┤
│            Application              │
│       Use Cases / Services           │
├─────────────────────────────────────┤
│               Domain                │
│       Entities / Business Rules      │
├─────────────────────────────────────┤
│            Infrastructure           │
│      JPA / Database / Adapters       │
└─────────────────────────────────────┘
```

O diagrama representa as responsabilidades conceituais da arquitetura. A organização física dos pacotes pode variar conforme a implementação.

### Responsabilidades das principais camadas

- **Domain:** contém as entidades de domínio e as regras de negócio, sem depender de detalhes de infraestrutura.
- **Application:** coordena os casos de uso e define as operações disponíveis para a aplicação.
- **Presentation:** recebe as requisições HTTP, valida os dados de entrada e expõe os resultados por meio de DTOs.
- **Infrastructure:** implementa os mecanismos externos, como persistência com JPA, acesso ao banco de dados e adaptadores.

Essa divisão reduz o acoplamento e facilita a manutenção, a evolução e os testes da aplicação.

## 🔄 Arquiteturas estudadas

### Clean Architecture

Organiza o sistema em camadas concêntricas de responsabilidade, priorizando a independência das regras de negócio em relação aos detalhes externos.

### Hexagonal Architecture

Também conhecida como Ports and Adapters, utiliza portas para definir contratos de comunicação e adaptadores para conectar a aplicação a tecnologias externas.

### Onion Architecture

Organiza o sistema em camadas ao redor do domínio, colocando as regras de negócio no centro e direcionando as dependências para dentro.

### Semelhanças e diferenças

As três arquiteturas buscam reduzir o acoplamento, facilitar os testes e proteger o domínio das mudanças tecnológicas.

A principal diferença está na forma de organizar e representar as responsabilidades e os limites da aplicação. Na prática, elas compartilham princípios semelhantes e 
podem ser combinadas em uma mesma solução.

## 👤 Gerenciamento de usuários

O projeto implementa a listagem de usuários e demonstra como os dados percorrem as diferentes camadas da aplicação.

### Principais componentes

| Componente | Responsabilidade |
|---|---|
| `Usuario` | Representar o conceito de usuário no domínio e concentrar as regras de negócio. |
| `UsuarioEntity` | Representar a estrutura de persistência, utilizando anotações JPA. |
| `UsuarioRepository` | Abstrair as operações de persistência por meio do Spring Data JPA e `JpaRepository`. |
| `Mapper` | Converter objetos de domínio em entidades de persistência e vice-versa. |
| `DTO` | Definir a estrutura dos dados recebidos ou retornados pela API. |
| `Controller` | Receber as requisições HTTP e encaminhar as operações para a camada responsável. |
| `Use Cases` | Coordenar as operações da aplicação, mantendo as responsabilidades bem definidas. |
| `Configuration` | Configurar os beans necessários para a injeção de dependência. |

Os nomes e as responsabilidades específicas dos componentes devem acompanhar a estrutura efetivamente implementada no código.

## 🔁 Fluxo da aplicação

O fluxo de comunicação entre as camadas segue a seguinte ideia:

1. O cliente envia uma requisição HTTP.
2. O Controller recebe a requisição e interpreta os dados de entrada.
3. O caso de uso executa a operação solicitada.
4. As regras de negócio são aplicadas no domínio.
5. A abstração de persistência é utilizada para consultar ou gravar os dados.
6. O adaptador de infraestrutura utiliza o Spring Data JPA para interagir com o banco de dados.
7. O Mapper converte os dados entre o domínio e o modelo de persistência, quando necessário.
8. O resultado é convertido para DTO e retornado ao cliente.

Esse fluxo demonstra como cada camada contribui para a execução da operação sem concentrar todas as responsabilidades em uma única classe.

## 🧪 Testes unitários

Os testes unitários são utilizados para validar as regras de negócio de forma isolada, sem depender necessariamente de banco de dados, servidor HTTP ou infraestrutura externa.

O projeto explora o JUnit, incluindo a anotação `@Test` e o método `assertThrows`, da classe `Assertions`.

Exemplo de utilização:

```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UsuarioTest {

    @Test
    void deveLancarExcecaoQuandoDadosForemInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Executar a operação com dados inválidos
            // e validar a exceção esperada.
        });
    }
}
```

O exemplo ilustra o uso de `assertThrows`; a operação e as condições de validação devem ser adaptadas às regras reais implementadas no domínio.

### Benefícios dos testes

- Validar regras de negócio independentemente da infraestrutura.
- Detectar regressões durante alterações no código.
- Facilitar refatorações com maior segurança.
- Reduzir o custo de manutenção.
- Garantir que a substituição de banco de dados, framework ou interface não altere inadvertidamente o comportamento esperado do domínio.

## 🏭 Padrões de projeto

### Factory

O padrão Factory centraliza ou abstrai a criação de objetos, permitindo controlar as regras de instanciação e evitar a duplicação de lógica de construção.

### Builder

O padrão Builder facilita a construção de objetos com múltiplos atributos, tornando a instanciação mais legível e permitindo organizar melhor a criação de objetos complexos.

A utilização desses padrões contribui para um código mais organizado, expressivo e fácil de manter, desde que seja adequada às necessidades de cada objeto.

## 💉 Inversão de controle e injeção de dependência

O projeto utiliza uma classe de configuração para definir os beans necessários à aplicação.

A **Inversão de Controle (IoC)** transfere ao container a responsabilidade de gerenciar a criação e o ciclo de vida dos objetos.
A **Injeção de Dependência (DI)** permite fornecer a uma classe as dependências de que ela precisa, em vez de criá-las diretamente.

Esses conceitos favorecem o baixo acoplamento, simplificam a substituição de implementações e tornam os componentes mais fáceis de testar.

## 🗄️ Persistência e independência tecnológica

Um dos principais aprendizados do projeto foi compreender como a separação entre domínio e infraestrutura facilita a implementação de novas formas de persistência.

Ao utilizar abstrações para acessar os dados, torna-se possível adicionar ou substituir implementações de persistência sem modificar diretamente as regras de negócio.

Essa abordagem permite evoluir a infraestrutura com menor impacto sobre o restante da aplicação.

**Importante:** essa independência depende do correto direcionamento das dependências. Para preservar a Clean Architecture, 
as regras de negócio não devem depender diretamente de classes específicas do Spring Data JPA ou de entidades de persistência.

## ⚖️ Vantagens e desafios

### Vantagens

- Separação clara de responsabilidades.
- Baixo acoplamento entre domínio e infraestrutura.
- Maior facilidade para criar testes unitários.
- Manutenção e evolução mais previsíveis.
- Flexibilidade para substituir tecnologias externas.
- Melhor organização das regras de negócio.
- Maior facilidade para compreender o fluxo da aplicação.

### Desafios

- Maior quantidade inicial de classes e interfaces.
- Necessidade de definir corretamente os limites entre as camadas.
- Custo inicial de implementação superior ao de estruturas mais simples.
- Possibilidade de criar abstrações desnecessárias em projetos pequenos.
- Necessidade de disciplina para manter as dependências direcionadas corretamente.

A escolha da arquitetura deve considerar o tamanho, a complexidade, os requisitos e as perspectivas de evolução do sistema.

## 🛠️ Tecnologias e conceitos

- Java 17
- Spring Boot
- Spring Data JPA
- JPA / Hibernate
- JUnit 5
- Clean Architecture
- Hexagonal Architecture
- Onion Architecture
- Inversão de Controle (IoC)
- Injeção de Dependência (DI)
- Factory e Builder
- Testes unitários
- DTO e Mapper
- Separação entre domínio e infraestrutura


## 🚀 Próximas evoluções

- Ampliar as operações de gerenciamento de usuários, incluindo criação, atualização e exclusão.
- Implementar testes de integração para os adaptadores de persistência.
- Adicionar documentação da API com OpenAPI/Swagger.
- Avaliar a utilização de diferentes implementações de persistência.
- Aprimorar o tratamento de exceções e a validação das requisições.
- Adicionar testes para os casos de uso e para os principais cenários de negócio.

---

**Projeto de estudo:** aplicação prática dos princípios da Clean Architecture com Java 17, voltada à compreensão de arquitetura de software, regras de negócio, testabilidade e independência tecnológica.
