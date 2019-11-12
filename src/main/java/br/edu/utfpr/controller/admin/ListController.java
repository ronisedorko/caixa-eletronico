package br.edu.utfpr.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.dto.RoleDTO;
import br.edu.utfpr.model.entity.Role;
import br.edu.utfpr.model.service.RoleService;

@WebServlet("/admin/lista")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RoleService roleService = new RoleService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/admin/list.jsp";
		
		List<Role> roles = roleService.findAll();
        List<RoleDTO> roleDTOs = new ArrayList<>();

        for(Role role : roles){
        	RoleDTO dto = new RoleDTO(role.getName(), role.getRole());
        	roleDTOs.add(dto);
        }

        request.setAttribute("users", roleDTOs);
		
		request.getRequestDispatcher(address).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getContextPath() + "/admin/cadastro";
		response.sendRedirect(address);
	}

}
