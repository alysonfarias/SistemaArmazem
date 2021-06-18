package produtosempresa;

import java.util.Scanner;

public class CadastroProdutos {

    public static Scanner sc = new Scanner(System.in);

    ABB<Produto> armazem = new ABB();

    void inserir(Produto prod) {
        if (prod != null) {
            armazem.insert(prod);
            System.out.println("Produto Inserido");
        }

    }

    void mostrarTodosProdutos() {
        armazem.mostrarNos();
    }

    private Produto procurarCodigo(String cod) {
        Produto aux = new Produto(cod);
        Produto valor = armazem.procurarNo(aux);
        return valor;
    }

    public void alterarPreco(String cod) {
        Produto aux = procurarCodigo(cod);
        if (aux != null) {
            System.out.println("Digite o novo preço");
            double preco = sc.nextDouble();
            aux.setPreco(preco);
            System.out.println("Preço atualizado!");
        } else {
            System.err.println("Codigo não encontrado");
        }

    }

    
    public void alterarQtdEstoque(String cod) {
        Produto aux = procurarCodigo(cod);
        if (aux != null) {
            System.out.println("Digite o novo preço");
            int qtd = sc.nextInt();
            aux.setQtdEmEstoque(qtd);
            System.out.println("Preço atualizado!");
        } else {
            System.err.println("Codigo não encontrado");
        }
    }

    
    public void exibirInfoUnico(String cod) {
        Produto aux = procurarCodigo(cod);
        if (aux != null) {
            System.out.println(aux);
        } else {
            System.err.println("Codigo não encontrado");
        }

    }

    
    public void removerProduto(String cod) {
        Produto aux = procurarCodigo(cod);
        if (aux != null) {
            armazem.remover(aux);
            System.out.println("Produto removido");
        } else {
            System.err.println("Codigo não encontrado");
        }

    }
    

}
