package main.java.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PAYMENTTOUSER")
@Getter
@Setter
@NoArgsConstructor
public class PaymentToUserPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "USERID", nullable = false)
	private UserPojo user;

	@ManyToOne
	@JoinColumn(name = "PAYMENTID", nullable = false)
	private PaymentPojo payment;

	@Column(name = "PERCENTAGE", nullable = false)
	private double percentage;

}
