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
@Entity(name = "MONTHLYPAYMENTTOGROUP")
@Getter
@Setter
@NoArgsConstructor
public class MonthlyPaymentToGroupPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "MONTHLYPAYMENTID", nullable = false)
	private MonthlyPaymentPojo monthlyPayment;

	@ManyToOne
	@JoinColumn(name = "GROUPID", nullable = false)
	private GroupPojo group;

}
