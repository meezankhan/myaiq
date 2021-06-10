package com.accenture.aiq.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.accenture.aiq.constants.Constants;
import com.accenture.aiq.dto.AnswersDTO;
import com.accenture.aiq.dto.HomePageDTO;
import com.accenture.aiq.dto.HomePageDropDownDTO;
import com.accenture.aiq.dto.InnoParamResultResponse;
import com.accenture.aiq.dto.InnovationParamDTO;
import com.accenture.aiq.dto.NewSurveyDTO;
import com.accenture.aiq.dto.OptionsDTO;
import com.accenture.aiq.dto.QuestionaireDTO;
import com.accenture.aiq.dto.SubmitSurveyResponseDTO;
import com.accenture.aiq.dto.SurveyDTO;
import com.accenture.aiq.dto.SurveyResultRequestDTO;
import com.accenture.aiq.dto.SurveyResultResponse;
import com.accenture.aiq.entities.InnovationParameterMaster;
import com.accenture.aiq.entities.OptionsMaster;
import com.accenture.aiq.entities.QuestionsMaster;
import com.accenture.aiq.entities.SurveyMaster;
import com.accenture.aiq.entities.SurveyResult;
import com.accenture.aiq.entities.SurveyResultInnoScore;
import com.accenture.aiq.entities.SurveyResultQuestionScore;
import com.accenture.aiq.repository.HomePageMasterRepository;
import com.accenture.aiq.repository.InnovationParamMasterRepository;
import com.accenture.aiq.repository.InnovationParamScoreMasterRepository;
import com.accenture.aiq.repository.OptionsMasterRepository;
import com.accenture.aiq.repository.QuestionsMasterRepository;
import com.accenture.aiq.repository.RecommendationsRepository;
import com.accenture.aiq.repository.SurveyMasterRepository;
import com.accenture.aiq.repository.SurveyResultInnoScoreRepository;
import com.accenture.aiq.repository.SurveyResultRepository;
import com.accenture.aiq.repository.SurveyResultScoreMasterRepository;
import com.accenture.aiq.repository.SurveyResultQuestionScoreRepository;

@Service
public class SurveyService {

	@Autowired
	SurveyResultRepository surveyResultDao;

	@Autowired
	SurveyMasterRepository surveyMasterDao;

	@Autowired
	HomePageMasterRepository homePageMasterDao;

	@Autowired
	InnovationParamMasterRepository innovationParamMasterRepository;

	@Autowired
	QuestionsMasterRepository questionsMasterRepository;

	@Autowired
	OptionsMasterRepository optionsMasterRepository;

	@Autowired
	SurveyResultQuestionScoreRepository surveyResultQuestionScoreRepository;

	@Autowired
	SurveyResultInnoScoreRepository surveyResultInnoScoreRepository;

	@Autowired
	SurveyResultScoreMasterRepository scoreMasterDao;

	@Autowired
	InnovationParamScoreMasterRepository innovationParamScoreMasterRepository;

	@Autowired
	RecommendationsRepository recommendationsRepository;

	public boolean checkIfInProgressSurveyExists(int surveyId, int userId) {

		List<Integer> surveyList = surveyResultDao.findActiveSurveyForUser(surveyId, userId);

		if (CollectionUtils.isEmpty(surveyList)) {
			return false;
		} else
			return true;
	}

	public NewSurveyDTO loadNewSurveyForUser(int surveyId, int userId) {

		NewSurveyDTO response = new NewSurveyDTO();

		SurveyMaster surveyMaster = surveyMasterDao.getOne(surveyId);

		SurveyDTO survey = new SurveyDTO();
		survey.setSurveyTitle(surveyMaster.getSurveyTitle());
		survey.setSurveyId(surveyId);
		survey.setUserId(userId);

		HomePageDTO homePage = getHomePageDataForUserAndSurvey(surveyId, userId);
		survey.setHomePage(homePage);

		List<InnovationParamDTO> innovationParams = getInnovationParamDataForSurvey(surveyId);
		survey.setInnovationParams(innovationParams);

		response.setSurvey(survey);

		return response;
	}

	private List<InnovationParamDTO> getInnovationParamDataForSurvey(int surveyId) {
		List<InnovationParamDTO> innovationParams = new ArrayList<InnovationParamDTO>();

		List<InnovationParameterMaster> innovationParamsData = innovationParamMasterRepository
				.findBySurveyidOrderByOrderidAsc(surveyId);

		if (CollectionUtils.isEmpty(innovationParamsData)) {
			return innovationParams;
		}

		for (InnovationParameterMaster data : innovationParamsData) {
			InnovationParamDTO ipDTO = new InnovationParamDTO();
			ipDTO.setId(data.getId());
			ipDTO.setInnovationParam(data.getInnovationParameter());
			ipDTO.setOrderId(data.getOrderid());
			List<QuestionaireDTO> questions = getQuestionsForInnovationParam(data.getId());
			ipDTO.setQuestions(questions);
			innovationParams.add(ipDTO);
		}

		return innovationParams;
	}

