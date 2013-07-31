package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias(OhLohAnalysisLanguageDTO.NODE_NAME)
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "content" })
public class OhLohAnalysisLanguageDTO implements OhLohResultDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1672599783346624942L;

	public final static String NODE_NAME = "language";

	@XStreamAsAttribute
	@XStreamConverter(value = NullableLongConverter.class)
	private Long id;

	@XStreamAsAttribute
	private Integer percentage;

	@XStreamAsAttribute
	private String color;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
