import java.util.List;
import java.util.ArrayList;
class Siga {
    private static Siga instance;

    List<Aluno> alunos;

    private Siga() {
        alunos = new ArrayList<>();
    }

    public static synchronized Siga getInstance() {
        if (instance == null) {
            instance = new Siga();
        }
        return instance;
    }

    public void adicionarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    @Override
    public String toString(){
        return alunos.toString();
    }
}

interface Aluno{
    public Aluno clone();
    
}

class AlunoDiadema implements Aluno{
   private String curso;
    private String nome;
    private String periodo;
    private int idade;
    private String unidade;
    
    public AlunoDiadema() {
        this.unidade = "Fatec Diadema";
}   
    public AlunoDiadema(String curso, String nome, String periodo, int idade, String unidade){
        this.curso = curso;
        this.nome = nome;
        this.periodo = periodo;
        this.idade = idade;
        this.unidade = unidade;
    }

    @Override
    public Aluno clone() {
    return new AlunoDiadema(this.curso, this.nome, this.periodo, this.idade, this.unidade);
    }
    
    public String toString() {
    return "Aluno: " + nome + ", Curso: " + curso + ", Período: " + periodo + ", Idade: " + idade + ", Unidade: " + unidade;
    }
    
    public String getCurso() {
    return curso;
}

public void setCurso(String curso) {
    this.curso = curso;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getPeriodo() {
    return periodo;
}

public void setPeriodo(String periodo) {
    this.periodo = periodo;
}

public int getIdade() {
    return idade;
}

public void setIdade(int idade) {
    this.idade = idade;
}

public String getUnidade() {
    return unidade;
}

public void setUnidade(String unidade) {
    this.unidade = unidade;
}
}

public class Singleton01{
    public static void main(String[] args){
        Siga siga = Siga.getInstance();
        AlunoDiadema aluno1 = new AlunoDiadema();
        aluno1.setNome("Stela");
        aluno1.setCurso("DSM");
        aluno1.setPeriodo("Manhã");
        aluno1.setIdade(19);

        siga.adicionarAluno(aluno1);
        
        AlunoDiadema aluno2 = (AlunoDiadema) aluno1.clone();
        aluno2.setNome("João");
        siga.adicionarAluno(aluno2);
    
        System.out.println(
        siga.toString());
    
    }
}
