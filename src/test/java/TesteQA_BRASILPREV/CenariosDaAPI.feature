Feature: API para cadastrar uma pessoa e seus dados (POST) e consultar uma pessoa cadastrada pelo número de seu telefone (GET)

@APIMetodosPostGet
  Scenario: Cadastrar uma pessoa com CPF e Telefone validos
    Given que estou com JASON com DDD "11", Telefone "900000010" e CPF "90778007006" e as demais informacoes preenchidas
    When  fizer a operacao POST
    Then  a requisicao deverar retornar codigo "201"
    And   o nome "Daniel Silva Motoso" no corpo da resposta

  Scenario: Cadastrar uma pessoa com o CPF já cadastrado
    Given  que estou com JASON com DDD "11", Telefone "900000011" e CPF "90778007006" preenchidas, com CPF já cadastrado
    When  fizer a operacao POST
    Then  a requisicao deverar retornar codigo com Status "400"

  Scenario: Cadastrar uma pessoa com o Telefone já cadastrado
    Given  que estou com JASON com DDD "11", Telefone "900000010" e CPF "59682149029" preenchidas, com Telefone já cadastrado
    When  fizer a operacao POST
    Then  a requisicao deverar retornar codigo com Status "400"

  Scenario: Cadastrar uma pessoa com o CPF invalido
    Given que estou com JASON com DDD "11", Telefone"900000015" validos e CPF "00000000000" invalido
    When  fizer a operacao POST
    Then  a requisicao deverar retornar codigo com Status "400"

  Scenario: Cadastrar uma pessoa com DDD e Telefone em branco no JSON
    Given que estou com JASON com DDD "   " e Telefone "  " em branco e CPF "39501366065" preenchido
    When  fizer a operacao POST
    Then  a requisicao deverar retornar codigo com Status "200"

  Scenario: Consultar um cadastro de uma pessoa pelo DDD e Telefone validos
    Given que estou com DDD "11" e Telefone "900000010" já cadastrados na base
    When  fizer a operacao GET
    Then  a requisicao deverar retornar codigo "200" na resposta
    And   o nome "Daniel Silva Motoso" no corpo da resposta_

  Scenario: Consultar um cadastro de uma pessoa pelo DDD e Telefone inexistente
    Given que estou com DDD "12" e Telefone "999999910" não cadastrados na base
    When  fizer a operacao GET
    Then  a requisicao deverar retornar codigo "404" na resposta

  Scenario: Consultar um cadastro de uma pessoa com DDD inexistente
    Given que estou com Telefone "900000010" cadastrado na base e DDD "99" inexistente
    When  fizer a operacao GET
    Then  a requisicao deverar retornar codigo "404" na resposta

  Scenario: Consultar um cadastro de uma pessoa com Telefone inexistente
    Given que estou com DD "11" cadastrado na base e Telefone "999999910" inexistente
    When  fizer a operacao GET
    Then  a requisicao deverar retornar codigo "404" na resposta




