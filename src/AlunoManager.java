import java.util.*;
public class AlunoManager {

 private List<Aluno> alunos = new ArrayList<>();  //object do tipo list<> nomeado de alunos

//CADASTRAR/EDITAR
 public void cadastrarAluno(Scanner scanner){

    System.out.println("Insira e pressione enter,em ordem: Nome, Matrícula, Curso e Aluno especial(s/n)...");
    String nome = scanner.next();
    int matricula = scanner.nextInt();
    String curso = scanner.next();
    String especial = scanner.next();
       
    //Verifica duplicidade com base na matrícula logo apos o scan
     if (buscarAluno(matricula) != null) {
     System.out.println("Já existe aluno com essa matrícula");
     return;  //se achar repetido já finaliza o método cadastrarAluno com return void.
    }

    //Especial ou não
    Aluno aluno = especial.equalsIgnoreCase("s")
     ? new AlunoEspecial(nome, matricula, curso)  
     : new Aluno(nome, matricula, curso); 
     alunos.add(aluno); 
     System.out.println("Aluno cadastrado (:");
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
    public Aluno buscarAluno(int matricula) {  //retorno do tipo Aluno
        for (Aluno a : alunos) {
          if (a.getmatricula() == matricula) 
          return a;  //retorna 'a' se achar matricula repetida
        }
        return null;  //retorna null como padrao
    }
}


/*
LEGENDA: 
 Aluno: CLASSE; aluno: OBJETO DE 'Aluno'; alunos: LISTA DE OBJETOS TIPO 'Aluno'
*/

