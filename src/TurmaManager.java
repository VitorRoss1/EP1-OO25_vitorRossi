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

 //buscar disciplina 
 System.out.println("Digite o código da disciplina:");
 String codigoDisciplina = scanner.next();
 Disciplina disciplina = disciplinaManager.buscarCodigo(codigoDisciplina);

 if (disciplina == null) 
 {
  System.out.println("Disciplina não existe!"); return; 
 }

//construtor
      System.out.print("Professor: ");
      String professor = scanner.next();
      System.out.print("Semestre (ex: 2024.2): ");
      String semestre = scanner.next();
      System.out.print("Horário (ex: 2T45): ");
      String horario = scanner.next();
      System.out.print("Presencial (true/false): ");
      boolean presencial = scanner.nextBoolean();  
      String sala = "";

       if (presencial) {
          System.out.print("Sala: ");
          sala = scanner.next();
        }
      System.out.print("Capacidade: ");
      int capacidade = scanner.nextInt();
      System.out.print("Tipo avaliação (0-simples/1-ponderada): ");
      int tipoAvaliacao = scanner.nextInt();

  //instanciando objeto tipo Turma
    Turma novaTurma = new Turma(disciplina, professor, semestre, horario,sala,
    presencial, capacidade, tipoAvaliacao);
     turmas.add(novaTurma);
     System.out.println("Turma cadastrada com sucesso!"+ novaTurma.getIndentificador());
}


//LISTAR TURMAS
public void listarTurmas(){ 
 for (Turma turmaX : turmas) {   
  System.out.println(
  "  Máteria " + turmaX.getDisciplina().getNome()
 + "\n Código: " + turmaX.getDisciplina().getCodigo()
 + "\n Professor: " + turmaX.getProfessor()
 + "\n Sala: " + turmaX.getSala()
 + "\n Horário: " + turmaX.getHorario()
 + "\n Vagas preenchidas: " + turmaX.getMatriculados().size() + "/" + turmaX.getCapacidade()
 + "\n Tipo de avaliação: " + turmaX.getTipoAvaliacao() + " | 0-Simples | 1-Ponderada |"
 );

 //listando os alunos nas turmas
if (!turmaX.getMatriculados().isEmpty()) {
    System.out.println("Alunos matriculados:");
    for (Aluno aluno : turmaX.getMatriculados()) {
     System.out.println("|" + aluno.getnome() + "|" + aluno.getmatricula() +"|"+ 
     (aluno.ehEspecial() ? " [ALUNO ESPECIAL]" : "[ALUNO NORMAL]")
     );
    }
} else {
  System.out.println("Nenhum aluno matriculado nesta turma.");
}
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
    Disciplina disciplinaTurma = turma.getDisciplina();
    
    // Inicializo todas as notas com 0
    disciplinaTurma.setP1(0);
    disciplinaTurma.setP2(0);
    disciplinaTurma.setP3(0);
    disciplinaTurma.setL(0);
    disciplinaTurma.setS(0);
    disciplinaTurma.setMediaF(0);
    disciplinaTurma.setPresenca(0);
    
    //Adiciona ao histórico do aluno (msm q não nao tenha passado :/ )
    alunoX.adDDisciplinaCursadas(disciplinaTurma);

  return turma.matricularAluno(alunoX); //metodo de turma add.matriculados(list)
  }

 //Adicionando turmas a disciplinas(lista)
  public List<Turma> getTurmasPorDisciplina(String codigoDisciplina) {
        List<Turma> turmasDaDisciplina = new ArrayList<>();
        for (Turma t : turmas) {
            if (t.getDisciplina().getCodigo().equals(codigoDisciplina)) {
                turmasDaDisciplina.add(t);
            }
        }
        return turmasDaDisciplina;
    }

//getter turmas
public List<Turma> getTurmas() {return this.turmas;}


//TRANCAMENTOS

 //único
 public boolean trancarDisciplina(Aluno aluno, String codigoDisciplina) {
    for (Turma turma : turmas) {
    if (turma.getCodigoDisciplina().equals(codigoDisciplina)) {
     if (turma.getMatriculados().contains(aluno)) {
      turma.getMatriculados().remove(aluno);
      if (aluno.ehEspecial()) { //Atualiza o contador de alunoEspecial
      ((AlunoEspecial)aluno).decrementarDisciplinas(); }
      return true; //flag
     }
    }
    }
    return false; //flag nao trancou
    }

 //geral
  public boolean trancarTodasDisciplinas(Aluno aluno) {
      boolean trancouGeral = false;
      for (Turma turma : turmas) { 
        if (turma.getMatriculados().contains(aluno)) {
         turma.getMatriculados().remove(aluno); //remove de todas disciplinas matriculadas
         trancouGeral = true;
        }
      }
        // Zera contador do alunoEspecial
        if (trancouGeral && aluno.ehEspecial()) { //zera o contador se trancouGeral for verdadeiro
        ((AlunoEspecial)aluno).setNdisciplinasAtuais(0);
        }
   return trancouGeral;
  }
}