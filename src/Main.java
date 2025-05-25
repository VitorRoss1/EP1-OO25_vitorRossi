import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      //instanciando
      Scanner scanner = new Scanner(System.in);
      AlunoManager alunoManager = new AlunoManager(); 
      TurmaManager turmaManager = new TurmaManager();
      DisciplinaManager disciplinaManager = new DisciplinaManager();

      int escolha, escolhaAluno,escolhaAvaliacao,escolhaTurma; 
     
        do { 
           System.out.println(" == MAIN MENU ==");
           System.out.println(" 1. MENU ALUNO:");
           System.out.println(" 2. MENU DISCIPLINA E TURMAS");
           System.out.println(" 3. MENU AVALIAÇÃO/FREQUÊNCIA");
           System.out.println(" 0. FECHAR");
            escolha = scanner.nextInt();
            
      switch (escolha) {
        
        case 1: 
           do{
           System.out.println("\n == MENU ALUNO ==");
           System.out.println(" 1. Cadastrar aluno"); //normal ou especial
           System.out.println(" 2. Editar aluno");
           System.out.println(" 3. Lista de alunos");
           System.out.println(" 4. Matricular");
           System.out.println(" 5. Trancar");
           System.out.println(" 0. Sair");
           escolhaAluno = scanner.nextInt(); 

        switch (escolhaAluno){
          case 1: 
          alunoManager.cadastrarAluno(scanner); 
          break;
          case 2:

            System.out.println("Digite a matrícula do aluno:");
                int matriculaEditar = scanner.nextInt();
                Aluno alunoEditar = alunoManager.alunoDuplo(matriculaEditar);

                if (alunoEditar != null) { //editar (setters) Matrícula imutavel
                System.out.println("Insira novo nome ou repita o antigo:");
                scanner.nextLine();
                String novoNome = scanner.nextLine();
                alunoEditar.setnome(novoNome);
                System.out.println("Nome editado para: " + alunoEditar.getnome());

                 System.out.println("Insira novo curso ou repita o antigo:");
                 String novoCurso = scanner.nextLine();
                 alunoEditar.setcurso(novoCurso);
                 System.out.println("Curso editado para: " + alunoEditar.getcurso());

                } else {
                    System.out.println("Aluno não encontrado!");
                }
          break;
          case 3:
          alunoManager.listarAlunos();
          break;
          case 4:
          System.out.println("Para matricular, 1º digite sua matrícula:");
          int matricula = scanner.nextInt();
          Aluno aluno = alunoManager.alunoDuplo(matricula);

          if(aluno == null){System.out.println("Aluno não encontrado!");
          break; 
          }
          System.out.println("\nDigite o código da disciplina para matrícula:");
          String codigoDisc = scanner.next();

            if (turmaManager.matricular(aluno, codigoDisc)) {
            System.out.println("Matrícula realizada com sucesso!");
            } else {
             System.out.println("Falha na matrícula! Verifique pré-requisitos ou vagas.");
            }
          break;
          case 5: 
          //TRANCAR semestre(todas) ou disciplina remove
          System.out.println("Digite a matrícula do aluno:");
          int matriculax = scanner.nextInt();
          Aluno alunoY = alunoManager.alunoDuplo(matriculax);

          if (alunoY == null) {System.out.println("Aluno não encontrado!");break;}

         System.out.println(" 1. Trancar disciplina específica");
         System.out.println(" 2. Trancar todas as disciplinas");
         System.out.println(" 0. Voltar");
         int opcaoTrancamento = scanner.nextInt();

        switch (opcaoTrancamento) {
         case 1: // Disciplina específica
          System.out.println("Disciplinas matriculadas:"); //listar disciplinas matriculadas
          for (Turma t : turmaManager.getTurmas()) {
           if (t.getMatriculados().contains(alunoY)) {
           System.out.println(t.getDisciplina().getCodigo()+" - "+ t.getDisciplina().getNome());
           }
          } 
          System.out.println("Digite o código da disciplina que quer trancar:");
          String codigo = scanner.next();  
           if (turmaManager.trancarDisciplina(alunoY, codigo)) { //flag true(conseguiu trancar: existe, tá matriculado...)
            System.out.println("Disciplina trancada com sucesso!");
            } else { System.out.println("Falha ao trancar disciplina!"); }
          break;

         case 2: //geral
            if (turmaManager.trancarTodasDisciplinas(alunoY)){ 
             System.out.println("Trancamento geral realizado com sucesso!"); }
            else { System.out.println("Aluno não estava matriculado em nenhuma disciplina!"); }
          break;   
         case 0: 
          break;
         default:
          System.out.println("Opção inválida!");
         }
          break;
          case 0:
          System.out.println("Voltando ao menu principal...");
          break;
          default:
          System.out.println("Opção inválida.");
          }

        } while ( escolhaAluno != 0);
          break;


           case 2:
           do {
            System.out.println("\n == MENU DISCIPLINAS e TURMAS ==");
            System.out.println(" 1. Cadastrar disciplina");
            System.out.println(" 2. Cadastrar turma:");
            System.out.println(" 3. Lista de turmas e alunos"); 
            System.out.println(" 0. Sair");
            escolhaTurma = scanner.nextInt();

        switch (escolhaTurma){
          case 1: 
          disciplinaManager.cadastrarDisciplina(scanner);
          break;
          case 2:
          turmaManager.CadastrarTurma(scanner, disciplinaManager);
          break;
          case 3:
          turmaManager.listarTurmas();
          break;
          case 0:
          System.out.println("Voltando ao menu principal...");
          break;
          default:
          System.out.println("Opção inválida.");
          }

        }while( escolhaTurma != 0);
           break;

           case 3:
           do { 
                System.out.println(" ==MENU AVALIAÇÃO/FREQUÊNCIA==");
                System.out.println(" 1. Lançar notas e presença ");
                System.out.println(" 2. Verificar resultados finais"); 
                System.out.println(" 0. Sair");
                escolhaAvaliacao = scanner.nextInt();

        switch (escolhaAvaliacao){
          case 1: 
          alunoManager.CadastrarNotaPresenca(scanner);
          break;
          case 2:
          alunoManager.informarAprovacao(scanner);
          break;
          case 0:
          System.out.println("Voltando ao menu principal...");
          break;
          default:
          System.out.println("Opção inválida.");
          }

          }while( escolhaAvaliacao != 0);
            break;
           case 0: 
           System.out.println("Closing...");
           break;
           default:
           System.out.println("Selecione opção válida.");
       }
      } while (escolha != 0 );
        scanner.close();  //fecha o metodo(leituras) "scanf" 
     }
}
