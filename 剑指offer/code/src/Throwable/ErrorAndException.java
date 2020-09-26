package Throwable;
import java.io.*;

public class ErrorAndException {
    private void throwError() {
        throw new StackOverflowError();
    }

    private void throwRuntimeException(){
        throw new RuntimeException();
    }

    private void throwCheckedException() throws IOException {
        throw new FileNotFoundException();
    }

    
    // private void throwCheckedException() {
    //     try {
    //         throw new FileNotFoundException();
    //     } catch(FileNotFoundException e) {
    //         e.printStackTrace();
    //     }
    // }

    public static int doWork() {
        try{
            int i = 10/0;
            System.out.println("i="+i);
        } catch(ArithmeticException e) {
            System.out.println("ArithemeticException: "+e);
            // finally 会执行在return的前面
            return 0;
            // 尽量捕捉特定的异常
        } catch(Exception e){
            System.out.println("Exception: " + e)  ;
            return 1;
        } finally {
            System.out.println("Finally");
            // return 3;
        }

        return 2;
    }
    public static void main(String[] args){
        // ErrorAndException eae = new ErrorAndException();
        // eae.throwError();
        // eae.throwRuntimeException();
        // eae.throwCheckedException(); throw 层层上抛，直到处理 或者main终止

        // 异常的从下往上 抛出
        System.out.println(doWork());
    }
}