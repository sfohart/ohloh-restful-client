package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohProjectResult {

	@XStreamImplicit(itemFieldName="project")
	private List<OhLohProject> ohLohProjects;
	
	public List<OhLohProject> getOhLohProjects() {
		return ohLohProjects;
	}
	
	public void setOhLohProjects(List<OhLohProject> ohLohProjects) {
		this.ohLohProjects = ohLohProjects;
	}
	
}
