package com.savchenko.myresume.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequests {
    private int amount;
    private long firstTry;
}
