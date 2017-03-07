package raphael.br.com.livrosfiap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


import raphael.br.com.livrosfiap.R;
import raphael.br.com.livrosfiap.Livros;

/**
 * Created by Raphael on 07/03/2017.
 */

public class LivrosAdapter extends RecyclerView.Adapter{
    private List<Livros> livros;
    private Context context;

    public LivrosAdapter(Context context, List<Livros> livros) {
        this.context = context;
        this.livros = livros;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_livro, parent, false);
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) context);
        LivrosViewHolder holder = new LivrosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        LivrosViewHolder holder = (LivrosViewHolder) viewHolder;
        Livros livro = livros.get(position);

        holder.nomeLivro.setText(livro.getNome());
        holder.isbnLivro.setText(livro.getIsbn());
        holder.assuntoLivro.setText(livro.getAssunto());
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public class LivrosViewHolder extends RecyclerView.ViewHolder {
        final TextView nomeLivro;
        final TextView isbnLivro;
        final TextView assuntoLivro;

        public LivrosViewHolder(View itemView) {
            super(itemView);
            nomeLivro = (TextView) itemView.findViewById(R.id.item_nome_livro);
            isbnLivro = (TextView) itemView.findViewById(R.id.item_isbn_livro);
            assuntoLivro = (TextView) itemView.findViewById(R.id.item_assunto_livro);
        }
    }
}