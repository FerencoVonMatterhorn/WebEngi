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
@Entity(name = "USERTOGROUP")
@Getter
@Setter
@NoArgsConstructor
public class UserToGroupPojo {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@ManyToOne
	@JoinColumn(name = "GROUPID", nullable = false)
	private GroupPojo group;

	@ManyToOne
	@JoinColumn(name = "USERID", nullable = false)
	private UserPojo user;

}
