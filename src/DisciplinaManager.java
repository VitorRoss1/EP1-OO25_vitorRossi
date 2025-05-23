//Cadastrar disciplinas (nome, código, carga horária, pré-requisitos); 
 
import java.util.ArrayList;
import java.util.List;

public class DisciplinaManager {
 private List<Disciplina> disciplinas = new ArrayList<>();


//VERIFICAR DUPLICIDADE DE DISCIPLINAS
 public Disciplina buscarCodigo(String codigo) {
    for (Disciplina d : disciplinas) {
      if (d.getCodigo().equals(codigo)) return d;
      }
      return null; //flag qnd nao ha dois codigos iguais
    }


//CADASTRAR DISCIPLINA
  public void CadastrarDisciplina(String nomeDisciplina,String codigo,int cargaHoraria,List<Disciplina> preRequisitos)
  {
   if(buscarCodigo(codigo) != null){
   System.out.println("Já existe uma disciplina com esse código.");
   return; //saí do método
  }
  else{
  Disciplina disciplinaX = new Disciplina(nomeDisciplina, codigo, cargaHoraria);
  disciplinaX.setPreRequisitos(preRequisitos); //adiciona pre req
  disciplinas.add(disciplinaX);
  System.out.println("Disciplina cadastrada com sucesso.");
  }
  }


//LISTAR DISCIPLINAS (PARA POSSIVEIS VERIFICAÇOES/ NAO SERA EXIBIDO)
 public void listarDisciplinas() {
  if (disciplinas.isEmpty()) {
   System.out.println("Nenhuma disciplina cadastrada.");
   return;
  }

 for (Disciplina d : disciplinas) {  //percorre todas disciplinas e d é temp
 System.out.println("| Código:" + d.getCodigo() + " | " +d.getNome()+ " | ");

 if (!d.getPreRequisitos().isEmpty()) {
  System.out.print(" | Pre-requisitos: ");  //! nega
  for (Disciplina preReq : d.getPreRequisitos()) {
  System.out.print(preReq.getCodigo() + " ");
    }
   }
   System.out.println(); // '/n' entre os prereq's
  }
 }

//getter
public List<Disciplina> getDisciplinas() { return disciplinas;} //retorna o objeto disciplinas preenchido


//Buscador de código(retorna a disciplina)
public Disciplina buscarDisciplina(String codigo){
for (Disciplina d : disciplinas) {
 if (d.getCodigo().equals(codigo)) {return d;} //retorna mas nao printa d
}
return null; //fecha o método
}

}