	private List<QuestionaireDTO> getQuestionsForInnovationParam(int innovationParamId) {
		List<QuestionaireDTO> questions = new ArrayList<QuestionaireDTO>();

		List<QuestionsMaster> qdata = questionsMasterRepository
				.findByInnovationparamidOrderByOrderIdAsc(innovationParamId);
		if (CollectionUtils.isEmpty(qdata)) {
			return questions;
		}

		for (QuestionsMaster data : qdata) {
			QuestionaireDTO qDTO = new QuestionaireDTO();
			qDTO.setId(data.getId());
			qDTO.setQuestion(data.getQuestion());
			qDTO.setOrderId(data.getOrderId());
			List<AnswersDTO> options = getOptionsForQuestion(innovationParamId, data.getId());
			qDTO.setOptions(options);
			questions.add(qDTO);
		}

		return questions;
	}

	private List<AnswersDTO> getOptionsForQuestion(int innovationParamId, int qId) {
		List<AnswersDTO> options = new ArrayList<AnswersDTO>();

		List<OptionsMaster> optionsData = optionsMasterRepository.findByQuestionidOrderByOrderidAsc(qId);
		if (CollectionUtils.isEmpty(optionsData)) {
			return options;
		}

		for (OptionsMaster data : optionsData) {
			AnswersDTO aDTO = new AnswersDTO();
			aDTO.setAnswer(data.getAnswer());
			aDTO.setOrderId(data.getOrderid());
			aDTO.setValue(innovationParamId + "_" + qId + "_" + data.getId() + "_" + data.getScore());
			aDTO.setDefault(data.isDefault());
			options.add(aDTO);
		}

		return options;
	}

	private HomePageDTO getHomePageDataForUserAndSurvey(int surveyId, int userId) {

		HomePageDTO homePage = new HomePageDTO();

		List<String> marketUnitEntity = homePageMasterDao.findMarketUnitBySurveyIdAndUserId(surveyId, userId);
		homePage.setMarketUnit(populateHomePageDropDownDTO(marketUnitEntity, Constants.BLANK_STR));

		List<String> clientGroupEntity = homePageMasterDao.findClientGroupBySurveyIdAndUserId(surveyId, userId);
		homePage.setClientGroup(populateHomePageDropDownDTO(clientGroupEntity, Constants.BLANK_STR));

		List<String> delievryUnitEntity = homePageMasterDao.findDeliveryUnitBySurveyIdAndUserId(surveyId, userId);
		homePage.setDeliveryUnit(populateHomePageDropDownDTO(delievryUnitEntity, Constants.BLANK_STR));

		List<String> clientNameEntity = homePageMasterDao.findClientNameBySurveyIdAndUserId(surveyId, userId);
		homePage.setClientName(populateHomePageDropDownDTO(clientNameEntity, Constants.BLANK_STR));

		List<String> calEntity = homePageMasterDao.findCALBySurveyIdAndUserId(surveyId, userId);
		homePage.setCal(populateHomePageDropDownDTO(calEntity, Constants.BLANK_STR));

		List<String> deliveryMDEntity = homePageMasterDao.findDeliveryMDBySurveyIdAndUserId(surveyId, userId);
		homePage.setDeliveryMD(populateHomePageDropDownDTO(deliveryMDEntity, Constants.BLANK_STR));

		return homePage;
	}

	public SurveyResult submitSurvey(SurveyResultRequestDTO request) {

		SurveyResult existingEntity = surveyResultDao.findIncompleteSurveyForUserProject(request.getUserId(),
				request.getSurveyId(), request.getProjectId());

		SurveyResult entity = convertFromRequestToEntity(request);
		entity.setStatus(Constants.SURVEY_STATUS_SUBMITTED);
		entity.setSubmittedOn(new Timestamp(new Date().getTime()));

		if (existingEntity == null) {
			entity.setCreatedOn(new Timestamp(new Date().getTime()));
		} else {
			entity.setId(existingEntity.getId());
		}

		SurveyResult newEntity = surveyResultDao.save(entity);

		int surveyScore = saveOptionsResult(newEntity.getId(), request.getOptionsData());
		newEntity.setScore(surveyScore);
		surveyResultDao.save(newEntity);

		return newEntity;
	}

