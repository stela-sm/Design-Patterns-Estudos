
class Tipo{
    public String tipo = null;
    Tipo(String tipo){
        this.tipo = tipo;
    }
}

class Tamanho{
    public String tamanho;
    Tamanho(String tamanho){
        this.tamanho = tamanho;
    }
}


class Cor{
    public String cor;
    Cor(String cor){
        this.cor = cor;
    }
}


class Preco{
    public float preco;
    Preco(float preco){
        this.preco = preco;
    }
}

class Roupa{
    public Preco preco;
    public Tamanho tamanho;
    public Cor cor;
    public Tipo tipo;
    Roupa(Tipo tipo, Cor cor, Tamanho tamanho, Preco preco){
        this.cor = cor;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.preco = preco;
    }
    public String toString(){
        return "Cor: " + this.cor.cor + " | Tipo: " + this.tipo.tipo +  " | Tamanho: " + this.tamanho.tamanho + " | Preço: " + this.preco.preco;
    }
}

class RoupaBuilder{
    public Preco preco;
    public Tamanho tamanho;
    public Cor cor;
    public Tipo tipo;

    public RoupaBuilder addPreco(float preco){
        this.preco = new Preco(preco);
        return this;
    }
    
    public RoupaBuilder addTamanho(String tamanho){
        this.tamanho = new Tamanho(tamanho);
        return this;
    }
    
    public RoupaBuilder addCor(String cor){
        this.cor = new Cor(cor);
        return this;
    }
    
    public RoupaBuilder addTipo(String tipo){
        this.tipo = new Tipo(tipo);
        return this;
    }

    public Roupa contruir(){
        return new Roupa(this.tipo, this.cor, this.tamanho, this.preco);
    }
}






public class Builder01 {

 public static void main(String[] args) {

    RoupaBuilder builder = new RoupaBuilder();

    Roupa roupa1 = builder
        .addCor("roxo")
        .addPreco(29)
        .addTamanho("M")
        .addTipo("Camiseta")
        .contruir();

    System.out.println(roupa1.toString());
}
    
}
