package com.savchenko.myresume.gpt;

import com.savchenko.myresume.model.UserRequests;
import org.junit.Test;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@EnableScheduling
public class SpamFilter {
    private Map<String, UserRequests> ipMap = new HashMap<>();

    public boolean filter(String ip) {
        if (ipMap.containsKey(ip)) {
            System.out.println(ipMap.get(ip).getAmount());
            if (ipMap.get(ip).getAmount() > 2) {
                return true;
            }
            else {
                ipMap.get(ip).setAmount(ipMap.get(ip).getAmount() + 1);
                return false;
            }
        }
        else {
            UserRequests userRequests = new UserRequests(1, System.currentTimeMillis());
            ipMap.put(ip, userRequests);
            return false;
        }
    }


    @Scheduled(initialDelay = 0, fixedDelay = 60, timeUnit = TimeUnit.SECONDS)
    public synchronized void clearFilter() {
        for (Map.Entry<String, UserRequests> entry : ipMap.entrySet()) {
            UserRequests userRequests = entry.getValue();
            if (System.currentTimeMillis() - userRequests.getFirstTry() > 60 * 60 * 1000) {
                ipMap.remove(entry.getKey());
            }
        }
    }
}

