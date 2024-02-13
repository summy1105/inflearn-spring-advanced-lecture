package hello.advanced.app.v2;

import hello.advanced.app.trace.TraceId;
import hello.advanced.app.trace.TraceStatus;
import hello.advanced.app.trace.hellotrace.HelloTraceV1;
import hello.advanced.app.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId, TraceId traceId) {
        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId,"OrderServiceV2.orderItem()");
            orderRepository.save(itemId, status.getTraceId());

            trace.end(status);
            return;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
