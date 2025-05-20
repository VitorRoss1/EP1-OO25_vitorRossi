import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DisciplinaManager {
        
//Cadastrar disciplinas (nome, código, carga horária, pré-requisitos);
//Matricular alunos em disciplinas existentes e com vagas disponíveis;
//Não pode ser matriculado se não tiver os pré-requisitos
//Trancar disciplinas e semestre;

List<Disciplina> preRequisitos = ArrayList<>();

//METODO CADASTRAR DISCIPLINA
void CadastrarDisciplina(Scanner scanner){
    System.out.println("Insira e pressione enter,em ordem: Nome da disciplina, código, carga horária e seus pré-requisitos:");
    String nomeDisciplina = scanner.next();
    String codigo = scanner.next();
    String cargaHoraria = scanner.next();
    List<Disciplina> preRequisitos = scanner.next();
}

 //METODO MATRICULAR
   public boolean matricular(Aluno alunoX ,Disciplina y){
    if(matriculados.size() < getcapacidadeTurma && y : disciplinas ){
        matriculados.add(alunoX); 
        return true; //flag de foi matriculado
    }  //FALTA VERIFICAR OS PREREQUISITOS(MATERIAS)
   }

   //TRANCAR 
 .remove

}