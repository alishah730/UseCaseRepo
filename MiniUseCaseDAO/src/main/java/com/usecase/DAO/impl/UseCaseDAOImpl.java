package com.usecase.DAO.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usecase.DAO.UseCaseDAO;
import com.usecase.DAO.helper.UseCaseDAOHelper;
import com.usecase.bean.RequirementDetails;
import com.usecase.exception.RequirementSubmitException;

/**
 * @author Habibul Ali Shah
 *
 */
@Component(value="usecaseDAO")

public class UseCaseDAOImpl implements UseCaseDAO {
	
	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UseCaseDAOHelper useCaseDaoHelper;
	private static final Logger log = Logger.getLogger(UseCaseDAOImpl.class);
	public String submitRequirement(RequirementDetails requirementDetails) throws RequirementSubmitException {
		log.info("requirementDetails :: "+requirementDetails);
		return useCaseDaoHelper.submitRequirement(requirementDetails);
	}
}
