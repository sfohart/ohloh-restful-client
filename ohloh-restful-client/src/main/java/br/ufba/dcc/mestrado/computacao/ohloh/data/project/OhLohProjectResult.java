package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohProjectResult {

	@XStreamImplicit(itemFieldName="project")
	private List<OhLohProjectDTO> ohLohProjectDTOs;
	
	public List<OhLohProjectDTO> getOhLohProjects() {
		return ohLohProjectDTOs;
	}
	
	public void setOhLohProjects(List<OhLohProjectDTO> ohLohProjectDTOs) {
		this.ohLohProjectDTOs = ohLohProjectDTOs;
	}
	
}
