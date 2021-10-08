package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Sep 23, 2021
 */
@Entity
@Table(name="games")
public class Game {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "GENRE")
	private String genre;
	@Column(name = "GAME")
	private String game;
	
	public Game(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}
	
	public Game (String genre, String game) {
		super();
		this.genre = genre;
		this.game = game;
	}
	
	public String returnGameDetails() {
		return this.genre + " - " + this.game;
	}

}
