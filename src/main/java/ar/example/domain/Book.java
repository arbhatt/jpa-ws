package ar.example.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "id")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6276791853183435133L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Version
	private Long version;

	@Column(name = "published")
	private Date publishDate;

	@NotNull
	@Column(name = "isbn")
	private String isbn;

	@NotNull
	@Column(name = "title")
	private String title;

	@NotNull
	@Column(name = "language")
	private String language;

	@Column(name = "textbook")
	private Boolean textBookFlag;

	// @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade =
	// CascadeType.ALL)
	// private List<Topic> topics;

}