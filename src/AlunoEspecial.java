//SO CURSA 2 Disciplinas E NAO RECEBE NOTAS SO PRESENÇA

public class AlunoEspecial extends Aluno{ 
    //construtor
  public AlunoEspecial(String nome,int matricula,String curso){
  super(nome, matricula, curso); //chama o construtor da superclasse(inicializa os atributos herdados)
   }

//é alunoEspecial
 @Override
 public boolean ehEspecial(){
  return true;
 }

 @Override 
 public String toString(){
    return super.toString() + " | ALUNO ESPECIAL |"; 
}

}
