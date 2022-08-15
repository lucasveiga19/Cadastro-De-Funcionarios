# Cadastro-De-Funcionarios

#### Sistema back-end em Java 11 de cadastramento de funcionários utilizando o banco de dados SQL Server 2019 Express. Esse sistema tem a possibilidade de executar seus testes de duas formas:

* #### A primeira forma de realizar os testes das funcionalidades é o Principal.java, pois ele executa essas funcionalidades de uma só vez e sua injeção de dados é feita diretamente no arquivo antes de executar. (Recomendada)

![image](https://user-images.githubusercontent.com/58401882/184639864-717de29a-2a3e-4063-9662-08df91054465.png)

* #### A segunda forma de realizar os testes das funcionalidades é o Principal2.java, pois o java apenas chama as funcionalidades de acordo com as informações injetadas via console/terminal e registra as mesmas. (Instável)

![image](https://user-images.githubusercontent.com/58401882/184641268-75f76c98-60cb-4972-a0fb-6337e595c7d5.png)

* ##### Observa-se: É importante ficar atento aos paramentos de cada funcionalidade para que essa forma de realizar os testes não retorne um erro, como por exemplo letras toda em maiscula ou minusculas. Também é possível que o método Update não permita que o campo Data seja nulo, logo todos os campos podem ser ignorados se deixar em branco, menos a data de nascimento. Logo é importante informar que essa segunda forma é instável e a primeira é a recomendada.

#### Abaixo está a lista de funcionalidades do sistema.

* #### Insert (Insere no banco de dados um novo funcionario)

![image](https://user-images.githubusercontent.com/58401882/184645486-94e7af3d-462f-4a87-8cd4-351c905aad26.png)

* #### Update (Ele busca o funcionario informado e atualiza algum campo de registro)

![image](https://user-images.githubusercontent.com/58401882/184646173-0280b61d-0bbd-46c2-a303-9987f75ebf36.png)

* #### Delete (Esse método deleta do banco de dados o registro que tiver o mesmo codigo informado)

![image](https://user-images.githubusercontent.com/58401882/184647016-a5235fc7-773a-4059-9abf-8b83973717d1.png)

* #### findByEfetivo (Busca no banco de dados os funcionarios que estão ativos ou inativos)

![image](https://user-images.githubusercontent.com/58401882/184647562-d61f11f3-3340-4ac5-a2dc-c1acea67fd02.png)

* #### findById (Realiza a busca de acordo com o código informado no banco de dados)

![image](https://user-images.githubusercontent.com/58401882/184648093-b0069c69-0ac6-4535-bfc5-494dd39fb7cf.png)

* #### findAll (Lista todos os cadastros do banco de dados)

![image](https://user-images.githubusercontent.com/58401882/184648598-bce8afa2-d57a-49b1-83dc-0447d36c6b57.png)
