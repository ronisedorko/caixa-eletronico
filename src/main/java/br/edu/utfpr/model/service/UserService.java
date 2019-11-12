package br.edu.utfpr.model.service;

import br.edu.utfpr.model.dto.UserDTO;
import br.edu.utfpr.error.ValidationError;
import br.edu.utfpr.model.dao.RoleDAO;
import br.edu.utfpr.model.dao.UserDAO;
import br.edu.utfpr.model.entity.Role;
import br.edu.utfpr.model.entity.User;
import br.edu.utfpr.util.JPAUtil;

import java.util.ArrayList;
import java.util.List;

public class UserService extends AbstractService<String, User> {

    public UserService() {
        dao = new UserDAO();
    }

    public boolean saveUserAndRole(User user, Role role){
        RoleDAO roleDAO = new RoleDAO();

        boolean isSuccess = true;
        try {
            JPAUtil.beginTransaction();
            dao.save(user);
            roleDAO.save(role);
            JPAUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
            JPAUtil.rollBack();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return isSuccess;
    }

    public List<ValidationError> paramValidation(String id) {
        List<ValidationError> errors = new ArrayList<>();

        if (id == null || id.isEmpty()) {
            errors.add(new ValidationError("id", "O identificador do item é obrigatório."));
        }

        User user = getById(id);
        if (user == null) {
            errors.add(new ValidationError("id", "O item não foi encontrado."));
        }
        return (errors.isEmpty() ? null : errors);
    }

    public List<ValidationError> formValidation(UserDTO userDTO) {
        List<ValidationError> errors = new ArrayList<>();

        if (userDTO.getName() == null || userDTO.getName().isEmpty()) {
            errors.add(new ValidationError("name", "O campo nome é obrigatório."));
        }

        if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
            errors.add(new ValidationError("email", "O campo email é obrigatório."));
        }

        return (errors.isEmpty() ? null : errors);
    }


}
