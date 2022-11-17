package io.github.mikedgl.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer yearsOld;
	
	@ManyToOne
	@JoinColumn(name= "position_id")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "national_team_id", nullable = false)
	private NationalTeam nationalTeam;
	
	@ManyToOne
	@JoinColumn(name = "club_id", nullable = false)
	private Club club;
	
	public Player(){}
	public Player(Long id, String name, Integer yearsOld, Position position, NationalTeam nationalTeam, Club club) {
		super();
		this.id = id;
		this.name = name;
		this.yearsOld = yearsOld;
		this.position = position;
		this.nationalTeam = nationalTeam;
		this.club = club;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYearsOld() {
		return yearsOld;
	}
	public void setYearsOld(Integer yearsOld) {
		this.yearsOld = yearsOld;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public NationalTeam getNationalTeam() {
		return nationalTeam;
	}
	public void setNationalTeam(NationalTeam nationalTeam) {
		this.nationalTeam = nationalTeam;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
