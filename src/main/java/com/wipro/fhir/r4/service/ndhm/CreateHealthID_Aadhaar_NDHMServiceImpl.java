package com.wipro.fhir.r4.service.ndhm;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wipro.fhir.r4.data.healthID.Details;
import com.wipro.fhir.r4.data.healthID.HealthIDException;
import com.wipro.fhir.r4.data.healthID.HealthIDRequestAadhar;
import com.wipro.fhir.r4.data.healthID.HealthIDResponse;
import com.wipro.fhir.r4.data.healthID.MobileOTP;
import com.wipro.fhir.r4.data.healthID.SendOTP;
import com.wipro.fhir.r4.data.healthID.VerifyOTP;
import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.http.HttpUtils;
import com.wipro.fhir.r4.utils.mapper.InputMapper;

/***
 * 
 * @author SH20094090
 *
 */

@Service
@PropertySource("classpath:application.properties")
public class CreateHealthID_Aadhaar_NDHMServiceImpl implements CreateHealthID_Aadhaar_NDHMService {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${ndhmGenerateOTPWithAadhaar}")
	private String ndhmGenerateOTPWithAadhaar;

	@Value("${abdmcreateHealthIdWithPreVerified}")
	private String abdmcreateHealthIdWithPreVerified;
	
	@Value("${abdmVerifyOTP}")
	private String abdmVerifyOTP;

	@Value("${abdmCheckAndGenerateMobileOTP}")
	private String abdmCheckAndGenerateMobileOTP;
	
	@Value("${abdmVerifyMobileOTP}")
	private String abdmVerifyMobileOTP;
	
	@Autowired
	private HttpUtils httpUtils;

	@Autowired
	private Common_NDHMService common_NDHMService;
	@Autowired
	private GenerateSession_NDHMService generateSession_NDHM;

	@Override
	public String generateOTP(String request) throws FHIRException {
		String res = null;
		Map<String, String> responseMap = new HashMap<String, String>();
		try {
			String ndhmAuthToken = generateSession_NDHM.getNDHMAuthToken();
			SendOTP obj = InputMapper.gson().fromJson(request, SendOTP.class);
			String requestOBJ = new Gson().toJson(obj);
			logger.info("NDHM_FHIR-generate OTP API request Obj for aadhar" + requestOBJ);
			HttpHeaders headers = common_NDHMService.getHeaders(ndhmAuthToken);
			ResponseEntity<String> responseEntity = httpUtils.postWithResponseEntity(ndhmGenerateOTPWithAadhaar,
					requestOBJ, headers);
			String responseStrLogin = common_NDHMService.getBody(responseEntity);
			if (responseStrLogin != null) {
				JsonObject jsnOBJ = new JsonObject();
				JsonParser jsnParser = new JsonParser();
				JsonElement jsnElmnt = jsnParser.parse(responseStrLogin);
				jsnOBJ = jsnElmnt.getAsJsonObject();
				String txnId = jsnOBJ.get("txnId").getAsString();
				responseMap.put("aadhaar", obj.getAadhaar());
				responseMap.put("txnId", txnId);
				res = new Gson().toJson(responseMap);
			} else
				res = "NDHM_FHIR Error while accessing generate OTP with Aadhaar API";// throw w
		}
		/**
		 * @author SH20094090
		 * @purpose To get response body in case of exception
		 */
		catch(HttpClientErrorException e)
		{
			String message=null;
			if(e.getResponseBodyAsString() !=null)
			{
			HealthIDException exception=InputMapper.gson().fromJson(e.getResponseBodyAsString(), HealthIDException.class);
			if(exception.getDetails() !=null && exception.getDetails().length >0)
			{
				Details details[]=exception.getDetails();
				if(details[0] !=null && details[0].getAttribute() !=null && details[0].getAttribute().getKey() !=null)
				{
					message=details[0].getMessage()+" :"+details[0].getAttribute().getKey();
				}
				else if(details[0] !=null)
					message=details[0].getMessage();
			}
			else if(exception.getMessage() !=null)
				message=exception.getMessage();
			}
			if(message !=null)
				throw new FHIRException("NDHM_FHIR Error while generating OTP for ABHA creation"+message);
			else
				throw new FHIRException("NDHM_FHIR Error while generating OTP for ABHA creation : "+e.getMessage());
			
		}
		catch (Exception e) {
			throw new FHIRException("NDHM_FHIR Error while accessing generate OTP with Aadhaar API" + e);
		}
		return res;
	}
	
