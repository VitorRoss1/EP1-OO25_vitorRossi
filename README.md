# Sistema Acadêmico - FCTE

## Descrição do Projeto

Desenvolvimento de um sistema acadêmico para gerenciar alunos, disciplinas, professores, turmas, avaliações e frequência, utilizando os conceitos de orientação a objetos (herança, polimorfismo e encapsulamento) e persistência de dados em arquivos.

O enunciado do trabalho pode ser encontrado aqui:
- [Trabalho 1 - Sistema Acadêmico](https://github.com/lboaventura25/OO-T06_2025.1_UnB_FCTE/blob/main/trabalhos/ep1/README.md)

## Dados do Aluno

- **Nome completo:** Vítor Da Costa Rossi De Oliveira
- **Matrícula:** 242015352
- **Curso:** Engenharias
- **Turma:** OO-T06 25.1

---

## Instruções para Compilação e Execução

1. **Compilação:**  
   [ javac *.java ]

2. **Execução:**  
   [ java Main ]

3. **Estrutura de Pastas:**  

  ├── src/
  
  │ ├── Aluno.java
  
  │ ├── AlunoEspecial.java
  
  │ ├── AlunoManager.java
  
  │ ├── Disciplina.java
  
  │ ├── Main.java
  
  │ ├── Turma.java
  
  │ └── TurmaManager.java
 
3. **Versão do JAVA utilizada:**  
    [ java 21 ]
---

## Vídeo de Demonstração

- [https://drive.google.com/file/d/1dxVLnQ6s_if0F5tho0aFE02E8hylol_F/view?usp=drive_web]

---

## Prints da Execução

1. Menu Principal:

 
![Captura de tela 2025-05-25 152508](https://github.com/user-attachments/assets/d558a27e-6599-4178-b3e9-329ab239017d)



2. Cadastro de Aluno:


![Captura de tela 2025-05-25 160121](https://github.com/user-attachments/assets/1b520ea8-0478-4e01-abcd-4e6bb3128366)



3. Relatório de Frequência/Notas:  


![Captura de tela 2025-05-25 191412](https://github.com/user-attachments/assets/60e704d0-f7bc-4bc1-b8a1-528e124c79ab)


---

## Principais Funcionalidades Implementadas

- [X] Cadastro, listagem, matrícula e trancamento de alunos (Normais e Especiais)
- [X] Cadastro de disciplinas e criação de turmas (presenciais e remotas)
- [X] Matrícula de alunos em turmas, respeitando vagas e pré-requisitos
- [X] Lançamento de notas e controle de presença
- [X] Cálculo de média final e verificação de aprovação/reprovação
- [ ] Relatórios de desempenho acadêmico por aluno, turma e disciplina
- [ ] Persistência de dados em arquivos (.txt ou .csv)
- [X] Tratamento de duplicidade de matrículas
- [X] Uso de herança, polimorfismo e encapsulamento

---

## Observações (Extras ou Dificuldades)

 -O sistema impede cadastro de alunos com matrícula repetida (alunoDuplo()).


 -Bloqueia matrícula além de 2 disciplinas para alunos especiais(podeMatricular() e 
incrementarDisciplinas()).


 -Dados são mantidos em memória durante a execução (sem arquivos).


---

## Contato

- vitorcrossi159@gmail.com
