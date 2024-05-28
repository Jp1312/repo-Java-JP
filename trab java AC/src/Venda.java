import java.util.*;
import java.text.SimpleDateFormat;

public class Venda {
    private String data;
    private String nomeCliente;
    private List<ItemVenda> itens;

    public Venda(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.itens = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void adicionarItem(int codigoProduto, int quantidade) {
        itens.add(new ItemVenda(codigoProduto, quantidade));
    }

    public double calcularTotal(List<Produto> produtos) {
        double total = 0.0;
        for (ItemVenda item : itens) {
            for (Produto produto : produtos) {
                if (produto.getCodigo() == item.getCodigoProduto()) {
                    total += produto.getPreco() * item.getQuantidade();
                    break;
                }
            }
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(data).append(";").append(nomeCliente);
        for (ItemVenda item : itens) {
            sb.append(";").append(item);
        }
        return sb.toString();
    }
}
