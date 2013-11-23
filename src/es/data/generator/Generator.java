package es.data.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.data.util.Description;
import es.data.util.NameEnterpriseGenerator;

public class Generator {
	
	private List<Offer> offer = new ArrayList<Offer>();
	
	private String[] cities = {"A Coruña", "Barcelona", "Burgos", "Caceres", "Madrid", "Oviedo", "San Sebastian", "Sevilla", 
			"Valencia", "Valladolid", "Zaragoza"};
	
	private String[] contract = {"Indefinido", "Temporal", "De relevo", "En prácticas y de formación", "Aprendizaje" };	
	
	private HashMap<String, String> images = new HashMap<>();
	
	public static String endpointResource = "http://localhost:8080/LMF-2.6.0/resource/";

	
	public List<Offer> generateRandom(int number){
		introduceImages();
		NameEnterpriseGenerator ng = new NameEnterpriseGenerator();
		Description des = new Description();
		for (int i=1; i<=number;i++){	
			String name = "Vacante"+i;
			String id = String.valueOf(100+i);
			String nameEnterprise = ng.getRandomNameCompanie();
			String citie = cities[random(0,cities.length-1)];
			String description = des.getDescritption(nameEnterprise);
			String photoUrl = images.get(nameEnterprise);
			String typeContract = contract[random(0,contract.length-1)];
			List<Skill> skills = new ArrayList<Skill>();
			int salary = random(10000, 40000);
			int numSkills = random(1,5);
			
			for(int j = 0; j<numSkills; j++){
				String skillName = Skill.skills[random(0,Skill.skills.length-1)];
				String skillLevel = Skill.levels[random(0,Skill.levels.length-1)];
				skills.add(new Skill(skillName, skillLevel));
				
			}
			offer.add(new Offer(name, id, nameEnterprise, citie, description, photoUrl, 
					typeContract, salary, skills));	
		}
		return offer;
	}
	
