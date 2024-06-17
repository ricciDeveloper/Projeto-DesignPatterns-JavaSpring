package spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.Model.Aluno;
import spring.Service.AlunoService;

@RestController
@RequestMapping("alunos")
public class AlunoRestController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<Iterable<Aluno>> buscarTodos(){
        return ResponseEntity.ok(alunoService.buscarTodosAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno) {
        alunoService.inserirAluno(aluno);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        alunoService.atualizarAluno(id, aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.ok().build();
    }


}

