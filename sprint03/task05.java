enum ClientType {
    NEW(0), SILVER(12), GOLD(30), PLATINUM(60);
 private int months;

    ClientType(int months) {
        this.months = months;
    }

    public double discount(){

       double discount = (100-this.months*0.35)/100;
        return discount;
    }
}
