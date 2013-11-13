package es.data.generator;


public class SkillsRDFGenerator {
	

	public static String generateSkill(String skillName){

		String rdf = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n<rdf:RDF\n    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n    xmlns:skos=\"http://www.w3.org/2004/02/skos/core#\">\n    \t\n\t" +
				"<skos:Concept rdf:about=\""+Generator.endpointResource+"skills/"+skillName.replaceAll("\\s","")+"\">\n\t\t" +
				"<skos:prefLabel>"+skillName+"</skos:prefLabel>\n\t\t"+
				"<skos:member>skill</skos:member>\n\t" +
				"</skos:Concept>\n</rdf:RDF>\n";

		return rdf;
	}
	
	public static String generateLevel(String level){

		String rdf = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n<rdf:RDF\n    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n    xmlns:skos=\"http://www.w3.org/2004/02/skos/core#\">\n    \t\n\t" +
				"<skos:Concept rdf:about=\""+Generator.endpointResource+"levels/"+level.replaceAll("\\s","")+"\">\n\t\t" +
				"<skos:prefLabel>"+level+"</skos:prefLabel>\n\t\t" +
				"<skos:member>level</skos:member>\n\t" +
				"</skos:Concept>\n</rdf:RDF>\n";

		return rdf;
	}
	
	

}
