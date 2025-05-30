import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina; 
    private String professor,semestre,horario,sala; 
    private boolean presencial; 
    private int capacidade;
    private int tipoAvaliacao; // 0 media simples, 1 ponderada
    private List<Aluno> matriculados;
    private List<Aluno> alunosTrancados;

 //construtor 
  public Turma (Disciplina disciplina,String professor,String semestre,String horario,
   String sala,boolean presencial,int capacidade,int tipoAvaliacao)
   {
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.presencial = presencial;
        this.sala = presencial ? sala : "on-line";
        this.horario = horario;
        this.capacidade = capacidade;
        this.tipoAvaliacao = tipoAvaliacao; 
        this.matriculados = new ArrayList<>();
        this.alunosTrancados = new ArrayList<>();  
   }

public boolean temVaga() { return matriculados.size() < capacidade;}

//Matricular alunos
 public boolean matricularAluno(Aluno aluno) {
  if(aluno instanceof AlunoEspecial && !((AlunoEspecial) aluno).podeMatricular()){ 
    return false; //ja verifico se tem >2 materias ja matriculadas no especial
  }
  if(temVaga() && !matriculados.contains(aluno) && !alunosTrancados.contains(aluno)){
    matriculados.add(aluno);
    if(aluno instanceof AlunoEspecial) {
    ((AlunoEspecial) aluno).incrementarDisciplinas();
    }
    return true; 
  }
  return false;
}

//trancar alunos
 public boolean trancarAluno(Aluno aluno) {
  if (matriculados.contains(aluno)) {
   matriculados.remove(aluno);
   alunosTrancados.add(aluno);
  if (aluno instanceof AlunoEspecial) {
   ((AlunoEspecial) aluno).decrementarDisciplinas();
   }
   return true;  
  }
  return false;
 }

 //getters
   public String getHorario() {return horario;} 
   public String getCodigoDisciplina() {return disciplina.getCodigo();}
   public int getCapacidade(){return capacidade;}
   public List<Aluno> getMatriculados() {return matriculados;}
   public int getTipoAvaliacao(){return tipoAvaliacao;}//0 ou 1
   public Disciplina getDisciplina(){return disciplina;}
   public String getSala(){return sala;}
   public String getIndentificador(){return disciplina.getCodigo() + "-" + semestre + "-" + horario;}
   public String getProfessor(){return professor;}
   //
   public void adicionarAluno(Aluno aluno) {matriculados.add(aluno);}
  }

