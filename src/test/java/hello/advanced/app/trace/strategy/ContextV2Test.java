package hello.advanced.app.trace.strategy;

import hello.advanced.app.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context1 = new ContextV2();
        context1.execute(new StrategyLogic1());
        context1.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2() {
        ContextV2 context1 = new ContextV2();
        context1.execute(()->log.info("람다 비즈니스 로직 1 실행"));
        context1.execute(()->log.info("람다 비즈니스 로직 2 실행"));
    }
}
