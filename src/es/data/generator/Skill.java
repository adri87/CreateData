package es.data.generator;

public class Skill {
	private String name;
	private String level;
	
	public static String[] skills = {"Java", "Software Engineering", "C", "iOS", "Android", 
			"HTML", "HTML5", "Javascript", "jQuery", "Knockout", "Sparql", "Semantic technologies", 
			"Linux", "Social skills", "Server administration", "PHP", "Signal procesing", "Photo editing",
			"Video rendering", "Windows", "Mobile developement", "Scrum"};
	
	public static String[] levels = {"Beginner", "Intermediate", "Expert"};
	
	public Skill(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	
	public String getUid(){
		return this.name.replaceAll("\\s","_");
	}
	public void setName(String name) {
		this.name = name;
	}

}
