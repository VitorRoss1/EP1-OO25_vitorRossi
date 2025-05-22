import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina; //codigo da Disciplina incluso;
    private String professor,semestre,horario,sala; 
    private boolean presencial; 
    private int capacidadeTurma;
    private List<Aluno> matriculados;
    private int tipoAvaliacao; // 1 media simples, 2 ponderada !!
   

 //construtor 
  public Turma (Disciplina disciplina,String professor,String semestre,String horario,String sala,boolean presencial,int capacidadeTurma,int tipoAvaliacao)
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

