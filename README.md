<h1 align="center">
 Api Tarefa
</h1>
<p align="center">
 API para gerenciar tarefas (CRUD) que faz parte desse desafio para pessoas desenvolvedoras backend júnior.
</p>

## Tecnologias
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas
SOLID, DRY, YAGNI, KISS
API REST
Consultas com Spring Data JPA
Injeção de Dependências
Tratamento de respostas de erro
Geração automática do Swagger com a OpenAPI 3

## Como Executar
Primeiro, clone o repositório do projeto para a sua máquina local.
```sh
git clone git:https://github.com/Rutiele93/ApiTarefa.git</br>
cd tarefa
```

A API poderá ser acessada em [localhost:8081](http://localhost:8081).
O Swagger poderá ser visualizado em [localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Tarefa 
```
$ http POST :8081/tarefas nome="Tarefa 1" descricao="Desc Tarefa 1" prioridade=1
[
  {
    "descricao": "Desc Tarefa 1",
    "id": 1,
    "nome": "Tarefa 1",
    "prioridade": 1,
    "realizado": false
  }
]
```

- Listar Tarefas
```
$ http GET :8081/tarefas

[
  {
    "descricao": "Desc Tarefa 1",
    "id": 1,
    "nome": "Tarefa 1",
    "prioridade": 1,
    "realizado": false
  }
]
```

- Atualizar Tarefa
```
$ http PUT :8081/tarefas/1 nome="Tarefa 1 Up" descricao="Desc Tarefa 1 Up" prioridade=2

[
  {
    "descricao": "Desc Tarefa 1 Up",
    "id": 1,
    "nome": "Tarefa 1 Up",
    "prioridade": 2,
    "realizado": false
  }
]
```

- Remover Tarefa
```
http DELETE :8081/tarefas/1

[ ]
```
