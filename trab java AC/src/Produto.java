import java.io.Serializable;


//classe produto+metodos
public class Produto implements Serializable {
    private int codigo;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(int codigo, String descricao, double preco, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return codigo + ";" + descricao + ";" + preco + ";" + quantidade;
    }
}
