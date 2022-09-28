package weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weather.domain.Memo;

@Repository
public interface JpaMemoRepository extends JpaRepository<Memo, Integer> {

}
