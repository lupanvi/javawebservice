package banco.com.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import banco.com.bean.UsuarioBean;


@WebService
public interface PersonaService {
	
	@WebResult(name="usuario")
	UsuarioBean obtenerUsuario(
			@WebParam(name="codigo") long codigo);
	
	@WebResult(name="usuarios")
	List<UsuarioBean> obtenerUsuarios();

}
