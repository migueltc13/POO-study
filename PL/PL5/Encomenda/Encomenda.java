import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

public class Encomenda {

    private String nome; /* nome do cliente */
    private int nif;
    private String morada;
    private int nr; /* numero da encomenda */
    private Date data; /* data da encomenda */
    private ArrayList<LinhaEncomenda> linhas; /* linhas de encomenda */

    public Encomenda() {
        this.nome = "n/a";
        this.nif = 0;
        this.morada = "n/a";
        this.nr = 0;
        this.data = new Date();
        this.linhas = new ArrayList<>();
    }

    public Encomenda(String nome, int nif, String morada, int nr, Date data, ArrayList<LinhaEncomenda> linhas) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.nr = nr;
        this.data = data;
        this.linhas = linhas;
    }

    public Encomenda(Encomenda enc) {
        this.nome = enc.getNome();
        this.nif = enc.getNif();
        this.morada = enc.getMorada();
        this.nr = enc.getNr();
        this.data = enc.getData();
        this.linhas = enc.getLinhas();
    }

    public String getNome() {
        return this.nome;
    }

    public int getNif() {
        return this.nif;
    }

    public String getMorada() {
        return this.morada;
    }

    public int getNr() {
        return this.nr;
    }

    public Date getData() {
        return this.data;
    }

    public ArrayList<LinhaEncomenda> getLinhas() {
        ArrayList<LinhaEncomenda> r = new ArrayList<>();
        Iterator it = this.linhas.iterator();

        while (it.hasNext()) {
            r.add((LinhaEncomenda)it.next());
        }
        return r;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setLinhas(ArrayList<LinhaEncomenda> linhas) {
        ArrayList<LinhaEncomenda> r = new ArrayList<>();
        Iterator it = linhas.iterator();

        while (it.hasNext()) {
            r.add(((LinhaEncomenda)it.next()).clone());
        }

        this.linhas = r;
    }

    // (ii)
    public double calculaValorTotal() {
        double r = 0;
        Iterator it = this.linhas.iterator();

        while (it.hasNext()) {
            r += ((LinhaEncomenda)it.next()).calculaValorLinhaEnc();
        }

        return r;
    }

    // (iii)
    public double calculaValorDesconto() {
        double r = 0;
        Iterator it = this.linhas.iterator();

        while (it.hasNext()) {
            r += ((LinhaEncomenda)it.next()).calculaValorDesconto();
        }

        return r;
    }

    // (iv)
    public int numeroTotalProdutos() {
        int c = 0;
        Iterator it = this.linhas.iterator();

        while (it.hasNext()) {
            c += ((LinhaEncomenda)it.next()).getQuantidade();
        }

        return c;
    }

    // (v)
    public boolean existeProdutoEncomenda(String refProduto) {
        boolean found = false;
        Iterator it = this.linhas.iterator();

        while (it.hasNext() && !found) {
            if (((LinhaEncomenda)it.next()).getReferencia().equals(refProduto))
                found = true;
        }

        return found;
    }

    // (vi)
    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhas.add(linha);
    }

    // (vii)
    public void removeProduto(String codProd) {
        Iterator it = this.linhas.iterator();

        while (it.hasNext()) {
            if (((LinhaEncomenda)it.next()).getReferencia().equals(codProd)) {
                it.remove();
            }
        }
    }
}
