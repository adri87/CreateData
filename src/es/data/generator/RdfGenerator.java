package es.data.generator;

import java.util.List;

public class RdfGenerator {

	private List<Offer> offer;
	
	public RdfGenerator(List<Offer> offer){
		this.offer = offer;
	}
	
	public String generateOffer(Offer o){		
		
		String rdf = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n<rdf:RDF\n    " +
				"xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n    " +
				"xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n    " +
				"xmlns:foaf=\"http://xmlns.com/foaf/0.1/\"\n    " +
				"xmlns:vcard=\"http://www.w3.org/2006/vcard/ns#\"\n    " +
				"xmlns:cv=\"http://kaste.lv/~captsolo/semweb/resume/cv.rdfs#\">\n    " +
				"<foaf:Person rdf:about=\""+Generator.endpointResource+o.getUid()+"\">\n        " +
				"<foaf:name>"+o.getName()+"</foaf:name>\n        " +
				"<foaf:id>"+o.getId()+"</foaf:id>\n        " +
				"<foaf:thumbnail rdf:resource=\""+o.getPhotoUrl()+"\" />\n        " +
				"<vcard:locality>"+o.getLocality()+"</vcard:locality>\n        " +
				"<cv:hasSkill>\n\t\t    ";
				for(Skill skill : o.getSkills()){
					rdf += "<cv:Skill>\n\t\t\t    " +
							"<cv:skillName rdf:resource=\""+Generator.endpointResource+"skills/"+skill.getUid()+"\" />\n\t\t            " +
							"<cv:skillLevel rdf:resource=\""+Generator.endpointResource+"levels/"+skill.getLevel()+"\"/>\n\t\t    " +
							"</cv:Skill>\n\t\t    ";
				}				
				rdf += "</cv:hasSkill>\n        " +
				"<cv:cvDescription>"+o.getDescription()+"</cv:cvDescription>\n        " +
				"<cv:jobTitle>"+o.getContract()+"</cv:jobTitle>\n        " +
				"<cv:targetSalary>"+o.getSalary()+"</cv:targetSalary>\n    " +
				"</foaf:Person>\n</rdf:RDF>";
		
		return rdf;
	}

//	public String generateOffer(Offer o){		
//		
//		String rdf = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n<rdf:RDF\n    " +
//				"xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n    " +
//				"xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n    " +
//				"xmlns:foaf=\"http://xmlns.com/foaf/0.1/\"\n    " +
//				"xmlns:vcard=\"http://www.w3.org/2006/vcard/ns#\"\n    " +
//				"xmlns:cv=\"http://kaste.lv/~captsolo/semweb/resume/cv.rdfs#\">\n    " +
//				"<vcard:Kind rdf:about=\""+Generator.endpointResource+o.getUid()+"\">\n        " +
//				"<vcard:title>"+o.getName()+"</vcard:title>\n        " +
//				"<vcard:hasLogo rdf:resource=\""+o.getPhotoUrl()+"\" />\n        " +
//				"<vcard:locality>"+o.getLocality()+"</vcard:locality>\n        " +
//				"<vcard:hasUID>"+o.getId()+"</vcard:hasUID>\n        " +
//				"<cv:hasSkill>\n\t\t    ";
//				for(Skill skill : o.getSkills()){
//					rdf += "<cv:Skill>\n\t\t\t    " +
//							"<cv:skillName rdf:resource=\""+Generator.endpointResource+"skills/"+skill.getUid()+"\" />\n\t\t            " +
//							"<cv:skillLevel rdf:resource=\""+Generator.endpointResource+"levels/"+skill.getLevel()+"\"/>\n\t\t    " +
//							"</cv:Skill>\n\t\t    ";
//				}				
//				rdf += "</cv:hasSkill>\n        " +
//				"<cv:cvDescription>"+o.getDescription()+"</cv:cvDescription>\n        " +
//				"<cv:jobTitle>"+o.getContract()+"</cv:jobTitle>\n        " +
//				"<cv:targetSalary>"+o.getSalary()+"</cv:targetSalary>\n    " +
//				"</vcard:Kind>\n</rdf:RDF>";
//		
//		return rdf;
//	}
		
	public void generateAll(){
		for(Offer o : offer){
			String rdf = this.generateOffer(o);
			System.out.println(rdf);
		}
	}

}
