import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private int gridLength;
    private boolean[] sites;
    private int openSitesNumber;
    private int virtualTopIndex;
    private int virtualBottomIndex;
    private WeightedQuickUnionUF ufForPercolation;
    private WeightedQuickUnionUF ufForFullness;

    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Grid must have at least one row and column");
        }

        gridLength = n;
        int gridSize = (n * n) + 2; 
        sites = new boolean[gridSize];
        openSitesNumber = 0;

  
        virtualTopIndex = 0;
        virtualBottomIndex = (gridLength * gridLength) + 1;
        sites[virtualTopIndex] = true;
        sites[virtualBottomIndex] = false;

        ufForPercolation = new WeightedQuickUnionUF(gridSize);
        ufForFullness = new WeightedQuickUnionUF(gridSize);

        
        for (int col = 1; col <= gridLength; col++) {
            int rowTop = 1;
            int siteTopIndex = getIndexByRowAndColumn(rowTop, col);
            ufForPercolation.union(virtualTopIndex, siteTopIndex);
            ufForFullness.union(virtualTopIndex, siteTopIndex);

            int rowBottom = gridLength;
            int siteBottomIndex = getIndexByRowAndColumn(rowBottom, col);
            ufForPercolation.union(virtualBottomIndex, siteBottomIndex);
        }
    }

    
    public void open(int row, int col)
    {
        int siteIndex = getIndexByRowAndColumn(row, col);
        if (sites[siteIndex]) {
            return;
        }

        openSitesNumber++;
        sites[siteIndex] = true;

        
        if (col > 1 && isOpen(row, col - 1)) {
            int siteLeftIndex = getIndexByRowAndColumn(row, col - 1);
            ufForPercolation.union(siteIndex, siteLeftIndex);
            ufForFullness.union(siteIndex, siteLeftIndex);
        }

        
        if (col < gridLength && isOpen(row, col + 1)) {
            int siteLeftIndex = getIndexByRowAndColumn(row, col + 1);
            ufForPercolation.union(siteIndex, siteLeftIndex);
            ufForFullness.union(siteIndex, siteLeftIndex);
        }

        
        if (row > 1 && isOpen(row - 1, col)) {
            int siteLeftIndex = getIndexByRowAndColumn(row - 1, col);
            ufForPercolation.union(siteIndex, siteLeftIndex);
            ufForFullness.union(siteIndex, siteLeftIndex);
        }

        
        if (row < gridLength && isOpen(row + 1, col)) {
            int siteLeftIndex = getIndexByRowAndColumn(row + 1, col);
            ufForPercolation.union(siteIndex, siteLeftIndex);
            ufForFullness.union(siteIndex, siteLeftIndex);
        }
    }

    
    public boolean isOpen(int row, int col)
    {
        int siteIndex = getIndexByRowAndColumn(row, col);

        return sites[siteIndex];
    }

    
    public boolean isFull(int row, int col)
    {
        int siteIndex = getIndexByRowAndColumn(row, col);

        return (isOpen(row, col) && ufForFullness.connected(virtualTopIndex, siteIndex));
    }

    
    public int numberOfOpenSites()
    {
        return openSitesNumber;
    }

    
    public boolean percolates()
    {
        
        if (gridLength == 1) {
            int siteIndex = getIndexByRowAndColumn(1, 1);
            return sites[siteIndex];
        }

        return ufForPercolation.connected(virtualTopIndex, virtualBottomIndex);
    }

    
    private int getIndexByRowAndColumn(int row, int col)
    {
        validateBounds(row, col);

        return ((row - 1) * gridLength) + col;
    }

    // Check if row and column values are in range of grid size
    private void validateBounds(int row, int col)
    {
        if (row > gridLength || row < 1) {
            throw new IndexOutOfBoundsException("Row index is out of bounds");
        }

        if (col > gridLength || col < 1) {
            throw new IndexOutOfBoundsException("Column index is out of bounds");
        }
    }

    
    public static void main(String[] args)
    {
        Percolation percolation = new Percolation(2);

        StdOut.println("percolates = " + percolation.percolates());

        StdOut.println("isOpen(1, 2) = " + percolation.isOpen(1, 2));
        StdOut.println("isFull(1, 2) = " + percolation.isFull(1, 2));
        StdOut.println("open(1, 2)");
        percolation.open(1, 2);
        StdOut.println("isOpen(1, 2) = " + percolation.isOpen(1, 2));
        StdOut.println("isFull(1, 2) = " + percolation.isFull(1, 2));
        StdOut.println("numberOfOpenSites() = " + percolation.numberOfOpenSites());
        StdOut.println("percolates() = " + percolation.percolates());

        StdOut.println("isOpen(2, 1) = " + percolation.isOpen(2, 1));
        StdOut.println("isFull(2, 1) = " + percolation.isFull(2, 1));
        StdOut.println("open(2, 1)");
        percolation.open(2, 1);
        StdOut.println("isOpen(2, 1) = " + percolation.isOpen(2, 1));
        StdOut.println("isFull(2, 1) = " + percolation.isFull(2, 1));
        StdOut.println("numberOfOpenSites() = " + percolation.numberOfOpenSites());
        StdOut.println("percolates() = " + percolation.percolates());

        StdOut.println("isOpen(1, 1) = " + percolation.isOpen(1, 1));
        StdOut.println("isFull(1, 1) = " + percolation.isFull(1, 1));
        StdOut.println("open(1, 1)");
        percolation.open(1, 1);
        StdOut.println("isOpen(1, 1) = " + percolation.isOpen(1, 1));
        StdOut.println("isFull(1, 1) = " + percolation.isFull(1, 1));
        StdOut.println("numberOfOpenSites() = " + percolation.numberOfOpenSites());
        StdOut.println("percolates() = " + percolation.percolates());
    }
}