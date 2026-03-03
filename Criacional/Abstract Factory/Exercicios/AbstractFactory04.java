
interface RoboMontador {
    public String montar();
}

interface RoboInspetor {
    public String analisar();
}

class RoboMontadorDeCarro implements RoboMontador {
    @Override
    public String montar() {
        return ("Robô montando carro...");
    }
}

class RoboMontadorDeCircuitos implements RoboMontador {
    @Override
    public String montar() {
        return ("Robô montando circuito...");
    }
}

class RoboInspetorDePeca implements RoboInspetor {
    @Override
    public String analisar() {
        return ("Robô analisando a montagem das peças automotivas...");
    }
}

class RoboInspetorDeChips implements RoboInspetor {
    @Override
    public String analisar() {
        return ("Robô analisando a montagem dos chips...");
    }
}

interface FabricaDeRobos {
    public RoboInspetor criarRoboInspetor();

    public RoboMontador criarRoboMontador();
}

class FabricaDeRobosAutomotiva implements FabricaDeRobos {
    @Override
    public RoboInspetor criarRoboInspetor() {
        return new RoboInspetorDePeca();
    }

    @Override
    public RoboMontador criarRoboMontador() {
        return new RoboMontadorDeCarro();
    }
}

class FabricaDeRobosEletronica implements FabricaDeRobos {
    @Override
    public RoboInspetor criarRoboInspetor() {
        return new RoboInspetorDeChips();
    }

    @Override
    public RoboMontador criarRoboMontador() {
        return new RoboMontadorDeCircuitos();
    }
}

public class AbstractFactory04 {
    // aqui é mais uma questão de teste mesmo
    public static FabricaDeRobos fabrica = new FabricaDeRobosAutomotiva();

    public static void main(String[] args) {
        RoboMontador roboMontador = fabrica.criarRoboMontador();
        RoboInspetor roboInspetor = fabrica.criarRoboInspetor();

        System.out.println(roboMontador.montar());
        System.out.println(roboInspetor.analisar());
    }

}
