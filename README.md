ShoeMarket
Bem-vindo ao ShoeMarket, uma plataforma de e-commerce para venda de calçados personalizados. Este sistema permite aos clientes criar tênis e botas únicos, acompanhar o status de pedidos em tempo real e gerenciar o estoque de forma eficiente. Utiliza padrões de projeto como Estado, Cadeia de Responsabilidade, Decorador, Fábrica e Singleton para garantir modularidade, escalabilidade e uma experiência de usuário fluida.
Funcionalidades

Personalização de Calçados: Adicione cadarços coloridos ou solas extras a tênis e botas.
Gerenciamento de Pedidos: Acompanhe o ciclo de vida do pedido (Processando, Em Transporte, Entregue) com notificações automáticas para os clientes.
Validação de Pedidos: Verifique endereço, CPF e método de pagamento usando uma cadeia de validadores.
Gestão de Estoque: Controle o inventário com um Singleton para acesso centralizado.
Entrega Flexível: Escolha entre entrega expressa via motoboy ou transportadora.

Pré-requisitos

Java: JDK 17 ou superior.
Maven: Para gerenciamento de dependências (opcional, se configurado).
Git: Para clonar o repositório.
IDE: Recomenda-se IntelliJ IDEA, Eclipse ou VS Code com extensões Java.

Instalação

Clone o repositório:
git clone https://github.com/seu-usuario/shoemarket.git
cd shoemarket


Compile o projeto:

Se usar Maven (certifique-se de ter um pom.xml configurado):mvn clean install


Ou compile manualmente:javac src/main/java/com/shoemarket/*.java




Execute o projeto:

Crie uma classe principal (ex.: Main.java) para testar as funcionalidades (veja a seção "Uso").
Execute:java -cp src/main/java com.shoemarket.Main





Uso
Exemplo de Código
Crie uma classe Main.java no pacote com.shoemarket para testar o sistema:
package com.shoemarket;

public class Main {
    public static void main(String[] args) {
        // Criar dados do pedido
        PedidoDados dados = new PedidoDados("Rua Exemplo, 123", "12345678901", "Cartão de Crédito");

        // Configurar cadeia de validadores
        PedidoValidador validador = new ValidadorEndereco();
        validador.setProximo(new ValidadorCPF());
        validador.setProximo(new ValidadorPagamento());

        // Validar pedido
        if (validador.validar(dados)) {
            // Criar cliente e pedido
            Cliente cliente = new Cliente("Maria Oliveira");
            Pedido pedido = new Pedido();
            pedido.adicionarObservador(cliente);

            // Personalizar calçado
            CalcadoFactory factory = new TenisFactory();
            Calcado calcado = factory.criarCalcado();
            System.out.println("Calçado: " + calcado.descricao() + ", Preço: R$" + calcado.preco());

            // Avançar estados do pedido
            System.out.println("Status inicial: " + pedido.getStatus());
            pedido.avancarEstado();
            System.out.println("Status após avanço: " + pedido.getStatus());
            System.out.println("Status do cliente: " + cliente.getStatusAtual());

            // Gerenciar estoque
            Estoque estoque = Estoque.getInstancia();
            estoque.adicionar(calcado.descricao(), 10);
            System.out.println("Estoque de " + calcado.descricao() + ": " + estoque.verificar(calcado.descricao()));

            // Configurar entrega
            EntregaFactory entregaFactory = new EntregaMotoboyFactory();
            Entrega entrega = entregaFactory.criarEntrega();
            System.out.println("Método de entrega: " + entrega.realizarEntrega());
        } else {
            System.out.println("Dados do pedido inválidos.");
        }
    }
}

Instruções de Uso

Personalizar Calçado:

Use TenisFactory ou BotaFactory para criar calçados com personalizações automáticas (cadarços coloridos para tênis, solas extras para botas).
Exemplo: Calcado calcado = new TenisFactory().criarCalcado();.


Fazer Pedido:

Crie um PedidoDados com endereço, CPF (11 dígitos) e método de pagamento.
Valide os dados usando a cadeia de validadores (ValidadorEndereco, ValidadorCPF, ValidadorPagamento).
Associe um cliente ao pedido com pedido.adicionarObservador(cliente).


Acompanhar Pedido:

Avance o status do pedido com pedido.avancarEstado().
Verifique o status do cliente com cliente.getStatusAtual() para confirmar notificações.


Gerenciar Estoque:

Acesse o estoque com Estoque.getInstancia().
Adicione produtos com estoque.adicionar(nome, quantidade) e consulte com estoque.verificar(nome).


Configurar Entrega:

Use EntregaMotoboyFactory para criar uma entrega expressa via motoboy.
Exemplo: Entrega entrega = new EntregaMotoboyFactory().criarEntrega();.



Estrutura do Projeto
shoemarket/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── shoemarket/
│   │   │   │   │   ├── Cliente.java
│   │   │   │   │   ├── Pedido.java
│   │   │   │   │   ├── PedidoState.java
│   │   │   │   │   ├── PedidoProcessando.java
│   │   │   │   │   ├── PedidoEmTransporte.java
│   │   │   │   │   ├── PedidoEntregue.java
│   │   │   │   │   ├── PedidoValidador.java
│   │   │   │   │   ├── ValidadorEndereco.java
│   │   │   │   │   ├── ValidadorCPF.java
│   │   │   │   │   ├── ValidadorPagamento.java
│   │   │   │   │   ├── PedidoDados.java
│   │   │   │   │   ├── Calcado.java
│   │   │   │   │   ├── TenisBase.java
│   │   │   │   │   ├── BotaBase.java
│   │   │   │   │   ├── CadarcoColorido.java
│   │   │   │   │   ├── SolaExtra.java
│   │   │   │   │   ├── CalcadoFactory.java
│   │   │   │   │   ├── TenisFactory.java
│   │   │   │   │   ├── BotaFactory.java
│   │   │   │   │   ├── Transporte.java
│   │   │   │   │   ├── Transportadora.java
│   │   │   │   │   ├── Motoboy.java
│   │   │   │   │   ├── Entrega.java
│   │   │   │   │   ├── EntregaExpressa.java
│   │   │   │   │   ├── EntregaFactory.java
│   │   │   │   │   ├── EntregaMotoboyFactory.java
│   │   │   │   │   ├── Estoque.java
│   │   │   │   │   ├── Main.java
├── README.md
├── pom.xml (opcional, se usar Maven)

Criando o Repositório no GitHub

Acesse o GitHub:

Faça login em github.com.
Clique em New no canto superior direito.


Configure o repositório:

Nome: shoemarket
Descrição: "Plataforma de e-commerce para calçados personalizados."
Visibilidade: Escolha Público ou Privado.
Marque Add a README file (pode substituir pelo conteúdo acima).
Opcional: Adicione .gitignore para Java e licença (ex.: MIT).


Inicialize o repositório local:

No diretório do projeto:git init
git add .
git commit -m "Inicializa projeto ShoeMarket"
git branch -M main
git remote add origin https://github.com/seu-usuario/shoemarket.git
git push -u origin main

