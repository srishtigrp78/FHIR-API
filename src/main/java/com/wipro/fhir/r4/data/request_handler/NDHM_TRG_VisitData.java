package com.wipro.fhir.r4.data.request_handler;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/***
 * 
 * @author NE298657
 *
 */

@Entity
@Table(name = "NDHM_TRG_VisitData")
public class NDHM_TRG_VisitData {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "id")
	private Long id;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long benRegID;
	@Expose
	@Column(name = "VisitCode")
	private Long visitCode;
	@Expose
	@Column(name = "created_date")
	private Timestamp createDate;
}
