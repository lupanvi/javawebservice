
create database BD_Banco;


use BD_Banco;





/* TABLA USUARIO*/


CREATE TABLE TB_Usuario(
	Pk_eUsuario integer not null,
	cDNI varchar(10) not null,
	cNombres varchar(50) not null,
	cApellidos varchar(50) not null,
	cTelefono varchar(10) not null,
	cDireccion varchar(50) not null,
	cSexo varchar(2) not null,
	
	CONSTRAINT Pk_eUsuario PRIMARY KEY CLUSTERED 
	(Pk_eUsuario ASC) 
	
) ;




/* TABLA TARJETA*/


CREATE TABLE TB_Tarjeta(
	Pk_eTarjeta integer  not null,
	Fk_eUsuario integer not null,
	cNroTarjeta varchar(16) not null,
	cCodTarjeta varchar(4) not null,
	dFecCreacion datetime not null,
	dFecVencimiento datetime not null,
	
	CONSTRAINT Pk_eTarjeta PRIMARY KEY CLUSTERED 
	(Pk_eTarjeta ASC) 

) ;


ALTER TABLE TB_Tarjeta
	ADD CONSTRAINT Fk_TB_Tarjeta_TB_Usuario FOREIGN KEY (Fk_eUsuario) REFERENCES TB_Usuario(Pk_eUsuario);
	

/* TABLA NUMERO DE CUENTA*/


CREATE TABLE TB_NroCuenta(
	Pk_eNroCuenta integer not null,
	Fk_eTarjeta integer not null,
	cNroCuenta varchar(15) not null,
	cTipoCuenta varchar(4) not null,
	dFecCreacion datetime not null,
	dFecVencimiento datetime not null,
	mLineaCredito decimal (8,2) not null,
	mSaldo decimal(8,2) null,
	
	CONSTRAINT Pk_eNroCuenta PRIMARY KEY CLUSTERED 
	(Pk_eNroCuenta ASC) 

) ;


ALTER TABLE TB_NroCuenta
	ADD CONSTRAINT Fk_TB_NroCuenta_TB_Tarjeta FOREIGN KEY (Fk_eTarjeta) REFERENCES TB_Tarjeta(Pk_eTarjeta);
	


/* TABLA TRANSACCION*/


CREATE TABLE TB_Transaccion(
	Pk_eTransaccion integer not null,
	Fk_eNroCuenta integer not null,
	cNroTransaccion varchar(15) not null,
	mMonto decimal(8,2) not null,
	dFecRegistro datetime not null,
	
	CONSTRAINT Pk_eTransaccion PRIMARY KEY CLUSTERED 
	(Pk_eTransaccion ASC) 
	
) ;

ALTER TABLE TB_Transaccion
	ADD CONSTRAINT Fk_TB_Transaccion_TB_NroCuenta FOREIGN KEY (Fk_eNroCuenta) REFERENCES TB_NroCuenta(Pk_eNroCuenta);
	
-- INSERT TABLA USUARIO

INSERT INTO TB_Usuario(cDNI,cNombres,cApellidos,cTelefono,cDireccion,cSexo) 
VALUES ('12345678', 'Juan Carlos', 'Mejía Medina', '5847458', 'Jr. Camelias 245 - San Isidro','M' );
INSERT INTO TB_Usuario(cDNI,cNombres,cApellidos,cTelefono,cDireccion,cSexo) 
VALUES ('02154785', 'Elena Rosa', 'Cavero Rivas', '996521458', 'Jr. Huandoy 012 - San Miguel','F' );
INSERT INTO TB_Usuario(cDNI,cNombres,cApellidos,cTelefono,cDireccion,cSexo) 
VALUES ('22548847', 'Julio Cesar', 'Arroyo Flores', '2520547', 'Av. Las Flores 25 - Surco','M' );
INSERT INTO TB_Usuario(cDNI,cNombres,cApellidos,cTelefono,cDireccion,cSexo) 
VALUES ('36523652', 'Rocío Reyna', 'Cueva Aburto', '958745899', 'Jr. Abancay 112 - Chorrillos','F' );
INSERT INTO TB_Usuario(cDNI,cNombres,cApellidos,cTelefono,cDireccion,cSexo) 
VALUES ('50481020', 'Daniel Erick', 'Herrera Gonzales', '4874968', 'Av. España 465 - Breña','M' );

select * from TB_Usuario;

-- INSERT TABLA TARJETA

INSERT INTO TB_Tarjeta(Fk_eUsuario,cNroTarjeta,cCodTarjeta,dFecCreacion,dFecVencimiento) 
VALUES (1, '6958474589632458', '0201', '2011-05-06 00:00:00', '2015-11-12 00:00:00');
INSERT INTO TB_Tarjeta(Fk_eUsuario,cNroTarjeta,cCodTarjeta,dFecCreacion,dFecVencimiento) 
VALUES (2, '2254887456965412', '1234', '2009-01-20 00:00:00', '2014-10-10 00:00:00');
INSERT INTO TB_Tarjeta(Fk_eUsuario,cNroTarjeta,cCodTarjeta,dFecCreacion,dFecVencimiento) 
VALUES (3, '3652458712459652', '4567', '2010-10-15 00:00:00', '2014-05-01 00:00:00');
INSERT INTO TB_Tarjeta(Fk_eUsuario,cNroTarjeta,cCodTarjeta,dFecCreacion,dFecVencimiento) 
VALUES (4, '5896475126984520', '8965', '2007-04-02 00:00:00', '2011-07-08 00:00:00');
INSERT INTO TB_Tarjeta(Fk_eUsuario,cNroTarjeta,cCodTarjeta,dFecCreacion,dFecVencimiento) 
VALUES (5, '4306982015632402', '3652', '2008-08-05 00:00:00', '2012-06-09 00:00:00');

select * from TB_Tarjeta;

-- INSERT TABLA NROCUENTA

INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(1, '7485968587', 'SOL', '2011-05-06 00:00:00', '2015-11-12 00:00:00', 3000.00, NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(1, '5252562510', 'DOL', '2013-05-06 00:00:00', '2015-11-12 00:00:00', 2000.00, NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(2, '4589632561', 'SOL', '2009-01-20 00:00:00', '2014-10-10 00:00:00', 5000.00 , NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(2, '2365893651', 'DOL', '2010-01-20 00:00:00', '2014-10-10 00:00:00', 4000.00, NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(3, '3652659856', 'SOL', '2010-10-15 00:00:00', '2014-05-01 00:00:00', 7000.00, NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(3, '3453455453', 'DOL', '2012-01-20 00:00:00', '2014-10-10 00:00:00', 6000.00, NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(4, '4596378545', 'SOL', '2007-04-02 00:00:00', '2011-07-08 00:00:00', 9000.00, NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(4, '9899778997', 'DOL', '2010-04-02 00:00:00', '2011-07-08 00:00:00', 8000.00, NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(5, '6636669636', 'SOL', '2008-08-05 00:00:00', '2012-06-09 00:00:00', 11000.00, NULL);
INSERT INTO TB_NroCuenta(Fk_eTarjeta,cNroCuenta,cTipoCuenta,dFecCreacion,dFecVencimiento, mLineaCredito, mSaldo) 
VALUES(5, '7545869967', 'DOL', '2010-08-05 00:00:00', '2012-06-09 00:00:00', 10000.00, NULL);

select * from TB_NroCuenta;