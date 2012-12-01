package banco.com.bean;

import java.io.Serializable;

public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int pk_eUsuario; 
	private String cDNI;
	private String cNombres;
	private String cApellidos;
	private String cTelefono;
	private String cDireccion;
	private String cSexo;
	
	public int getPk_eUsuario() {
		return pk_eUsuario;
	}
	public void setPk_eUsuario(int pk_eUsuario) {
		this.pk_eUsuario = pk_eUsuario;
	}
	public String getcDNI() {
		return cDNI;
	}
	public void setcDNI(String cDNI) {
		this.cDNI = cDNI;
	}
	public String getcNombres() {
		return cNombres;
	}
	public void setcNombres(String cNombres) {
		this.cNombres = cNombres;
	}
	public String getcApellidos() {
		return cApellidos;
	}
	public void setcApellidos(String cApellidos) {
		this.cApellidos = cApellidos;
	}
	public String getcTelefono() {
		return cTelefono;
	}
	public void setcTelefono(String cTelefono) {
		this.cTelefono = cTelefono;
	}
	public String getcDireccion() {
		return cDireccion;
	}
	public void setcDireccion(String cDireccion) {
		this.cDireccion = cDireccion;
	}
	public String getcSexo() {
		return cSexo;
	}
	public void setcSexo(String cSexo) {
		this.cSexo = cSexo;
	}
	
	


}
