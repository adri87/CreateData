package es.data.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.data.generator.DataMahout;
import es.data.generator.Generator;
import es.data.generator.Offer;
import es.data.generator.RdfGenerator;
import es.data.generator.Skill;
import es.data.generator.SkillsRDFGenerator;
import es.data.sql.ConnectionSQL;

public class Main {

	/**
	 * @param args
	 */
	private static boolean genOffer = true;
	private static boolean genSkills = true;
	private static boolean genLevels = true;
	
	private static String dirOutput = "output";	
	private static String dirOffers = "offers";
	private static String dirSkills = "skills";
	private static String dirLevels = "levels";
	private static DataMahout mah;

	public static void main(String[] args) {
		if(genOffer){
			deleteDir(dirOffers);
			Generator g = new Generator();
			List<Offer> offer = g.generateRandom(100);
			mah = new DataMahout(offer);

			RdfGenerator rdfGen = new RdfGenerator(offer);
			for(Offer o : offer){
				writeRdf(dirOffers, o.getUid(), rdfGen.generateOffer(o));
			}
		}

		if(genSkills){
			deleteDir(dirSkills);
			for(String s : Skill.skills){
				writeRdf(dirSkills, s.replaceAll("\\s","_"), SkillsRDFGenerator.generateSkill(s));
			}
		}
		
		if(genLevels){
			deleteDir(dirLevels);
			for(String l : Skill.levels){
				writeRdf(dirLevels, l.replaceAll("\\s","_"), SkillsRDFGenerator.generateLevel(l));
			}
		}
		writeCsv();
		ConnectionSQL dbCon = new ConnectionSQL();
		dbCon.introduceRatings();
		System.out.println("End");

	}

	private static void writeRdf(String dir, String name, String content){			
		try {
			String filename = dirOutput+"/"+dir+"/"+name+".rdf";
			File newTextFile = new File(filename);
			newTextFile.createNewFile();
			FileWriter fw = new FileWriter(newTextFile);
			fw.write(content);
			fw.close();
			System.out.println("Generated "+filename);

		} catch (IOException iox) {
			iox.printStackTrace();
		}
	}
	
	private static void writeCsv(){
		ArrayList<String> idsOffers = mah.getOffersId();
		try {
			String filenameRated = dirOutput+"/mahout/ratings.csv";
			File fileRated = new File(filenameRated);
			FileWriter fwr = new FileWriter(fileRated);
			for (int i = 1; i <= 5 ; i++) {
				int numValoraciones = (int)(Math.random()*10 + 1);
				ArrayList<Integer> yaValorados = new ArrayList<>();
				for (int j = 0; j < numValoraciones; j++) {
					int pos = (int)(Math.random()*idsOffers.size());
					while (yaValorados.contains(pos)) {
						pos = (int)(Math.random()*idsOffers.size());
					}
					yaValorados.add(pos);
					String elemento = idsOffers.get(pos);
					BigDecimal numeroDecimal = new BigDecimal(Math.random()*2).setScale(1,BigDecimal.ROUND_DOWN ); 
					double rate = 5 - numeroDecimal.doubleValue();
					fwr.write(i+","+elemento+","+rate+"\n");
				}
			}
			fwr.close();
			System.out.println("Generated "+filenameRated);
		} catch (IOException iox) {
			iox.printStackTrace();
		}
	}
	
	private static void deleteDir(String dir){
		File directory = new File(dirOutput+"/"+dir);
		for(File file: directory.listFiles()) file.delete();
	}
}
