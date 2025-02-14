import java.math.BigInteger;

class ProductOfNumbers {

    private int[] zeroesUntilI;
    private BigInteger[] prodArayrUntilI;
    private int zeroCountUntilI;
    private BigInteger prodUntilI;
    private int I; // To keep track of the index while adding.

    public ProductOfNumbers() {
        this.zeroesUntilI = new int[40000];
        this.prodArayrUntilI = new BigInteger[40000];
        this.prodUntilI = BigInteger.valueOf(1);
        this.zeroCountUntilI = 0;
        this.I = 0; // Always points to next index. Next index = 0, since no elements are inserted yet.
    }
    
    public void add(int num) {
        if (num == 0) {
            this.zeroCountUntilI++;
        } else {
            this.prodUntilI = this.prodUntilI.multiply(BigInteger.valueOf(num));
        }
        this.prodArayrUntilI[I] = this.prodUntilI;
        this.zeroesUntilI[I] = this.zeroCountUntilI;
        this.I++;
    }
    
    public int getProduct(int k) {
        // This should query the product from range (I - k) to I, i.e, last k integers.
        int i = I; // We do not want to modify the I, since it holds the current index and we may have more add calls in future. Check the input.

        if (i - k == 0) {   // From the beginning of an array.
            if (this.zeroesUntilI[i - 1] == 0) { // No zeroes from the beginning
                return this.prodArayrUntilI[i - 1].intValue();
            } else {
                return 0;   // There are zeroes in from the beginning.
            }
        }
        else { // Range doesn't start from the beginning.
            if (this.zeroesUntilI[i - 1] - this.zeroesUntilI[i - 1 - k] == 0) { // No zeroes in between
                
                return this.prodArayrUntilI[i - 1].divide(this.prodArayrUntilI[i - 1 - k]).intValue();
            } else {
                return 0;   // There are zeroes in between
            }
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
