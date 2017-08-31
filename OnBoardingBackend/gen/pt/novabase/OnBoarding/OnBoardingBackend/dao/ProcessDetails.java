package pt.novabase.OnBoarding.OnBoardingBackend.dao;
// Generated Aug 30, 2017 5:13:33 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProcessDetails generated by hbm2java
 */
@Entity
@Table(name = "PROCESS_DETAILS")
public class ProcessDetails implements java.io.Serializable {

	private long processId;
	private String nif;
	private String name;
	private String email;
	private String idNumber;
	private String phoneNumber;
	private String creationUser;
	private Date creationDate;
	private String updateUser;
	private Date updateDate;
	private Set<ProcessImages> processImageses = new HashSet<ProcessImages>(0);

	public ProcessDetails() {
	}

	public ProcessDetails(long processId, String nif, String name, String idNumber, String phoneNumber,
			String creationUser, String updateUser) {
		this.processId = processId;
		this.nif = nif;
		this.name = name;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.creationUser = creationUser;
		this.updateUser = updateUser;
	}

	public ProcessDetails(long processId, String nif, String name, String email, String idNumber, String phoneNumber,
			String creationUser, Date creationDate, String updateUser, Date updateDate,
			Set<ProcessImages> processImageses) {
		this.processId = processId;
		this.nif = nif;
		this.name = name;
		this.email = email;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.creationUser = creationUser;
		this.creationDate = creationDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.processImageses = processImageses;
	}

	@Id

	@Column(name = "PROCESS_ID", unique = true, nullable = false)
	public long getProcessId() {
		return this.processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	@Column(name = "NIF", nullable = false)
	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ID_NUMBER", nullable = false)
	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Column(name = "PHONE_NUMBER", nullable = false)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "CREATION_USER", nullable = false)
	public String getCreationUser() {
		return this.creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", length = 23)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "UPDATE_USER", nullable = false)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE", length = 23)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "processDetails")
	public Set<ProcessImages> getProcessImageses() {
		return this.processImageses;
	}

	public void setProcessImageses(Set<ProcessImages> processImageses) {
		this.processImageses = processImageses;
	}

}
