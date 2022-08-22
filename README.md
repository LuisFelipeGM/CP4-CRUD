## Checkpoint4-Java-DDD

# 1. Crie a tabela Filmes em sua conexão oracle conforme indicado abaixo (1 ponto):

    create table filmes (
      codigo varchar(5) not null primary key,
      titulo varchar(35),
      genero varchar(8),
      produtora varchar(15)
    )

# 2. Desenvolva um projeto em Java com Manipulação à Banco de Dados com a tabela da questão anterior.
Siga modelo UML para desenvolvimento das classes necessárias (4 pontos):

![image](https://user-images.githubusercontent.com/101107763/185945818-45925b50-719c-48f8-86bc-b0a1d1b397a1.png)

# 3. Implemente outra classe que possua o método main para testar os métodos das classes anteriores. Siga as orientações abaixo (5 pontos):
    1. Exibir um menu perguntando para o usuário qual operação deseja realizar (inserir, alterar ou excluir).
    2. Dependendo da escolha do usuário, solicite as informações necessárias para realizar a operação (codigo, titulo, genero, produtora).
    3. Após executar a operação escolhida exiba todos os dados da tabela filmes (com JOptionPane).
    4. Perguntar ao usuário se deseja continuar (em caso afirmativo repetir os passos de 1 a 4 novamente).
    5. Em caso negativo encerre o programa.
