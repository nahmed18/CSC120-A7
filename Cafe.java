/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    //Attributes 
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    /**
     * Constructor for Cafe sets up coffee oz, sugar, cream, and cups
     * @param name - the name of the cafe 
     * @param address - the address of the cafe 
     * @param nFloors - the number of floors in the cafe
     * @param nCoffeeOunces - # of oz coffee
     * @param nSugarPackets - # of sugar packets
     * @param nCreams - # of splashes of cream
     * @param nCups - # of cups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces; 
        this.nSugarPackets = nSugarPackets; 
        this.nCreams = nCreams; 
        this.nCups = nCups;  
        System.out.println("You have built a cafe: ☕");
    }

    //Methods 

    /**
     * Sell coffee by subtracting ingredients from inventory & restock if there's not enough
     * @param size - # of coffee oz
     * @param nSugarPackets - # of sugar packets
     * @param nCreams - # of splashes of cream
     */
    public void sellCoffee(int size,  int nSugarPackets, int nCreams) {
        //Call restock in case there isn't enough in inventory
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(50, 20, 20, 50);
        }
        
        //Subtract the amount of inventory used 
        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets; 
        this.nCreams -= nCreams; 
    }

    /**
     * Restock the inventory in case it runs out by adding more 
     * @param nCoffeeOunces - # of oz coffee
     * @param nSugarPackets - # of sugar packets
     * @param nCreams - # of splashes of cream
     * @param nCups - # of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces; 
        this.nSugarPackets += nSugarPackets; 
        this.nCreams += nCreams; 
        this.nCups += nCups; 
    }

    
    
    public static void main(String[] args) {
        Cafe Qawah = new Cafe("Qawah House", "yemeni st", 2, 10, 5, 5, 10); //create a new cafe 

        Qawah.sellCoffee(3, 4, 4); //test if it subtracts from inventory properly 
        System.out.println(Qawah.nCoffeeOunces);
        System.out.println(Qawah.nSugarPackets);
        System.out.println(Qawah.nCreams);

        Qawah.sellCoffee(6, 2, 0); //test if it restocks properly 
        System.out.println(Qawah.nCoffeeOunces);
        System.out.println(Qawah.nSugarPackets);
        System.out.println(Qawah.nCreams);
    }
}
