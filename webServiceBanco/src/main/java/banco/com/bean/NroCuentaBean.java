package banco.com.bean;

import java.io.Serializable;
import java.util.Date;

public class NroCuentaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int pk_eNroCuenta;
	private String cNroTarjeta;
	private String cNroCuenta;
	private String cTipoCuenta;
	private Date dFecCreacion;
	private Date dFecVencimiento;
	private double mLineaCredito;
	private double mSaldo;
	
	
	public int getPk_eNroCuenta() {
		return pk_eNroCuenta;
	}
	public void setPk_eNroCuenta(int pk_eNroCuenta) {
		this.pk_eNroCuenta = pk_eNroCuenta;
	}
	public String getcNroTarjeta() {
		return cNroTarjeta;
	}
	public void setcNroTarjeta(String cNroTarjeta) {
		this.cNroTarjeta = cNroTarjeta;
	}
	public String getcNroCuenta() {
		return cNroCuenta;
	}
	public void setcNroCuenta(String cNroCuenta) {
		this.cNroCuenta = cNroCuenta;
	}
	public String getcTipoCuenta() {
		return cTipoCuenta;
	}
	public void setcTipoCuenta(String cTipoCuenta) {
		this.cTipoCuenta = cTipoCuenta;
	}
	public Date getdFecCreacion() {
		return dFecCreacion;
	}
	public void setdFecCreacion(Date dFecCreacion) {
		this.dFecCreacion = dFecCreacion;
	}
	public Date getdFecVencimiento() {
		return dFecVencimiento;
	}
	public void setdFecVencimiento(Date dFecVencimiento) {
		this.dFecVencimiento = dFecVencimiento;
	}
	public double getmLineaCredito() {
		return mLineaCredito;
	}
	public void setmLineaCredito(double mLineaCredito) {
		this.mLineaCredito = mLineaCredito;
	}
	public double getmSaldo() {
		return mSaldo;
	}
	public void setmSaldo(double mSaldo) {
		this.mSaldo = mSaldo;
	}
	
	

}
