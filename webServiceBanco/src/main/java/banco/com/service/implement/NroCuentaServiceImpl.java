package banco.com.service.implement;

import javax.jws.WebService;

import banco.com.bean.NroCuentaBean;
import banco.com.dao.DAOException;
import banco.com.dao.NroCuentaDAO;
import banco.com.service.NroCuentaService;

@WebService(endpointInterface="banco.com.service.NroCuentaService")
public class NroCuentaServiceImpl implements NroCuentaService {

	private NroCuentaDAO nroCuentaDAO;
	
	@Override
	public String obtenerTransaccion(String cNroTarjeta, String cCodTarjeta,
			String cTipoCuenta, double dMonto) {

		NroCuentaBean nroCuenta=null;
		
		try {
			nroCuenta = new NroCuentaBean();
			nroCuenta = nroCuentaDAO.obtenerCuenta(cNroTarjeta, cCodTarjeta, cTipoCuenta, dMonto);
		} catch (DAOException ex) {
			// TODO Auto-generated catch block
			ex.getMessage();
		}
		
		if(nroCuenta != null)
			return "exito";
		else
			return "fracaso";
	}

	public NroCuentaDAO getNroCuentaDAO() {
		return nroCuentaDAO;
	}

	public void setNroCuentaDAO(NroCuentaDAO nroCuentaDAO) {
		this.nroCuentaDAO = nroCuentaDAO;
	}
	

}
