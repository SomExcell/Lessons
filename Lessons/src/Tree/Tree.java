package Tree;

public class Tree
{
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int[] values)
    {
        this.value = values[0];
        Add(values);
    }

    public Tree(int value)
    {
        this.value = value;
    }

    public void Add(int[] values)
    {
        for (var i : values)
            Add(i);
    }

    public void Add(int value)
    {
        var tree = this;
        while(true)
        {
            if(tree.value == value)
            {
                return;
            }
            else if(value > tree.value)
            {
                if(tree.right == null)
                {
                    tree.right = new Tree(value);
                    return;
                }
                tree = tree.right;
            }
            else if(value < tree.value)
            {
                if(tree.left == null)
                {
                    tree.left = new Tree(value);
                    return;
                }
                tree = tree.left;
            }
        }
    }

    public boolean Contains(int value)
    {
        var tree = this;

        while(true)
        {
            if(tree == null)
            {
                return false;
            }
            else if(tree.value == value)
            {
                return true;
            }
            else if(value < tree.value)
            {
                tree = tree.left;
            }
            else
            {
                tree = tree.right;
            }
        }
    }

    public void Print()
    {
        Print(this.left);
        System.out.print(this.value + " ");
        Print(this.right);
    }

    private void Print(Tree tree)
    {
        if(tree != null)
            tree.Print();
    }

    public void PrintLeaves()
    {
        PrintLeaves(this);
    }

    private void PrintLeaves(Tree tree)
    {
        if(tree.left != null)
        {
            PrintLeaves(tree.left);
        }

        if(tree.right != null)
        {
            PrintLeaves(tree.right);
        }

        if(tree.left == null && tree.right == null)
        {
            System.out.println(tree.value);
        }
    }

    public int GetSum(int low, int high)
    {
        var sum = Integer.valueOf(0);
        Sum(this, low, high, sum);
        return sum;
    }

    private void Sum(Tree tree, int low, int high, Integer sum)
    {
        if(tree.value <= high && tree.value >= low)
        {
            sum += tree.value;
        }

        if(tree.left != null)
        {
            Sum(tree.left, low, high, sum);
        }

        if(tree.right != null)
        {
            Sum(tree.right, low, high, sum);
        }
    }
}


