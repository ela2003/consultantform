package com.consultant.form.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "form")
public class consultantEntity {
	public consultantEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String Father_Name;
private String Address;
private String Email;
private Long Mobile_no;
public consultantEntity(String name, String father_Name, String address, String email, Long mobile_no,
		String dateofbirth, String gender, String education_Qualification, String experience, String field,
		MultipartFile resume, String resumeName) {
	super();
	this.name = name;
	Father_Name = father_Name;
	Address = address;
	Email = email;
	Mobile_no = mobile_no;
	this.dateofbirth = dateofbirth;
	Gender = gender;
	Education_Qualification = education_Qualification;
	Experience = experience;
	Field = field;
	Resume = resume;
	ResumeName = resumeName;
}
private String dateofbirth;

public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
private String Gender;
private  String Education_Qualification;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFather_Name() {
	return Father_Name;
}
public void setFather_Name(String father_Name) {
	Father_Name = father_Name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public Long getMobile_no() {
	return Mobile_no;
}
public void setMobile_no(Long mobile_no) {
	Mobile_no = mobile_no;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getEducation_Qualification() {
	return Education_Qualification;
}
public void setEducation_Qualification(String education_Qualification) {
	Education_Qualification = education_Qualification;
}
public String getExperience() {
	return Experience;
}
public void setExperience(String experience) {
	Experience = experience;
}
public String getField() {
	return Field;
}
public void setField(String field) {
	Field = field;
}
private String Experience;
private String Field;
@Transient
private MultipartFile Resume;
public MultipartFile getResume() {
	return Resume;
}
public void setResume(MultipartFile resume) {
	Resume = resume;
}
public String getResumeName() {
	return ResumeName;
}
public void setResumeName(String resumeName) {
	ResumeName = resumeName;
}

@Column(length = 100)
private String ResumeName;


}
