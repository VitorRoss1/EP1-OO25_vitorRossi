import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nomeDisciplina;
    private String codigo;
    private int cargaHoraria;
    private List<String> preRequisitos; //materias  


//Construtor
  public Disciplina(String nomeDisciplina, String codigo,int cargaHoraria){
   this.nomeDisciplina = nomeDisciplina;
   this.codigo = codigo;
   this.cargaHoraria = cargaHoraria;
   this.preRequisitos = new ArrayList<>(); //instanciando o objeto prerequisitos do tipo list
}

//Metodo q adiciona preRequisitos na list (setter de preRequsito) 
 public void addPreRequisito(String codigo) {
    preRequisitos.add(codigo); 
 }


//Getters
    public String getCodigo() { return codigo; }
    public String getNome() { return nomeDisciplina; }
    public int getCargaHoraria() { return cargaHoraria; }
    public List<String> getPreRequisitos() { return preRequisitos; }


}
