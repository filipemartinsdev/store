import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Loja {
    private static HashMap<Integer, Produto> estoque = new HashMap<>();

    private static int quantidadeDeProdutos = 0;
    private static int quantidadePedidosEmAberto = 0;
    private static List<Pedido> pedidosEmAberto = new ArrayList<>();

    public static int getQuantidadePedidosEmAberto(){
        return quantidadePedidosEmAberto;
    }

    public static void atulizarEstoque(){
        for(Produto produto:Loja.estoque.values()){
            if(produto.quantidadeEmEstoque == 0) produto.estaDisponivel = false;
        }
    }

    public static void adicionarProduto(Produto produto){
        Loja.estoque.put(produto.ID, produto);
        Loja.quantidadeDeProdutos++;
    }

    public static void removerProduto(Produto produto){
        Loja.estoque.remove(produto.ID);
        Loja.quantidadeDeProdutos--;
    }

    public static int getQuantidadeEmEstoque(Produto produto){
        return Loja.estoque.get(produto.ID).quantidadeEmEstoque;
    }

    public static void printEstoque(){
        System.out.println("+==============================ESTOQUE==============================+");
        System.out.printf("%-10s%-30s%-15s%-15s\n", "ID", "| "+"Descricao", "| "+"Preco uni.", "| "+"Quantidade");
        System.out.println("+-------------------------------------------------------------------+");
        for(Integer ID:Loja.estoque.keySet()){
            System.out.printf("%-10s%-30s%-15s%-15s\n",
                    ID,
                    "| "+Loja.estoque.get(ID).nome,
                    "| "+Loja.estoque.get(ID).precoUnitario,
                    "| "+Loja.estoque.get(ID).quantidadeEmEstoque);
        }
        System.out.println("+-------------------------------------------------------------------+\n");
    }
}