package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ClienteModel {

    @Expose(serialize = false)
    private Long id;
    @Expose
    private String nome;
    @Expose
    private String cpf;
    @Expose
    private String cep;
    @Expose
    private String endereco;
    @Expose
    private long telefone;
    @Expose
    private String email;
    @Expose
    private String senha;
}

