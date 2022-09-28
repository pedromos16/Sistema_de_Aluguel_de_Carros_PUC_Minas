# Endpoints do CRUD dos objetos:
_____________________________________________________________________

## Automovel

### Create

Endpoint: {host}/automoveis

Exemplo de JSON:
{
"matricula": "1-A",
"ano": 2022,
"marca": "siena",
"modelo": "corsa",
"placa": "123-IJK",
"preco": 312512.00
}

### Update

Endpoint: {host}/automoveis/{id}

{
"matricula": "1-A",
"ano": 2022,
"marca": "siena tunado",
"modelo": "corsa v3 rebaixado",
"placa": "123-IJK",
"preco": 999912.00
}

### Delete

Endpoint: {host}/automoveis/{id}

### find

Endpoint: {host}/automoveis/{id}

### findAll

Endpoint: {host}/automoveis

_____________________________________________

## Agente

### Create

Endpoint: {host}/agentes

Exemplo de JSON:
{
 "usuario": "user",
 "senha": "senha123",
 "obsAvaliacao": "Jogador de Transformice"
}

### Update

Endpoint: {host}/agentes/{id}

Exemplo de JSON:
{
 "usuario": "user123",
 "senha": "senha124513343",
 "obsAvaliacao": "Jogador de Habbo"
}

### Delete

Endpoint: {host}/agentes/{id}

### find

Endpoint: {host}/agentes/{id}

### findAll

Endpoint: {host}/agentes

____________________________________________________

## Cliente

### Create

Endpoint: {host}/clientes

Exemplo de JSON:
{
 "usuario": "user",
 "senha": "senha123",
 "rg": "3212312",
 "cpf": "132981240",]
 "nome": "Clarinha",
 "endereco": "California, USA",
 "profissao": "Conjuradora",
 "entidadeEmpregadora": "Ugo Ltda."
 "agente": {"id": 1}
}

### Update

Endpoint: {host}/clientes/{id}

Exemplo de JSON:
{
 "usuario": "user",
 "senha": "senha123",
 "rg": "3212312",
 "cpf": "132981240",]
 "nome": "Clarinha Campinhos",
 "endereco": "California, USA",
 "profissao": "Conjuradora",
 "entidadeEmpregadora": "Ugo Ltda."
 "agente": {"id": 1}
}

### Delete

Endpoint: {host}/clientes/{id}

### find

Endpoint: {host}/clientes/{id}

### findAll

Endpoint: {host}/clientes

___________________________________________________

## Pedido Aluguel

### Create

Endpoint: {host}/pedidoAluguel

Exemplo de JSON:
{
 "cliente": {"id":1},
 "observacao": "Pedido realizado com sucesso",
 "automoveis":[{"id":1}, {"id":2}]
}

### Update

Endpoint: {host}/pedidoAluguel/{id}

Exemplo de JSON:
{
 "cliente": {"id":1},
 "observacao": "Pedido faiou",
 "automoveis":[{"id":1}, {"id":2}]
}
### Delete

Endpoint: {host}/pedidoAluguel/{id}

### find

Endpoint: {host}/pedidoAluguel/{id}

### findAll

Endpoint: {host}/pedidoAluguel
