package ir.maktab.service.user;

import ir.maktab.model.User;
import ir.maktab.repository.Repository;

public class UserServiceIml implements UserService {

    private final Repository<User> repository;

    public UserServiceIml(){
        repository =new Repository<User>() {};
    }

    @Override
    public User save(User user) {
       return repository.save(user);
    }
}
