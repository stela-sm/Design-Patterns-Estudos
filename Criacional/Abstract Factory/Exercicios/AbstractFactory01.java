public interface Veiculo {
    void exibirInfo();
}

public class Carro implements Veiculo {

    @Override
    public void exibirInfo() {
        System.out.println("Carro - Transporte Terrestre");
    }
}

public class Onibus implements Veiculo {

    @Override
    public void exibirInfo() {
        System.out.println("Ônibus - Transporte Terrestre");
    }
}

public class Helicoptero implements Veiculo {

    @Override
    public void exibirInfo() {
        System.out.println("Helicóptero - Transporte Aéreo");
    }
}

public class Aviao implements Veiculo {

    @Override
    public void exibirInfo() {
        System.out.println("Avião - Transporte Aéreo");
    }
}

public interface FabricaTransporte {

    Veiculo criarVeiculoIndividual();

    Veiculo criarVeiculoColetivo();
}

public class FabricaTerrestre implements FabricaTransporte {

    @Override
    public Veiculo criarVeiculoIndividual() {
        return new Carro();
    }

    @Override
    public Veiculo criarVeiculoColetivo() {
        return new Onibus();
    }
}

public class FabricaAerea implements FabricaTransporte {

    @Override
    public Veiculo criarVeiculoIndividual() {
        return new Helicoptero();
    }

    @Override
    public Veiculo criarVeiculoColetivo() {
        return new Aviao();
    }
}

public class Aplicacao {

    public static void main(String[] args) {

        // Escolha da fábrica
        FabricaTransporte fabrica = new FabricaTerrestre();

        Veiculo individual = fabrica.criarVeiculoIndividual();
        Veiculo coletivo = fabrica.criarVeiculoColetivo();

        individual.exibirInfo();
        coletivo.exibirInfo();
    }
}