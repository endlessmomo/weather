package weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weather.domain.Diary;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    List <Diary> findAllByDate(LocalDate date);
    List <Diary> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
    Diary getFirstByDate(LocalDate date);
}
