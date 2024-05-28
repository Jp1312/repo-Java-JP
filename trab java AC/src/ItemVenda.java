public class ItemVenda {
    private int codigoProduto;
    private int quantidade;

    public ItemVenda(int codigoProduto, int quantidade) {
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return codigoProduto + ";" + quantidade;
    }
}
