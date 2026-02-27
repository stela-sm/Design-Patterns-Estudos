#PRODUTOS ABSTRATOS

class GatewayPagamento:
    def autorizar(self, valor):
        raise NotImplementedError("autorizar() deve ser implementado")


class Recibo:
    def gerar(self, valor):
        raise NotImplementedError("gerar() deve ser implementado")

#PRODUTOS CONCRETOS - PAYPAL

class GatewayPayPal(GatewayPagamento):
    def autorizar(self, valor):
        return f"PayPal: Pagamento de R$ {valor:.2f} autorizado"

class ReciboPayPal(Recibo):
    def gerar(self, valor):
        return f"PayPal: Recibo do pagamento de R$ {valor:.2f}."

#PRODUTOS CONCRETOS - MERCADOPAGO

class GatewayMercadoPago(GatewayPagamento):
    def autorizar(self, valor):
        return f"Mercado pago: Pagagamento de R$ {valor:.2f} autorizado"


class ReciboMercadoPago(Recibo):
    def gerar(self, valor):
        return f"Mercado Pago: Recibo do pagamento de R$ {valor:.2f}."

#FABRICA ABSTRATA
class FabricaPagamento:
    def criarGateway(self):
        raise NotImplementedError("criarGateway() deve ser implementado")

    def criarRecibo(self):
        raise NotImplementedError("criarRecibo() deve ser implementado")

    
#FABRICA CONCRETA
class FabricaPayPal(FabricaPagamento):
    def criarGateway(self):
        return GatewayPayPal()

    def criarRecibo(self):
        return ReciboPayPal()

class FabricaMercadoPago(FabricaPagamento):
    def criarGateway(self):
        return GatewayMercadoPago()

    def criarRecibo(self):
        return ReciboMercadoPago()


#MAIN

def finalizarCompra(fabrica, valor):
    gateway = fabrica.criarGateway()
    recibo = fabrica.criarRecibo()

    print(gateway.autorizar(valor))
    print(recibo.gerar(valor))


finalizarCompra(FabricaPayPal(), 100.99 )
print("*************************")
finalizarCompra(FabricaMercadoPago(),3100.99 )
print("*************************")
finalizarCompra(FabricaPayPal(), 180.99 )
print("*************************")
finalizarCompra(FabricaMercadoPago(), 1008.99 )