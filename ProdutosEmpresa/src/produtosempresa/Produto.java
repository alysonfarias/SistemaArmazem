package produtosempresa;

public class Produto implements Comparable<Produto> {

    private String codigo;
    private int qtdEmEstoque;
    private double preco;
    private String desc; //descrição
    private String fornecedor;

    public Produto(String codigo, int qtdEmEstoque, double preco, String desc, String fornecedor) {
        this.codigo = codigo;
        this.qtdEmEstoque = qtdEmEstoque;
        this.preco = preco;
        this.desc = desc;
        this.fornecedor = fornecedor;
    }
    public Produto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

    public int getQtdEmEstoque() {
        return qtdEmEstoque;
    }

    public void setQtdEmEstoque(int qtdEmEstoque) {
        this.qtdEmEstoque = qtdEmEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString(){
        return "[Código: " + this.getCodigo()
                + " | Fornecedor: "+ this.getFornecedor()
                + " | Preço: " + this.getPreco()
                + " | Estoque: " + this.getQtdEmEstoque() +" ]";
    }

    @Override
    public int compareTo(Produto produto) {
        int result;
        result = this.codigo.compareTo(produto.codigo);
        return result;
    }
}
