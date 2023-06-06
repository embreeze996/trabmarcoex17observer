package ObserverMethod;

import java.util.Observable;
import java.util.Observer;

public class Cidadao implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cidadao(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void assinar(Editora editora) {
        editora.addObserver(this);
    }

    public void update(Observable editora, Object arg1) {
        this.ultimaNotificacao = this.nome + ", Pagamento recebido pela " + editora.toString();
    }
}
