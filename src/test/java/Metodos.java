import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

public class Metodos {
    private String uri = null;
    private Response resposta = null;
    private ValidatableResponse validacao = null;
    private String json = null;
    ValidatableResponse responsePost = null;

    @Given("^que estou com JASON com DDD \"([^\"]*)\", Telefone \"([^\"]*)\" e CPF \"([^\"]*)\" e as demais informacoes preenchidas$")
    public void que_estou_com_JASON_com_DDD_Telefone_e_CPF_e_as_demais_informacoes_preenchidas(String dDD, String telefone, String cPF) throws Throwable {
        json = "{ \"codigo\": 0, \n" +
                "\"nome\": \"Daniel Silva Motoso\", \n" +
                "\"cpf\": \"" + cPF + "\", \n" +
                "\"enderecos\": [ { \n" +
                "\t\"logradouro\": \"Daniel Silva Motoso\",\n" +
                "\t\"numero\": 123, \n" +
                "\t\"complemento\": \"Empresa\",\n" +
                "\t\"bairro\": \"Chacara Santo Antonio\", \n" +
                "\t\"cidade\": \"São Paulo\", \n" +
                "\t\"estado\": \"SP\" } ], \n" +
                "\"telefones\": [ { \n" +
                "\t\"ddd\": \"" + dDD + "\",\n" +
                "\t\"numero\": \"" + telefone + "\"}] }";

        // throw new PendingException();
    }

    @When("^fizer a operacao POST$")
    public void fizer_a_operacao_POST() throws Throwable {
        responsePost = given()
                // .log().all()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("http://localhost:8080/pessoas")

                .then();
        System.out.println(responsePost);
        // throw new PendingException();
    }

    @Then("^a requisicao deverar retornar codigo \"([^\"]*)\"$")
    public void a_requisicao_deverar_retornar_codigo(int arg1) throws Throwable {
        validacao = responsePost.and()
                .statusCode(arg1);
        //throw new PendingException();
    }

    @Then("^o nome \"([^\"]*)\" no corpo da resposta$")
    public void o_nome_no_corpo_da_resposta(String arg1) throws Throwable {
        validacao = responsePost.and()
                .body(Matchers.containsString(arg1));

        //throw new PendingException();
    }

    @Given("^que estou com JASON com DDD \"([^\"]*)\", Telefone \"([^\"]*)\" e CPF \"([^\"]*)\" preenchidas, com CPF já cadastrado$")
    public void que_estou_com_JASON_com_DDD_Telefone_e_CPF_preenchidas_com_CPF_já_cadastrado(String dDD, String telefone, String cPF) throws Throwable {
        json = "{ \"codigo\": 0, \n" +
                "\"nome\": \"Daniel Silva Motoso\", \n" +
                "\"cpf\": \"" + cPF + "\", \n" +
                "\"enderecos\": [ { \n" +
                "\t\"logradouro\": \"Daniel Silva Motoso\",\n" +
                "\t\"numero\": 123, \n" +
                "\t\"complemento\": \"Empresa\",\n" +
                "\t\"bairro\": \"Chacara Santo Antonio\", \n" +
                "\t\"cidade\": \"São Paulo\", \n" +
                "\t\"estado\": \"SP\" } ], \n" +
                "\"telefones\": [ { \n" +
                "\t\"ddd\": \"" + dDD + "\",\n" +
                "\t\"numero\": \"" + telefone + "\"}] }";

        // throw new PendingException();
    }

    @Then("^a requisicao deverar retornar codigo com Status \"([^\"]*)\"$")
    public void a_requisicao_deverar_retornar_codigo_com_Status(int arg1) throws Throwable {
        validacao = responsePost.and()
                .statusCode(arg1);
    }

    @Given("^que estou com JASON com DDD \"([^\"]*)\", Telefone \"([^\"]*)\" e CPF \"([^\"]*)\" preenchidas, com Telefone já cadastrado$")
    public void que_estou_com_JASON_com_DDD_Telefone_e_CPF_preenchidas_com_Telefone_já_cadastrado(String dDD, String telefone, String cPF) throws Throwable {
        json = "{ \"codigo\": 0, \n" +
                "\"nome\": \"Daniel Silva Motoso\", \n" +
                "\"cpf\": \"" + cPF + "\", \n" +
                "\"enderecos\": [ { \n" +
                "\t\"logradouro\": \"Daniel Silva Motoso\",\n" +
                "\t\"numero\": 123, \n" +
                "\t\"complemento\": \"Empresa\",\n" +
                "\t\"bairro\": \"Chacara Santo Antonio\", \n" +
                "\t\"cidade\": \"São Paulo\", \n" +
                "\t\"estado\": \"SP\" } ], \n" +
                "\"telefones\": [ { \n" +
                "\t\"ddd\": \"" + dDD + "\",\n" +
                "\t\"numero\": \"" + telefone + "\"}] }";
        // throw new PendingException();
    }

    @Given("^que estou com DDD \"([^\"]*)\" e Telefone \"([^\"]*)\" já cadastrados na base$")
    public void que_estou_com_DDD_e_Telefone_já_cadastrados_na_base(String dd, String telefone) throws Throwable {
        uri = "http://localhost:8080/pessoas/" + dd + "/" + telefone;
        //throw new PendingException();
    }

    @When("^fizer a operacao GET$")
    public void fizer_a_operacao_GET() throws Throwable {
        resposta = RestAssured.request(Method.GET, uri);
        validacao = resposta.then();
        //throw new PendingException();
    }

    @Then("^a requisicao deverar retornar codigo \"([^\"]*)\" na resposta$")
    public void a_requisicao_deverar_retornar_codigo_na_resposta(int arg1) throws Throwable {
        validacao.statusCode(arg1);
        //throw new PendingException();
    }

    @Then("^o nome \"([^\"]*)\" no corpo da resposta_$")
    public void o_nome_no_corpo_da_resposta_(String arg1) throws Throwable {
        validacao.body(Matchers.containsString(arg1));
        //throw new PendingException();
    }

    @Given("^que estou com DDD \"([^\"]*)\" e Telefone \"([^\"]*)\" não cadastrados na base$")
    public void que_estou_com_DDD_e_Telefone_não_cadastrados_na_base(String dd, String telefone) throws Throwable {
        uri = "http://localhost:8080/pessoas/" + dd + "/" + telefone;
        //throw new PendingException();
    }

    @Given("^que estou com Telefone \"([^\"]*)\" cadastrado na base e DDD \"([^\"]*)\" inexistente$")
    public void que_estou_com_Telefone_cadastrado_na_base_e_DDD_inexistente(String telefone, String dd) throws Throwable {
        uri = "http://localhost:8080/pessoas/" + dd + "/" + telefone;
        // throw new PendingException();
    }

    @Given("^que estou com DD \"([^\"]*)\" cadastrado na base e Telefone \"([^\"]*)\" inexistente$")
    public void que_estou_com_DD_cadastrado_na_base_e_Telefone_inexistente(String dd, String telefone) throws Throwable {
        uri = "http://localhost:8080/pessoas/" + dd + "/" + telefone;
        // throw new PendingException();
    }


}




