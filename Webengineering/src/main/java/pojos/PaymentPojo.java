package main.java.pojos;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
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
	private OffsetDateTime dateCreated;

	@Column(name = "Description", nullable = false)
	private String paymentDescription;

	@Transient
	private String groupName;

	@Transient
	private String users;

	public String formatDateCreated() {
		OffsetDateTime dateTime = this.getDateCreated();

		StringBuilder builder = new StringBuilder();

		builder.append(dateTime.getDayOfMonth());

		builder.append(".");

		builder.append(dateTime.getMonth().getValue());

		builder.append(".");

		builder.append(dateTime.getYear());

		builder.append(" ");

		builder.append(dateTime.getHour());

		builder.append(":");

		builder.append(dateTime.getMinute());

		return builder.toString();
	}

}
