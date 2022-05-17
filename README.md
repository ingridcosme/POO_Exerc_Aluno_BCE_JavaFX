# Exercício - Aluno (Boundary e Control) - Propriedades

### Exercício - Aluno (Boundary e Control) – Com propriedades vinculadas usando JavaFX Properties

Crie uma CRUD para fazer o input dos dados de um aluno(a), contendo o Boundary e o Control, conforme o layout em anexo e seguindo as diretrizes abaixo:

Os campos da tela do aluno serão 
- id
- ra
- nome

O control deverá possuir uma propriedade JavaFX para cada campo:
- StringProperty id = new SimpleStringProperty()
- StringProperty ra = new SimpleStringProperty()
- StringProperty nome = new SimpleStringProperty()
- Faça os gets e sets para estas propriedades para exportar os valores e uma função property para exportar a propriedade conforme a seguir

    - private StringProperty id = new SimpleStringProperty("");
    - public String getId() { return id.get(); }
    - public void setId(String id) { this.id.set(id); }
    - public StringProperty idProperty() { return id; }

Faça com que o método start() vincule os textFields com as propriedades do control.

O botão adicionar() da tela ao ser clicado deve mostrar os valores que estão nas propriedades do control.