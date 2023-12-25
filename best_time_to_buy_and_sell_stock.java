class best_time_to_buy_and_sell_stock {
    static int maxProfit(int[] price){
        int gmin=0,nmin,smallest=price[0];
        int[] cprice= price;
        for(int i=0;i<price.length-1;i++){
            if(price[i]<smallest){
                smallest=price[i];
            }
            nmin=price[i+1]-smallest;
            System.out.println("nmin "+nmin);
            if(nmin>gmin){
                gmin=nmin;
                System.out.println("gmin "+gmin);
            }
        }
        return gmin;
    }
}