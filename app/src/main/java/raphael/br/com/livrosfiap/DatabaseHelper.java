package raphael.br.com.livrosfiap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raphael on 07/03/2017.
 */

public class DatabaseHelper  extends SQLiteOpenHelper {
    public static final String NOME_BD = "livros.db";
    public static final int VERSAO_BD = 1;

    public static final String TABELA_USUARIOS = "usuarios";
    public static final String TABELA_LIVROS = "livros";

    public DatabaseHelper(Context context){
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( criaTabelaUsuarios() );
        sqLiteDatabase.execSQL( criaTabelaLivro() );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoNova) {}

    // USUARIOS ***************
    private String criaTabelaUsuarios(){
        String sql = "CREATE TABLE " + TABELA_USUARIOS
                + " (id INTEGER PRIMARY KEY, "
                + " login TEXT, "
                + " senha TEXT);";

        return sql;
    }

    public void insereUsuario(Usuario usuario){
        ContentValues values = new ContentValues();

        values.put("login", usuario.getLogin());
        values.put("senha", usuario.getSenha());

        getWritableDatabase().insert(TABELA_USUARIOS, null, values);
    }

    public int procuraUsuario(String login, String senha){
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM " + TABELA_USUARIOS
                + " WHERE login='"+ login.trim() +"' AND senha='"+ senha.trim() +"';";

        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while(c.moveToNext()){
            Usuario usuario = new Usuario();
            usuarios.add(usuario);
        }

        return usuarios.size();
    }

    // RESTAURANTES ***************
    private String criaTabelaLivro(){
        String sql = "CREATE TABLE " + TABELA_LIVROS
                + " (id INTEGER PRIMARY KEY, "
                + " nome TEXT, "
                + " isbn TEXT, "
                + " assunto TEXT);";

        return sql;
    }

    public void insereLivro(Livros livros){
        ContentValues values = new ContentValues();

        values.put("nome", livros.getNome());
        values.put("isbn", livros.getIsbn());
        values.put("assunto", livros.getAssunto());

        getWritableDatabase().insert(TABELA_LIVROS, null, values);
    }

    public List<Livros> getLivros(){
        List<Livros> livros = new ArrayList<>();
        String sql = "SELECT * FROM " + TABELA_LIVROS + " ORDER BY id DESC;";

        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while(c.moveToNext()){
            Livros livro = new Livros();

            livro.setId(c.getLong(c.getColumnIndex("id")));
            livro.setNome(c.getString(c.getColumnIndex("nome")));
            livro.setIsbn(c.getString(c.getColumnIndex("isbn")));
            livro.setAssunto(c.getString(c.getColumnIndex("assunto")));

            livros.add(livro);
        }

        return livros;
    }

    public void atualizaLivro(Livros livro){
        ContentValues values = new ContentValues();

        values.put("nome", livro.getNome());
        values.put("isbn", livro.getIsbn());
        values.put("assunto", livro.getAssunto());

        String[] args = { livro.getId().toString() };
        getWritableDatabase().update(TABELA_LIVROS, values, "id=?", args);
    }

    public void deletaLivro(Livros livro){
        String[] args = { livro.getId().toString() };
        getWritableDatabase().delete(TABELA_LIVROS, "id=?", args);
    }

}