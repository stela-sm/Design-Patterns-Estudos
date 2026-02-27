//PRODUTOS ABSTRADOS
class GatewayPagamento{
    autorizar(valor){
        throw new Error("autorizar() deve ser implementado.")
    }
}

class Recibo{
    gerar(valor){
        throw new Error("gerar() deve ser implementado.")
    }
}

//PRODUTOS CONCRETOS
class GatewayPayPal extends GatewayPagamento{
    autorizar(valor){
        return `Paypal: Pagamento de R${valor.toFixed(2)} autorizado.` 
    }
}

class ReciboPayPal extends Recibo{
    gerar(valor){
        return `PayPal: Recibo do pagamento de R${valor.toFixed(2)}.`
    }

}


class GatewayMercadoPago extends GatewayPagamento{
    autorizar(valor){
        return `Mercado Pago: Pagamento de R${valor.toFixed(2)} autorizado.`
    }
}

class ReciboMercadoPago extends Recibo{
    gerar(valor){
        return `Mercado Pago: Recibo da pagamento de R${valor.toFixed(2)}.`
    }
}


//  FÁBRICA ABSTRATA
class FabricaPagamento{
    criatGateway(){
        throw new Error("criarGateway() deve ser implementado")
    }

    criarRecibo(){
        throw new Error("criarRecibo() deve ser implementado")
    }
}


//FABRICA CONCRETA

class FabricaPayPal{
    criarGateway(){
        return new GatewayPayPal;
    }

    criarRecibo(){
        return new ReciboPayPal;
    }
}


class FabricaMercadoPago{
    criarGateway(){
        return new GatewayMercadoPago;
    }

    criarRecibo(){
        return new ReciboMercadoPago
    }
}



//MAIN
function finalizarCompra(fabrica, valor){
    const gateway = fabrica.criarGateway();
    const recibo = fabrica.criarRecibo();

    console.log(gateway.autorizar(valor));
    
    console.log(recibo.gerar(valor));
}

finalizarCompra(new FabricaPayPal(), 100.99 )
console.log("*************************")
finalizarCompra(new FabricaMercadoPago(),3100.99 )
console.log("*************************")
finalizarCompra(new FabricaPayPal(), 180.99 )
console.log("*************************")
finalizarCompra(new FabricaMercadoPago(), 1008.99 )