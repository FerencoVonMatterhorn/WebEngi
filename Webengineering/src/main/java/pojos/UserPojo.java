package main.java.pojos;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "USERS")
@Getter
@Setter
@Builder
public class UserPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERID")
	private UUID id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "SALT")
	private String salt;

	@Column(name = "ITERATIONS")
	private int iterations;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Lob
	@Column(name = "PROFILEPICTURE")
	private byte[] proilePicture;

	@Column(name = "BIO")
	private String bio;

	@Transient
	private boolean loggedIn;
}