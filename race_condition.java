public class race_condition{
    private static int counter = 0;
        public static void increase(){counter++;}
        public static void decrease(){counter--;}

    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable(){
        
            //@Override
            public void run() {
                for(int i = 0; i<10000; i++)
                    {increase();}
            }
        });
        Thread t2 = new Thread(new Runnable(){
        
            //@Override
            public void run() {
                for(int i = 0; i<10000; i++)
                    {decrease();}
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("Value="+counter);
    }
}