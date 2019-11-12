package br.edu.utfpr.model.service;

import br.edu.utfpr.model.dao.RoleDAO;
import br.edu.utfpr.model.entity.Role;

public class RoleService extends AbstractService<String, Role> {

    public RoleService() {
        dao = new RoleDAO();
    }
}
