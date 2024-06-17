package spring.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.Model.Endereco;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>ViaCEP</b>.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author Joao Ricci
 */

@FeignClient(name = "ViaCepService", url = "https://viacep.com.br")
public interface ViaCepService {
    @GetMapping("/ws/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}