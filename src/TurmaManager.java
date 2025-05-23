import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurmaManager {

private List<Turma> turmas = new ArrayList<>();


//Cadastrar Turma em disciplina existente
void CadastrarTurma(Scanner scanner,DisciplinaManager disciplinaManager){

 //lista de disciplinas disponiveis
 System.out.println("Disciplinas disponíveis:");
 disciplinaManager.listarDisciplinas();

 //buscar disciplina (!!extra)
 System.out.println("Digite o código da disciplina:");
 String codigoDisciplina = scanner.next();
 Disciplina disciplina = disciplinaManager.buscarCodigo(codigoDisciplina);

 if (disciplina == null) {System.out.println("Disciplina não existe!");
  return; 
  }


//construtor
 System.out.println("Insira: professor, semestre, horário, sala, presencial(true/false),capacidade e tipo de avaliação(simples:0|ponderada:1)");
    //nomedisciplina(classe turma/disciplina)
    String professor = scanner.next();
    String  semestre = scanner.next();
    String horario = scanner.next();
    String sala = scanner.next();
    boolean presencial = scanner.nextBoolean();
    int capacidade = scanner.nextInt();
    int tipoAvaliacao = scanner.nextInt();

  //instanciando objeto tipo Turma
 Turma novaTurma = new Turma(disciplina, professor, semestre, horario,sala,
  presencial, capacidade, tipoAvaliacao);
 turmas.add(novaTurma);
 System.out.println("Turma cadastrada com sucesso!");
}

//LISTAR TURMAS
public void listarTurmas(){ //preciso listar os alunos tbm e SALA
 for (Turma turmaX : turmas) {   
  System.out.println(
  "Máteria " + turmaX.getDisciplina().getNome()
+ " -Código: " + turmaX.getDisciplina().getCodigo()
+ " -Professor: " + turmaX.getDisciplina().getNome()
+ " -Vagas preenchidas: " + turmaX.getMatriculados().size() + "/" + turmaX.getCapacidade()
+ " -Tipo de avaliação: " + turmaX.getTipoAvaliacao() + "0: Simples, 1: Ponderada"
);
}
}

public Turma buscarTurma(String codigoDisciplina) {
 for (Turma turma : turmas) {
 if(turma.getDisciplina().getCodigo().equals(codigoDisciplina)) {
  return turma;}
 }
 return null;
}

//MATRICULAR
public boolean matricular(Aluno alunoX, String codigoTurma){
 Turma turma = buscarTurma(codigoTurma); 
  if (turma == null) return false; //se nao existe turma já finalizo

 // Verificar pre-requisitos
  for (Disciplina preReq : turma.getDisciplina().getPreRequisitos()) {
   if (!alunoX.jaCursou(preReq)) {
    System.out.println("Aluno não cumpriu o pré-requisito: " + preReq.getCodigo());
    return false;
   }
  }
  return turma.matricularAluno(alunoX); //metodo de turma add.matriculados(list)
  }
}