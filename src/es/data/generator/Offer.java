package es.data.generator;

import java.util.List;

public class Offer {
	
	private String name;
	private String id;
	private String nameEnterprise;
	private String locality;
	private String description;
	private String photoUrl;
	private String contract;
	private int salary;
	private List<Skill> skills;
	
	public Offer(String name, String id, String nameEnterprise, String locality, String description, String photoUrl, 
			String contract, int salary, List<Skill> skills){
		this.name=name;
		this.id=id;
		this.nameEnterprise=nameEnterprise;
		this.locality=locality;
		this.description=description;
		this.photoUrl=photoUrl;
		this.contract=contract;
		this.salary=salary;
		this.skills=skills;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getNameEnterprise() {
		return nameEnterprise;
	}
	
	public void setNameEnterprise(String nameEnterprise) {
		this.nameEnterprise=nameEnterprise;
	}
	
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public void setSkill(Skill skill){
		this.skills.add(skill);
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	public int getSalary(){
		return salary;
	}
	
	public void setSalary(int salary){
		this.salary=salary;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}
	
	public String getUid(){
		return this.name.replaceAll(" ","_");
	}	
}
