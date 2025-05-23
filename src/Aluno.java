
import java.util.ArrayList;
import java.util.List;


public class Aluno {

    private String nome,curso;
    private int matricula;
    private List<Disciplina> historico;

//construtor/inicializador
public Aluno(String nome ,int matricula ,String curso){
this.nome = nome;
this.matricula = matricula;
this.curso = curso;
this.historico = new ArrayList<>();
}

//getters
public String getnome(){ return nome;}
public int getmatricula(){return matricula;}
public String getcurso(){return curso;}
public List<Disciplina> getHistorico() { return historico; }

//setters(editar)
public void setnome(String nome){this.nome = nome;}
public void setmatricula(int matricula){this.matricula = matricula;}//imutavel
public void setcurso(String curso){this.curso = curso;}

public void adDDisciplinaCursadas(Disciplina disciplina) {
  if (!historico.contains(disciplina)) {
  historico.add(disciplina);}
}

//verificar se já cursou a disciplina
public boolean jaCursou(Disciplina d) {
 return historico.contains(d); //TorF 
}

//nâo é alunoEspecial
public boolean ehEspecial(){return false;}


  @Override
  public String toString() {
  return nome + " | Matrícula: " + matricula + " | Curso: " + curso ;
    } 
 }









