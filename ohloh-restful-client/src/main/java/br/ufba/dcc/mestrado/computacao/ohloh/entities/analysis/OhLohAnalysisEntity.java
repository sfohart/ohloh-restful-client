package br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.factoid.OhLohFactoidEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;

@Entity
@Table(name = OhLohAnalysisEntity.NODE_NAME)
public class OhLohAnalysisEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5783114228038874115L;

	public final static String NODE_NAME = "analysis";

	@Column(name = "url")
	private String url;

	@Column(name = "project_id")
	private Long projectId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "project_id", referencedColumnName = "id", updatable = false, insertable = false)
	private OhLohProjectEntity ohlohProject;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "logged_at")
	private Timestamp loggedAt;

	@Column(name = "min_month")
	private Timestamp minMonth;

	@Column(name = "max_month")
	private Timestamp maxMonth;

	@Column(name = "twelve_month_contributor_count")
	private Integer twelveMonthContributorCount;

	@Column(name = "total_code_lines")
	private Integer totalCodeLines;

	@OneToMany(mappedBy = "ohLohAnalysis")
	private List<OhLohFactoidEntity> ohLohFactoidEntities;

	@ManyToOne
	@JoinColumn(name = "languages_id", referencedColumnName = "id")
	private OhLohAnalysisLanguagesEntity ohLohAnalysisLanguagesEntity;

	@Column(name = "main_language_id")
	private Integer mainLanguageId;

	@Column(name = "main_language_name")
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

	public OhLohProjectEntity getOhlohProject() {
		return ohlohProject;
	}

	public void setOhlohProject(OhLohProjectEntity ohlohProject) {
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

	public void setTwelveMonthContributorCount(
			Integer twelveMonthContributorCount) {
		this.twelveMonthContributorCount = twelveMonthContributorCount;
	}

	public Integer getTotalCodeLines() {
		return totalCodeLines;
	}

	public void setTotalCodeLines(Integer totalCodeLines) {
		this.totalCodeLines = totalCodeLines;
	}

	public List<OhLohFactoidEntity> getOhLohFactoids() {
		return ohLohFactoidEntities;
	}

	public void setOhLohFactoids(List<OhLohFactoidEntity> ohLohFactoidEntities) {
		this.ohLohFactoidEntities = ohLohFactoidEntities;
	}

	public OhLohAnalysisLanguagesEntity getOhLohAnalysisLanguages() {
		return ohLohAnalysisLanguagesEntity;
	}

	public void setOhLohAnalysisLanguages(
			OhLohAnalysisLanguagesEntity ohLohAnalysisLanguagesEntity) {
		this.ohLohAnalysisLanguagesEntity = ohLohAnalysisLanguagesEntity;
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
