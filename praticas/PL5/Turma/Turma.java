import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Turma {

    private String designacao;
    private List<Aluno> alunos;

    public Turma() {
        this.designacao = "";
        this.alunos = new ArrayList<>();
    }

    public Turma(String designacao) {
        this.designacao = designacao;
        this.alunos = new ArrayList<>();
    }

    public Turma(String designacao, List<Aluno> alunos) {
        this.designacao = designacao;
        // this.alunos = new ArrayList<>(alunos);
        this.alunos = new ArrayList<>();
        for (Aluno a : alunos) {
            this.alunos.add(a.clone());
        }
    }

    public Turma(Turma t) {
        this.designacao = t.getDesignacao();
        this.alunos = new ArrayList<>(t.getAlunos());
    }

    public String getDesignacao() {
        return this.designacao;
    }

    public ArrayList<Alunos> getAlunos() {
        ArrayList<Aluno> res = new ArrayList<>();
        Iterator<Aluno> it = this.alunos.iterator();

        while (it.hasNext()) {
            res.add(it.next());
        }

        return res;
    }

    public void addAluno(Aluno a) {
        this.alunos.add(a.clone());
    }

    public boolean existeAluno(Aluno a) {
        return this.alunos.contains(a);
    }

    public boolean existeAluno(String numero) {
        boolean found = false;
        Iterator<Aluno> it = this.alunos.iterator();

        while (it.hasNext() && !found) {
            if (it.next().getNumero().equals(numero)) {
                found = true;
            }
        }

        return found;
    }

    public int posAluno(String numero) {
        for (int i = 0; i < this.alunos.size(); i++) {
            if (this.alunos.get(i).getNumero().equals(numero)) {
                return i;
            }
        }
        return -1;
    }

    public Aluno getAlunoByNumero(String numero) {
        Aluno res = null;

        if (posAluno(numero) != -1)
            res = this.alunos.get(posAluno(numero)).clone();

        return res;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("Designacao: ");
        sb.append(this.designacao + "\n");

        sb.append("Alunos: ");
        sb.append(this.alunos.toString());

        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if ((o == null) || (this.getClass() != o.getClass()))
            return false;

        Turma t = (Turma) o;

        Iterator it1 = this.alunos.iterator();
        Iterator it2 = t.getAlunos().iterator();
        while (it1.hasNext() && it2.hasNext()) {
            Aluno a1 = it1.next();
            Aluno a2 = it2.next();
            if (!a1.equals(a2))
                return false;
        }

        if (it1.hasNext() || it2.hasNext())
            return false;

        return
            this.designacao.equals(t.getDesignacao());
    }

    public Turma clone() {
        return new Turma(this);
    }
}
