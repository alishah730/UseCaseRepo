package com.usecase.service.helper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.usecase.DAO.UseCaseDAO;
import com.usecase.bean.RequirementDetails;
import com.usecase.constant.MiniUseCaseServiceConstant;
import com.usecase.exception.RequirementSubmitException;
import com.usecase.service.response.MiniUseCaseServiceResponse;
@Service
public class MiniUseCaseServiceHelper {
	
	@Autowired
	UseCaseDAO useCaseDAO;
	private static final Logger log=Logger.getLogger(MiniUseCaseServiceHelper.class);
	public String submitRequirement(RequirementDetails requirementDetails) throws RequirementSubmitException{
		log.info("MiniUseCaseServiceHelper request :: "+requirementDetails);
		String result = null;
		MiniUseCaseServiceResponse response=new MiniUseCaseServiceResponse();
		try {
			result=useCaseDAO.submitRequirement(requirementDetails);
			if(result.equalsIgnoreCase("Y")){
				Gson gson = new Gson();
				response.setStatus(MiniUseCaseServiceConstant.SUCCESS);
				response.setDescription(MiniUseCaseServiceConstant.REQUIREMENT_SUBMIT_SUCCESS);
				return gson.toJson(response);
			}
			else {
				Gson gson = new Gson();
				response.setStatus(MiniUseCaseServiceConstant.FAILURE);
				response.setDescription(MiniUseCaseServiceConstant.REQUIREMENT_SUBMIT_FAILURE);
				return gson.toJson(response);
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
