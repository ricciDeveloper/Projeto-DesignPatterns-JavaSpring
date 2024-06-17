package spring.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Model.Aluno;
import spring.Model.Curso;
import spring.Model.Endereco;
import spring.Repository.AlunoRepository;
import spring.Repository.CursoRepository;
import spring.Repository.EnderecoRepository;
import spring.Service.AlunoService;
import spring.Service.ViaCepService;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link AlunoService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author Joao Victor Ricci
 */
@Service
public class AlunoServiceImpl implements AlunoService {

    //Singleton:injetar os componentes springcom @Autorwired
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private CursoRepository cursoRepository;


    //Strategy: implementar os métodos definidos na interface
    //Facade: abstrair informações com subsistemas, provendo uma interface simples;
    @Override
    public Iterable<Aluno> buscarTodosAlunos() {
        //Busca todos alunos
        return alunoRepository.findAll();
    }

    @Override
    public Aluno buscarPorId(Long id) {
        //Busca por Id do aluno
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.get();
    }

    @Override
    public void inserirAluno(Aluno aluno) {
        // Verifique se o curso está presente e válido
        if (aluno.getCurso() != null) {
            Optional<Curso> curso;
            curso = cursoRepository.findById(aluno.getCurso().getId());
            if (curso.isPresent()) {
                aluno.setCurso(curso.get());
            } else {
                throw new IllegalArgumentException("Curso não encontrado.");
            }
        }
        // Salva o objeto aluno
        salvarAlunoComCep(aluno);
    }

    @Override
    public void atualizarAluno(Long id, Aluno aluno) {
        Optional<Aluno> alunoBd = alunoRepository.findById(id);
        if (alunoBd.isPresent()) {
            if (aluno.getCurso() != null) {
                Optional<Curso> curso = cursoRepository.findById(aluno.getCurso().getId());
                if (curso.isPresent()) {
                    aluno.setCurso(curso.get());
                } else {
                    throw new IllegalArgumentException("Curso não encontrado.");
                }
            }
            salvarAlunoComCep(aluno);
        } else {
            System.out.println("Aluno não localizado pelo Id informado.");
        }
    }

    @Override
    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    private void salvarAlunoComCep(Aluno aluno){
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = aluno.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()->{
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        aluno.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        alunoRepository.save(aluno);
    }

}
