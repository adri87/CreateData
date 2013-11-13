package es.data.util;

public class NameEnterpriseGenerator {
	
	private String[] nameCompanies = {"Accenture","Accenture Outsourcing Services","Adecco","ACK Storm","Alcatel-Lucent","Alianzit Consulting", "Altran",
			"ATM Broadcast", "Atos Origin", "Banco Santander Central Hispano", "Capgemini", "Coritel", "Deloitte", "eDreams", "Electronic Arts", 
			"Ericsson Espana Id", "eSoluzion", "Everis", "Fujitsu", "GAME", "GMV", "HP Outsourcing", "Huawei Technologies", "Ieci Informatica El Corte Ingles",
			"Catenon", "Telefonica", "BQ", "Coca-Cola", "Elecnor", "Indra", "Orange", "Vodafone", "Microsoft", "PWC", "Samsung", "Apple", "Delogica", 
			"BBVA", "HTC", "Ono", "Sony", "LG", "Bankia", "Packard Bell", "Blackberry", "Google", "Yahoo", "IBM", "Siemens", "Intel", "Boeing", "Oracle", 
			"Nokia", "Canon", "Motorola", "Philips", "Amazon", "Adobe", "Sun Microsystems", "Ebay", "Verizon"};
	
	/**
	 * Returns random companie name
	 * @return
	 */
	public String getRandomNameCompanie(){
		return nameCompanies[random(0, nameCompanies.length-1)];
	}
	
	private static int random(int min, int max){
		return (min + (int)(Math.random()*max));
	}

}
