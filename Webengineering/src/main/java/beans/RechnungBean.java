package main.java.beans;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.UUID;

public class RechnungBean {

	// TODO: �berlegen wann und wir man die Betr�ge ausrechnet.

	UUID rechnungsID;
	Map<UserBean, Double> participants; // Benutzer + Betrag
	BufferedImage image;

	public RechnungBean() {
		// TODO Auto-generated constructor stub
	}

}