	public boolean saveSurvey(SurveyResultRequestDTO request) {

		SurveyResult existingEntity = surveyResultDao.findIncompleteSurveyForUserProject(request.getUserId(),
				request.getSurveyId(), request.getProjectId());

		SurveyResult entity = convertFromRequestToEntity(request);
		
		entity.setStatus(Constants.SURVEY_STATUS_IN_PROGRESS);
		
		if (existingEntity == null) {
			entity.setCreatedOn(new Timestamp(new Date().getTime()));
		} else {
			entity.setSubmittedOn(new Timestamp(new Date().getTime()));
			entity.setId(existingEntity.getId());
			entity.setCreatedOn(existingEntity.getCreatedOn());
		}

		SurveyResult newEntity = surveyResultDao.save(entity);

		int surveyScore = saveOptionsResult(newEntity.getId(), request.getOptionsData());
		newEntity.setScore(surveyScore);
		surveyResultDao.save(newEntity);

		return true;
	}

	private int saveOptionsResult(int id, List<OptionsDTO> list) {
		int surveyScore = 0;
		try {
			List<SurveyResultQuestionScore> scoreResult = surveyResultQuestionScoreRepository.findBySurveyresultid(id);
			Map<Integer, Integer> iScore = new HashMap<Integer, Integer>();
			boolean dataExists = !CollectionUtils.isEmpty(scoreResult);

			List<SurveyResultQuestionScore> newScoreList = new ArrayList<SurveyResultQuestionScore>();
			for (OptionsDTO l : list) {
				String[] idList = l.getValue().split("_"); // InnoParamId_qId_oId_score
				int iId = Integer.parseInt(idList[0]);
				int qId = Integer.parseInt(idList[1]);
				int oId = Integer.parseInt(idList[2]);
				int score = Integer.parseInt(idList[3]);

				SurveyResultQuestionScore oEntity;
				if (dataExists) {
					oEntity = surveyResultQuestionScoreRepository.findBySurveyresultidAndQuestionid(id, qId);
					if (oEntity != null) {
						oEntity.setAnswerid(oId);
						oEntity.setScore(score);
						oEntity.setComments(l.getComments());
					} else {
						oEntity = new SurveyResultQuestionScore(id, oId, qId, score, l.getComments());
					}

				} else {
					oEntity = new SurveyResultQuestionScore(id, oId, qId, score, l.getComments());
				}

				newScoreList.add(oEntity);
				if (iScore.get(iId) == null) {
					iScore.put(iId, score);
				} else {
					iScore.put(iId, score + iScore.get(iId));
				}
			}
			surveyResultQuestionScoreRepository.saveAll(newScoreList);
			List<SurveyResultInnoScore> iScoreList = new ArrayList<SurveyResultInnoScore>();
			for (Map.Entry<Integer, Integer> entry : iScore.entrySet()) {

				surveyScore = surveyScore + entry.getValue();

				SurveyResultInnoScore iEntity;

				if (dataExists) {
					iEntity = surveyResultInnoScoreRepository.findBySurveyresultidAndInnoparamid(id, entry.getKey());
					if (iEntity != null) {
						iEntity.setScore(entry.getValue());
					} else {
						iEntity = new SurveyResultInnoScore(id, entry.getKey(), entry.getValue());
					}
				} else {
					iEntity = new SurveyResultInnoScore(id, entry.getKey(), entry.getValue());
				}

				iScoreList.add(iEntity);
			}

			surveyResultInnoScoreRepository.saveAll(iScoreList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return surveyScore;
	}

	private SurveyResult convertFromRequestToEntity(SurveyResultRequestDTO request) {
		SurveyResult entity = new SurveyResult(request.getUserId(), request.getProjectId(), request.getSurveyId(),
				request.getMarketUnit(), request.getClientGroup(), request.getDeliveryUnit(), request.getClientName(),
				request.getCal(), request.getDeliveryMD(), request.getInnovationLead(), null, 0, null, null);
		return entity;

	}

	public SubmitSurveyResponseDTO generateSubmitSurveyResponse(SurveyResult surveyResult) {

		SubmitSurveyResponseDTO response = new SubmitSurveyResponseDTO();

		SurveyResultResponse surveyResultResponse = new SurveyResultResponse();
		SurveyMaster surveyMaster = surveyMasterDao.getOne(surveyResult.getSurveyid());

		double finalRating = surveyResult.getScore() * .09;
		surveyResultResponse.setLevel(scoreMasterDao.findLevelByScore(finalRating));
		surveyResultResponse.setSurveyRating(String.format("%.1f", finalRating) + "/" + surveyMaster.getMaxRating());
		surveyResultResponse.setSurveyScore(surveyResult.getScore() + "/" + surveyMaster.getMaxScore());

		List<InnoParamResultResponse> innoParamResults = new ArrayList<InnoParamResultResponse>();
		List<SurveyResultInnoScore> list = surveyResultInnoScoreRepository.findBySurveyresultid(surveyResult.getId());
		if (!CollectionUtils.isEmpty(list)) {
			for (SurveyResultInnoScore l : list) {
				InnoParamResultResponse innoParamResultResponse = new InnoParamResultResponse();

				InnovationParameterMaster innovationParameterMaster = innovationParamMasterRepository
						.getOne(l.getInnoparamid());

				innoParamResultResponse.setInnoParamTitle(innovationParameterMaster.getInnovationParameter());
				innoParamResultResponse.setLevel(innovationParamScoreMasterRepository
						.findLevelByScoreAndInnovationParam(l.getScore(), l.getInnoparamid()));
				innoParamResultResponse.setScore(l.getScore() + "/" + innovationParameterMaster.getMaxscore());

				innoParamResultResponse.setRecommendations(recommendationsRepository.findByLevelAndInnovationparamid(
						innoParamResultResponse.getLevel(), innovationParameterMaster.getId()));

				innoParamResults.add(innoParamResultResponse);
			}
		}
		surveyResultResponse.setInnoParamResults(innoParamResults);

		response.setSurveyResultResponse(surveyResultResponse);

		return response;

	}

	public NewSurveyDTO loadActiveSurveyForProject(int surveyId, int projectId) {
		NewSurveyDTO response = null;

		SurveyResult ipSurvey = surveyResultDao.findActiveSurveyForProject(surveyId, projectId);

		if (ipSurvey != null) {

			response = new NewSurveyDTO();

			SurveyMaster surveyMaster = surveyMasterDao.getOne(surveyId);

			SurveyDTO survey = new SurveyDTO();
			survey.setSurveyTitle(surveyMaster.getSurveyTitle());
			survey.setSurveyId(surveyId);
			survey.setUserId(ipSurvey.getUserid());

			HomePageDTO homePage = getHomePageDataForInProgressSurvey(surveyId, ipSurvey);
			survey.setHomePage(homePage);

			List<InnovationParamDTO> innovationParams = getInnovationParamDataForInProgressSurvey(surveyId,
					ipSurvey.getId());
			survey.setInnovationParams(innovationParams);

			response.setSurvey(survey);
		}

		return response;
	}

	private List<InnovationParamDTO> getInnovationParamDataForInProgressSurvey(int surveyId, int surveyResultId) {

		List<InnovationParamDTO> innovationParams = new ArrayList<InnovationParamDTO>();

		List<InnovationParameterMaster> innovationParamsData = innovationParamMasterRepository
				.findBySurveyidOrderByOrderidAsc(surveyId);

		if (CollectionUtils.isEmpty(innovationParamsData)) {
			return innovationParams;
		}

		for (InnovationParameterMaster data : innovationParamsData) {
			InnovationParamDTO ipDTO = new InnovationParamDTO();
			ipDTO.setId(data.getId());
			ipDTO.setInnovationParam(data.getInnovationParameter());
			ipDTO.setOrderId(data.getOrderid());
			List<Object[]> savedResponseList = surveyResultQuestionScoreRepository
					.findSelectOptionBySurveyresultid(surveyResultId);
			Map<Integer, String> savedResponses = convertToMap(savedResponseList);
			List<QuestionaireDTO> questions = getQuestionsForInnovationParamForInProgressSurvey(data.getId(),
					savedResponses);
			ipDTO.setQuestions(questions);
			innovationParams.add(ipDTO);
		}

		return innovationParams;
	}

	private Map<Integer, String> convertToMap(List<Object[]> savedResponseList) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		if (CollectionUtils.isEmpty(savedResponseList)) {
			return map;
		} else {
			for (Object[] ob : savedResponseList) {
				Integer key = (Integer) ob[0];
				String value = (String) ob[1];
				map.put(key, value);
			}
		}
		return map;
	}

	private List<QuestionaireDTO> getQuestionsForInnovationParamForInProgressSurvey(int innovationParamId,
			Map<Integer, String> savedResponses) {

		List<QuestionaireDTO> questions = new ArrayList<QuestionaireDTO>();

		List<QuestionsMaster> qdata = questionsMasterRepository
				.findByInnovationparamidOrderByOrderIdAsc(innovationParamId);
		if (CollectionUtils.isEmpty(qdata)) {
			return questions;
		}

		for (QuestionsMaster data : qdata) {
			QuestionaireDTO qDTO = new QuestionaireDTO();
			qDTO.setId(data.getId());
			qDTO.setQuestion(data.getQuestion());
			qDTO.setOrderId(data.getOrderId());
			List<AnswersDTO> options = getOptionsForQuestionForInProgressSurvey(innovationParamId, data.getId(),
					savedResponses);
			if (savedResponses.get(data.getId()) != null) {
				String savedResponse = savedResponses.get(data.getId());
				qDTO.setComment(savedResponse.substring(savedResponse.indexOf("_") + 1));
			}
			qDTO.setOptions(options);
			questions.add(qDTO);
		}

		return questions;
	}

	private List<AnswersDTO> getOptionsForQuestionForInProgressSurvey(int innovationParamId, int qId,
			Map<Integer, String> savedResponses) {

		List<AnswersDTO> options = new ArrayList<AnswersDTO>();

		List<OptionsMaster> optionsData = optionsMasterRepository.findByQuestionidOrderByOrderidAsc(qId);
		if (CollectionUtils.isEmpty(optionsData)) {
			return options;
		}
		int selectedOptionId = -1;
		if (savedResponses.get(qId) != null) {
			String savedResponse = savedResponses.get(qId);
			selectedOptionId = Integer.parseInt(savedResponse.substring(0, savedResponse.indexOf("_")));
		}

		for (OptionsMaster data : optionsData) {
			AnswersDTO aDTO = new AnswersDTO();
			aDTO.setAnswer(data.getAnswer());
			aDTO.setOrderId(data.getOrderid());
			aDTO.setValue(innovationParamId + "_" + qId + "_" + data.getId() + "_" + data.getScore());
			if (data.getId() == selectedOptionId) {
				aDTO.setDefault(true);
				options.add(aDTO);
				if (options.size() > 1) {
					options.get(0).setDefault(false);
				}
			} else {
				options.add(aDTO);
			}

		}

		return options;
	}

	private List<HomePageDropDownDTO> populateHomePageDropDownDTO(List<String> entityList, String oldValue) {
		List<HomePageDropDownDTO> list = new ArrayList<HomePageDropDownDTO>();
		if (CollectionUtils.isEmpty(entityList)) {
			return list;
		}

		HomePageDropDownDTO dto = new HomePageDropDownDTO();
		dto.setValue(Constants.DEFAULT_DROP_DOWN_OPTION);
		dto.setDefault(true);

		list.add(dto);

		for (String data : entityList) {
			HomePageDropDownDTO dTO = new HomePageDropDownDTO();
			dTO.setValue(data);
			list.add(dTO);
			if (data.equals(oldValue)) {
				dTO.setDefault(true);
				list.get(0).setDefault(false);
			}
		}

		return list;
	}

	private HomePageDTO getHomePageDataForInProgressSurvey(int surveyId, SurveyResult ipSurvey) {

		HomePageDTO homePage = new HomePageDTO();
		int userId = ipSurvey.getUserid();

		List<String> marketUnitEntity = homePageMasterDao.findMarketUnitBySurveyIdAndUserId(surveyId, userId);
		homePage.setMarketUnit(populateHomePageDropDownDTO(marketUnitEntity, ipSurvey.getMarketunit()));

		List<String> clientGroupEntity = homePageMasterDao.findClientGroupBySurveyIdAndUserId(surveyId, userId);
		homePage.setClientGroup(populateHomePageDropDownDTO(clientGroupEntity, ipSurvey.getClientgroup()));

		List<String> delievryUnitEntity = homePageMasterDao.findDeliveryUnitBySurveyIdAndUserId(surveyId, userId);
		homePage.setDeliveryUnit(populateHomePageDropDownDTO(delievryUnitEntity, ipSurvey.getDeliveryunit()));

		List<String> clientNameEntity = homePageMasterDao.findClientNameBySurveyIdAndUserId(surveyId, userId);
		homePage.setClientName(populateHomePageDropDownDTO(clientNameEntity, ipSurvey.getClientname()));

		List<String> calEntity = homePageMasterDao.findCALBySurveyIdAndUserId(surveyId, userId);
		homePage.setCal(populateHomePageDropDownDTO(calEntity, ipSurvey.getCal()));

		List<String> deliveryMDEntity = homePageMasterDao.findDeliveryMDBySurveyIdAndUserId(surveyId, userId);
		homePage.setDeliveryMD(populateHomePageDropDownDTO(deliveryMDEntity, ipSurvey.getDeliverymd()));
		homePage.setInnovationLead(ipSurvey.getInnovationlead());

		return homePage;
	}
}
