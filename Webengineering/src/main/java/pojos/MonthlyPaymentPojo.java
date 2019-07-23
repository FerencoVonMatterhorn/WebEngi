package main.java.pojos;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
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
	private OffsetDateTime dateUntil;

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

	public String formatDateUntil() {

		OffsetDateTime dateTime = this.getDateUntil();

		StringBuilder builder = new StringBuilder();

		builder.append(dateTime.getDayOfMonth());

		builder.append(".");

		builder.append(dateTime.getMonth().getValue());

		builder.append(".");

		builder.append(dateTime.getYear());

		return builder.toString();
	}

}
