class Motor:
    def __init__(self, tipo):
        self.tipo = tipo


class Roda:
    def __init__(self, tamanho):
        self.tamanho = tamanho


class Interior:
    def __init__(self, cor):
        self.cor = cor


class Carroceria:
    def __init__(self, estilo):
        self.estilo = estilo


class CarroBuilder:
    def __init__(self):
        self.motor = None
        self.roda = None
        self.interior = None
        self.carroceria = None

    def addMotor(self, tipo):
        self.motor = Motor(tipo)
        return self

    def addRoda(self, tamanho):
        self.roda = Roda(tamanho)
        return self

    def addInterior(self, cor):
        self.interior = Interior(cor)
        return self

    def addCarroceria(self, estilo):
        self.carroceria = Carroceria(estilo)
        return self

    def construir(self):
        return Carro(self.motor, self.carroceria, self.roda, self.interior)


class Carro:
    def __init__(self, motor, carroceria, rodas, interior):
        self.motor = motor
        self.carroceria = carroceria
        self.rodas = rodas
        self.interior = interior

    def mostrarDetalhes(self):
        print(f"""
Carro composto por:
Motor: {self.motor.tipo}
Carroceria: {self.carroceria.estilo}
Roda: {self.rodas.tamanho}
Interior: {self.interior.cor}
""")


builder = CarroBuilder()

carro1 = builder \
    .addMotor("1.0") \
    .addCarroceria("Pickup") \
    .addRoda(15) \
    .addInterior("Rosa") \
    .construir()

carro2 = builder \
    .addMotor("2.0") \
    .addCarroceria("SUV") \
    .addRoda(18) \
    .addInterior("Preto") \
    .construir()

carro1.mostrarDetalhes()
carro2.mostrarDetalhes()