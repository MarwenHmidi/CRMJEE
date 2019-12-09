package Service;

import javax.ejb.Local;

import model.User;

@Local
public interface UserService {
 public User getUserByEmailAndPassword(String email, String password);
}
