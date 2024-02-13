package hello.advanced.app.trace.logtrace;

import hello.advanced.app.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus traceStatus, Exception e);
}
