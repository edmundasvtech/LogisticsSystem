package Model;

import lombok.Getter;

import java.time.LocalDateTime;

public class Order {
    private String client;
    private String supplier;
    private String pickLocation;
    private LocalDateTime pickTime;
    private String deliveryLocation;
    private LocalDateTime deliveryTime;
    private String productName;
    private String type;
    private int qty;

    enum Status{
        COMPLETED,
        IN_PROGRESS,
        ABORTED
    }
}
