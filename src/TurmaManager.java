import java.util.Scanner;

public class TurmaManager {
//Listar turmas disponíveis e alunos matriculados em cada uma;
//Cadastrar turmas com professor responsável, semestre, forma de avaliação, se é presencial ou remota, sala, horário e capacidade máxima de alunos;
//Cada disciplina pode ter mais de uma turma, desde que em horário diferente.
//list turmas<Turma>

//METODO CADASTRAR TURMA
void CadastrarDisciplina(Scanner scanner, Disciplina){

    System.out.println("Insira: professor,semestre,avaliação(simples 0 ou ponderada 1), presencial(s/n),sala,horário e capacidade:");
    String professor = scanner.next();
    String semestre = scanner.next();
    String tipoAvaliacao = scanner.next();
    boolean presencial = scanner.next().equalsIgnoreCase("s"); //(s/n)
    String sala = presencial ?scanner.next() : "on-line"; //depende do resultado de presencial
    String horario = scanner.next();
    int capacidadeTurma = scanner.nextInt();



}

//METODO LISTAR TURMAS E ALUNOS
//TRANCAR








}
