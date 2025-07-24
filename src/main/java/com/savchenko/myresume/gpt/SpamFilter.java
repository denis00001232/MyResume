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

    SpamFilter() {
        filter("127.0.0.1");
        filter("127.0.0.1");
        filter("127.0.0.1");
        filter("127.0.0.1");
        System.out.println(filter("127.0.0.1"));
    }

    public boolean filter(String ip) {

        if (ipMap.containsKey(ip)) {
            if (ipMap.get(ip).getAmount() > 3) {
                return true;
            }
            else {
                ipMap.get(ip).setAmount(ipMap.get(ip).getAmount() + 1);
                return false;
            }
        }
        else {
            UserRequests userRequests = new UserRequests(0, System.currentTimeMillis());
            ipMap.put(ip, userRequests);
            return false;
        }
    }


    @Scheduled(initialDelay = 5000, fixedDelay = 60, timeUnit = TimeUnit.SECONDS)
    private synchronized void clearFilter() {
        for (Map.Entry<String, UserRequests> entry : ipMap.entrySet()) {
            UserRequests userRequests = entry.getValue();
            if (System.currentTimeMillis() - userRequests.getFirstTry() > 60 * 60 * 1000) {
                ipMap.remove(entry.getKey());
            }
        }
    }
}

