// classe base para perfil
import java.time.Instant;

enum Funcao {
    Administrativo, Aluno, Professor, Visitante
}

class Perfil{
    private String nome;
    private Funcao funcao;
    private long matricula;
    private Instant horaEntrada;
    private Instant horaSaida;

    Perfil(String nome, Funcao funcao, long matricula, Instant horaEntrada, Instant horaSaida){
        this.nome = nome;
        this.funcao = funcao;
        this.matricula = matricula;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    @Override
    public String toString() {
        return "Perfil [nome=" + nome + ", funcao=" + funcao + ", matricula=" + matricula + ", horaEntrada="
                + horaEntrada + ", horaSaida=" + horaSaida + "]";
    }

    
     
}


class PerfilBuilder{
    private String nome;
    private Funcao funcao;
    private long matricula;
    private Instant horaEntrada;
    private Instant horaSaida;

    public PerfilBuilder addNome(String nome){
        this.nome = nome;
        return this;
    }

    
    public PerfilBuilder addFuncao(Funcao funcao){
        this.funcao = funcao;
        return this;
    }
    
    public PerfilBuilder addMatricula(long matricula){
        this.matricula = matricula;
        return this;
    }
    
    public PerfilBuilder addHoraEntrada(Instant horaEntrada){
        this.horaEntrada = horaEntrada;
        return this;
    }
    
    public PerfilBuilder addHoraSaida(Instant horaSaida){
        this.horaSaida = horaSaida;
        return this;
    }

    public Perfil construir(){
        return new Perfil(this.nome, this.funcao, this.matricula, this.horaEntrada, this.horaSaida);

    }

}


public class Builder02{
    public static void main(String[] args) {
        PerfilBuilder builder = new PerfilBuilder();

        Perfil perfil1 = builder
            .addFuncao(Funcao.Administrativo)
            .addNome("Lucas")
            .addMatricula(00000)
            .addHoraEntrada(Instant.now())
            .addHoraSaida(Instant.now())
            .construir();

         Perfil perfil2 = builder
            .addFuncao(Funcao.Aluno)
            .addNome("Stela")
            .addMatricula(74282)
            .addHoraEntrada(Instant.now())
            .addHoraSaida(Instant.now())
            .construir();
        
        System.out.println(perfil1.toString());
        System.out.println(perfil2.toString());

    }
}