	/**
	 * 
	 */
	private void introduceImages(){
		images.put("Accenture", "https://si0.twimg.com/profile_images/1896690488/Accenture-Spain.jpg");
		images.put("Accenture Outsourcing Services", "http://2.bp.blogspot.com/-uX8YQFcA-6E/UYfDxglvUYI/AAAAAAAASNM/CgQhYR9PAEg/s1600/accenture.jpg");
		images.put("Adecco", "http://www.enredando.info/wp-content/uploads/2013/03/adecco_logo-1024x552.jpg");
		images.put("ACK Storm", "http://3.bp.blogspot.com/__bA2iRUgEOA/TKTFP-uR54I/AAAAAAAAAFo/MWz2-R8fHgk/s400/ackstorm_trans.jpg");
		images.put("Everis", "https://www.coitcv.org/wp-content/uploads/2013/05/everis_logo.jpg");
		images.put("eSoluzion", "http://www.esoluzion.com/templates/vr_corp/images/logoEsoluzion.jpg");
		images.put("Ericsson Espana Id", "http://www.ericsson.com/shared/eipa/images/elogo.png");
		images.put("Electronic Arts", "http://www.muylinux.com/wp-content/uploads/2012/05/electronic-arts-1.jpg");
		images.put("eDreams", "http://soyviajero.com/wp-content/uploads/2013/06/edreams-e1371230697437.jpg");
		images.put("Deloitte", "http://www.deloitte.com/deloitte-ecm-cm-dpm-web/images/dcom/new_deloitte_logo.gif");
		images.put("Coritel", "http://blog.infoempleo.com/wp-content/uploads/2010/06/logo-coritel.gif");
		images.put("Capgemini", "http://www.es.capgemini.com/sites/all/themes/capgemini/logo.png");
		images.put("Banco Santander Central Hispano", "https://www.bancosantander.es/CsApps/GrupoSantander/Internet/SantanderComercial/img/logo_SAN.gif");
		images.put("Atos Origin", "http://es.atos.net/etc/designs/neoweb/images/new-images/atos_logo.jpg");
		images.put("ATM Broadcast", "http://static.comunicae.com/photos/notas/1021008/LOGO-ATM.jpg");
		images.put("Altran", "http://www.altran.es/fileadmin/templates/main/media/logo/logo_altran.png");
		images.put("Alianzit Consulting", "http://www.alianzit.es/imagenes/logo.gif");
		images.put("Alcatel-Lucent", "http://www.alcatel-lucent.com/sites/all/themes/alu_theme/logo.png");
		images.put("Fujitsu", "http://www.fujitsu.com/es/resources/design/stylesheets/images/css_images/fujitsu/symbolmark.gif");
		images.put("GAME", "http://www.game.es/Theme/Images/Head/GAME.png");
		images.put("GMV", "http://www.gmv.com/export/system/modules/com.gmv.teresa.site/resources/imagenes/generales/logo.gif");
		images.put("HP Outsourcing", "http://www.www8-hp.com/es/es/images/i/header-footer/caas-hf-v3/hp-logo.gif");
		images.put("Huawei Technologies", "http://www.huawei.com/ucmf/groups/public/documents/webasset/hw_000353.jpg");
		images.put("Ieci Informatica El Corte Ingles", "http://www.iecisa.com/iecisa/images/img/informatica_el_corte_ingles_logo.png");
		images.put("Catenon", "http://www.gurusblog.com/jordi/wp/wp-content/uploads/2011/11/Logo-Catenon.jpg");
		images.put("Telefonica", "http://www.saberinvertir.es/wp-content/uploads/2011/05/telef%C3%B3nica-inciar%C3%A1-un-ere-de-ac%C3%A1-a-cinco-a%C3%B1os.jpg");
		images.put("BQ", "http://static-bqreaders.s3.amazonaws.com/file/logos/bq_blanco_con_fondo_negro.png");
		images.put("Coca-Cola", "http://www.lacia.com/blog/wp-content/uploads/2012/07/Coca_Cola03.jpeg");
		images.put("Elecnor", "http://www.elecnor.es/support/img/logo.png");
		images.put("Indra", "http://www.indracompany.com/sites/default/files/basic_logo.gif");
		images.put("Orange", "http://ohmyphone.orange.es/UpImages/ohmyphone/2010/12/orange_es.jpg");
		images.put("Vodafone", "http://www.vodafone.es/static/img/header_logo.png");
		images.put("Microsoft", "http://i.s-microsoft.com/global/ImageStore/PublishingImages/logos/hp/logo-lg-1x.png");
		images.put("PWC", "http://www.pwc.es/en_GX/webadmin/assets/image/pwclogo.gif");
		images.put("Samsung", "http://www.samsung.com/common/img/logo.png");
		images.put("Apple", "http://tradersecrets.es/wp-content/uploads/2013/09/apple_logo2.jpg");
		images.put("Delogica", "http://www.delogica.com/images/logotipo_delogica.jpg");
		images.put("BBVA", "https://www.bbva.es/estaticos/mult/logoBBVA.png");
		images.put("HTC", "http://english.inforpress.es/wp-content/uploads/2013/06/htc-logo-2.jpg");
		images.put("Ono", "http://img.tecnologiapyme.com/2012/06/ono-logo.jpg");
		images.put("Sony", "http://www.tuexperto.com/wp-content/uploads/2012/12/Sony-logo.jpg");
		images.put("LG", "http://phandroid.s3.amazonaws.com/wp-content/uploads/2013/04/lg-logo.jpg");
		images.put("Bankia", "http://www.bankia.es/Ficheros/CMA/ficheros/CMP_IMG_h1_logo.PNG");
		images.put("Packard Bell", "http://www.skynetmi.com/wp-content/uploads/2013/09/logo-packard-bell-2009.jpg");
		images.put("Blackberry", "http://t1.gstatic.com/images?q=tbn:ANd9GcTTWGkXI3-2s9QeJzr9l8LSJEB8m1YLxdnFEMW28uP2X3k7tZQM");
		images.put("Google", "http://blog.phonehouse.es/wp-content/uploads/2013/10/cabeza6.jpg");
		images.put("Yahoo", "http://blog.mp3.es/wp-content/uploads/2013/06/Yahoo-ids.jpg");
		images.put("IBM", "http://1.bp.blogspot.com/-rNu9TlxhL3w/UQcjdr4VGnI/AAAAAAAAA4c/DLE6h347Eq4/s1600/IBM.jpg");
		images.put("Siemens", "http://www.motordehidrogeno.net/wp-content/uploads/2011/08/Siemens.bmp");
		images.put("Intel", "http://www.tecnologiabit.com/wp-content/uploads/2011/08/intel_logo2.jpg");
		images.put("Boeing", "http://www.boeing.es/App_Themes/BoeingInternational/images/global/header_logo.jpg");
		images.put("Oracle", "http://www.siliconweek.es/wp-content/uploads/2013/06/oraclelogo2.png");
		images.put("Nokia", "http://4.bp.blogspot.com/-G-ZE6Fp98-0/URxzd9uz8II/AAAAAAAAAOY/Bsy7egGmqqM/s1600/Nokia.jpg");
		images.put("Canon", "http://www.canon.es/Images/logo.gif");
		images.put("Motorola", "http://www.mivgo.com/wp-content/uploads/2010/12/Motorola-New-Logo1.jpg");
		images.put("Philips", "http://www.crsc.philips.com/crsc/images/mainlogo.gif");
		images.put("Amazon", "http://www.ubuntizando.com/wp-content/uploads/2012/09/amazon-ubuntu.jpg");
		images.put("Adobe", "http://1.bp.blogspot.com/-iPcds0mYo30/TtdjE5C7yqI/AAAAAAAAAFU/sddvzfZivEY/s200/adobe-logo.jpg");
		images.put("Sun Microsystems", "http://columnatamaulipas.com/wp-content/uploads/2013/07/sunmicro.png");
		images.put("Ebay", "http://visualescrita.files.wordpress.com/2010/11/ebay_logo.jpg");
		images.put("Verizon", "http://www.verizon.com/cs/groups/public/documents/adacct/logo_landing.png");
	}
	
	public static int random(int min, int max){
		return (min + (int)(Math.random()*(max+1)));
	}

}
