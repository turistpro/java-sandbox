package com.github.turistpro.sandbox.interview.order;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Date createdAt;
    private String orderType;
    private String description;
    private Integer category;
}
