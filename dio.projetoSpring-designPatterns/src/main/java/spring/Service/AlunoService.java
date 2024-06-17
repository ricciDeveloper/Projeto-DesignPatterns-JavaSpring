package spring.Service;

import spring.Model.Aluno;

public interface AlunoService {
    //Strategy: implementar os métodos definidos na interface
    //Facade: abstrair informações com subsistemas, provendo uma interface simples;
    Iterable<Aluno> buscarTodosAlunos();

    Aluno buscarPorId(Long id);

    void inserirAluno(Aluno aluno);

    void atualizarAluno(Long id, Aluno aluno);

    void deletarAluno(Long id);
}
