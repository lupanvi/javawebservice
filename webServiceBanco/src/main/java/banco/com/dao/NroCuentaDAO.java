package banco.com.dao;

import banco.com.bean.NroCuentaBean;

public interface NroCuentaDAO {
	
	public NroCuentaBean obtenerCuenta(String cNroTarjeta, String cCodTarjeta, 
			String cTipoCuenta,	double dMonto) throws DAOException;

}
