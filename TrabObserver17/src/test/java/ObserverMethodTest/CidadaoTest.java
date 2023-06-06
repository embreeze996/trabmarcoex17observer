package ObserverMethodTest;

import ObserverMethod.Cidadao;
import ObserverMethod.Editora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CidadaoTest {

    @Test
    void deveNotificarUmCidadao() {
        Editora editora = new Editora("MundoEstranho", "45");
        Cidadao cidadao = new Cidadao("Cidadao 1");
        cidadao.assinar(editora);
        editora.enviarRevistas();
        assertEquals("Cidadao 1, Pagamento recebido pela Editora{ nomeRevista='MundoEstranho', edicaoRevista='45'}", cidadao.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMultiplosCidadaos() {
        Editora editora = new Editora("IssoE", "22");
        Cidadao cidadao1 = new Cidadao("Cidadao 1");
        Cidadao cidadao2 = new Cidadao("Cidadao 2");
        cidadao1.assinar(editora);
        cidadao2.assinar(editora);
        editora.enviarRevistas();
        assertEquals("Cidadao 1, Pagamento recebido pela Editora{ nomeRevista='IssoE', edicaoRevista='22'}", cidadao1.getUltimaNotificacao());
        assertEquals("Cidadao 2, Pagamento recebido pela Editora{ nomeRevista='IssoE', edicaoRevista='22'}", cidadao2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCidadao() {
        Editora editora = new Editora("Algoritmos", "A");
        Cidadao cidadao = new Cidadao("Cidadao 1");
        editora.enviarRevistas();
        assertEquals(null, cidadao.getUltimaNotificacao());
    }
    @Test
    void deveNotificarCidadaoEditoraA() {
        Editora editoraA = new  Editora("IssoE", "22");
        Editora editoraB = new  Editora("IssoE", "22");
        Cidadao cidadao1 = new  Cidadao("Cidadao 1");
        Cidadao cidadao2 = new  Cidadao("Cidadao 2");
        cidadao1.assinar(editoraA);
        cidadao2.assinar(editoraB);
        editoraA.enviarRevistas();
        assertEquals("Cidadao 1, Pagamento recebido pela Editora{ nomeRevista='IssoE', edicaoRevista='22'}", cidadao1.getUltimaNotificacao());
        assertEquals(null, cidadao2.getUltimaNotificacao());
    }
}
