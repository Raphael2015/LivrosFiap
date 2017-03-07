package raphael.br.com.livrosfiap;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raphael on 07/03/2017.
 */

public class Usuario implements Serializable {
    @SerializedName("usuario")
    private String login;

    @SerializedName("senha")
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
