package com.example.shop.members.dto;

import org.springframework.stereotype.Component;

import com.example.shop.common.execption.WrongEmailPasswordException;

import lombok.Getter;

@Component
public class MembersDTO {
	private String memberEmail; //이메일
	private String memberPass; //비밀번호
	private String memberName; //이름
	private String memberPhone; //전화번호
	private int memberType; //회원구분 일반회원 1, 관리자 2
	private boolean rememberEmail; //자동 로그인
	private String authRole;
	
	public MembersDTO() {
		
	}
	
	
	
	public String getAuthRole() {
		return authRole;
	}
	
	public void setAuthRole(String authRole) {
		this.authRole = authRole;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public String getMemberPass() {
	return memberPass;
	}
 
	public void setMemberEmail(String memberEmail) {
	this.memberEmail = memberEmail;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public boolean isRememberEmail() {
		return rememberEmail;
	}

	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}

	   								    //입력한 비밀번호
	public boolean matchPassword(String memberPass) {
		return this.memberPass.equals(memberPass);
									  //DB 에서 보내준 비밀번호
	}
	
	//기존 비밀번호와 새로운 비밀번호를 받아서 비교
	public void changePassword(String oldPassword, String newPassword) {
		   //본인이 맞는지 체크하는 식 -> 테이블에 저장된 비밀번호와 현재 비밀번호를 입력한 값이 같은지
		if(!memberPass.equals(oldPassword))
			throw new WrongEmailPasswordException();
		//테이블에서 가져온 비밀번호에 새로 입력한 비밀번호를 담아준다.
		this.memberPass=newPassword;
	}

	@Override
	public String toString() {
		return "MembersDTO [memberEmail=" + memberEmail + ", memberPass=" + memberPass + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + ", memberType=" + memberType + ", rememberEmail=" + rememberEmail
				+ ", authRole=" + authRole + "]";
	}
	
	
	
	
}//end class











