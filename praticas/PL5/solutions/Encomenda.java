/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Classe que implementa uma Encomenda (cf exercício da Ficha 4).
 *
 * @author MaterialPOO
 * @version 20180323
 * 
 * @version 20190209
 * @version 20220324
 * @version 20230320
 * @version 20240318
 */

public class Encomenda {
    private static int nEnc = 0;
    
    private String nomeCliente;
    private int nif;
    private String morada;
    private LocalDate data;
    private List<LinhaEncomenda> linhas;
    
    /* Métodos de classe */
    
    public static int getNEnc() {
      return nEnc;
    }
    
    public static void incNEnc() {
      nEnc++;
    }
    
    /* Construtores */
    
    public Encomenda(String nomeCliente, int nif, String morada,
                    LocalDate data, List<LinhaEncomenda> linhasEnc) {
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.nEnc = ++nEnc; // podia utilizar os métodos de classe
        /*
         * incNEnc();
         * this.nEnc = getNEnc();
         */
        this.data = data;
        setEncomendas(linhasEnc);
    }
    
    public Encomenda() {
        this.linhas = new ArrayList<>();
        this.nomeCliente = "n/a";
        this.nif = 0;
        this.morada = "n/a";
        this.nEnc = ++nEnc;
        this.data = LocalDate.now();
    }
    
    public Encomenda(Encomenda enc) {
        this.linhas = enc.getLinhas();
        this.nomeCliente = enc.getNomeCliente();
        this.nif = enc.getNif();
        this.morada = enc.getMorada();
        this.nEnc = enc.getNEnc();
        this.data = enc.getData();
        //this.data = LocalDate.now();
    }
    
    public String getNomeCliente() {
        return this.nomeCliente;
    }
    
    public int getNif() {
        return this.nif;
    }
    
    public String getMorada() {
        return this.morada;
    }
      
    
    public LocalDate getData() {
        return this.data;
    }
    
    public void setEncomendas(List<LinhaEncomenda> linhasEnc) {
        this.linhas = new ArrayList<>();
        for(LinhaEncomenda le : linhasEnc) {
            this.linhas.add(le.clone());
        }
    }
    
    //
    // Uma versão com iteradores internos:
    // 
    // public void setEncomendas(List<LinhaEncomenda> linhasEnc) {
    //   this.linhas = linhasEnc.stream().map(LinhaEncomenda::clone)
    //                                   .collect(Collectors.toList());
    // }     
    // 
    
    
    public List<LinhaEncomenda> getLinhas() {
      return this.linhas.stream().map(LinhaEncomenda::clone)
                                 .collect(Collectors.toList());        
    }
    
    
    public ArrayList<LinhaEncomenda> getLinhas_1() {
      return this.linhas.stream().map(LinhaEncomenda::clone)
                                 .collect(Collectors.toCollection(ArrayList::new));  
    }
    
    
    /*
     * Versão com iterators
     */
    
    public List<LinhaEncomenda> getLinhasIT() {
      List<LinhaEncomenda> res = new ArrayList<>();
      Iterator<LinhaEncomenda> it = this.linhas.iterator();
      
      while (it.hasNext()) {
        LinhaEncomenda le = it.next();  
        res.add(le.clone());
      }
        
      return res;
    }
    
    //public List<LinhaEncomenda> getLinhas() {
    //    List<LinhaEncomenda> res = new ArrayList<>();
    //    for(LinhaEncomenda le : this.linhas) {
    //        res.add(le.clone());
    //    }
    //    return res;
    //}
    
    public Encomenda clone() {
        return new Encomenda(this);
    }
    
    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        Encomenda e = (Encomenda)o;
        return nomeCliente.equals(e.getNomeCliente()) && nif == e.getNif() &&
               morada.equals(e.getMorada()) && nEnc == e.getNEnc() && 
               data.equals(e.getData()) && this.linhas.equals(e.getLinhas()); 
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomenda : [");
        sb.append("Número Encomenda: ").append(this.nEnc);
        sb.append("NomeCliente: ").append(this.nomeCliente);
        sb.append("NIF: ").append(this.nif);
        sb.append("Morada: ").append(this.morada);
        sb.append("Data Enc: ").append(this.data);
        sb.append(this.linhas.toString());
        return sb.toString();
    }
    
    
    /**
     * B)
     */
    public double calculaValorTotal() {
        double r = 0;
        for(LinhaEncomenda le : this.linhas) {
            r += le.calculaValorLinhaEnc();
        }
        return r;
    }
    
    
    /*
     * Método de resposta a B) com recurso a iteradores internos.
     */
    
    public double calculaValorTotal_I() {
      return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc)
                                 .sum();      
    }
    
    
    
    /**
     * C)
     */
    
    public double calculaValorDesconto() {
      return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto)
                                 .sum();   
    }
    
    /*
     * Método que implementa C) com recurso a iteradores externos 
     */
    
    public double calculaValorDesconto_E() {
      double r = 0;
      for(LinhaEncomenda le : this.linhas) {
        r += le.calculaValorDesconto();
      }
      return r;
    }
    
    
    /**
     * D)
     */
    public int numeroTotalProdutos() {
        int r = 0;
        for(LinhaEncomenda le : this.linhas) {
            r += le.getQuantidade();
        }
        return r;
    }

    /**
     * E)
     */
    public boolean existeProdutoEncomenda(String codProd) {
      boolean existe = false;
      int i=0;
         
      while(!existe && i< this.linhas.size()) {
        if(this.linhas.get(i).getReferencia().equals(codProd)) 
           existe = true;
        i++;
      }
      return existe;
    }
     
      
    // codificação alternativa de E) com recurso a iteradores internos
    public boolean existeNaEncomenda(String codProd) {
      return this.linhas.stream()
                        .anyMatch(le -> (le.getReferencia()).equals(codProd));
    }
    
    
    /**
     * F)
     */
    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhas.add(linha.clone());
    }

    /**
     * G)
     */
    
    public void removeProduto(String codProd){
      for(Iterator<LinhaEncomenda> it = this.linhas.iterator() ; it.hasNext();){
          LinhaEncomenda le = it.next();
          if(le.getReferencia().equals(codProd)){
              it.remove();
          }
      }
    }

    //calcula o número de produtos encomendados nesta encomenda
    public int numProdutos() {
     
      return this.linhas.stream()
                         .mapToInt(LinhaEncomenda::getQuantidade).sum();
    }    
    
    
    
    
    
    //calcula a lista dos códigos de produto de uma encomenda
    public List<String> getListaProdutos() {
      return this.linhas.stream()
                        .map(LinhaEncomenda::getReferencia)
                        .distinct()
                        .collect(Collectors.toList());    
    }
    
    // a devolver conjunto
    public Set<String> getListaProdutosAsSet() {
       Set<String> res = new HashSet<String>();
       
       for(LinhaEncomenda le: this.linhas)
         res.add(le.getReferencia());
       
       return res;
    }
    
    // a devolver conjunto com iteradores internos
    public Set<String> getListaProdutosAsSetI() {
      return this.linhas.stream()
                        .map(LinhaEncomenda::getReferencia)
                        .collect(Collectors.toSet());
    }
    
    
    /**
     * Método que devolve um conjunto ordenado pela ordem natural das 
     * linhas de encomenda (ordem alfabética crescente)
     */
    
    public Set<LinhaEncomenda> encomendasPorOrdem() {
      Set<LinhaEncomenda> res = new TreeSet<>();
      for(LinhaEncomenda le: this.linhas)
        res.add(le.clone());
    
      return res;
    }
    
}
