//Listar turmas disponíveis e alunos matriculados em cada uma;
//Cadastrar turmas com professor responsável, semestre, forma de avaliação, se é presencial ou remota, sala, horário e capacidade máxima de alunos;
//Cada disciplina pode ter mais de uma turma, desde que em horário diferente.
//list turmas<Turma>
//Trancar disciplinas e semestre(TODAS);
//METODO LISTAR TURMAS E ALUNOS
//TRANCAR
//METODO CADASTRAR TURMA
//Não pode ser matriculado se não tiver os pré-requisitos (classe aluno) !
//METODO MATRICULAR //Matricular alunos em disciplinas existentes e com vagas disponíveis; 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurmaManager {

private List<Turma> turmas;
turmas = new ArrayList<>();

void CadastrarTurma(Scanner scanner){
    
 System.out.println("Insira: Disciplina,professor,semestre,horário,sala,presencial(true/false),capacidade e tipo de avaliação(simples:0/ponderada:1)");
    String disciplinaC = scanner.next();
    String professorC = scanner.next();
    String  semestreC= scanner.next();
    String horarioC = scanner.next();
    boolean presencialC = scanner.nextBoolean();
    int capacidadeC = scanner.nextInt();
    int tipoAvaliacaoC = scanner.nextInt();

//verificar duplicidade

//avaliacao 0 1
}









public void listarTurmas(){ //preciso listar os alunos tbm e SALA
    for (Turma turmaX : turmas) {
        
System.out.println(
  "Máteria " + turmaX.getDisciplina().getNome()
+ " -Código: " + turmaX.getDisciplina().getCodigo()
+ " -Professor: " + turmaX.getDisciplina().getNome()
+ " -Vagas preenchidas: " + turmaX.getMatriculados().size() + "/" + turmaX.getCapacidade()
+ " -Tipo de avaliação: " + turmaX.getTipoAvaliacao() + "1: Simples, 2: Ponderada"
);
}
}


//MATRICULAR
public boolean matricular(Turma turma,Aluno alunoX){
 if (!turmas.contains(turma)) {
  System.out.println("Turma inexistente.");
  return false;
  }
 if (!turma.temVaga()) {
  System.out.println("Turma cheia.");
  return false;
  }
  
//verificando pre requsitos
 Disciplina disciplina = turma.getDisciplina();
    for (Disciplina pre : disciplina.getPreRequisitos()) {
     if (!aluno.jaCursou(pre)) {
      System.out.println("Aluno não tem pré-requisito: " + pre.getCodigo());
      return false;
        }
      }

        turma.adicionarAluno(aluno);
        System.out.println("Aluno matriculado na turma de " + disciplina.getNome());
        return true;

   }
  }
