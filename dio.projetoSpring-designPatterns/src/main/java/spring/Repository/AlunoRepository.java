package spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.Model.Aluno;

/**
 * Repository do Modelo de entidade Aluno
 * @Author João Victor Ricci
 */
@Repository
public interface AlunoRepository extends CrudRepository<Aluno,Long> {
}
