package hcmute.edu.tgdd.exception.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.edu.tgdd.model.DataResponse;

public final class MyExceptionResonseHandler {
	public static void exceptionResponseHandler(HttpServletResponse response, DataResponse dataResponse, Exception e) throws IOException {
		if(e!=null)
			response.setHeader("Error", e.getMessage());
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("application/json");
		new ObjectMapper().writeValue(response.getOutputStream(), dataResponse);
		new ObjectMapper().writeValue(response.getOutputStream(), new DataResponse("403", "Access is denied", 200));
	}
}
