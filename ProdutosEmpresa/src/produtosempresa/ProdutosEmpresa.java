package produtosempresa;

import java.util.Scanner;

public class ProdutosEmpresa {

    public static int codigo;

    public static void main(String[] args) {
        CadastroProdutos armazem = new CadastroProdutos();
        Produto prod;
        Scanner sc = new Scanner(System.in);
        short option;
        String desc, fornecedor, cod;
        double preco;
        int qtdEstoque;

        do {
            menu();
            System.out.println("Digite sua opção:");
            option = sc.nextShort();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    desc = sc.nextLine();
                    System.out.println("Digite o fornecedor do produto: ");
                    fornecedor = sc.nextLine();
                    System.out.println("Digite o preço do produto: ");
                    preco = sc.nextDouble();
                    System.out.println("Digite a quantidade em estoque: ");
                    qtdEstoque = sc.nextInt();
                    cod = Integer.toString(codigo++);
                    prod = new Produto(cod, qtdEstoque, preco, desc, fornecedor);
                    armazem.inserir(prod);
                    break;
                case 2:
                    armazem.mostrarTodosProdutos();
                    break;
                case 3:
                    System.out.println("Digite o código do produto que deseja alterar o preço");
                    cod = sc.nextLine();
                    armazem.alterarPreco(cod);
                    break;
                case 4:
                    System.out.println("Digite o código do produto que deseja alterar a quantidade no estoque");
                    cod = sc.nextLine();
                    armazem.alterarQtdEstoque(cod);
                    break;
                case 5:
                    System.out.println("Digite o código para mostrar as informações do produto");
                    cod = sc.nextLine();
                    armazem.exibirInfoUnico(cod);
                    break;
                case 6:
                    System.out.println("Digite o código para remover do armazém");
                    cod = sc.nextLine();
                    armazem.removerProduto(cod);
                    break;

                default:
                    throw new AssertionError();
            }
        } while (option != 0);

    }

    public static void menu() {
        System.out.println("1 - Cadastrar novo produto\n"
                + "2 - Mostrar info de todos os produtos\n"
                + "3 - Alterar preço do produto \n"
                + "4 - Alterar a quantidade em estoque\n"
                + "5 - Exibir as info produto unico\n"
                + "6 - Remover produto do armazem");

    }
}
