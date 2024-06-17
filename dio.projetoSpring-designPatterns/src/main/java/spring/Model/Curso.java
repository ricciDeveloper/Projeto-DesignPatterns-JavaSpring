package spring.Model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeCurso;
    private String materiaCurso;
    private Date dataFinalizacaoCurso;
    private Date dataInicioCurso;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getMateriaCurso() {
        return materiaCurso;
    }

    public void setMateriaCurso(String materiaCurso) {
        this.materiaCurso = materiaCurso;
    }

    public Date getDataFinalizacaoCurso() {
        return dataFinalizacaoCurso;
    }

    public void setDataFinalizacaoCurso(Date dataFinalizacaoCurso) {
        this.dataFinalizacaoCurso = dataFinalizacaoCurso;
    }

    public Date getDataInicioCurso() {
        return dataInicioCurso;
    }

    public void setDataInicioCurso(Date dataInicioCurso) {
        this.dataInicioCurso = dataInicioCurso;
    }


}
