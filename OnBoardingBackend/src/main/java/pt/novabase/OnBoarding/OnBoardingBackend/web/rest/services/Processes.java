package pt.novabase.OnBoarding.OnBoardingBackend.web.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import pt.novabase.OnBoarding.OnBoardingBackend.business.Process;
import pt.novabase.OnBoarding.OnBoardingBackend.web.response.ServiceResult;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ProcessesBean;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ValidationBean;

@Api(value="/process")
@Path("/process")
public class Processes {

	private static final Logger LOGGER = LoggerFactory.getLogger(Processes.class);
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Creates a new journey", notes="Creates a new journey")
	public Response newJourney(ProcessesBean process) {
		try {

			LOGGER.info("[REST] Inicializing a new process/journey for client with fical number " + process.getNif());

			ServiceResult result = new ServiceResult(Process.createProcess(process));
			
			return Response.status(Response.Status.OK).entity(result).build();

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process newJourney request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}

	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Updating journey", notes="Updating journey")
	public Response updateProcess(ProcessesBean process) {
		try {

			LOGGER.info("[REST] Updating process/journey: " + process.getProcessId());

			ServiceResult result = new ServiceResult(Process.updateProcess(process));
			return Response.status(Response.Status.OK).entity(result).build();

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process updateProcess request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}

	}
	
	@GET
	@Path("/details/{processId}")
	@ApiOperation(value="Gets the process details", notes="Gets the process details")
	public Response getJourneyDetails(@ApiParam(value="processId", required=true) @PathParam("processId") long processId) {
		try {
			
			LOGGER.info("[REST] Getting details of the process: " + processId);
			
			ProcessesBean process = Process.getProcessDetails(processId);

			ServiceResult result = new ServiceResult(process);
			return Response.status(Response.Status.OK).entity(result).build();

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process getJourneyDetails request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}
	}
	
	@GET
	@Path("/fulldetails/{processId}")
	@ApiOperation(value="Gets the process details", notes="Gets the process details")
	public Response getJourneyFullDetails(@ApiParam(value="processId", required=true) @PathParam("processId") long processId) {
		try {
			
			LOGGER.info("[REST] Getting details of the process: " + processId);
			
			ValidationBean process = Process.getFullProcess(processId);

			ServiceResult result = new ServiceResult(process);
			return Response.status(Response.Status.OK).entity(result).build();

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process getJourneyDetails request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Deletes a process", notes="Deletes a process")
	public Response deleteProcess(ProcessesBean process) {
		try {
			LOGGER.info("[REST] Deleting image: " + process.getProcessId());
			
			ServiceResult result = new ServiceResult(null);
			return Response.status(Response.Status.OK).entity(result).build();
			
		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process deleteProcess request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}
	}
}
