package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

import com.google.gson.annotations.Expose;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class ColetaModel {

    @Expose(serialize = false)
    private Long id;
    @Expose
    private String cepFinal;
    @Expose
    private String cepInicial;
    @Expose
    private LocalDate dataColeta;
}

