package ru.gbhw.notes.configurations;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoteConfiguration {

    @Bean
    public Timer timer(MeterRegistry meterRegistry) {
        return Timer.builder("lead_time")
                .description("Время выполнения сервисов").register(meterRegistry);
    }
    @Bean
    public Counter counter(MeterRegistry meterRegistry) {
        return Counter.builder("count_hits_db")
                .description("Количетсво обращений к базе").register(meterRegistry);
    }
}
