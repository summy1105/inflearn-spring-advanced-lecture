package hello.advanced.app.v5;

import hello.advanced.app.trace.callback.TraceTemplate;
import hello.advanced.app.trace.logtrace.LogTrace;
import hello.advanced.app.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final TraceTemplate template;
    private final OrderServiceV5 orderService;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.template = new TraceTemplate(trace);
        this.orderService = orderService;
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        String result = template.execute("OrderControllerV5.request()", () -> {
            orderService.orderItem(itemId);
            return "Ok";
        });
        return result;
    }
}
