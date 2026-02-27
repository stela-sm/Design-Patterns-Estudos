#classe base de veiculo

class veiculo:
    def __init__(self, modelo):
        self.modelo = modelo

    def MostrarDetalhes(self):
        print(f'Modelo: {self.modelo}')



#subclasse de veiculo
class Carro(veiculo):
    def __init__(self, modelo):
        super().__init__(modelo) 

class Moto(veiculo):
    def __init__(self, modelo):
        super().__init__(modelo)

class Barco(veiculo):
    def __init__(self,modelo):
        super().__init__(modelo)

# fabrica abstrata de veiculo
class FabricaDeVeiculo:
    def criar_veiculo(self, modelo):
        raise NotImplementedError('O metodo criar veiculo deve ser aplicado')

# fabrica concreta de carros
class FabricaDeCarros(FabricaDeVeiculo):
    def criar_veiculo(self,modelo):
        return Carro(modelo)
# fabrica concreta de motos
class FabricaDeMotos(FabricaDeVeiculo):
    def criar_veiculo(self,modelo):
        return Moto(modelo)
# fabrica concreta de Barcos
class FabricaDeBarcos(FabricaDeVeiculo):
    def criar_veiculo(self,modelo):
        return Barco(Modelo)
# uso do cliente
FabricaDeCarros = FabricaDeCarros()
FabricaDeMotos = FabricaDeMotos()
FabricaDeBarcos = FabricaDeBarcos()

veiculo1 = FabricaDeCarros.criar_veiculo('Sedan')
veiculo2 = FabricaDeCarros.criar_veiculo('Hatch')
veiculo3 = FabricaDeMotos.criar_veiculo('esportiva')
veiculo4 = FabricaDeMotos.criar_veiculo('Hudson')

veiculo1.MostrarDetalhes()
veiculo2.MostrarDetalhes()
veiculo3.MostrarDetalhes()
veiculo4.MostrarDetalhes()