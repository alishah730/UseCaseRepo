package com.usecase.bean;
/**
 * @author Habibul Ali Shah
 */
public class RequirementDetails {
	private long reqId;
	private String businessName;
	private String roleName;
	private String location;
	private String approver1;
	private String approver2;
	public long getReqId() {
		return reqId;
	}
	public void setReqId(long reqId) {
		this.reqId = reqId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getApprover1() {
		return approver1;
	}
	public void setApprover1(String approver1) {
		this.approver1 = approver1;
	}
	public String getApprover2() {
		return approver2;
	}
	public void setApprover2(String approver2) {
		this.approver2 = approver2;
	}
	@Override
	public String toString() {
		return "RequirementDetails [reqId=" + reqId + ", businessName=" + businessName + ", roleName=" + roleName
				+ ", location=" + location + ", approver1=" + approver1 + ", approver2=" + approver2 + "]";
	}
	
}
