package main.java.beans;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.UUID;

public class RechnungBean {

	// TODO: Überlegen wann und wir man die Beträge ausrechnet.

	UUID rechnungsID;
	Map<UserBean, Double> participants; // Benutzer + Betrag
	BufferedImage image;

	public RechnungBean() {
		// TODO Auto-generated constructor stub
	}

}
