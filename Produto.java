public abstract class Produto {
    float precoUnitario;
    String nome;
    int quantidadeEmEstoque;
    boolean estaDisponivel;
    int ID;
    private int quantidadeEmPedido;
    private static int ultimoID;

    Produto(String nome, float preco, int quantidade){
        this.nome = nome;
        this.precoUnitario = preco;
        this.quantidadeEmEstoque = quantidade;
        this.quantidadeEmPedido = 0;
        this.ID = ++ultimoID;

        if (quantidade > 0) {
            this.estaDisponivel = true;
        }
    }

    Produto(){
        this.precoUnitario = 0;
        this.quantidadeEmEstoque = 0;
        this.quantidadeEmPedido = 0;
        this.ID = ++ultimoID;
        this.estaDisponivel = false;
    }

    public int getQuantidadeEmPedido(){
        return this.quantidadeEmPedido;
    }
    public void setQuantidadeEmPedido(int valor){
        quantidadeEmPedido = valor;
    }
    public void incrementarQuantidadeEmPedido(int valor){
        this.quantidadeEmPedido+=valor;
    }
    public void incrementarQuantiadeEmPedido(){
        this.quantidadeEmPedido++;
    }
}
