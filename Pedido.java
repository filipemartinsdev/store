import java.util.ArrayList;
import java.util.List;

class Pedido {
    private static int ultimoIdPedido = 0;
    private int ID;

    private float totalDescontoAplicado = 0.00F;
    private float descontoFixo;
    private int descontoPercentual;

    private float totalValorProdutos;
    private float totalValorPedido;
    private int quantidadeItens;

    private List<Produto> itens = new ArrayList<>();

    // private HashMap<Integer, Produto> itens = new HashMap<>();

    public Pedido(float desconto){
        this.descontoFixo = desconto;
        this.totalDescontoAplicado = desconto;
        this.ID = ++(Pedido.ultimoIdPedido);
        System.out.println("> Pedido "+this.ID+" criado");
    }
    public Pedido(){
        // this.ID = Loja.getUltimoIdPedido();
        this.ID = ++(Pedido.ultimoIdPedido);
        System.out.println("> Pedido "+this.ID+" criado");
    }

    public int getID(){
        return this.ID;
    }
    public float getDescontoAplicado(){
        return this.totalDescontoAplicado;
    }

    public void setDescontoFixo(float desconto){
        this.descontoFixo = desconto;
        this.totalDescontoAplicado = this.descontoFixo + (float)this.descontoPercentual/100 * this.totalValorProdutos;
        this.totalValorPedido = this.totalValorProdutos - this.totalDescontoAplicado;
    }
    public void setDescontoPercentual(int porcentagem) {
        this.descontoPercentual = porcentagem;
        this.totalDescontoAplicado = this.descontoFixo + (float)this.descontoPercentual/100 * this.totalValorProdutos;
    }

    public boolean adicionarProduto(Produto produto, int quantidade){
        if(produto.quantidadeEmEstoque - produto.getQuantidadeEmPedido() < quantidade) return false;
        this.itens.add(produto);
        this.totalValorProdutos += produto.precoUnitario * quantidade;
        this.totalValorPedido = this.totalValorProdutos - this.totalDescontoAplicado;
        produto.incrementarQuantidadeEmPedido(quantidade);
        return true;
    }

    public void printPedido(){
        System.out.println("==============================Pedido===============================+");
        System.out.printf("%-10s%-30s%-15s%-15s\n", "ID", "| Descricao", "| Preco uni.", "| Quantidade");
        System.out.println("+------------------------------------------------------------------+");

        for(Produto item : this.itens){
            System.out.printf("%-10s%-30s%-15s%-15s\n",
                    item.ID,
                    "| "+item.nome,
                    "| "+item.precoUnitario,
                    "| "+item.getQuantidadeEmPedido()
            );
        }
        System.out.println("+------------------------------------------------------------------+");
        System.out.printf("ID do pedido: %d\n", this.ID);
        System.out.printf("Desconto fixo = R$%.2f\n", this.descontoFixo);
        System.out.println("Desconto percentual = " + this.descontoPercentual+"%");
        System.out.printf("Desconto total = R$%.2f\n", this.totalDescontoAplicado);
        System.out.printf("Valor dos produtos = R$%.2f\n", this.totalValorProdutos);
        System.out.printf("Valor do pedido = R$%.2f\n", this.totalValorPedido);
        System.out.println("+------------------------------------------------------------------+\n");
    }

    public void finalizarPedido(){
        for(Produto item:this.itens){
            item.quantidadeEmEstoque -= item.getQuantidadeEmPedido();
            Loja.atulizarEstoque();
        }
        System.out.println("> Pedido "+this.ID+" finalizado!");
    }
}
