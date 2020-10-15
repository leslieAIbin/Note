class CodeZY {
    public CodeZY() {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    static {
        System.out.println("3");
    }
}


public class CodeBlock03 {
    {
        System.out.println("4");
    }

    static  {
        System.out.println("5");
    }

    public CodeBlock03() {
        System.out.println("6");
    }

    public static void main(String[] args) {
        System.out.println("=====");
        new CodeZY();
        System.out.println("=====");
        new CodeZY();
        System.out.println("=====");
        new CodeBlock03();
    }
}
