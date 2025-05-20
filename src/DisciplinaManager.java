import java.util.*;

public class DisciplinaManager {
        
//Cadastrar disciplinas (nome, código, carga horária, pré-requisitos);
//Matricular alunos em disciplinas existentes e com vagas disponíveis;
//Não pode ser matriculado se não tiver os pré-requisitos
//Trancar disciplinas e semestre;

private List<Disciplina> disciplinas = new ArrayList<>();

 //METODO CADASTRAR DISCIPLINA
 public void CadastrarDisciplina(String nomeDisciplina,String codigo,int cargaHoraria,List<Disciplina> preRequisitos){
disciplinas.add(new Disciplina(nomeDisciplina, codigo, cargaHoraria));
disciplinas.setPreRequisitos(preRequisitos);//
disciplinas.add()
 }

//METODO VERIFICAR DUPLICIDADE DE DISCIPLINAS
public Disciplina buscarCodigo(String codigo) {
    for (Disciplina d : disciplinas) {
      if (d.getCodigo().equals(codigo)) return d;
    }
        return null; //flag qnd nao ha dois codigos iguais
}

//LISTAR DISCIPLINAS(PARA POSSIVEIS VERIFICAÇOES/ NAO SERA EXIBIDO)
public void listarDisciplinas() {
 for (Disciplina d : disciplinas) { //d é temp
 System.out.println("| Código:" + d.getCodigo() + " | " +d.getNome()+ " | ");
  }
}
//getter pra disciplinas
public List<Disciplina> getDisciplinas() { return disciplinas; }
}