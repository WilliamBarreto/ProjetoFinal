package br.ucb.util;

import java.sql.Types;

import org.hibernate.dialect.MySQL5Dialect;

public class HibernateMeuMysql5Dialect extends MySQL5Dialect{

	public HibernateMeuMysql5Dialect(){
		super();
		registerColumnType(Types.BOOLEAN, "bit");
		registerColumnType(Types.DATE, "datatime");
	}
}
