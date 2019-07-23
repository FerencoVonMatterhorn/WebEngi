package main.java.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
public class UserPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USERID")
	private int id;

	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "SALT", nullable = false)
	private String salt;

	@Column(name = "ITERATIONS", nullable = false)
	private int iterations;

	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@Column(name = "LASTNAME", nullable = false)
	private String lastName;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Lob
	@Column(name = "PROFILEPICTURE")
	private byte[] proilePicture;

	@Column(name = "BIO")
	private String bio;

}