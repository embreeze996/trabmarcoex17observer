package ObserverMethod;

import java.util.Observable;

public class Editora extends Observable {

    private String nomeRevista;
    private String edicaoRevista;

    public Editora(String nomeRevista, String edicaoRevista) {
        this.nomeRevista = nomeRevista;
        this.edicaoRevista = edicaoRevista;
    }

    public void enviarRevistas() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Editora{" +
                " nomeRevista='" + nomeRevista + '\'' +
                ", edicaoRevista='" + edicaoRevista + '\'' +
                '}';
    }
}
