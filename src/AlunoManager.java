import java.io.PipedWriter;
import java.util.*;
import javax.print.attribute.standard.Media;

public class AlunoManager {
  private List<Aluno> alunos = new ArrayList<>();  

  
//CADASTRAR 
 public void cadastrarAluno(Scanner scanner){

    System.out.println("Insira,em ordem: Nome, Matrícula, Curso e Aluno especial(s/n)...");
    String nome = scanner.next();
    int matricula = scanner.nextInt();
    String curso = scanner.next();
    String especial = scanner.next();
       

    //Verifica duplicidade com base no metodo buscaAluno(abaixo) 
     if (alunoDuplo(matricula) != null) {
     System.out.println("Já existe aluno com essa matrícula");
     return;  //se achar repetido já finaliza o método cadastrarAluno com return void.
    }

    //Direcionar o alunos especiais/nao
    Aluno aluno = especial.equalsIgnoreCase("s")
     ? new AlunoEspecial(nome, matricula, curso)  
     : new Aluno(nome, matricula, curso); 
      alunos.add(aluno); 
      System.out.println("Aluno cadastrado (:");
    }


//CADASTRAR NOTAS E PRESENÇA E LANÇAR MEDIAF E PRESENÇAF COM RESULTADOS
AlunoManager alunoManager = new AlunoManager();

public void CadastrarNotaPresenca(Scanner scanner){
    System.out.println("Para cadastrar notas e presença, antes digite a matrícula do aluno");
    int matricula = scanner.nextInt();
if(alunoManager.alunoDuplo(matricula) != null){

   System.out.println("Insira as 5 notas (P1,P2,P3,L,S) notas e pressione enter");
   int P1 = scanner.nextInt();
      alunos.setP1(P1);
   int P2 = scanner.nextInt();
      alunos.setP2(P2);
   int P3 = scanner.nextInt();
      alunos.setP3(P3);
   int L = scanner.nextInt();
      alunos.setL(L);
   int S = scanner.nextInt();
      alunos.setS(S);

   System.out.println("Insira o modo de avaliação (simples 0/ ponderada 1)");
   int tipoAvaliacao = scanner.nextInt();
   int mediaF = 0;
   if(tipoAvaliacao == 0){ mediaF = (P1+P2+P3+L+S)/5; }
   if(tipoAvaliacao == 1){mediaF =  (P1 + 2*P2 + 3*P3 + L + S) / 8;}
   alunos.setMediaF(mediaF);

   //presença
   System.out.println("Insira a presença 0 a 100(%) do aluno");
   int presenca = scanner.nextInt();   
   alunos.setPresenca();

}
else{System.out.println("Aluno não encontrado.");return;}
}


//RESULTADOS
public void informarAprovacao(Scanner scanner){
    System.out.println("Para listar notas e presença, antes digite a matrícula do aluno");
    int matricula = scanner.nextInt();
if(alunoManager.alunoDuplo(matricula) != null){
     
 if(alunos.presenca >= 75)
 {
   if(alunos.mediaF >= 5){  System.out.println("Aprovado :) ");}
   else{ System.out.println("Reprovado por nota :( ");}
 } 
 else{ System.out.println("Reprovado por Falta :/");}

}





//LISTAR
    public void listarAlunos(){
     if(alunos.isEmpty()){
        System.out.println("Nenhum aluno cadastrado");}
     else{ 
      for(Aluno a : alunos){ System.out.print(a); }  // referencia temporária chamada 'a'
         }
    }

 //VERIFICAR DUPLICIDADE DE ALUNOS
    public Aluno alunoDuplo(int matricula) {  //retorno do tipo Aluno
        for (Aluno a : alunos) {
          if (a.getmatricula() == matricula) 
          return a;  //retorna 'a'(flag) se achar matricula repetida
        }
        return null;  //retorna null como padrao
    }
}


/*
LEGENDA: 
 Aluno: CLASSE; aluno: OBJETO DE 'Aluno'; alunos: LISTA DE OBJETOS TIPO 'Aluno'
*/

