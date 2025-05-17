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

class Roupa extends Produto {
    char tamanho;
    Roupa(String nome, float preco, int quantidade, char tamanho) {
        super(nome, preco, quantidade);
        this.tamanho = tamanho;
    }
}
class Alimento extends Produto {
    String validade;
    Alimento(String nome, float preco, int quantidade, String validade) {
        super(nome, preco, quantidade);
        this.validade = validade;
    }
}
class Eletronico extends Produto {
    Eletronico(String nome, float preco, int quantidade) {
        super(nome, preco, quantidade);
    }
}
class Frios extends Alimento {
    Frios(String nome, float preco, int quantidade, String validade){
        super(nome, preco, quantidade, validade);
    }
}