package es.data.util;

public class Description {
  public static final String DESCRIPTION = "Oferta de empleo de la empresa en la REPLACE en la que se necesitan profesionales que satisfagan una serie de habilidades tecnicas.";
  
  public String getDescritption(String company) {
	  return DESCRIPTION.replace("REPLACE", company);
  }
  
}
