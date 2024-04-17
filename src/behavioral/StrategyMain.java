package behavioral;

/**
 * @author: liuzt
 * @date: 2024/4/17 - 04 - 17 - 15:03
 * @description: behavioral  策略模式
 * @version: 1.0
 */
public class StrategyMain {
    public static void main(String[] args) {
        Strategy addStrategy = new AddStrategy();
        Strategy subStrategy = new SubStrategy();

        OperationContext operationContext = new OperationContext(addStrategy);
        operationContext.Operation(34,53);
        OperationContext operationContext1 = new OperationContext(subStrategy);
        operationContext1.Operation(34,1);
    }
}


class OperationContext{
    private Strategy strategy;
    public OperationContext(Strategy strategy){
        this.strategy = strategy;
    }
    public void Operation(int a, int b){
        strategy.TwoNumberOperation(a,b);
    }

}

interface Strategy{
    public void TwoNumberOperation(int a, int b);
}
class AddStrategy implements Strategy{

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a+b);
    }
}

class SubStrategy implements Strategy{

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a-b);
    }
}
