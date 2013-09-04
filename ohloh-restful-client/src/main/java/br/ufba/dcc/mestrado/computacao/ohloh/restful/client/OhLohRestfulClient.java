package br.ufba.dcc.mestrado.computacao.ohloh.restful.client;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.log4j.Logger;

import br.com.caelum.restfulie.Response;
import br.com.caelum.restfulie.RestClient;
import br.com.caelum.restfulie.Restfulie;
import br.com.caelum.restfulie.mediatype.XmlMediaType;
import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccountDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccountResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.activityfact.OhLohActivityFactDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.activityfact.OhLohActivityFactResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact.OhLohContributorFactDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact.OhLohContributorFactResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment.OhLohEnlistmentDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment.OhLohEnlistmentResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.factoid.OhLohFactoidDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.factoid.OhLohFactoidResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.kudo.OhLohKudoDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.kudo.OhLohKudoResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.sizefact.OhLohSizeFactDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.sizefact.OhLohSizeFactResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackResult;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohAccountResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohActivityFactResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohAnalysisResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohBaseResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohContributorFactResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohEnlistmentResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohFactoidResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohKudoResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohProjectResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohSizeFactResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohStackResponse;
import br.ufba.dcc.mestrado.computacao.qualifier.ConfigurationArrayValue;
import br.ufba.dcc.mestrado.computacao.qualifier.ConfigurationValue;

@Singleton
public class OhLohRestfulClient {
	
	public static Logger logger = Logger.getLogger(OhLohRestfulClient.class);
	
	@Inject
	@ConfigurationArrayValue(value = {
			@ConfigurationValue(value="meta.ohloh.api.key.01", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.02", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.03", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.04", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.05", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.06", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.07", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.08", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.09", required=true),
			@ConfigurationValue(value="meta.ohloh.api.key.10", required=true)
	})
	private String[] apiKey;
	
	private Integer currentApiKey;

	private static Properties properties;
	
	public OhLohRestfulClient() {
		this.currentApiKey = 0;
	}
	
