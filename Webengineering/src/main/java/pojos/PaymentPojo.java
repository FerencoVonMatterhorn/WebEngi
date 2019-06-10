package main.java.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PAYMENTS")
@Getter
@Setter
@NoArgsConstructor
public class PaymentPojo {

	@Id
	@Column(name = "PAYMENTID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int paymentID;

	@Column(name = "AMOUNT", nullable = false)
	private double amount;

	@Column(name = "DATECREATED", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

}
