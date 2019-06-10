package main.java.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "GROUPS")
@Getter
@Setter
public class GroupPojo {

	@Id
	@Column(name = "GROUPID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int GroupID;

	@Column(name = "GROUPNAME")
	private String GroupName;

	@Column(name = "GROUPDESCRIPTION")
	private String GroupDescription;

	@Transient
	private String users;

}
