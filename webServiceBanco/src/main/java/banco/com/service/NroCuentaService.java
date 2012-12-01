package banco.com.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService
public interface NroCuentaService {
	
	@WebResult(name="transaccion")
	String obtenerTransaccion(
			@WebParam(name="cNroTarjeta") String cNroTarjeta,
			@WebParam(name="cCodTarjeta") String cCodTarjeta,
			@WebParam(name="cTipoCuenta") String cTipoCuenta,
			@WebParam(name="dMonto") double dMonto);

}
