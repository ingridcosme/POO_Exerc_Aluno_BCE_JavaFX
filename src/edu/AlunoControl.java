package edu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AlunoControl {
	
	private List<Aluno> alunosLista = new ArrayList<>();
	private StringProperty id = new SimpleStringProperty("");
	private StringProperty ra = new SimpleStringProperty("");
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty nascimento = new SimpleStringProperty("");
	
	public StringProperty idProperty() {
		return id;
	}
		
	public StringProperty raProperty() {
		return ra;
	}
	
	public StringProperty nomeProperty() {
		return nome;
	}
	
	public StringProperty nascimentoProperty() {
		return nascimento;
	}
	
	public Aluno boundaryToEntity() {
		Aluno aluno = new Aluno();
		aluno.setRa(ra.get());
		aluno.setNome(nome.get());
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date data = formato.parse(nascimento.get());
			aluno.setNascimento(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return aluno;
	}
	
	public void entityToBoundary(Aluno aluno) {
		if(aluno != null) {
			id.set(String.valueOf(aluno.getId()));
			ra.set(aluno.getRa());
			nome.set(aluno.getNome());
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			nascimento.set(formato.format(aluno.getNascimento()));
		}
	}
	
	public void adicionar() {
		alunosLista.add(boundaryToEntity());
	}
	
	public void pesquisar() {
		Iterator<Aluno> iterator = alunosLista.iterator();
		while(iterator.hasNext()) {
			Aluno next = iterator.next();
			if (next != null && next.getRa() != null && next.getRa().contains(ra.get())) {
                entityToBoundary(next);
            }
		}
	}

	public String getId() {
		return id.get();
	}
	
	public void setId(String id) {
		this.id.set(id);
	}
	
	public String getRa() {
		return ra.get();
	}
	
	public void setRa(String ra) {
		this.ra.set(ra);
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public String getNascimento() {
		return nascimento.get();
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento.set(nascimento);
	}
	
}
