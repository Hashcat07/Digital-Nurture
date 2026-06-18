public class Logger {
    //volatile helps to give thread safety
    private volatile static Logger Instance;

    //private constructor prevents new calls
    private Logger(){
        System.out.println("Private Constructor");
    }
    public static Logger returnInstance(){
        if(Instance==null){
            //double lock check and synchronized allows access to only on thread
            synchronized (Logger.class){
                if (Instance==null){
                    Instance=new Logger();
                }
            }
        }
        return Instance;
    }

    /*
     * Using enum
     * public enum Logger{
     * Instance;
     * }
     * */

    static void main() {

        //constructor runs only once
        Logger obj1=Logger.returnInstance();
        Logger obj2=Logger.returnInstance();

        System.out.println("Are the Objects/Instanes same: "+ (obj1==obj2));//prints true

    }
}
