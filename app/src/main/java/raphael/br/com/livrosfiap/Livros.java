package raphael.br.com.livrosfiap;

import java.io.Serializable;

/**
 * Created by Raphael on 07/03/2017.
 */

public class Livros implements Serializable {
    private Long id;
    private String nome;
    private String isbn;
    private String assunto;

    public Livros(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
