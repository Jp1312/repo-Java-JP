import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Alterar produto");
            System.out.println("3. Registrar venda");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Código: ");
                int codigo = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();
                System.out.print("Preço: ");
                double preco = scanner.nextDouble();
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();

                Produto produto = new Produto(codigo, descricao, preco, quantidade);
                boolean cadastrado = loja.cadastrarProduto(produto);
                if (cadastrado) {
                    System.out.println("Produto cadastrado com sucesso!");
                } else {
                    System.out.println("Produto com esse código já existe!");
                }

            } else if (opcao == 2) {
                System.out.print("Código do produto a alterar: ");
                int codigo = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                Produto produto = loja.buscarProduto(codigo);
                if (produto == null) {
                    System.out.println("Produto não encontrado!");
                    continue;
                }
                System.out.print("Nova descrição: ");
                String novaDescricao = scanner.nextLine();
                System.out.print("Novo preço: ");
                double novoPreco = scanner.nextDouble();
                System.out.print("Nova quantidade: ");
                int novaQuantidade = scanner.nextInt();

                boolean alterado = loja.alterarProduto(codigo, novaDescricao, novoPreco, novaQuantidade);
                if (alterado) {
                    System.out.println("Produto alterado com sucesso!");
                } else {
                    System.out.println("Erro ao alterar produto!");
                }

            } else if (opcao == 3) {
                scanner.nextLine(); // Consumir a nova linha
                System.out.print("Nome do cliente: ");
                String nomeCliente = scanner.nextLine();
                Venda venda = new Venda(nomeCliente);

                while (true) {
                    System.out.print("Código do produto (ou 0 para finalizar): ");
                    int codigoProduto = scanner.nextInt();
                    if (codigoProduto == 0) {
                        break;
                    }
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    Produto produto = loja.buscarProduto(codigoProduto);
                    if (produto == null) {
                        System.out.println("Código do produto não encontrado, tente novamente!");
                        continue;
                    }
                    if (produto.getQuantidade() < quantidade) {
                        System.out.println("Estoque insuficiente!");
                        continue;
                    }

                    venda.adicionarItem(codigoProduto, quantidade);
                }

                boolean registrada = loja.registrarVenda(venda);
                if (registrada) {
                    double total = venda.calcularTotal(loja.getProdutos());
                    System.out.println("Venda registrada com sucesso!");
                    System.out.printf("Total da venda: R$ %.2f%n", total);
                } else {
                    System.out.println("Erro ao registrar venda!");
                }

            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
