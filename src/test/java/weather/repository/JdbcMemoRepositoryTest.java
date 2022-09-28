package weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import weather.domain.Memo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest(){
        //given
        Memo newMemo = new Memo(1, "this is new memo");
        //when
        jdbcMemoRepository.save(newMemo);
        //then
        Optional <Memo> result = jdbcMemoRepository.findById(1);
        assertEquals(result.get().getId()   , newMemo.getId());
    }

    @Test
    void findAllMemoTest(){
        //given
        List<Memo> memoList = jdbcMemoRepository.findAll();
        System.out.println(memoList);
        //when

        //then
        assertNotNull(memoList);
    }
}