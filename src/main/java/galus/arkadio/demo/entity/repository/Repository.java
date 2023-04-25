package galus.arkadio.demo.entity.repository;

import galus.arkadio.demo.entity.Konsekrowany;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Konsekrowany,Long> {


}
