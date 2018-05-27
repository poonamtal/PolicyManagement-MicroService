package com.proj.policy.summary.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "userpolicytable")
public class UserPolicy {

	// id will be used for storing MongoDB id
	@Id
	private String id;
	@Field("user_Policy_Id")
	private String userPolicyId;
	@Field("userId")
	private String userId;
	@Field("productId")
	private String ProductId;
	@Field("sumAssured")
	private String SumAssured;
	@Field("maturityDate")
	private String MaturityDate;
	@Field("premiumFrequency")
	private String PremiumFrequency;
	@Field("premiumAmt")
	private String PremiumAmt;
	@Field("purchaseDate")
	private String PurchaseDate;
	@Field("policyStatus")
	private String PolicyStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getUserPolicyId() {
		return userPolicyId;
	}

	public void setUserPolicyId(String userPolicyId) {
		this.userPolicyId = userPolicyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		ProductId = productId;
	}

	public String getSumAssured() {
		return SumAssured;
	}

	public void setSumAssured(String sumAssured) {
		SumAssured = sumAssured;
	}

	public String getMaturityDate() {
		return MaturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		MaturityDate = maturityDate;
	}

	public String getPremiumFrequency() {
		return PremiumFrequency;
	}

	public void setPremiumFrequency(String premiumFrequency) {
		PremiumFrequency = premiumFrequency;
	}

	public String getPremiumAmt() {
		return PremiumAmt;
	}

	public void setPremiumAmt(String premiumAmt) {
		PremiumAmt = premiumAmt;
	}

	public String getPurchaseDate() {
		return PurchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		PurchaseDate = purchaseDate;
	}

	public String getPolicyStatus() {
		return PolicyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		PolicyStatus = policyStatus;
	}

	@Override
	public String toString() {
		return "UserPolicy [id=" + id + ", userPolicyId=" + userPolicyId + ", userId=" + userId + ", ProductId="
				+ ProductId + ", SumAssured=" + SumAssured + ", MaturityDate=" + MaturityDate + ", PremiumFrequency="
				+ PremiumFrequency + ", PremiumAmt=" + PremiumAmt + ", PurchaseDate=" + PurchaseDate + ", PolicyStatus="
				+ PolicyStatus + "]";
	}
	
}
