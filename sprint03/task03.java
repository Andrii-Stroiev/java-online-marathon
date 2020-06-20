public static void addAtoB(int a, int b) {
    Strategy addStrategy =new Strategy(){
         @Override
        public double doOperation(int a, int b){
            return (double)(a+b);
        }
    };
    execute(a, b, addStrategy);
}

public static void subtractBfromA(int a, int b) {
   Strategy subtractStrategy =new Strategy(){
         @Override
        public double doOperation(int a, int b){
            return (double)(a-b);
        }
    };
    execute(a, b, subtractStrategy);
};

public static void multiplyAbyB(int a, int b) {
    
   Strategy multiplyStrategy =new Strategy(){
         @Override
        public double doOperation(int a, int b){
            return (double)(a*b);
        }
    };
    execute(a, b, multiplyStrategy);
    }

public static void divideAbyB(int a, int b) {
    
    Strategy divideStrategy =new Strategy(){
         @Override
        public double doOperation(int a, int b){
            return (double)(a/b);
        }
    };
    execute(a, b, divideStrategy);
    
}
    
