//PRODUTOS ABSTRADOS
class ProdutoModa{
    toString(){
        throw new Error("criar() deve ser implementado.");
    }
}

class ProdutoEletronico{
    toString(){
        throw new Error("criar() deve ser implementado.");
    }
}

//PRODUTOS CONCRETOS
class CamisaFashion extends ProdutoModa{
    toString(){
        return `Camisa Fashion` ;
    }
}

class CelularFashion extends ProdutoEletronico{
    toString(){
        return `Celular Fashion.`;
    }

}


class CamisaTech extends ProdutoModa{
    toString(){
        return `Camisa Tech` ;
    }
}

class CelularTech extends ProdutoEletronico{
    toString(){
        return `Celular Tech`;
    }

}

//  FÁBRICA ABSTRATA
class FabricaCombo{
    criarCamisa(){
        throw new Error("criarCamisa() deve ser implementado")
    }

    criarCelular(){
        throw new Error("criarCelular() deve ser implementado")
    }
}


//FABRICA CONCRETA

class FabricaComboTech extends FabricaCombo{
    criarCamisa(){
        return new CamisaTech;
    }

    criarCelular(){
        return new CelularTech;
    }
}


class FabricaComboFashion extends FabricaCombo{
    criarCamisa(){
        return new CamisaFashion;
    }

    criarCelular(){
        return new CelularFashion;
    }
}



//MAIN
function lojaVirtual(fabrica){
    const camisa = fabrica.criarCamisa();
    const celular = fabrica.criarCelular();

    console.log(camisa.toString());
    console.log(celular.toString());
}

console.log("Combo fashion: ")
lojaVirtual(new FabricaComboFashion())

console.log("-------")

console.log("Combo tech: ")
lojaVirtual(new FabricaComboTech())
