package com.example.PSM01.Security;

import jakarta.persistence.*;

@Entity
@Table(name="operador")
public class Operador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codope;
	
	private String nicope;
	private String pasope;
	private String rolope;
	public int getCodope() {
		return codope;
	}
	public void setCodope(int codope) {
		this.codope = codope;
	}
	public String getNicope() {
		return nicope;
	}
	public void setNicope(String nicope) {
		this.nicope = nicope;
	}
	public String getPasope() {
		return pasope;
	}
	public void setPasope(String pasope) {
		this.pasope = pasope;
	}
	public String getRolope() {
		return rolope;
	}
	public void setRolope(String rolope) {
		this.rolope = rolope;
	}
	
}