	public String[] getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String[] apiKey) {
		this.apiKey = apiKey;
	}
	
	public Integer getCurrentApiKey() {
		return currentApiKey;
	}
	
	public void setCurrentApiKey(Integer currentApiKey) {
		this.currentApiKey = currentApiKey;
	}
	
	public static Properties getProperties() throws IOException {
		if (properties == null) {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("ohloh.properties");
			
			properties = new Properties();
			properties.load(is);
		}
		
		return properties;
	}
	
	/**
	 * 
	 * @return
	 */
	public OhLohAccountResponse getAllAccounts(OhLohBaseRequest request) {
		
		OhLohAccountResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.account.all");
			
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohAccountResponse.class,
					OhLohAccountResult.class,
					OhLohAccountDTO.class));
			
			resource = this.<OhLohAccountResponse>processResponse(url, request, restfulie);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	private <T extends OhLohBaseResponse> T processResponse(String url, OhLohBaseRequest request, RestClient restClient, String... params) {
		T resource = null;
		
		boolean retry = true;
		String uri = "";
		
		while (retry) {
			retry = false;
			
			if (getApiKey() != null) {				
				if (getCurrentApiKey() < getApiKey().length) {				
					String apiKey = getApiKey()[getCurrentApiKey()];
					
					
					
					if (params != null && params.length > 0) {
						String[] args = Arrays.copyOf(params, params.length + 1);
						args[args.length -1] = apiKey;
						uri = MessageFormat.format(url, args);
					} else {
						uri = MessageFormat.format(url, apiKey);
					}
					
					uri = processRequest(uri, request);
					
					Response response = restClient.at(uri).get();
					
					resource = response.getResource();
					
					if (resource != null && ! resource.isStatusSuccess()) {
						if (OhLohBaseResponse.ERROR_API_KEY_EXCEDED.equals(resource.getError())) {
							setCurrentApiKey(getCurrentApiKey() + 1);
							retry = true;
						}						
					}
				}
			}
		};
			
		
		logger.debug(uri);
		return resource;
	}
	
	private String processRequest(String uri, OhLohBaseRequest request) {
		String newURI = uri;
		
		if (request != null) {
			if (request.getQuery() != null && ! "".equals(request.getQuery())) {
				newURI += "&query=" + request.getQuery();
			}
			
			if (request.getSort() != null && ! "".equals(request.getSort())) {
				newURI += "&sort=" + request.getSort();
			}
			
			if (request.getPage() != null) {
				newURI += "&page=" + request.getPage();
			}
		}
		
		return newURI;
	}

	/**
	 * 
	 * @param accountId Id da conta do usu�rio do OhLoh
	 * @return
	 */
	public OhLohAccountDTO getAccountById(String accountId, OhLohBaseRequest request) {
		
		OhLohAccountDTO account = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.account");
						
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohAccountResponse.class,
					OhLohAccountResult.class,
					OhLohAccountDTO.class));
			
			OhLohAccountResponse resource = this.<OhLohAccountResponse>processResponse(url, request, restfulie);
			if (OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohAccountDTO> ohLohAccountDTOs = resource.getResult().getOhLohAccounts();
				if (ohLohAccountDTOs != null && ! ohLohAccountDTOs.isEmpty())
					account =  ohLohAccountDTOs.get(0);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return account;
	}

	/**
	 * 
	 * @return
	 */
	public OhLohProjectResponse getAllProjects(OhLohBaseRequest request) {
		
		OhLohProjectResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.project.all");
			
			RestClient restfulie = Restfulie.custom();
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohProjectResponse.class,
					OhLohProjectResult.class,
					OhLohProjectDTO.class));
			
			resource = this.<OhLohProjectResponse>processResponse(url, request, restfulie);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	/**
	 * 
	 * @param projectId ID de um projeto cadastrado no OhLoh
	 * @return
	 */
	public OhLohProjectDTO getProject(String projectId, OhLohBaseRequest request) {
		OhLohProjectDTO project = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.project");
			
			
			RestClient restfulie = Restfulie.custom();
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohProjectResponse.class,
					OhLohProjectResult.class,
					OhLohProjectDTO.class));
			
			OhLohProjectResponse resource = this.<OhLohProjectResponse>processResponse(url, request, restfulie, projectId);
			
			if (OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohProjectDTO> ohLohProjectDTOs = resource.getResult().getOhLohProjects();
				if (ohLohProjectDTOs != null && ! ohLohProjectDTOs.isEmpty()) {
					project = ohLohProjectDTOs.get(0);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return project;
	}
	
	/**
	 * 
	 * @param accountId
	 * @param stackId
	 * @return
	 */
	public OhLohStackDTO getSingleAccountStack(String accountId, String stackId, OhLohBaseRequest request) {
		
		OhLohStackDTO stack = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.stack.account");
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohStackResponse.class,
					OhLohStackResult.class,
					OhLohStackDTO.class));
			
			
			OhLohStackResponse resource = this.<OhLohStackResponse>processResponse(url, request, restfulie);
			if (OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohStackDTO> ohLohStackDTOs = resource.getResult().getOhLohStacks();
				if (ohLohStackDTOs != null && ! ohLohStackDTOs.isEmpty()) {
					stack = ohLohStackDTOs.get(0);
				}
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return stack;
	}
	
	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public OhLohStackDTO getDefaultAccountStack(String accountId, OhLohBaseRequest request) {
		OhLohStackDTO stack = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.stack.account.default");
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohStackResponse.class,
					OhLohStackResult.class,
					OhLohStackDTO.class));
			
			OhLohStackResponse resource = this.<OhLohStackResponse>processResponse(url, request, restfulie, accountId);
			if (OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohStackDTO> ohLohStackDTOs = resource.getResult().getOhLohStacks();
				if (ohLohStackDTOs != null && ! ohLohStackDTOs.isEmpty()) {
					stack = ohLohStackDTOs.get(0);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return stack;
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public List<OhLohStackDTO> getProjectStacks(String projectId, OhLohBaseRequest request) {
		List<OhLohStackDTO> stackList = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.stack.project");
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohStackResponse.class,
					OhLohStackResult.class,
					OhLohStackDTO.class));
			
			OhLohStackResponse resource = this.<OhLohStackResponse>processResponse(url, request, restfulie, projectId);
			
			if (OhLohStackResponse.SUCCESS.equals(resource.getStatus())) {
				OhLohStackResult result = resource.getResult();
				if (result != null) {
					return result.getOhLohStacks();
				}
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return stackList;
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public OhLohFactoidResponse getAllFactoidsByProject(String projectId, OhLohBaseRequest request) {
		OhLohFactoidResponse resource = null;
		
		try {
			
			String url = getProperties().getProperty("meta.ohloh.api.factoid.project");
						
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohFactoidResponse.class,
					OhLohFactoidResult.class,
					OhLohFactoidDTO.class));
			
			resource = this.<OhLohFactoidResponse>processResponse(url, request, restfulie);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	/**
	 * 
	 * @param projectId
	 * @param factoidId
	 * @return
	 */
	public OhLohFactoidResponse getSingleFactoidByProject(String projectId, String factoidId, OhLohBaseRequest request) {
		OhLohFactoidResponse resource = null;
		
		try {
			
			String url = getProperties().getProperty("meta.ohloh.api.factoid");
						
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohFactoidResponse.class,
					OhLohFactoidResult.class,
					OhLohFactoidDTO.class));
			
			resource = this.<OhLohFactoidResponse>processResponse(url, request, restfulie);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	public OhLohSizeFactResponse getLatestSizeFackByProject(String projectId, OhLohBaseRequest request) {
		OhLohSizeFactResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.size_facts.latest");
			
			RestClient restfulie = Restfulie.custom();
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohSizeFactResponse.class,
					OhLohSizeFactResult.class,
					OhLohSizeFactDTO.class));
			
			resource = this.<OhLohSizeFactResponse>processResponse(url, request, restfulie);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	/**
	 * 
	 * @param projectId
	 * @param analysisId
	 * @param request
	 * @return
	 */
	public OhLohSizeFactResponse getAnalysizSizeFactByProject(String projectId, String analysisId, OhLohBaseRequest request) {
		OhLohSizeFactResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.size_facts");
			
			RestClient restfulie = Restfulie.custom();
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohSizeFactResponse.class,
					OhLohSizeFactResult.class,
					OhLohSizeFactDTO.class));
			
			resource = this.<OhLohSizeFactResponse>processResponse(url, request, restfulie);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	/**
	 * 
	 * @param analysisId
	 * @param request
	 * @return
	 */
	public OhLohAnalysisDTO getAnalysisById(String projectId, String analysisId, OhLohBaseRequest request) {
		
		OhLohAnalysisDTO analysis = null;
		
		try {
			
			String url = getProperties().getProperty("meta.ohloh.api.analysis");

			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohAnalysisResponse.class,
					OhLohAnalysisResult.class,
					OhLohAnalysisDTO.class));
			
			OhLohAnalysisResponse resource = this.<OhLohAnalysisResponse>processResponse(url, request, restfulie, projectId, analysisId);
			if (resource != null && OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				analysis = resource.getResult().getAnalysis();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return analysis;
	}
	
	/**
	 * 
	 * @param projectId
	 * @param request
	 * @return
	 */
	public OhLohAnalysisDTO getLatestAnalysis(String projectId, OhLohBaseRequest request) {
		return getAnalysisById(projectId, "latest", request);
	}
	
	/**
	 * 
	 * @return
	 */
	public OhLohContributorFactDTO getProjectContributorFactById(String projectId, String contributorId, OhLohBaseRequest request) {
		OhLohContributorFactDTO contributorFact = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.contributor_facts");
						
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohContributorFactResponse.class,
					OhLohContributorFactResult.class,
					OhLohContributorFactDTO.class));

			OhLohContributorFactResponse resource = this.<OhLohContributorFactResponse>processResponse(url, request, restfulie);
			
			if (resource != null && OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohContributorFactDTO> ohLohContributorFactDTOs = resource.getResult().getOhLohContributorFacts();
				
				if (ohLohContributorFactDTOs != null && ! ohLohContributorFactDTOs.isEmpty()) {
					contributorFact = ohLohContributorFactDTOs.get(0);
				}
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return contributorFact;
	}
	
	/**
	 * 
	 * @param projectId
	 * @param request
	 * @return
	 */
	public OhLohContributorFactResponse getAllProjectContributorFacts(String projectId, OhLohBaseRequest request) {
		OhLohContributorFactResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.contributor_facts.all");
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohContributorFactResponse.class,
					OhLohContributorFactResult.class,
					OhLohContributorFactDTO.class));
			
			
			resource = this.<OhLohContributorFactResponse>processResponse(url, request, restfulie);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	/**
	 * 
	 * @param projectId
	 * @param analysisId
	 * @return
	 */
	public OhLohActivityFactResponse getProjectActivityFactByAnalysisId(String projectId, String analysisId) {
		OhLohActivityFactResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.activity_facts");
						
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohActivityFactResponse.class,
					OhLohActivityFactResult.class,
					OhLohActivityFactDTO.class));
			
			
			resource = this.<OhLohActivityFactResponse>processResponse(url, null, restfulie);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public OhLohActivityFactResponse getLatestProjectActivityFacts(String projectId) {
		return getProjectActivityFactByAnalysisId(projectId, "latest");
	}
	
	/**
	 * 
	 * @param projectId
	 * @param request
	 * @return
	 */
	public OhLohEnlistmentResponse getAllProjectEnlistments(String projectId, OhLohBaseRequest request) {
		OhLohEnlistmentResponse resource = null;
		
		try {	
			
			String url = getProperties().getProperty("meta.ohloh.api.enlistment.all");
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohEnlistmentResponse.class,
					OhLohEnlistmentResult.class,
					OhLohEnlistmentDTO.class));
			
			
			resource = this.<OhLohEnlistmentResponse>processResponse(url, request, restfulie);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	/**
	 * 
	 * @param projectId
	 * @param enlistmentId
	 * @return
	 */
	public OhLohEnlistmentDTO getProjectEnlistmentById(String projectId, String enlistmentId) {
		OhLohEnlistmentDTO enlistment = null;
		
		try {	
			
			String url = getProperties().getProperty("meta.ohloh.api.enlistment.all");
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohEnlistmentResponse.class,
					OhLohEnlistmentResult.class,
					OhLohEnlistmentDTO.class));

			OhLohEnlistmentResponse resource = this.<OhLohEnlistmentResponse>processResponse(url, null, restfulie);
			
			if (resource != null && OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohEnlistmentDTO> ohLohEnlistmentDTOs = resource.getResult().getOhLohEnlistments();
				
				if (ohLohEnlistmentDTOs != null && ! ohLohEnlistmentDTOs.isEmpty()) {
					enlistment = ohLohEnlistmentDTOs.get(0);
				}
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return enlistment;
	}
	
	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public OhLohKudoResponse getAllKudoReceivedByAccountId(String accountId) {
		OhLohKudoResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.kudos.received");
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohKudoResponse.class,
					OhLohKudoResult.class,
					OhLohKudoDTO.class));
			

			resource = this.<OhLohKudoResponse>processResponse(url, null, restfulie);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	
	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public OhLohKudoResponse getAllKudoSentByAccountId(String accountId) {
		OhLohKudoResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.kudos.sent");
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohKudoResponse.class,
					OhLohKudoResult.class,
					OhLohKudoDTO.class));
			

			resource = this.<OhLohKudoResponse>processResponse(url, null, restfulie);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
}
