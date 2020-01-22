
public class ArquivoJSON {
    private String dd;
    private String telefone;
    private String cpf;

    public void setDDD(String dd) {
        this.dd = dd;
    }

    public String getDDD() {
        return dd;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCPF() {
        return cpf;
    }

    public ArquivoJSON(String dd, String telefone, String cpf) {
        setDDD(dd);
        setTelefone(telefone);
        setCPF(cpf);

    }

    public String trazerArquivo() {
       String json = "{ \"codigo\": 0, \n" +
                "\"nome\": \"Daniel Silva Motoso\", \n" +
                "\"cpf\": \"" + this.cpf + "\", \n" +
                "\"enderecos\": [ { \n" +
                "\t\"logradouro\": \"Daniel Silva Motoso\",\n" +
                "\t\"numero\": 123, \n" +
                "\t\"complemento\": \"Empresa\",\n" +
                "\t\"bairro\": \"Chacara Santo Antonio\", \n" +
                "\t\"cidade\": \"São Paulo\", \n" +
                "\t\"estado\": \"SP\" } ], \n" +
                "\"telefones\": [ { \n" +
                "\t\"ddd\": \"" + this.dd + "\",\n" +
                "\t\"numero\": \"" + this.telefone + "\"}] }";
       return json;
    }

}



