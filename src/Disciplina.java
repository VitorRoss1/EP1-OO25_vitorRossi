import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nomeDisciplina;
    private String codigo;
    private int cargaHoraria;
    private List<Disciplina> preRequisitos= new ArrayList<>();; //materias  

//Construtor
  public Disciplina(String nomeDisciplina, String codigo,int cargaHoraria){
   this.nomeDisciplina = nomeDisciplina;
   this.codigo = codigo;
   this.cargaHoraria = cargaHoraria;
   this.preRequisitos = new ArrayList<>(); //instanciando o objeto prerequisitos do tipo list
}

//adiciona preRequisitos na list prerequisito's
 public void addPreRequisito(Disciplina disciplinaX) {
     if (!preRequisitos.contains(disciplinaX)) { //pra nao repetir os preReq's
            preRequisitos.add(disciplinaX);
        } 
 }
//setter
    public void setPreRequisitos(List<Disciplina> preRequisitos) {
    this.preRequisitos = preRequisitos;
    }
//Getters
    public String getCodigo() { return codigo; }
    public String getNome() { return nomeDisciplina; }
    public int getCargaHoraria() { return cargaHoraria; }
    public List<Disciplina> getPreRequisitos() { return preRequisitos; }

 @Override //sobrescrita q agr verifica se objetos(disciplina) sao os mesmos(tem o msm codigo)
    public boolean equals(Object obj) {
     if (!(obj instanceof Disciplina)) return false; //se o obj nao é do tipo objeto do parametro(instancia) retorna falso imediatamente
      Disciplina outro = (Disciplina) obj; //cast object->disciplina
      return this.codigo.equals(outro.codigo); //verifica se é a msm disciplina pelo codigo
    }

   //Sempre que você sobrescreve equals é obrigatório sobrescrever hashCode
    @Override
    public int hashCode() {return codigo.hashCode();}

    @Override
    public String toString() {
         return " | " + codigo + " | " + nomeDisciplina + " | ";
    }
}
