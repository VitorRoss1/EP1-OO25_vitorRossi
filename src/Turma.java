import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String professor,semestre,horario,sala,codigoDisciplinaTurma;
    private boolean presencial; 
    private int capacidadeTurma;
    private List<Aluno> matriculados;

 //construtor 
  public Turma (String professor,String semestre,String horario,String sala,boolean presencial,int capacidadeTurma)
   {
        this.codigoDisciplinaTurma = codigoDisciplinaTurma;
        this.professor = professor;
        this.semestre = semestre;
        this.presencial = presencial;
        this.sala = presencial ? sala : "Curso ead"; //se true this.sala = sala,se false this.sala = " " 
        this.horario = horario;
        this.capacidadeTurma = capacidadeTurma;
        this.matriculados = new ArrayList<>();
   }

 //getters(os necessarios para verificaçoes)
   public String getHorario() {return horario;} 
   public String getCodigoDisciplinaTurma() {return codigoDisciplinaTurma;}
   public List<Aluno> getMatriculados() {return matriculados;}


 //METODO MATRICULAR
   public boolean matricular(Aluno alunoX){
    if(matriculados.size() < capacidadeTurma){
        matriculados.add(alunoX); 
        return true; //flag de foi matriculado
    }
    return false;
   }

}
