package ServiceImpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Service.QuizService;
import model.Question;

@Stateless
@LocalBean
public class ServiceQuizImpl implements QuizService {
	@PersistenceContext(unitName="primary")
	EntityManager em;
	@Override
	public List<Question> getAllQuestion() {
		TypedQuery<Question> query = em.createQuery("Select c from Question c",Question.class);
		List<Question> questions = query.getResultList();
		return questions;
	}

}
