package com.practicing.musicstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "albums")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(max = 100)
	@NotBlank
	@NotNull
	@Column(name = "name")
	private String name;

	@Size(max = 100)
	@NotBlank
	@NotNull
	@Column(name = "author")
	private String author;

	@NotNull
	@Digits(integer = 4, fraction = 0)
	@Column(name = "year_of_release")
	private Integer yearOfRelease;

	public Album(String albumName, String author, int yearOfRelease) {

		this.name = albumName;
		this.author = author;
		this.yearOfRelease = yearOfRelease;
	}

	public Album() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getYearOfRelease() {
		return yearOfRelease;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYearOfRelease(Integer yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((yearOfRelease == null) ? 0 : yearOfRelease.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearOfRelease == null) {
			if (other.yearOfRelease != null)
				return false;
		} else if (!yearOfRelease.equals(other.yearOfRelease))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Album [name=" + name + ", author=" + author + ", yearOfRelease=" + yearOfRelease + "]";
	}

}
