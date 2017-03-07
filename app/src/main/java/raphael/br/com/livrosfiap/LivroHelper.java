package raphael.br.com.livrosfiap;

import android.app.Activity;
import android.widget.EditText;
import raphael.br.com.livrosfiap.R;

/**
 * Created by Raphael on 07/03/2017.
 */

public class LivroHelper {
    private Activity activity;
    private EditText nomeEdit, isbnEdit, assuntoEdit;
    private Livros livros;

    public LivroHelper(Activity activity){
        this.activity = activity;
        nomeEdit = (EditText) activity.findViewById(R.id.form_nome_livro);
        isbnEdit = (EditText) activity.findViewById(R.id.form_isbn_livro);
        assuntoEdit = (EditText) activity.findViewById(R.id.form_assunto_livro);
        livros = new Livros();
    }

    public Livros pegaLivroDoFormulario(){
        livros.setNome( nomeEdit.getText().toString() );
        livros.setIsbn( isbnEdit.getText().toString() );
        livros.setAssunto( assuntoEdit.getText().toString() );

        return livros;
    }

    public void colocaNoFormulario(Livros livros){
        nomeEdit.setText(livros.getNome());
        isbnEdit.setText(livros.getIsbn());
        assuntoEdit.setText(livros.getAssunto());
    }

    public boolean formularioValido(){
        boolean retorno = true;

        if( nomeEdit.getText().toString().equals("") ){
            nomeEdit.setError( activity.getString(R.string.erro_form_nome) );
            retorno = false;
        }

        if( isbnEdit.getText().toString().equals("") ){
            isbnEdit.setError( activity.getString(R.string.erro_form_isbn) );
            retorno = false;
        }

        if( assuntoEdit.getText().toString().equals("") ){
            assuntoEdit.setError( activity.getString(R.string.erro_form_assunto) );
            retorno = false;
        }

        return retorno;
    }

}
