public class AlunoEspecial extends Aluno{ 

private static final int MAX_DISCIPLINAS = 2;
private int NdisciplinasAtuais;

//construtor
  public AlunoEspecial(String nome,int matricula,String curso){
  super(nome, matricula, curso); //chama o construtor da superclasse(inicializa os atributos herdados)
   this.NdisciplinasAtuais = 0;
}

//so cursa 2 Disciplinas 
public boolean podeMatricular() {
return NdisciplinasAtuais < MAX_DISCIPLINAS;
}
public void incrementarDisciplinas() {
 if (podeMatricular()) { NdisciplinasAtuais++;}
 }
public void decrementarDisciplinas() {
 if (NdisciplinasAtuais > 0) {NdisciplinasAtuais--;}
}

//setter
public void setNdisciplinasAtuais(int NdisciplinasAtuais)
{
this.NdisciplinasAtuais = NdisciplinasAtuais;
}

//(+2 polimorfismos sobreescrita)
 @Override
 public boolean ehEspecial(){
  return true;
 }

 @Override 
 public String toString(){
    return super.toString() + " | ALUNO ESPECIAL |"; 
}

}
