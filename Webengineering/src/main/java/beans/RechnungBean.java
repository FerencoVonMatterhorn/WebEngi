package main.java.beans;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class RechnungBean {

	UUID rechnungsID;
	Map<UserBean, Double> participants; // Benutzer + Betrag
	BufferedImage image;

}
