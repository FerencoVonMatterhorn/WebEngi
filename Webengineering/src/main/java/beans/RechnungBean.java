package main.java.beans;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import main.java.pojos.UserPojo;

@Entity
@Getter
@Setter
@Builder
public class RechnungBean {

	UUID rechnungsID;
	Map<UserPojo, Double> participants; // Benutzer + Betrag
	BufferedImage image;

}
