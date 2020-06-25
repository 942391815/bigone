package test.spring;

import java.util.List;

public interface UserService {
    List<User> selectLibrarian(int id);
}