package techlogistics.repository;

import techlogistics.model.EstadoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Integer> {}