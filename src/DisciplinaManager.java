//Cadastrar disciplinas (nome, código, carga horária, pré-requisitos); 
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
  public void cadastrarDisciplina(Scanner scanner)
  {
        System.out.println("Digite o código da disciplina:");
        String codigo = scanner.next();

      // Verifica duplicidade
        if (buscarCodigo(codigo) != null) {
           System.out.println("Já existe disciplina com este código!");
           return;
        }

        System.out.println("Digite o nome da disciplina:");
        String nome = scanner.next();
        System.out.println("Digite a carga horária:");
        int cargaHoraria = scanner.nextInt();
        
        //pré-requisitos
        List<Disciplina> preRequisitos = new ArrayList<>();
        
        System.out.println("Cadastrar pré-requisitos? (s/n)");
      if (scanner.next().equalsIgnoreCase("s")) {
            System.out.println("Disciplinas disponíveis:");
            listarDisciplinas(); // Mostra as disciplinas já cadastradas
            
            System.out.println("Digite os códigos dos pré-requisitos (separados por vírgula):");
            scanner.nextLine();  //lê a linha toda
            String input = scanner.nextLine();
            
        if (!input.isEmpty()) {
          String[] codigos = input.split(","); //retorna um array de strings; divide uma string em substrings usando um delimitador definido ','
          for (String codigoTemp : codigos) {
            Disciplina prereq = buscarCodigo(codigoTemp.trim());// "all leading and trailing space removed"
            if (prereq != null) { //se a disciplina existe
            preRequisitos.add(prereq); } 
            else {
            System.out.println("Disciplina com código " + codigoTemp + " não encontrada!");
            }
          }
        }
      }
        // Instancia e add disciplina
        Disciplina novaDisciplina = new Disciplina(nome, codigo, cargaHoraria);
        novaDisciplina.setPreRequisitos(preRequisitos); // Define os pre req's 
        disciplinas.add(novaDisciplina);
        System.out.println("Disciplina cadastrada com sucesso!");
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
return null; //fecha o método(qnd nao achou)
}

}