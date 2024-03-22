public class LinhaDeEncomenda {

    String reference;
    String description;
    double price;
    int quantity;
    double tax;
    double discount;

    public LinhaDeEncomenda(String reference, String description, double price, int quantity, double tax, double discount) {
        this.reference = reference;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.tax = tax;
        this.discount = discount;
    }

    public LinhaDeEncomenda() {
        this.reference = "";
        this.description = "";
        this.price = 0;
        this.quantity = 0;
        this.tax = 0;
        this.discount = 0;
    }

    public LinhaDeEncomenda(LinhaDeEncomenda l) {
        this.reference = l.getReference();
        this.description = l.getDescription();
        this.price = l.getPrice();
        this.quantity = l.getQuantity();
        this.tax = l.getTax();
        this.discount = l.getDiscount();
    }

    public String getReference() {
        return this.reference;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTax() {
        return this.tax;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LinhaDeEncomenda clone() {
        return new LinhaDeEncomenda(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LinhaDeEncomenda l = (LinhaDeEncomenda) o;
        return this.reference.equals(l.getReference()) &&
                this.description.equals(l.getDescription()) &&
                this.price == l.getPrice() &&
                this.quantity == l.getQuantity() &&
                this.tax == l.getTax() &&
                this.discount == l.getDiscount();
    }

    public String toString() {
        return "LinhaDeEncomenda{" +
                "reference='" + reference + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", tax=" + tax +
                ", discount=" + discount +
                '}';
    }

    public double calculaValorLinhaEnc() {
        return this.price * this.quantity * (1 - this.discount) * (1 + this.tax);
    }

    public double calculaValorDesconto() {
        return this.price * this.quantity * this.discount;
    }
}
