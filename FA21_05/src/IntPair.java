public class IntPair {
    private int x;
    private int y;

    /**
     * Creates new instance of integer pair
     *
     * @param x
     * @param y
     */
    public IntPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates new instance of integer pair
     */
    public IntPair() {

    }

    /**
     * Gets x of pair
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Sets x for pair
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get y of pair
     *
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * Sets y for pair
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Converts pair object to string
     */
    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }

}