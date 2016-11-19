package com.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
  @Scheduled(fixedRate = 5000)
  public void runFixedRate() {
    System.out
        .println("printing at fixed rate from scheduled task at " + System.currentTimeMillis());
  }

  @Scheduled(fixedDelay = 5000)
  public void runFixedDelay() {
    System.out
        .println("printing at fixed delay from scheduled task at " + System.currentTimeMillis());
  }

}
