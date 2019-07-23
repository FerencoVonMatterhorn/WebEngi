package main.java.pojos;

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
@Entity(name = "GROUPS")
@Getter
@Setter
@NoArgsConstructor
public class GroupPojo {

	@Id
	@Column(name = "GROUPID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int groupID;

	@Column(name = "GROUPNAME", nullable = false)
	private String groupName;

	@Column(name = "GROUPDESCRIPTION", nullable = false)
	private String groupDescription;

	@Transient
	private String users;

}
