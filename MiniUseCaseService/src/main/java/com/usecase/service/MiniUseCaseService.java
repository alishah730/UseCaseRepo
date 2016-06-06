package com.usecase.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.bean.RequirementDetails;
import com.usecase.service.helper.MiniUseCaseServiceHelper;

@Path("miniUseCaseService")
@Service
public class MiniUseCaseService {
	@Autowired
	MiniUseCaseServiceHelper miniUseCaseServiceHelper;
	private static final Logger log=Logger.getLogger(MiniUseCaseService.class);
	@POST
	@Path("/submitRequirement")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response submitRequirement(RequirementDetails requirementDetails)throws Exception{
		log.info(" MiniUseCaseService Request :: "+requirementDetails);
		return Response.ok().status(200).entity(miniUseCaseServiceHelper.submitRequirement(requirementDetails)).type("application/json").build();
	}

}
