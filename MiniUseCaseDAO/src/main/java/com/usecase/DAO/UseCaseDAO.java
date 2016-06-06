package com.usecase.DAO;

import com.usecase.bean.RequirementDetails;
import com.usecase.exception.RequirementSubmitException;

public interface UseCaseDAO {
	public abstract String submitRequirement(RequirementDetails requirementDetails ) throws RequirementSubmitException;

}
