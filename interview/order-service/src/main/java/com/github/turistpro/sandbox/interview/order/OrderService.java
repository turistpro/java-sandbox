package com.github.turistpro.sandbox.interview.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private LogService logService;
    private NotificationService notificationService;

    public TariffService tariffService = new DefaultTariffService();
    Order order;

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public Order createOrder(String orderType, String description) {
        Order newOrder = new Order();
        newOrder.setCreatedAt(new Date());
        newOrder.setOrderType(orderType);
        newOrder.setDescription(description);

        int orderCategory;
        switch (orderType) {
            case "food":
                orderCategory = 2;
                break;
            case "electronic devices":
                orderCategory = 3;
                break;
            case "other":
                orderCategory = 4;
                break;
            default:
                orderCategory = 1;
        }
        newOrder.setCategory(orderCategory);

        notificationService.notifyIfNewOrderIsCreated(newOrder);
        logService.sendLog(newOrder);

        this.order = newOrder;

        return newOrder;
    }

    public void changeOrderDetails(String description) {
        this.order.setDescription(description);
        logService.sendLog(order);
    }

    public Order getOrder() {
        return this.order;
    }
}