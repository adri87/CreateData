package es.data.generator;

import java.util.ArrayList;
import java.util.List;

public class DataMahout {
	private List<Offer> offers;
	
	public DataMahout(List<Offer> offers){
		this.offers=offers;
	}
	
	public ArrayList<String> getOffersId(){
		ArrayList<String> ids = new ArrayList<>();
		for (Offer o: offers){
			ids.add(o.getId());
		}
		return ids;
	}

}
