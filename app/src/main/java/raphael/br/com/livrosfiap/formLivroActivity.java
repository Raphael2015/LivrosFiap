package raphael.br.com.livrosfiap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class formLivroActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private LivroHelper helper;
    private Livros livro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_livro);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        iniciaElementos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if( livro != null ){
            helper.colocaNoFormulario(livro);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

            case R.id.action_salvar:
                if( helper.formularioValido() ){
                    salvaOuEditaLivro();
                }
                return false;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void salvaOuEditaLivro(){
        if( livro == null ){
            salvaLivro();
        }else{
            atualizaLivro();
        }
    }

    private void salvaLivro(){
        Livros livro = helper.pegaLivroDoFormulario();
        databaseHelper.insereLivro(livro);
        databaseHelper.close();
        Toast.makeText(this, R.string.sucesso_form, Toast.LENGTH_SHORT).show();
        finish();
    }

    private void atualizaLivro(){
        Livros tmp = helper.pegaLivroDoFormulario();

        livro.setNome( tmp.getNome() );
        livro.setIsbn( tmp.getIsbn() );
        livro.setAssunto( tmp.getAssunto() );

        databaseHelper.atualizaLivro(livro);
        Toast.makeText(this, R.string.sucesso_edita_form, Toast.LENGTH_SHORT).show();
        finish();
    }

    private void iniciaElementos(){
        helper = new LivroHelper(this);
        databaseHelper = new DatabaseHelper(this);
        livro = (Livros) getIntent().getSerializableExtra(Constantes.TAG_LIVRO);
    }

}
