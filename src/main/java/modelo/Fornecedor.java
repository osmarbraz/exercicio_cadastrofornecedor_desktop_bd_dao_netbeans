package modelo;

public class Fornecedor {

    private int fornecedorId;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String regiao;

    public Fornecedor() {
        this(-1, "", "", "", "", "");
    }

    public Fornecedor(int pessoaId, String nome, String razaoSocial, String cnpj, String cidade, String regiao) {
        setFornecedorId(pessoaId);
        setNomeFantasia(nome);
        setRazaoSocial(razaoSocial);
        setCnpj(cnpj);
        setCidade(cidade);
        setRegiao(regiao);
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getRegiao() {
        return regiao;
    }
}
