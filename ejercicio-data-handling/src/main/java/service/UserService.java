package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }
    // Lista de usuarios con un determinado rol
    public Set<User> getUserByRole(String roleName) {
        return userRepository.findUserByRole(roleName);
    }

    // Saldo deudor de un determinado usuario (nombre, apellido, importe y moneda)
    public List<Object> getInfoOfDebtor(User user) {
        List<Object> infoaux = new ArrayList<>();
        infoaux.add(user.getFirstName());
        infoaux.add(user.getLastName());
        infoaux.add(user.getDebt());
        infoaux.add(user.getDebt().getCurrency());
        return infoaux;
    }

    public List<User> getUsersWithQuestions() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().filter(u -> u.getDebt() == null).filter(u -> u.getQuestions() == null).collect(Collectors.toList());
    }

}
