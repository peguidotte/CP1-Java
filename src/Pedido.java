import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {
    private String endereco;
    private List<Produto> itens;
    private List<Integer> quantidades;
    private double total;
    private String status;

    public Pedido(String endereco) {
        this.endereco = endereco;
        this.itens = new ArrayList<>();
        this.quantidades = new ArrayList<>();
        this.total = 0;
        this.status = "Pendente";
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.estoqueFaltando(quantidade)) {
            this.itens.add(produto);
            this.quantidades.add(quantidade);
            this.total += produto.getPreco() * quantidade;
        } else {
            System.out.println("Estoque insuficiente para " + produto.getNome());
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            this.total -= this.total * (percentual / 100);
        }
    }

    public void exibirPedido() {
        System.out.println("Endereço: " + endereco + " - Pedido (Status: " + status + "):");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println(quantidades.get(i) + "x " + itens.get(i).getNome() + " - R$ " + (itens.get(i).getPreco() * quantidades.get(i)));
        }
        System.out.println("Total: R$ " + total);
    }

    public int pedidoMaiorTempo() {
        int maiorDemorado = 0;
        for (Produto item: itens) if (item.getTempoPreparo() > maiorDemorado) maiorDemorado = item.getTempoPreparo();
        return maiorDemorado;
    }

}
