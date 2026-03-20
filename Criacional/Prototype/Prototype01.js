//Classe Pessoa que será clonada
class Pessoa {
    constructor(id, nome, idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }
 
    // método clone para realizar uma cópia superficial do objeto
    clone() {
        return new Pessoa(this.id, this.nome, this.idade);
    }
}
 
// classe GerenciaPessoa para gerenciar instâncias de Pessoa
class GerenciaPessoa {
    constructor() {
        this.pessoas = {};
    }
 
    // adiciona uma nova pessoa ao dicionário
    addPessoa(id, nome, idade) {
        const pessoa = new Pessoa(id, nome, idade);
        this.pessoas[id] = pessoa;
    }
 
    // retorna uma cópia da pessoa pelo id
    getPessoaById(id) {
        const pessoaOriginal = this.pessoas[id];
        if (pessoaOriginal) {
            return pessoaOriginal.clone();
        }
        return null;
    }
}
 
// criando uma instância
const gerencia = new GerenciaPessoa();
 
gerencia.addPessoa(1, "João", 30);
gerencia.addPessoa(2, "Maria", 25);
gerencia.addPessoa(3, "Carlos", 40);
 
// clonando a primeira pessoa
const pessoaClone = gerencia.getPessoaById(1);
 
// modificando o clone
if (pessoaClone) {
    pessoaClone.nome = "Novo João";
}
 
// exibindo resultados
console.log("Pessoa Original:");
console.log(gerencia.pessoas[1]);
 
console.log("Pessoa Clone:");
console.log(pessoaClone);