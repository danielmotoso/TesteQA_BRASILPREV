package TesteQA_BRASILPREV;

public class ArquivoJSON {

    public String trazerArquivo(String dd, String telefone, String cpf) {
        String json = "{ \"codigo\": 0, \n" +
                "\"nome\": \"Daniel Silva Motoso\", \n" +
                "\"cpf\": \"" + cpf + "\", \n" +
                "\"enderecos\": [ { \n" +
                "\t\"logradouro\": \"Daniel Silva Motoso\",\n" +
                "\t\"numero\": 123, \n" +
                "\t\"complemento\": \"Empresa\",\n" +
                "\t\"bairro\": \"Chacara Santo Antonio\", \n" +
                "\t\"cidade\": \"São Paulo\", \n" +
                "\t\"estado\": \"SP\" } ], \n" +
                "\"telefones\": [ { \n" +
                "\t\"ddd\": \"" + dd + "\",\n" +
                "\t\"numero\": \"" + telefone + "\"}] }";
        return json;
    }
}