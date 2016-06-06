package com.usecase.DAO.helper;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.usecase.bean.RequirementDetails;
import com.usecase.exception.RequirementSubmitException;

@Component
public class UseCaseDAOHelper {

	@Autowired
	private DataSource dataSource;
	private static final Logger logger=Logger.getLogger(UseCaseDAOHelper.class);

	public String submitRequirement(RequirementDetails requirementDetails) throws RequirementSubmitException {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String response="N";
		try {
			String reqDetailsQuery="SELECT * FROM usecase.requirement_details_master;";
			int row=namedParameterJdbcTemplate.update(reqDetailsQuery, (SqlParameterSource) requirementDetails);
			if(row>0){
				response="Y";
			}
		} catch (Exception e) {
			logger.debug("Exception details"+e);
		}
		return response;
	}
}
