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
import lombok.ToString;

@ToString
@Entity(name = "MONTHLYPAYMENTTOUSER")
@Getter
@Setter
@NoArgsConstructor
public class MonthlyPaymentToUserPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "USERID", nullable = false)
	private UserPojo user;

	@ManyToOne
	@JoinColumn(name = "MONTHLYPAYMENTID", nullable = false)
	private MonthlyPaymentPojo monthlyPayment;

}
