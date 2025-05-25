import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nomeDisciplina;
    private String codigo;
    private int cargaHoraria;
    private List<Disciplina> preRequisitos= new ArrayList<>();; 
    
    private int P1,P2,P3,L,S;
    private int mediaF;
    private int presencaFinal;


//Construtor
  public Disciplina(String nomeDisciplina, String codigo,int cargaHoraria){
   this.nomeDisciplina = nomeDisciplina;
   this.codigo = codigo;
   this.cargaHoraria = cargaHoraria;
   this.preRequisitos = new ArrayList<>(); 
}

//adiciona preRequisitos na list prerequisito's
 public void addPreRequisito(Disciplina disciplinaX) {
     if (!preRequisitos.contains(disciplinaX)) { // nao repetir os preReq's
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

    //  Getters e Setters para as notas
    public int getP1() { return P1; }
    public void setP1(int P1) { this.P1 = P1; }

    public int getP2() { return P2; }
    public void setP2(int P2) { this.P2 = P2; }
    
    public int getP3() { return P3; }
    public void setP3(int P3) { this.P3 = P3; }
    
    public int getL() { return L; }
    public void setL(int l) { this.L = l; }
    
    public int getS() { return S; }
    public void setS(int S) { this.S = S; }
    
    public int getMediaF() { return mediaF; }
    public void setMediaF(int mediaF) { this.mediaF = mediaF; }
    
    public int getPresencaFinal() { return presencaFinal; }
    public void setPresenca(int presencaFinal) { this.presencaFinal = presencaFinal; }


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
