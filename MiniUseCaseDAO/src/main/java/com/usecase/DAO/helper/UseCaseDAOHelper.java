package com.usecase.DAO.helper;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.usecase.bean.RequirementDetails;
import com.usecase.exception.RequirementSubmitException;

@Component
public class UseCaseDAOHelper {

	@Autowired
	private DataSource dataSource;
	private static final Logger log=Logger.getLogger(UseCaseDAOHelper.class);

	public String submitRequirement(RequirementDetails reqDtl) throws RequirementSubmitException {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String response=null;
			String reqDetailsQuery="INSERT INTO `usecase`.`requirement_details_master` VALUES(?,?,?,?,?,?)";
			try {
				log.info("reqDetailsQuery ::"+reqDetailsQuery);
				int row=jdbcTemplate.update(reqDetailsQuery,
						new Object[]{reqDtl.getReqId(),reqDtl.getBusinessName(),reqDtl.getRoleName(),
								reqDtl.getLocation(),reqDtl.getApprover1(),reqDtl.getApprover2()});
				log.info("Row effected :: "+row);
				if(row>0){
					response="Y";
				}
				else{
					response ="N";
				}
			} catch (Exception e) {
				log.debug("Exception :: ",e);
			}
				
			
			
		return response;
	}
}
