package br.ufba.dcc.mestrado.computacao.ohloh.restful.client;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import br.com.caelum.restfulie.Response;
import br.com.caelum.restfulie.RestClient;
import br.com.caelum.restfulie.Restfulie;
import br.com.caelum.restfulie.mediatype.XmlMediaType;
import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccount;
import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccountResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.activityfact.OhLohActivityFact;
import br.ufba.dcc.mestrado.computacao.ohloh.data.activityfact.OhLohActivityFactResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysis;
import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact.OhLohContributorFact;
import br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact.OhLohContributorFactResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment.OhLohEnlistment;
import br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment.OhLohEnlistmentResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.factoid.OhLohFactoid;
import br.ufba.dcc.mestrado.computacao.ohloh.data.factoid.OhLohFactoidResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.kudo.OhLohKudo;
import br.ufba.dcc.mestrado.computacao.ohloh.data.kudo.OhLohKudoResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.sizefact.OhLohSizeFact;
import br.ufba.dcc.mestrado.computacao.ohloh.data.sizefact.OhLohSizeFactResult;
import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStack;
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

public class OhLohRestfulClient {
	
	private String apiKey;
	private static Properties properties;
	
	public OhLohRestfulClient() {
		
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
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
			String uri = MessageFormat.format(url, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohAccountResponse.class,
					OhLohAccountResult.class,
					OhLohAccount.class));
			
			Response response = restfulie.at(uri).get();
			
			resource = response.getResource();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	private String processRequest(String uri, OhLohBaseRequest request) {
		String newURI = uri;
		
		if (request != null) {
			if (request.getQuery() != null && ! "".equals(request.getQuery())) {
				uri += "&query=" + request.getQuery();
			}
			
			if (request.getSort() != null && ! "".equals(request.getSort())) {
				uri += "&sort=" + request.getSort();
			}
			
			if (request.getPage() != null) {
				uri += "&page=" + request.getPage();
			}
		}
		
		return newURI;
	}

	/**
	 * 
	 * @param accountId Id da conta do usuário do OhLoh
	 * @return
	 */
	public OhLohAccount getAccountById(String accountId, OhLohBaseRequest request) {
		
		OhLohAccount account = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.account");
			String uri = MessageFormat.format(url, accountId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohAccountResponse.class,
					OhLohAccountResult.class,
					OhLohAccount.class));
			
			Response response = restfulie.at(uri).get();
			
			OhLohAccountResponse resource = response.getResource();
			if (OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohAccount> ohLohAccounts = resource.getResult().getOhLohAccounts();
				if (ohLohAccounts != null && ! ohLohAccounts.isEmpty())
					account =  ohLohAccounts.get(0);
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
			String uri = MessageFormat.format(url, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohProjectResponse.class,
					OhLohProjectResult.class,
					OhLohProject.class));
			
			Response response = restfulie.at(uri).get();
			
			resource = response.getResource();
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
	public OhLohProject getProject(String projectId, OhLohBaseRequest request) {
		OhLohProject project = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.project");
			String uri = MessageFormat.format(url, projectId,  getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohProjectResponse.class,
					OhLohProjectResult.class,
					OhLohProject.class));
			
			Response response = restfulie.at(uri).get();
			
