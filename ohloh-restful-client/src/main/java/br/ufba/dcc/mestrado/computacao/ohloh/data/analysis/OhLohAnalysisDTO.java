package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import java.sql.Timestamp;
import java.util.List;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.factoid.OhLohFactoidDTO;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohAnalysisDTO.NODE_NAME)
public class OhLohAnalysisDTO implements OhLohResultDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5783114228038874115L;

	public final static String NODE_NAME = "analysis";

	private String url;

	@XStreamAsAttribute
	@XStreamConverter(value = NullableLongConverter.class)
	private Long id;

	@XStreamAlias("project_id")
	@XStreamConverter(value = NullableLongConverter.class)
	private Long projectId;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("updated_at")
	private Timestamp updatedAt;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("logged_at")
	private Timestamp loggedAt;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("min_month")
	private Timestamp minMonth;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("max_month")
	private Timestamp maxMonth;

	@XStreamAlias("twelve_month_contributor_count")
	@XStreamConverter(value = NullableLongConverter.class)
	private Long twelveMonthContributorCount;

	@XStreamAlias("total_code_lines")
	@XStreamConverter(value = NullableLongConverter.class)
	private Long totalCodeLines;

	@XStreamAlias("factoids")
	private List<OhLohFactoidDTO> ohLohFactoidEntities;

	@XStreamAlias("languages")
	private OhLohAnalysisLanguagesDTO ohLohAnalysisLanguages;

	@XStreamAlias("main_language_id")
	@XStreamConverter(value = NullableLongConverter.class)
	private Long mainLanguageId;

	@XStreamAlias("main_language_name")
	private String mainLanguageName;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getLoggedAt() {
		return loggedAt;
	}

	public void setLoggedAt(Timestamp loggedAt) {
		this.loggedAt = loggedAt;
	}

	public Timestamp getMinMonth() {
		return minMonth;
	}

	public void setMinMonth(Timestamp minMonth) {
		this.minMonth = minMonth;
	}

	public Timestamp getMaxMonth() {
		return maxMonth;
	}

	public void setMaxMonth(Timestamp maxMonth) {
		this.maxMonth = maxMonth;
	}

	public Long getTwelveMonthContributorCount() {
		return twelveMonthContributorCount;
	}

	public void setTwelveMonthContributorCount(
			Long twelveMonthContributorCount) {
		this.twelveMonthContributorCount = twelveMonthContributorCount;
	}

	public Long getTotalCodeLines() {
		return totalCodeLines;
	}

	public void setTotalCodeLines(Long totalCodeLines) {
		this.totalCodeLines = totalCodeLines;
	}

	public List<OhLohFactoidDTO> getOhLohFactoids() {
		return ohLohFactoidEntities;
	}

	public void setOhLohFactoids(List<OhLohFactoidDTO> ohLohFactoidEntities) {
		this.ohLohFactoidEntities = ohLohFactoidEntities;
	}

	public OhLohAnalysisLanguagesDTO getOhLohAnalysisLanguages() {
		return ohLohAnalysisLanguages;
	}

	public void setOhLohAnalysisLanguages(
			OhLohAnalysisLanguagesDTO ohLohAnalysisLanguagesDTO) {
		this.ohLohAnalysisLanguages = ohLohAnalysisLanguagesDTO;
	}

	public Long getMainLanguageId() {
		return mainLanguageId;
	}

	public void setMainLanguageId(Long mainLanguageId) {
		this.mainLanguageId = mainLanguageId;
	}

	public String getMainLanguageName() {
		return mainLanguageName;
	}

	public void setMainLanguageName(String mainLanguageName) {
		this.mainLanguageName = mainLanguageName;
	}

}
