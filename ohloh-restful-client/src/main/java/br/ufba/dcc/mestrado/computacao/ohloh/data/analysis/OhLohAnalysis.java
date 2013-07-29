package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.factoid.OhLohFactoid;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohAnalysis.NODE_NAME)
@Entity
@Table(name="analysis")
public class OhLohAnalysis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5783114228038874115L;

	public final static String NODE_NAME = "analysis";
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="url")
	private String url;
	
	@XStreamAlias("project_id")
	@Column(name="project_id")
	private Long projectId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="project_id", referencedColumnName="id", updatable=false, insertable=false)
	private OhLohProject ohlohProject;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("updated_at")
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("logged_at")
	@Column(name="logged_at")
	private Timestamp loggedAt;

	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("min_month")
	@Column(name="min_month")
	private Timestamp minMonth;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("max_month")
	@Column(name="max_month")
	private Timestamp maxMonth;
	
	@XStreamAlias("twelve_month_contributor_count")
	@Column(name="twelve_month_contributor_count")
	private Integer twelveMonthContributorCount;
	
	@XStreamAlias("total_code_lines")
	@Column(name="total_code_lines")
	private Integer totalCodeLines;
	
	@XStreamAlias("factoids")
	@OneToMany(mappedBy="ohLohAnalysis")
	private List<OhLohFactoid> ohLohFactoids;
	
	@XStreamAlias("languages")
	@ManyToOne
	@JoinColumn(name="languages_id", referencedColumnName="id")
	private OhLohAnalysisLanguages ohLohAnalysisLanguages;
	
	@XStreamAlias("main_language_id")
	@Column(name="main_language_id")
	private Integer mainLanguageId;
	
	@XStreamAlias("main_language_name")
	@Column(name="main_language_name")
	private String mainLanguageName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public OhLohProject getOhlohProject() {
		return ohlohProject;
	}

	public void setOhlohProject(OhLohProject ohlohProject) {
		this.ohlohProject = ohlohProject;
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

	public Integer getTwelveMonthContributorCount() {
		return twelveMonthContributorCount;
	}

	public void setTwelveMonthContributorCount(Integer twelveMonthContributorCount) {
		this.twelveMonthContributorCount = twelveMonthContributorCount;
	}

	public Integer getTotalCodeLines() {
		return totalCodeLines;
	}

	public void setTotalCodeLines(Integer totalCodeLines) {
		this.totalCodeLines = totalCodeLines;
	}

	public List<OhLohFactoid> getOhLohFactoids() {
		return ohLohFactoids;
	}

	public void setOhLohFactoids(List<OhLohFactoid> ohLohFactoids) {
		this.ohLohFactoids = ohLohFactoids;
	}

	public OhLohAnalysisLanguages getOhLohAnalysisLanguages() {
		return ohLohAnalysisLanguages;
	}

	public void setOhLohAnalysisLanguages(
			OhLohAnalysisLanguages ohLohAnalysisLanguages) {
		this.ohLohAnalysisLanguages = ohLohAnalysisLanguages;
	}

	public Integer getMainLanguageId() {
		return mainLanguageId;
	}

	public void setMainLanguageId(Integer mainLanguageId) {
		this.mainLanguageId = mainLanguageId;
	}

	public String getMainLanguageName() {
		return mainLanguageName;
	}

	public void setMainLanguageName(String mainLanguageName) {
		this.mainLanguageName = mainLanguageName;
	}

		
}
