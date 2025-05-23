import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      //INSTANCIANDO
      Scanner scanner = new Scanner(System.in); //instanciando 
      AlunoManager alunoManager = new AlunoManager(); 

      int escolha, escolhaAluno,escolhaAvaliacao,escolhaTurma = 0; 
     
        do { 
           System.out.println("=====MAIN=MENU=====");
           System.out.println(" ");
           System.out.println("1.MENU ALUNO:");
           System.out.println("2.MENU TURMA/DISCIPLINA");
           System.out.println("3.MENU AVALIAÇÃO/FREQUÊNCIA");
           System.out.println("0.FECHAR");
            escolha = scanner.nextInt();//Lê integers
            

      switch (escolha) {
        
        case 1: 
           do{
           System.out.println("==MENU ALUNO==");
           System.out.println("Selecione a subcategoria:");
           System.out.println("1.Cadastrar aluno"); //normal ou especial
           System.out.println("2.Editar aluno");
           System.out.println("3.Lista de alunos");
           System.out.println("4.Matricular");
           System.out.println("5.Trancar");
           System.out.println("0.Sair");
           escolhaAluno = scanner.nextInt(); 

        switch (escolhaAluno){
          case 1: 
          alunoManager.cadastrarAluno(scanner); 
          break;
          case 2:
          //editar setters
          break;
          case 3:
          alunoManager.listarAlunos();
          break;
          case 4:
          // matricular
          break;
          case 5:
          //trancar semestre(todas) ou disciplina
          break;
          case 6:
          System.out.println("Voltando ao menu principal...");
          break;
          default:
          System.out.println("Opção inválida.");
          }

        } while ( escolhaAluno != 0);
          break;


           case 2:
           do {
            System.out.println("==MENU DISCIPLINAS e TURMAS==");
            System.out.println("Selecione a subcategoria:");
            System.out.println("1.Cadastrar disciplina");
            System.out.println("2.Cadastrar turma:");
            System.out.println("3.Lista de turmas e alunos"); 
            System.out.println("0.Sair");
            escolhaTurma = scanner.nextInt();

        switch (escolhaTurma){
          case 1: 
          //cadastrar disc 
          break;
          case 2:
          //cadastrar turma
          break;
          case 3:
          //listar turmas e alunos em cada
          break;
          case 4:
          System.out.println("Voltando ao menu principal...");
          break;
          default:
          System.out.println("Opção inválida.");
          }

        }while( escolhaTurma != 0);
           break;

           case 3:
           do { 
                System.out.println("==MENU AVALIAÇÃO/FREQUÊNCIA==");
                System.out.println("Selecione a subcategoria:");
                System.out.println("1.Lançar notas e presença"); //2 modos
                System.out.println("2.Calcular média e presença finais");
                System.out.println("3.visualizar resultado final");//aprovado ou reprovado e SR
                System.out.println("4.Visualizar relatorios");//3 tipos de por
                System.out.println("5.Visualizar boletins"); //aluno + listar turma ou nao
                System.out.println("0.Sair");
                escolhaAvaliacao = scanner.nextInt();

        switch (escolhaAvaliacao){
          case 1: 
          //Lançar NOTAS E PRESENÇA 
          break;
          case 2:
          //CALCULAR MEDIAF E PRESENÇAF
          break;
          case 3:
          //VISUALIZAR BOLETINS
          break;
          case 4:
          //VISUALIZAR RELATORIOS
          break;
          case 5:
          //VISUALIZAR BOLETINS
          break;
          case 6:
          System.out.println("Voltando ao menu principal...");
          break;
          default:
          System.out.println("Opção inválida.");
          }

          }while( escolhaAvaliacao != 0);
                break;

           case 4: 
           System.out.println("Closing...");
           break;
           default:
           System.out.println("Selecione opção válida.");
       }
  
       } while (escolha != 0 );

      scanner.close(); //fecha o metodo(leituras) "scanf" 
      }
}
