package spring.Repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import spring.Model.Curso;
@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
}
