
public class Aluno {
    private String nome,curso;
    private int matricula;

//construtor/inicializador
public Aluno(String nome ,int matricula ,String curso){
this.nome = nome;
this.matricula = matricula;
this.curso = curso;
}

//getters
public String getnome(){
    return nome;
}
public int getmatricula(){
    return matricula;
}
public String getcurso(){
    return curso;
}

//setters
public void setnome(String nome){
   this.nome = nome;
}
public void setmatricula(int matricula){
   this.matricula = matricula;
}
public void setcurso(String curso){
   this.curso = curso;
}

public boolean ehEspecial(){return false;}

  @Override
    public String toString() {
        return nome + " | Matrícula: " + matricula + " | Curso: " + curso ;
    }
 }









