package MainClass_GenshinGacha;

import java.time.LocalDateTime;

public class Models_User {
	private String username;
	private String diamondvalue;
	private int gachaCount;
	private int purchaseGacha;
	private LocalDateTime lastGachaTimestamp;
	

	public Models_User(String username, String diamondvalue, int gachaCount, int purchaseGacha,
			LocalDateTime lastGachaTimestamp) {
		super();
		this.username = username;
		this.diamondvalue = diamondvalue;
		this.gachaCount = gachaCount;
		this.purchaseGacha = purchaseGacha;
		this.lastGachaTimestamp = lastGachaTimestamp;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDiamondvalue() {
		return diamondvalue;
	}


	public void setDiamondvalue(String diamondvalue) {
		this.diamondvalue = diamondvalue;
	}


	public int getGachaCount() {
		return gachaCount;
	}


	public void setGachaCount(int gachaCount) {
		this.gachaCount = gachaCount;
	}


	public int getPurchaseGacha() {
		return purchaseGacha;
	}


	public void setPurchaseGacha(int purchaseGacha) {
		this.purchaseGacha = purchaseGacha;
	}


	public LocalDateTime getLastGachaTimestamp() {
		return lastGachaTimestamp;
	}


	public void setLastGachaTimestamp(LocalDateTime lastGachaTimestamp) {
		this.lastGachaTimestamp = lastGachaTimestamp;
	}

	}