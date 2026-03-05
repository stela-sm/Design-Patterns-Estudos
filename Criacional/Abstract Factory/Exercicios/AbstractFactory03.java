interface Botao {
    public String toString();
}

interface Janela {
    public String toString();
}

class BotaoWindows implements Botao {
    @Override
    public String toString() {
        return "Esse é um botão do windows.";
    }
}

class BotaoMacOS implements Botao {
    @Override
    public String toString() {
        return "Esse é um botão do MacOS.";
    }
}

class BotaoLinux implements Botao {
    @Override
    public String toString() {
        return "Esse é um botão do Linux.";
    }
}

class JanelaWindows implements Janela {
    @Override
    public String toString() {
        return "Essa é uma janela do windows.";
    }
}

class JanelaMacOS implements Janela {
    @Override
    public String toString() {
        return "Essa é uma janela do MacOS.";
    }
}

class JanelaLinux implements Janela {
    @Override
    public String toString() {
        return "Essa é uma janela do Linux.";
    }
}

interface FabricaDeElementos {

    public Botao criarBotao();

    public Janela criarJanela();
}

class FabricaDeElementosWindows implements FabricaDeElementos {
    @Override
    public Botao criarBotao() {
        return new BotaoWindows();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaWindows();
    }

}

class FabricaDeElementosMacOS implements FabricaDeElementos {
    @Override
    public Botao criarBotao() {
        return new BotaoMacOS();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaMacOS();
    }

}

class FabricaDeElementosLinux implements FabricaDeElementos {
    @Override
    public Botao criarBotao() {
        return new BotaoLinux();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaLinux();
    }

}

public class AbstractFactory03 {
    //aqui é mais uma questão de teste mesmo
    public static FabricaDeElementos fabrica = new FabricaDeElementosLinux();

    public static void main(String[] args) {
        Botao botao = fabrica.criarBotao();
        Janela janela = fabrica.criarJanela();

        System.out.println(botao.toString());
        System.out.println(janela.toString());
    }

}