public class Main {
    public static void main(String[] args) {

        Produto ps5 = new Eletronico("Play Station 5", 5000, 10);
        Produto mortadela = new Frios("mortadela perdigao 150g", 7.99F, 10, "2025-08-30");
        Produto mussarela = new Frios("mussarela perdigao 150g", 12.99F, 50, "2025-12-9");
        Produto camiseta = new Roupa("camiseta SOAD", 49.99F, 1, 'g');
        Produto bacon1 = new Frios("bacon sadia 250g", 14.99F, 150, "2025-12-1");
        Produto bacon2 = new Frios("bacon perdigao 300g", 17.99F, 200, "2025-12-1");

        Loja.adicionarProduto(ps5);
        Loja.adicionarProduto(mortadela);
        Loja.adicionarProduto(mussarela);
        Loja.adicionarProduto(camiseta);
        Loja.adicionarProduto(bacon1);
        Loja.adicionarProduto(bacon2);

        Loja.printEstoque();

        Pedido pedido1 = new Pedido();
        pedido1.adicionarProduto(ps5, 5);
        pedido1.adicionarProduto(camiseta, 1);
        pedido1.adicionarProduto(bacon2, 100);
        pedido1.setDescontoPercentual(10);
        pedido1.setDescontoFixo(50);

        pedido1.printPedido();
        pedido1.finalizarPedido();

        Loja.printEstoque();
    }
}