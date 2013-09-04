package br.ufba.dcc.mestrado.computacao.ohloh.entities;

import java.io.Serializable;

public interface OhLohBaseEntity<ID extends Number> extends Serializable {

	ID getId();
	
	void setId(ID id);
	
}
