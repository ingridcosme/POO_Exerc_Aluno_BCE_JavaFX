package edu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {

	private long id = 0L;
	private Date nascimento;
	private String ra = "";
	private String nome = "";
	private static long SEQUENCIAL = 1L;
	
	public Aluno() {
		this.id = SEQUENCIAL++;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nId " + this.id);
		buffer.append("\nRA " + this.ra);
		buffer.append("\nAluno " + this.nome);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		buffer.append("\nNascimento " + formato.format(this.nascimento));
		
		return buffer.toString();
	}
	
}