			OhLohProjectResponse resource = response.getResource();
			if (OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohProject> ohLohProjects = resource.getResult().getOhLohProjects();
				if (ohLohProjects != null && ! ohLohProjects.isEmpty()) {
					project = ohLohProjects.get(0);
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
	public OhLohStack getSingleAccountStack(String accountId, String stackId, OhLohBaseRequest request) {
		
		OhLohStack stack = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.stack.account");
			String uri = MessageFormat.format(url, accountId, stackId , getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohStackResponse.class,
					OhLohStackResult.class,
					OhLohStack.class));
			
			Response response = restfulie.at(uri).get();
			
			OhLohStackResponse resource = response.getResource();
			if (OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohStack> ohLohStacks = resource.getResult().getOhLohStacks();
				if (ohLohStacks != null && ! ohLohStacks.isEmpty()) {
					stack = ohLohStacks.get(0);
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
	public OhLohStack getDefaultAccountStack(String accountId, OhLohBaseRequest request) {
		OhLohStack stack = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.stack.account.default");
			String uri = MessageFormat.format(url, accountId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohStackResponse.class,
					OhLohStackResult.class,
					OhLohStack.class));
			
			Response response = restfulie.at(uri).get();
			
			OhLohStackResponse resource = response.getResource();
			if (OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohStack> ohLohStacks = resource.getResult().getOhLohStacks();
				if (ohLohStacks != null && ! ohLohStacks.isEmpty()) {
					stack = ohLohStacks.get(0);
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
	public OhLohStackResponse getProjectStacks(String projectId, OhLohBaseRequest request) {
		OhLohStackResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.stack.project");
			String uri = MessageFormat.format(url, projectId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohStackResponse.class,
					OhLohStackResult.class,
					OhLohStack.class));
			
			Response response = restfulie.at(uri).get();
			
			resource = response.getResource();
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
	public OhLohFactoidResponse getAllFactoidsByProject(String projectId, OhLohBaseRequest request) {
		OhLohFactoidResponse resource = null;
		
		try {
			
			String url = getProperties().getProperty("meta.ohloh.api.factoid.project");
			String uri = MessageFormat.format(url, projectId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohFactoidResponse.class,
					OhLohFactoidResult.class,
					OhLohFactoid.class));
			
			Response response = restfulie.at(uri).get();
			
			resource = response.getResource();
			
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
			String uri = MessageFormat.format(url, projectId, factoidId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohFactoidResponse.class,
					OhLohFactoidResult.class,
					OhLohFactoid.class));
			
			Response response = restfulie.at(uri).get();
			
			resource = response.getResource();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
	
	public OhLohSizeFactResponse getLatestSizeFackByProject(String projectId, OhLohBaseRequest request) {
		OhLohSizeFactResponse resource = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.size_facts.latest");
			String uri = MessageFormat.format(url, projectId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohSizeFactResponse.class,
					OhLohSizeFactResult.class,
					OhLohSizeFact.class));
			
			Response response = restfulie.at(uri).get();
			
			resource = response.getResource();
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
			String uri = MessageFormat.format(url, projectId, analysisId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohSizeFactResponse.class,
					OhLohSizeFactResult.class,
					OhLohSizeFact.class));
			
			Response response = restfulie.at(uri).get();
			
			resource = response.getResource();
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
	public OhLohAnalysis getAnalysisById(String projectId, String analysisId, OhLohBaseRequest request) {
		
		OhLohAnalysis analysis = null;
		
		try {
			
			String url = getProperties().getProperty("meta.ohloh.api.analysis");
			String uri = MessageFormat.format(url, projectId, analysisId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohAnalysisResponse.class,
					OhLohAnalysisResult.class,
					OhLohAnalysis.class));
			
			Response response = restfulie.at(uri).get();
			
			OhLohAnalysisResponse resource = response.getResource();
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
	public OhLohAnalysis getLatestAnalysis(String projectId, OhLohBaseRequest request) {
		return getAnalysisById(projectId, "latest", request);
	}
	
	/**
	 * 
	 * @return
	 */
	public OhLohContributorFact getProjectContributorFactById(String projectId, String contributorId, OhLohBaseRequest request) {
		OhLohContributorFact contributorFact = null;
		
		try {
			String url = getProperties().getProperty("meta.ohloh.api.contributor_facts");
			String uri = MessageFormat.format(url, projectId, contributorId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohContributorFactResponse.class,
					OhLohContributorFactResult.class,
					OhLohContributorFact.class));
			
			Response response = restfulie.at(uri).get();
			OhLohContributorFactResponse resource = response.getResource();
			
			if (resource != null && OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohContributorFact> ohLohContributorFacts = resource.getResult().getOhLohContributorFacts();
				
				if (ohLohContributorFacts != null && ! ohLohContributorFacts.isEmpty()) {
					contributorFact = ohLohContributorFacts.get(0);
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
			String uri = MessageFormat.format(url, projectId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohContributorFactResponse.class,
					OhLohContributorFactResult.class,
					OhLohContributorFact.class));
			
			Response response = restfulie.at(uri).get();
			resource = response.getResource();
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
			String uri = MessageFormat.format(url, projectId, analysisId, getApiKey());
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohActivityFactResponse.class,
					OhLohActivityFactResult.class,
					OhLohActivityFact.class));
			
			Response response = restfulie.at(uri).get();
			resource = response.getResource();
			
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
			String uri = MessageFormat.format(url, projectId, getApiKey());
			
			uri = processRequest(uri, request);
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohEnlistmentResponse.class,
					OhLohEnlistmentResult.class,
					OhLohEnlistment.class));
			
			Response response = restfulie.at(uri).get();
			resource = response.getResource();
			
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
	public OhLohEnlistment getProjectEnlistmentById(String projectId, String enlistmentId) {
		OhLohEnlistment enlistment = null;
		
		try {	
			
			String url = getProperties().getProperty("meta.ohloh.api.enlistment.all");
			String uri = MessageFormat.format(url, projectId, getApiKey());
			
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohEnlistmentResponse.class,
					OhLohEnlistmentResult.class,
					OhLohEnlistment.class));
			
			Response response = restfulie.at(uri).get();
			OhLohEnlistmentResponse resource = response.getResource();
			
			if (resource != null && OhLohBaseResponse.SUCCESS.equals(resource.getStatus())) {
				List<OhLohEnlistment> ohLohEnlistments = resource.getResult().getOhLohEnlistments();
				
				if (ohLohEnlistments != null && ! ohLohEnlistments.isEmpty()) {
					enlistment = ohLohEnlistments.get(0);
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
			String uri = MessageFormat.format(url, accountId, getApiKey());
			
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohKudoResponse.class,
					OhLohKudoResult.class,
					OhLohKudo.class));
			
			Response response = restfulie.at(uri).get();
			resource = response.getResource();
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
			String uri = MessageFormat.format(url, accountId, getApiKey());
			
			
			RestClient restfulie = Restfulie.custom();
			
			restfulie.getMediaTypes().register(new XmlMediaType().withTypes(
					OhLohKudoResponse.class,
					OhLohKudoResult.class,
					OhLohKudo.class));
			
			Response response = restfulie.at(uri).get();
			resource = response.getResource();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return resource;
	}
}
