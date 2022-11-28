package object;

import java.time.LocalDateTime;

public class Member
{
	private String ID;
	private String PW;
	private String role;
	private String name;
	private String address;
	private String phone;
	private LocalDateTime createDate;
	
	public Member(){}
	
	public Member(String iD, String pW, String role, String name, String address, String phone, LocalDateTime createDate) {
		super();
		ID = iD;
		PW = pW;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.createDate = createDate;
	}

	public void setAllwithoutRole(String iD, String pW)
	{
		this.ID = iD;
		this.PW = pW;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public void setManagerRole()
	{
		setRole("manager");
	}
	public void setParttimerRole()
	{
		setRole("parttimer");
	}
}