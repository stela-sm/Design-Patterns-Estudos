public class Veiculo {
    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public void mostrarDetalhes() {
        System.out.printf("Modelo: %s", this.modelo)
    }
}

public static void main(String... args) {
    Veiculo veiculo = new Veiculo("Sedan");
    veiculo.mostrarDetalhes
}