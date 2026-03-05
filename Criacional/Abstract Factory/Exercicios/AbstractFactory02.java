interface Boleto {
    public String metodo();
}

interface CartaoCredito {
    public String metodo();
}

class CartaoCreditoBanco1 implements CartaoCredito {
    public String metodo() {
        return "Cartão de Crédito do Banco 1";
    }
}

class BoletoBanco1 implements Boleto {
    public String metodo() {
        return "Boleto do Banco 1";
    }
}

class CartaoCreditoBanco2 implements CartaoCredito {
    public String metodo() {
        return "Cartão de Crédito do banco 2";
    }
}

class BoletoBanco2 implements Boleto {
    public String metodo() {
        return "Boleto do banco 2";
    }
}

interface FabricaDePagamentos {
    public CartaoCredito cartaoCredito();

    public Boleto boleto();
}

class PagamentoBanco01 implements FabricaDePagamentos {
    @Override
    public CartaoCredito cartaoCredito() {
        return new CartaoCreditoBanco1();
    }

    @Override
    public Boleto boleto() {
        return new BoletoBanco1();
    }
}

class PagamentoBanco02 implements FabricaDePagamentos {
    @Override
    public CartaoCredito cartaoCredito() {
        return new CartaoCreditoBanco2();
    }

    @Override
    public Boleto boleto() {
        return new BoletoBanco2();
    }
}

public class AbstractFactory02 {
    // aqui é mais uma questão de teste mesmo
    public static FabricaDePagamentos fabrica = new PagamentoBanco01();

    public static void main(String[] args) {
        CartaoCredito cartao = fabrica.cartaoCredito();
        Boleto boleto = fabrica.boleto();

        System.out.println(cartao.metodo());
        System.out.println(boleto.metodo());
    }

}
