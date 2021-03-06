package raphael.br.com.livrosfiap;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Raphael on 07/03/2017.
 */

public class Preferencias {
    private SharedPreferences preferences;

    public Preferencias(Context context){
        this.preferences = context.getSharedPreferences(Constantes.SHARED_PREFERENCES, 0);;
    }

    public boolean estaLogado(){
        return preferences.getBoolean(Constantes.PREF_LOGADO, false);
    }

    public void manterLogado(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Constantes.PREF_LOGADO, true);
        editor.apply();
    }

    public void deslogar(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Constantes.PREF_LOGADO, false);
        editor.apply();
    }

}
