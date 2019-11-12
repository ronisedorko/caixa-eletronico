package br.edu.utfpr.model.dto;

public class RoleDTO {

    private String name;
    private String role;
    
    public RoleDTO() {
    	
    }
    
    public RoleDTO(String name, String role) {
    	this.name = name;
    	this.role = role;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
