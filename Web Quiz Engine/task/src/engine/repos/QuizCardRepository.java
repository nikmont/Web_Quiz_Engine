package engine.repos;

import engine.model.QuizCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizCardRepository extends CrudRepository<QuizCard, Long> {

}
