package com.wipro.fhir.r4.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.service.atoms.feed.bahmni.ClinicalFeedWorker;
import com.wipro.fhir.r4.service.resource_gateway.DiagnosticReportRecordImpl;
import com.wipro.fhir.r4.service.resource_gateway.OPConsultRecordBundle;
import com.wipro.fhir.r4.service.resource_gateway.OPConsultRecordBundleImpl;
import com.wipro.fhir.r4.service.resource_gateway.PrescriptionRecordBundleImpl;
import com.wipro.fhir.r4.utils.http.HttpUtils;
import com.wipro.fhir.r4.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/feeds", headers = "Authorization")
public class Test {
	@Autowired
	HttpUtils httpUtils;
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private RestTemplate rest;

	@Autowired
	private ClinicalFeedWorker clinicalFeedWorker;

	@Autowired
	private PrescriptionRecordBundleImpl prescriptionRecordBundleImpl;

	@Autowired
	private OPConsultRecordBundle o;
	@Autowired
	private OPConsultRecordBundleImpl oPConsultRecordBundleImpl;

	// @Deprecated
	@CrossOrigin
	@ApiOperation(value = "Test parse ATOM Feeds", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/parse/feed/ATOM" }, method = { RequestMethod.POST })
	public String parseFeeds(@RequestBody ResourceRequestHandler resourceRequestHandler,
			@RequestHeader(value = "Authorization") String Authorization) {
		OutputResponse response = new OutputResponse();
		String s = null;
		try {

			s = oPConsultRecordBundleImpl.getOPConsultRecordBundle(resourceRequestHandler, null);

			response.setResponse(s);
		} catch (Exception e) {
			// TODO: handle exception\
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
			System.out.println(e);
		}
		return response.toString();

	}

}