	@Override
	public String verifyOTP(String request) throws FHIRException {
		String res = null;
		Map<String, String> resMap = new HashMap<String, String>();
		try {
			String ndhmAuthToken = generateSession_NDHM.getNDHMAuthToken();
			VerifyOTP obj = InputMapper.gson().fromJson(request, VerifyOTP.class);
			String reqObj = new Gson().toJson(obj);
			logger.info("NDHM_FHIR verfiy ADBM API with verfity OTP " + reqObj);
			
			HttpHeaders headers = common_NDHMService.getHeaders(ndhmAuthToken);
			ResponseEntity<String> responseEntity = httpUtils.postWithResponseEntity(abdmVerifyOTP,
					reqObj, headers);
			String responseStrLogin = common_NDHMService.getBody(responseEntity);
			if(responseStrLogin != null && responseEntity.getStatusCodeValue() == 200) {
				JsonObject jsnOBJ = new JsonObject();
				JsonParser jsnParser = new JsonParser();
				JsonElement jsnElmnt = jsnParser.parse(responseStrLogin);
				jsnOBJ = jsnElmnt.getAsJsonObject();
				resMap.put("tnxId", jsnOBJ.get("txnId").getAsString());
				res = new Gson().toJson(resMap);
			} else 
				throw new FHIRException("NDHM_FHIR Error while verifying the OTP");
			
		}
		catch (Exception e) {
			throw new FHIRException("NDHM_FHIR Error while accessing ABHA API" + e);
		}
		return res;
	}
	
	@Override
	public String checkAndGenerateMobileOTP(String request) throws FHIRException {
		String res = null;
		Map<String, String> resMap = new HashMap<String, String>();
		try {
			String ndhmAuthToken = generateSession_NDHM.getNDHMAuthToken();
			MobileOTP obj = InputMapper.gson().fromJson(request, MobileOTP.class);
			String reqObj = new Gson().toJson(obj);
			logger.info("NDHM_FHIR verfiy ADBM API with Check and Generate mobile OTP " + reqObj);
			
			HttpHeaders headers = common_NDHMService.getHeaders(ndhmAuthToken);
			ResponseEntity<String> responseEntity = httpUtils.postWithResponseEntity(abdmCheckAndGenerateMobileOTP,
					reqObj, headers);
			String responseStrLogin = common_NDHMService.getBody(responseEntity);
			if(responseStrLogin != null && responseEntity.getStatusCodeValue() == 200) {
				JsonObject jsnOBJ = new JsonObject();
				JsonParser jsnParser = new JsonParser();
				JsonElement jsnElmnt = jsnParser.parse(responseStrLogin);
				jsnOBJ = jsnElmnt.getAsJsonObject();
				//String mobileLinked = jsnOBJ.get("mobileLinked").getAsString();
				resMap.put("mobileLinked", jsnOBJ.get("mobileLinked").getAsString());
				resMap.put("tnxId", jsnOBJ.get("txnId").getAsString());
				res = new Gson().toJson(resMap);
				
			} else 
				throw new FHIRException("NDHM_FHIR Error while checking and generating mobile OTP");
			
		}
		catch (Exception e) {
			throw new FHIRException("NDHM_FHIR Error while accessing ABHA API" + e);
		}
		return res;
	}
	
