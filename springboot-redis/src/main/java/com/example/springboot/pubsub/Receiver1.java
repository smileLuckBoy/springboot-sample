package com.example.springboot.pubsub;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmin
 * @version OmniPrime.All rights reserved.
 * @Comments
 * @since 2018/2/5
 */
@Slf4j
public class Receiver1 {

    public void handleMessage(String message) {
        log.info("Receiver1 receive message [ " + message + " ]");
    }

}
