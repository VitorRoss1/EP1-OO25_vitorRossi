import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String professor,semestre,horario,sala,codigoDisciplinaTurma; 
    private boolean presencial; 
    private int capacidadeTurma;
    private List<Aluno> matriculados;
    private int tipoAvaliacao; // 1 media simples, 2 ponderada

 //construtor 
  public Turma (String professor,String semestre,String horario,String sala,boolean presencial,int capacidadeTurma,int tipoAvaliacao)
   {
        this.codigoDisciplinaTurma = codigoDisciplinaTurma;
        this.professor = professor;
        this.semestre = semestre;
        this.presencial = presencial;
        this.sala = presencial ? sala : "on-line"; //se true this.sala = sala,se false this.sala = " " 
        this.horario = horario;
        this.capacidadeTurma = capacidadeTurma;
        this.matriculados = new ArrayList<>();
        this.tipoAvaliacao = tipoAvaliacao;
   }

 //getters(os necessarios para verificaçoes)
   public String getHorario() {return horario;} 
   public String getCodigoDisciplinaTurma() {return codigoDisciplinaTurma;}
   public List<Aluno> getMatriculados() {return matriculados;}
   public int getTipoAvaliacao(){return tipoAvaliacao;}

   }
