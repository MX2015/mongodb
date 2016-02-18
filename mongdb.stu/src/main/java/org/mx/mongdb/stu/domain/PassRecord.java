package org.mx.mongdb.stu.domain;

import java.util.Date;

public class PassRecord {

	private String id ;
	private String carNum ;	
	private Date   passTime ;
	private String kkcode ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public Date getPassTime() {
		return passTime;
	}
	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}
	public String getKkcode() {
		return kkcode;
	}
	public void setKkcode(String kkcode) {
		this.kkcode = kkcode;
	}
	
	
}
