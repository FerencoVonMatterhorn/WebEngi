package main.java.pojos;

import java.time.OffsetDateTime;
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

@Entity(name = "MONTHLYPAYMENTS")
@Getter
@Setter
@NoArgsConstructor
public class MonthlyPaymentPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "MONTHLYPAYMENTID")
	private int monthlyPaymentID;

	@Column(name = "DATECREATED", nullable = false)
	private OffsetDateTime dateCreated;

	@Column(name = "DATEUNTIL", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateUntil;

}
