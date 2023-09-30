import java.util.ArrayList;
import java.util.List;

// Classe Produto
class Produto {
    private String descricao;
    private double preco;

    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return descricao + " - R$" + preco;
    }
}

// Classe Burguer
class Burguer {
    private int gramas;

    public Burguer(int gramas) {
        this.gramas = gramas;
    }

    public int getGramas() {
        return gramas;
    }

    @Override
    public String toString() {
        return gramas + "g Burguer";
    }
}

// Classe Sobremesa
class Sobremesa {
    private String tamanho;

    public Sobremesa(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return tamanho + " Sobremesa";
    }
}

// Classe Bebida
class Bebida {
    private int ml;

    public Bebida(int ml) {
        this.ml = ml;
    }

    public int getMl() {
        return ml;
    }

    @Override
    public String toString() {
        return ml + "ml Bebida";
    }
}

// Classe Combo (Facade)
class Combo {
    private List<Produto> itens = new ArrayList<>();

    public void criarComboMaster() {
        Produto burguer = new Produto("Combo Master", 15.99);
        Produto sobremesa = new Produto("Sobremesa", 5.99);
        Produto bebida = new Produto("Bebida", 3.99);

        itens.add(burguer);
        itens.add(sobremesa);
        itens.add(bebida);
    }

    public void criarSuperCombo() {
        Produto burguer = new Produto("Super Combo", 19.99);
        Produto sobremesa = new Produto("Sobremesa", 5.99);
        Produto bebida = new Produto("Bebida", 3.99);

        itens.add(burguer);
        itens.add(sobremesa);
        itens.add(bebida);
    }

    public List<Produto> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Produto item : itens) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Selecione seu combo");
        System.out.println("1. Combo Master");
        System.out.println("2. Super Combo");
        System.out.print("Sua escolha: ");

        Scanner input = new Scanner(System.in);

        int tipo = input.nextInt();
        Combo combo = new Combo();

        if (tipo == 1) {
            combo.criarComboMaster();
        } else if (tipo == 2) {
            combo.criarSuperCombo();
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.println("Itens do combo:");
        List<Produto> itensDoCombo = combo.getItens();
        for (Produto item : itensDoCombo) {
            System.out.println(item);
        }
    }
}
