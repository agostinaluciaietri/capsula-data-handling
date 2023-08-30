package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserById(String id);

    Set<User> findUserByRole(String nombreRol);
    //Lista de usuarios con un determinado rol
    Set<User> getUserByRole(String roleName);
    List<Object> getInfoOfDebtor(User user);
    List<User> getUsersWithQuestions();
}
