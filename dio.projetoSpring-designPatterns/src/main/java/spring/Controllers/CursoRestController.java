package spring.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.Model.Curso;
import spring.Repository.CursoRepository;

import java.util.Optional;

@RestController
@RequestMapping("cursos")
public class CursoRestController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<Curso> inserir(@RequestBody Curso curso) {
        cursoRepository.save(curso);
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Outros métodos para atualizar, deletar, etc., se necessário
}
