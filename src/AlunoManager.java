import java.util.*;

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


//CADASTRAR NOTAS E PRESENÇA 
public void CadastrarNotaPresenca(Scanner scanner){
    System.out.println("Para cadastrar notas e presença, antes digite a matrícula do aluno");
    int matricula = scanner.nextInt();
    Aluno alunoA = alunoDuplo(matricula);

 if(alunoA!= null){

 //Lista as disciplinas para cadastrar notas e presenca
 System.out.println("Disciplinas do aluno:");
 for (Disciplina d : alunoA.getHistorico()) {
 System.out.println(d.getCodigo() + " - " + d.getNome());
 }
 System.out.println("Digite o código da disciplina:");
 String codigo = scanner.next();

 //Encontra a disciplina no histórico
   Disciplina disciplinaA = null;  //flag padrao de não encontrada
   for (Disciplina d : alunoA.getHistorico()) {
    if (d.getCodigo().equals(codigo)) {
        disciplinaA = d; break; }
   }
        
  if (disciplinaA != null) { //foi encontrada
// ALUNO ESPECIAL (só presença)
    if (alunoA.ehEspecial()) {
    System.out.println("ALUNO ESPECIAL - Cadastrar apenas presença");
    System.out.println("Insira a presença (0-100%):");
    int presenca = scanner.nextInt();
    disciplinaA.setPresenca(presenca);
    System.out.println("Presença cadastrada para aluno especial!");
            } 
// ALUNO NORMAL (notas + presença)
    else {
   System.out.println("Insira as 5 notas (P1,P2,P3,L,S) separadas por espaço:");
     disciplinaA.setP1(scanner.nextInt());
     disciplinaA.setP2(scanner.nextInt());
     disciplinaA.setP3(scanner.nextInt());
     disciplinaA.setL(scanner.nextInt());
     disciplinaA.setS(scanner.nextInt());

 //Calculando mediaF
   System.out.println("Insira o modo de avaliação (0-simples/ 1-ponderada):");
   int tipoAvaliacao = scanner.nextInt();

int mediaF = (tipoAvaliacao == 0) 
   ? (disciplinaA.getP1() + disciplinaA.getP2() + disciplinaA.getP3() + disciplinaA.getL() + disciplinaA.getS()) / 5
   : (disciplinaA.getP1() + 2*disciplinaA.getP2() + 3*disciplinaA.getP3() + disciplinaA.getL() + disciplinaA.getS()) / 8;
   
   disciplinaA.setMediaF(mediaF);

 //Presença
  System.out.println("Insira a presença 0 a 100 (%) do aluno:");
  disciplinaA.setPresenca(scanner.nextInt());   
    System.out.println("Notas e presença cadastradas com sucesso para"+ disciplinaA.getNome());
  }
}else { System.out.println("Disciplina não encontrada no histórico do aluno!");
} 
} else{ System.out.println("Aluno não encontrado.");
}
}


//RESULTADOS
public void informarAprovacao(Scanner scanner){
    System.out.println("Para listar notas e presença, antes digite a matrícula do aluno");
    int matricula = scanner.nextInt();
    Aluno alunoB =  alunoDuplo(matricula); //instanciando da obj classe aluno

 if(alunoB != null){
  System.out.println("Disciplinas cursadas:");
  for (Disciplina d : alunoB.getHistorico()) {

    // Aprovação só por presença para alunosEspeciais
   if (alunoB.ehEspecial()) {            
    String resultado = (d.getPresencaFinal() >= 75) ? "Aprovado por presença" : "Reprovado por falta";
    System.out.println(d.getNome() + " | Presença: " + d.getPresencaFinal() + "% | " + situacao);
   
  } else {
   String resultado = (d.getPresencaFinal() >= 75) //valor da string resultado muda conforme resultado
    ? (d.getMediaF() >= 5 ? "Aprovado :)" : "Reprovado por nota :(" )
    : "Reprovado por falta :( "; 

 // Mostra os detalhes(EXTRA)
    System.out.println(d.getNome() + 
    " | Média: " + d.getMediaF() + 
    " | Presença: " + d.getPresencaFinal() + "%" +
    " | Situação: " + resultado);
  }
  }
  } else{ System.out.println("Aluno não encontrado");}
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

