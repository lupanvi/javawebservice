package banco.com.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.lang.StringUtils;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

import banco.com.bean.NroCuentaBean;
import banco.com.dao.DAOException;
import banco.com.dao.NroCuentaDAO;

public class NroCuentaDAOImpl implements NroCuentaDAO{

	private DataSource dataSource;
	private SimpleJdbcTemplate simplejdbcTemplate;
    DefaultLobHandler lobHandler;
    
       
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simplejdbcTemplate = new SimpleJdbcTemplate(dataSource);
        lobHandler = new DefaultLobHandler();
        
    }
    
	
	@Override
	public NroCuentaBean obtenerCuenta(String cNroTarjeta, String cCodTarjeta,
			String cTipoCuenta, double dMonto) throws DAOException {

		String sql = " select C.Pk_eNroCuenta, T.cNroTarjeta, C.cNroCuenta from tb_nrocuenta C " + 
					 " inner join tb_tarjeta T on C.Fk_eTarjeta = T.Pk_eTarjeta " + 
					 " where T.cNroTarjeta = ? and T.cCodTarjeta = ? " +
					 " and C.cTipoCuenta = ? and C.mLineaCredito >= ? ";	
		
		ParameterizedRowMapper<NroCuentaBean> mapper = new ParameterizedRowMapper<NroCuentaBean>() {
			public NroCuentaBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				NroCuentaBean nroCuenta = new NroCuentaBean();
				
				int pkNumCta = rs.getInt("Pk_eNroCuenta");
				if(pkNumCta > 0){
					nroCuenta.setPk_eNroCuenta(pkNumCta);
					nroCuenta.setcNroTarjeta(rs.getString("cNroTarjeta"));
					nroCuenta.setcNroCuenta(rs.getString("cNroCuenta"));
					return nroCuenta;
				}
				else
					return null;
				
				
			
			
			}
			};
				
			NroCuentaBean nroCuenta = new NroCuentaBean();
			
			nroCuenta = this.simplejdbcTemplate.queryForObject(sql, mapper, cNroTarjeta, cCodTarjeta, cTipoCuenta,dMonto);
			
			if(nroCuenta == null)
				return null;
			else
				return nroCuenta;
			 
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
