package spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.Model.Endereco;
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
