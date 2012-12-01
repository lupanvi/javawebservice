package banco.com.dao;

import java.util.List;

import banco.com.bean.UsuarioBean;

public interface UsuarioDAO {
	
	public List<UsuarioBean> listarUsuarios() throws DAOException;

}
