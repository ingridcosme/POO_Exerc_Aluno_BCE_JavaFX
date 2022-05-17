package edu;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoBoundary extends Application {

	private TextField txtId = new TextField();
	private TextField txtRa = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtNascimento = new TextField();
	
	private Button botaoAdicionar = new Button("Adicionar");
	private Button botaoPesquisar = new Button("Pesquisar");
	
	private AlunoControl control = new AlunoControl();
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Gestão de Alunos");
		
		Label labelId = new Label("Id");
		Label labelRa = new Label("Ra");
		Label labelNome = new Label("Nome");
		Label labelNascimento = new Label("Nascimento");
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets (10, 10, 10, 10));
		
		gridPane.add(labelId, 0, 0);
		gridPane.add(txtId, 1, 0);
		gridPane.add(labelRa, 0, 1);
		gridPane.add(txtRa, 1, 1);
		gridPane.add(labelNome, 0, 2);
		gridPane.add(txtNome, 1, 2);
		gridPane.add(labelNascimento, 0, 3);
		gridPane.add(txtNascimento, 1, 3);
		gridPane.add(botaoAdicionar, 0, 4);
		gridPane.add(botaoPesquisar, 1, 4);
		gridPane.setVgap(10);
		gridPane.setHgap(20);
		
		Bindings.bindBidirectional(txtId.textProperty(), control.idProperty());
		Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(txtNascimento.textProperty(), control.nascimentoProperty());

        botaoAdicionar.setOnAction((e) -> {
        	StringBuffer buffer = new StringBuffer();
    		buffer.append("Aluno adicionado com sucesso!");
    		buffer.append("\n" + control.getId());
    		buffer.append("\n" + control.getRa());
    		buffer.append("\n" + control.getNome());
    		buffer.append("\n" + control.getNascimento());
            control.adicionar();
            new Alert(Alert.AlertType.INFORMATION, buffer.toString()).show();
            txtId.setText("");
            txtRa.setText("");
            txtNome.setText("");
            txtNascimento.setText("");
        });

        botaoPesquisar.setOnAction((e) -> {
            control.pesquisar();
        });
		
		Scene scene = new Scene(gridPane, 400, 200);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(AlunoBoundary.class, args);
	}

}
