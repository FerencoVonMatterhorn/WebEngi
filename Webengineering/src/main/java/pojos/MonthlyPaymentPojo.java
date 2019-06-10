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

@Entity(name = "NONTHLYPAYMENTS")
@Getter
@Setter
@NoArgsConstructor
public class MonthlyPaymentPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "MONTHLYPAYMENTID")
	private int monthlyPaymentID;

	@Column(name = "AMOUNT", nullable = false)
	private double amount;

	@Column(name = "DATECREATED", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Column(name = "DATEUNTIL", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateUntil;

}
