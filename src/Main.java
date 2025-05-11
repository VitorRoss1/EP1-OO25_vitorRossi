import java.util.Scanner;

public class Main {
    public static void main() {

      Scanner scanner = new Scanner(System.in); //instanciando 
      int escolha, escolhaAluno,escolhaAvaliacao,escolhaTurma = 0; 
     
        do { 
            System.out.println("=====MAIN=MENU=====");
            System.out.println("SELECIONE O MODO DESEJADO:");
            System.out.println("        ");
            System.out.println("1.ALUNO:");
            System.out.println("2.TURMA/DISCIPLINA");
            System.out.println("3.AVALIACAO/FREQUENCIA");
            System.out.println("4.CLOSE");
            escolha = scanner.nextInt();//Lê integers
            } while (escolha != 4 );


       switch (escolha) {
           case 1: 
           do{
           System.out.println("==MENU ALUNO==");
           System.out.println("Selecione a subcategoria:");
           System.out.println("1.Cadastrar ou editar aluno"); //normal ou especial
           System.out.println("2.Lista de alunos");
           System.out.println("3.Matricular");
           System.out.println("4.Trancamentos");
           System.out.println("5.Fechar");
           escolhaAluno = scanner.nextInt(); 
           } while ( escolhaAluno != 5);
            break;

           case 2:
           do {
            System.out.println("==MENU TURMA/DISCIPLINA==");
            System.out.println("Selecione a subcategoria:");
            System.out.println("1.Cadastrar disciplina");
            System.out.println("2.Cadastrar turma:");
            System.out.println("3.Lista de turmas"); //e alunos nelas
            System.out.println("4.Fechar");
            escolhaTurma = scanner.nextInt();
           }while( escolhaTurma != 4);
           break;

           case 3:
           do { 
                System.out.println("==MENU AVALIACAO/FREQUENCIA==");
                System.out.println("Selecione a subcategoria:");
                System.out.println("1.Listar notas e presenca");
                System.out.println("2.Calcular media e presenca finais");
                System.out.println("3.visualisar resultado final");//aprovado reprovado e SR
                System.out.println("4.Visualiar relatorios");
                System.out.println("5.Visualiar boletins");
                System.out.println("6.Fechar");
                escolhaAvaliacao = scanner.nextInt();
              }while( escolhaAvaliacao != 6);
                break;

           case 4: 
           System.out.println("Closing...");
           break;

           default:
           System.out.println("Selecione opcao valida!");
       }
  
      scanner.close(); //fecha o metodo(leituras) "scanf" 
      }
}
