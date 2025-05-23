import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina; //codigo da Disciplina incluso;
    private String professor,semestre,horario,sala; 
    private boolean presencial; 
    private int capacidadeTurma;
    private int tipoAvaliacao; // 1 media simples, 2 ponderada !!
    private List<Aluno> matriculados;
    private List<Aluno> alunosTrancados;

 //construtor 
  public Turma (Disciplina disciplina,String professor,String semestre,String horario,
   String sala,boolean presencial,int capacidadeTurma,int tipoAvaliacao)
   {
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.presencial = presencial;
        this.sala = presencial ? sala : "on-line"; //se true this.sala = sala,se false this.sala = " " 
        this.horario = horario;
        this.capacidadeTurma = capacidadeTurma;
        this.tipoAvaliacao = tipoAvaliacao; 
        this.matriculados = new ArrayList<>();
        this.alunosTrancados = new ArrayList<>();  
   }

//Matricular alunos
 public boolean matricularAluno(Aluno aluno) {
   if (aluno instanceof AlunoEspecial && !((AlunoEspecial) aluno).podeMatricular()){
    return false;
  }
   if (temVaga() && !matriculados.contains(aluno) && !alunosTrancados.contains(aluno)){
    matriculados.add(aluno);
    if (aluno instanceof AlunoEspecial) {
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


 //getters(os necessarios para verificaçoes)
   public String getHorario() {return horario;} 
   public String getCodigoDisciplina() {return disciplina.getCodigo();}
   public int getCapacidade(){return capacidadeTurma;}
   public List<Aluno> getMatriculados() {return matriculados;}
   public int getTipoAvaliacao(){return tipoAvaliacao;}//0 ou 1
   public Disciplina getDisciplina(){return disciplina;}

 //
   public boolean temVaga() { return matriculados.size() < capacidadeTurma;}

   public void adicionarAluno(Aluno aluno) {matriculados.add(aluno);}
  }