	@Override
	public String verifyMobileOTP(String request) throws FHIRException {
		String res = null;
		Map<String, String> resMap = new HashMap<String, String>();
		try {
			String ndhmAuthToken = generateSession_NDHM.getNDHMAuthToken();
			VerifyOTP obj = InputMapper.gson().fromJson(request, VerifyOTP.class);
			String reqObj = new Gson().toJson(obj);
			logger.info("NDHM_FHIR verfiy ADBM API with verify Mobile OTP " + reqObj);
			
			HttpHeaders headers = common_NDHMService.getHeaders(ndhmAuthToken);
			ResponseEntity<String> responseEntity = httpUtils.postWithResponseEntity(abdmVerifyMobileOTP,
					reqObj, headers);
			String responseStrLogin = common_NDHMService.getBody(responseEntity);
			if(responseStrLogin != null && responseEntity.getStatusCodeValue() == 200) {
				JsonObject jsnOBJ = new JsonObject();
				JsonParser jsnParser = new JsonParser();
				JsonElement jsnElmnt = jsnParser.parse(responseStrLogin);
				jsnOBJ = jsnElmnt.getAsJsonObject();
				resMap.put("tnxId", jsnOBJ.get("txnId").getAsString());
				res = new Gson().toJson(resMap);
			} else 
				throw new FHIRException("NDHM_FHIR Error while verifiying mobile OTP");
			
		}
		catch (Exception e) {
			throw new FHIRException("NDHM_FHIR Error while accessing ABHA API" + e);
		}
		return res;
	}


	@Override
	public HealthIDResponse createHealthIDWithUID(String request) throws FHIRException {
		HealthIDResponse health = new HealthIDResponse();
		// Map<String, String> requestMap = new HashMap<String, String>();
		try {
			String ndhmAuthToken = generateSession_NDHM.getNDHMAuthToken();
			HealthIDRequestAadhar obj = InputMapper.gson().fromJson(request, HealthIDRequestAadhar.class);
//			requestMap.put("email", obj.getEmail());//create class
//			requestMap.put("firstName", obj.getFirstName());
//			requestMap.put("lastName", obj.getLastName());
//			requestMap.put("otp", obj.getOtp());
//			requestMap.put("txnId", obj.getTxnId());
//			requestMap.put("username", obj.getUsername());
			String requestOBJ = new Gson().toJson(obj);
			logger.info("NDHM_FHIR create ABHA API with aadhar request Obj " + requestOBJ);
			HttpHeaders headers = common_NDHMService.getHeaders(ndhmAuthToken);
			ResponseEntity<String> responseEntity = httpUtils.postWithResponseEntity(abdmcreateHealthIdWithPreVerified,
					requestOBJ, headers);
			String responseStrLogin = common_NDHMService.getBody(responseEntity);
			if (responseStrLogin != null) {
				health = InputMapper.gson().fromJson(responseStrLogin, HealthIDResponse.class);
			} else
				throw new FHIRException("NDHM_FHIR Error while accessing create ABHA with Aadhaar API");
		}
		/**
		 * @author SH20094090
		 * @purpose To get response body in case of exception
		 */
		catch(HttpClientErrorException e)
		{
			String message=null;
			if(e.getResponseBodyAsString() !=null)
			{
			HealthIDException exception=InputMapper.gson().fromJson(e.getResponseBodyAsString(), HealthIDException.class);
			if(exception.getDetails() !=null && exception.getDetails().length >0)
			{
				Details details[]=exception.getDetails();
				if(details[0] !=null && details[0].getAttribute() !=null && details[0].getAttribute().getKey() !=null)
				{
					message=details[0].getMessage()+" :"+details[0].getAttribute().getKey();
				}
				else if(details[0] !=null)
					message=details[0].getMessage();
			}
			else if(exception.getMessage() !=null)
				message=exception.getMessage();
			}
			if(message !=null)
				throw new FHIRException("NDHM_FHIR Error while creating ABHA "+message);
			else
				throw new FHIRException("NDHM_FHIR Error while creating ABHA : "+e.getMessage());
			
		}
		catch (Exception e) {
			throw new FHIRException("NDHM_FHIR-Error while accessing create ABHA with Aadhaar API" + e);
		}
		return health;
	}

}
