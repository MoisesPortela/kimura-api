package kimtela.api.domain.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


//DAO que herda do jpa e o spring faz todos os selects padrão automaticamente
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    Page<Pessoa> findAllByAtivoTrue(Pageable pageable);



}
