/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas         */
/** de POO. Representa uma solução em construção, com base na matéria leccionada    */
/** até ao momento da sua elaboração, e resulta da discussão e experimentação       */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,     */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.         */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a         */
/** procurar soluções alternativas, à medida que forem adquirindo mais              */
/** conhecimentos de POO.                                                           */
/*********************************************************************************/

/**
  * Classe que implementa um Point num plano2D.
  * As coordenadas do Point são inteiras.
  *
  * @author  MaterialPOO
  * @version 20180212
  * @version 20210305
  * @version 20240229
  */

public class Point {

    //variáveis de instância
    private int x;
    private int y;

    /**
      * Construtores da classe Point.
      * Declaração dos construtores por omissão (vazio),
      * parametrizado e de cópia.
      */

    /**
      * Construtor por omissão de Point.
      */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
      * Construtor parametrizado de Point.
      * Aceita como parâmetros os valores para cada coordenada.
      */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int cx) {
        this.x = cx;
        this.y = 0;
    }

    /**
      * Construtor de cópia de Point.
      * Aceita como parâmetro outro Point e utiliza os métodos
      * de acesso aos valores das variáveis de instância.
      */
    public Point(Point umPoint) {
        this.x = umPoint.getX();
        this.y = umPoint.getY();
    }

    /**
      * métodos de instância
      */

    /**
      * Devolve o valor da coordenada em x.
      *
      * @return valor da coordenada x.
      */
    public int getX() {
        return this.x;
    }

    /**
      * Devolve o valor da coordenada em y.
      *
      * @return valor da coordenada y.
      */
    public int getY() {
        return this.y;
    }

    /**
      * Actualiza o valor da coordenada em x.
      *
      * @param novoX novo valor da coordenada em X
      */
    public void setX(int novoX) {
        this.x = novoX;
    }

    /**
      * Actualiza o valor da coordenada em y.
      *
      * @param novoY novo valor da coordenada em Y
      */
    public void setY(int novoY) {
        this.y = novoY;
    }

    /**
      * Método que desloca um ponto somando um delta às coordenadas
      * em x e y.
      *
      * @param deltaX valor de deslocamento do x
      * @param deltaY valor de deslocamento do y
      */
    public void deslocamento(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
      * Método que soma as componentes do Point passado como parâmetro.
      * @param umPoint ponto que é somado ao ponto receptor da mensagem.
      */
    public void somaPoint(Point umPoint) {
        this.x += umPoint.getX();
        this.y += umPoint.getY();
    }

    /**
      * Método que move o Point para novas coordenadas.
      * @param novoX novo valor de x.
      * @param novoY novo valor de y.
      */
    public void movePoint(int cx, int cy) {
        this.x = cx;  // ou setX(cx)
        this.y = cy;  // ou this.setY(cy)
    }

    /**
      * Método que determina se o ponto está no quadrante positivo de x e y
      * @return booleano que é verdadeiro se x>0 e y>0
      */
    public boolean ePositivo() {
        return (this.x > 0 && this.y > 0);
    }

    /**
      * Método que determina a distância de um Point a outro.
      * Determina a distância entre this e o ponto passado por parâmetro.
      *
      *
      * @param umPoint ponto ao qual se quer determinar a distância
      * @return double com o valor da distância
      */

    public double distancia(Point umPoint) {

        return Math.sqrt(Math.pow(this.x - umPoint.getX(), 2) +
            Math.pow(this.y - umPoint.getY(), 2));
    }

    /**
      * Método (inicial) que determina se dois pontos são iguais.
      *
      * NOTA: ver, mais abaixo, implementação do método equals para que
      * seja coerente com a forma de fazer igualdade de objectos.
      *
      * @return booleano que é verdadeiro se os valores das duas
      * coordenadas forem iguais.
      */
    public boolean iguais(Point umPoint) {
        return (this.x == umPoint.getX() && this.y == umPoint.getY());
    }

    /**
      * Método que determina se o módulo das duas coordenadas é o mesmo.
      * @return true, se as coordenadas em x e y
      * forem iguais em valor absoluto.
      */
    private boolean xIgualAy() {
        return (Math.abs(this.x) == Math.abs(this.y));
    }

    /**
      * Método que devolve a representação em String do Point.
      * @return String com as coordenadas x e y
      */
    public String toString() {
        return "Point: --> Cx = " + this.x + " -  Cy = " + this.y;
    }

    /**
      * Método standard de igualdade de objectos.
      * Reimplementação do método equals, definido em Object, para que passe a
      * comparar de forma correcta dois objectos do tipo Point.
      *
      */

    public boolean equals(Object o) {
        if (this == o)
        return true;
        if ((o == null) || (this.getClass() != o.getClass()))
        return false;
        Point p = (Point) o;
        return (this.x == p.getX() && this.y == p.getY());

    }

    /**
      * Método que faz uma cópia do objecto receptor da mensagem.
      * Para tal invoca o construtor de cópia.
      *
      * @return objecto clone do objecto que recebe a mensagem.
      */

    public Point clone() {
        return new Point(this);
    }
}
