package Service;

import java.util.List;

import javax.ejb.Local;

import model.Question;

@Local
public interface QuizService {

	public List<Question> getAllQuestion(); 
}
