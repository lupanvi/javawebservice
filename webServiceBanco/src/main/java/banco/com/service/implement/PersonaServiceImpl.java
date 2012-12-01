package banco.com.service.implement;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import banco.com.bean.UsuarioBean;
import banco.com.dao.DAOException;
import banco.com.dao.UsuarioDAO;
import banco.com.service.PersonaService;

@WebService(endpointInterface="banco.com.service.PersonaService")
public class PersonaServiceImpl implements PersonaService {
	
	private UsuarioDAO usuarioDao;

	@Override
	public UsuarioBean obtenerUsuario(long codigo) {
		
		UsuarioBean usuario = new UsuarioBean();
		
		
		usuario.setPk_eUsuario(1);
		usuario.setcDNI("123456");
		usuario.setcNombres("Cindy");
		usuario.setcApellidos("Condor");
		usuario.setcDireccion("Lima");
		usuario.setcTelefono("458796");
		usuario.setcSexo("F");
		
		return usuario;
	}

	@Override
	public List<UsuarioBean> obtenerUsuarios(){
				
		List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
		
		try {
			usuarios = usuarioDao.listarUsuarios();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*UsuarioBean usuario1 = new UsuarioBean();
		usuario1.setPk_eUsuario(1);
		usuario1.setcDNI("123456");
		usuario1.setcNombres("Cindy");
		usuario1.setcApellidos("Condor");
		usuario1.setcDireccion("Lima");
		usuario1.setcTelefono("458796");
		usuario1.setcSexo("F");
		
		UsuarioBean usuario2 = new UsuarioBean();
		usuario2.setPk_eUsuario(2);
		usuario2.setcDNI("456425542");
		usuario2.setcNombres("Juan");
		usuario2.setcApellidos("Mejía");
		usuario2.setcDireccion("Tarapoto");
		usuario2.setcTelefono("965452452");
		usuario2.setcSexo("M");
		
		UsuarioBean usuario3 = new UsuarioBean();
		usuario3.setPk_eUsuario(3);
		usuario3.setcDNI("123456");
		usuario3.setcNombres("María");
		usuario3.setcApellidos("Llanos");
		usuario3.setcDireccion("Ica");
		usuario3.setcTelefono("98678");
		usuario3.setcSexo("F");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);*/
		
		return usuarios;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	

}
