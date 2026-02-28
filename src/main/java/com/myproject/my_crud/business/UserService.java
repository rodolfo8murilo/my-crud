package com.myproject.my_crud.business;

import com.myproject.my_crud.infrastructure.entitys.Usuario;
import com.myproject.my_crud.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public void saveUser(Usuario user){
        repository.saveAndFlush(user);
    }

    public Usuario searchUserToEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email not found!")

        );
    }

    public void deleteUserToEmail(String email){
        repository.deleteByEmail(email);
    }

    public void updateUserToId(Long id, Usuario user){
        Usuario userEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id not found!")
        );
        Usuario userUpdate = Usuario.builder().email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                        .id(userEntity.getId()).
                build();

        repository.saveAndFlush(userUpdate);

    }
}
