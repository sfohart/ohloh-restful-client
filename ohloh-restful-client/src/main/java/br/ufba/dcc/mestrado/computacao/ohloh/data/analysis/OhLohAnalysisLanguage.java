package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;


@XStreamAlias("language")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"content"})
public class OhLohAnalysisLanguage {

	@XStreamAsAttribute
	private Integer percentage;
	
	@XStreamAsAttribute
	private String color;
	
	@XStreamAsAttribute
	private String id;

	
	private String content;

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
