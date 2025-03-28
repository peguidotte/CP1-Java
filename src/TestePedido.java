import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestePedido {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        List<Produto> cardapio = new ArrayList<>();
        cardapio.add(new Produto("Pizza", 40.0, 10, 20, 4.5));
        cardapio.add(new Produto("Hamburguer", 25.0, 95, 15, 4.7));
        cardapio.add(new Produto("Suco de Laranja", 8.0, 100, 5, 4.3));
        // cardapio.add(new Produto("Vinho", 90, 30, 1, 5));
        // cardapio.add(new Produto("Carbonara", 65, 23, 40, 4.9));

        System.out.println("\nEndereço: ");
        String endereco = scanner.nextLine();
        Pedido pedido = new Pedido(endereco);

        while (true) {
            System.out.println("\nMenu:");
            for (int i = 0; i < cardapio.size(); i++) {
                Produto produto = cardapio.get(i);
                System.out.println((i + 1) + " - " + produto.getNome() + " (R$ " + produto.getPreco() + ") Nota: " + produto.getNota());
            }
            System.out.println("0 - Finalizar pedido");
            System.out.println("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) break;
            if (opcao < 1 || opcao > cardapio.size()) {
                System.out.println("Opção inválida!");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            pedido.adicionarItem(cardapio.get(opcao - 1), quantidade);
        }

        System.out.println("\nAguarde, estamos analisando seu pedido...");
        Thread.sleep(2000);
        pedido.exibirPedido();

        System.out.print("\nTem cupom de desconto? (Digite a porcentagem ou 0 para nenhum): ");
        double desconto = scanner.nextDouble();
        if (desconto > 0) {
            pedido.aplicarDesconto(desconto);
            System.out.println("\nNovo total com desconto: R$ " + pedido.getTotal());
        }

        Thread.sleep(2000);
        pedido.setStatus("Confirmado");
        System.out.println("\nPedido confirmado!\nTempo aproximado de espera: " + pedido.pedidoMaiorTempo() + " minutos\nMuito obrigado!");
        scanner.close();
    }
}