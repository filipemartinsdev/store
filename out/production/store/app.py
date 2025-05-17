from abc import ABC, abstractmethod

# Conceito de Abstração e Encapsulamento
class Produto:
    def __init__(self, id_produto, nome, preco):
        self.id_produto = id_produto  # Atributo público
        self._nome = nome             # Atributo "protegido" (indicado pelo underscore)
        self._preco = preco           # Atributo "protegido"

    def get_preco(self):
        return self._preco

    def get_nome(self):
        return self._nome

# Conceito de Herança e Polimorfismo com diferentes tipos de produtos
class ProdutoEletronico(Produto):
    def __init__(self, id_produto, nome, preco, garantia):
        super().__init__(id_produto, nome, preco)
        self.garantia = garantia  # Garantia em meses

class ProdutoRoupa(Produto):
    def __init__(self, id_produto, nome, preco, tamanho):
        super().__init__(id_produto, nome, preco)
        self.tamanho = tamanho  # Tamanho da roupa (P, M, G, etc.)

class ProdutoAlimento(Produto):
    def __init__(self, id_produto, nome, preco, validade):
        super().__init__(id_produto, nome, preco)
        self.validade = validade  # Data de validade do produto

class ProdutoFrios(ProdutoAlimento):
    def __init__(self, id_produto, nome, preco, alimento, validade):
        super().__init__(id_produto, nome, preco, validade)

# Abstração para diferentes tipos de desconto
class Desconto(ABC):
    @abstractmethod
    def aplicar_desconto(self, valor_total):
        pass

# Desconto fixo
class DescontoFixo(Desconto):
    def __init__(self, valor):
        self.valor = valor

    def aplicar_desconto(self, valor_total):
        return max(0, valor_total - self.valor)  # Não deixa o total ser negativo

# Desconto percentual
class DescontoPercentual(Desconto):
    def __init__(self, percentual):
        self.percentual = percentual

    def aplicar_desconto(self, valor_total):
        return valor_total * (1 - self.percentual / 100)

# Encapsulamento e Manipulação de Pedidos
class Pedido:
    def __init__(self):
        self.produtos = []        # Lista de produtos no pedido
        self.desconto = None      # Desconto a ser aplicado

    def adicionar_produto(self, produto):
        self.produtos.append(produto)

    def aplicar_desconto(self, desconto):
        self.desconto = desconto

    def calcular_total(self):
        total = sum(produto.get_preco() for produto in self.produtos)
        if self.desconto:
            total = self.desconto.aplicar_desconto(total)
        return total

    def listar_produtos(self):
        for produto in self.produtos:
            print(f"Produto: {produto.get_nome()} - Preço: R${produto.get_preco()}")

# Exemplo de uso:
# Criando produtos
produto1 = ProdutoEletronico(1, "Smartphone", 1200, 12)
produto2 = ProdutoRoupa(2, "Camiseta", 50, "M")
produto3 = ProdutoAlimento(3, "Chocolate", 10, "2024-12-31")
produto4 = ProdutoAlimento(4, "Mortadela", 7.99, "2024-12-31")

# Criando pedido e adicionando produtos
pedido = Pedido()
pedido.adicionar_produto(produto1)
pedido.adicionar_produto(produto2)
pedido.adicionar_produto(produto3)
pedido.adicionar_produto(produto4)


# Aplicando desconto percentual de 10%
desconto_percentual = DescontoPercentual(10)
pedido.aplicar_desconto(desconto_percentual)

# Listando produtos e calculando total
pedido.listar_produtos()
print(f"Total com desconto: R${pedido.calcular_total():.2f}")
