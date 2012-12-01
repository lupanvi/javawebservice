package banco.com.dao.implement;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

import banco.com.bean.UsuarioBean;
import banco.com.dao.DAOException;
import banco.com.dao.UsuarioDAO;


public class UsuarioDAOImpl implements UsuarioDAO {

	
	private DataSource dataSource;
	private SimpleJdbcTemplate simplejdbcTemplate;
    DefaultLobHandler lobHandler;
    
       
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simplejdbcTemplate = new SimpleJdbcTemplate(dataSource);
        
    }
    
    @Override
	public List<UsuarioBean> listarUsuarios() throws DAOException {
		
    	
    	String sql = " SELECT Pk_eUsuario, cDNI, cNombres "+    
                	 " FROM  tb_usuario ";
    	
    	List<Map<String, Object>> rows = this.simplejdbcTemplate.queryForList(sql);
    	List<UsuarioBean> listaUsuarios = new ArrayList<UsuarioBean>();
    	
    	if(rows!=null || rows.size() > 0){
			for (Map row : rows) {
				UsuarioBean usuario = new UsuarioBean();
				usuario.setPk_eUsuario((Integer)row.get("Pk_eUsuario"));
				usuario.setcDNI((String)row.get("cDNI"));
				usuario.setcNombres((String)row.get("cNombres"));
				
				listaUsuarios.add(usuario);
			}
		}
                	 
		return listaUsuarios;
	}
    
	public static void main(String[] args) {	
		
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		try {
			
			lista = dao.listarUsuarios();
		} catch (DAOException ex) {
			// TODO Auto-generated catch block
			ex.getMessage();
		}
		
        

	}



	public SimpleJdbcTemplate getSimplejdbcTemplate() {
		return simplejdbcTemplate;
	}



	public void setSimplejdbcTemplate(SimpleJdbcTemplate simplejdbcTemplate) {
		this.simplejdbcTemplate = simplejdbcTemplate;
	}



	public DataSource getDataSource() {
		return dataSource;
	}
	
	

}
