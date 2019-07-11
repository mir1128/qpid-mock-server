package com.looboo.rabbitmqexample;

import org.apache.qpid.server.SystemLauncher;
import org.junit.BeforeClass;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class QpidBrokerServer {
    private static final String INITIAL_CONFIGURATION = "test-initial-config.json";

    private final static SystemLauncher systemLauncher = new SystemLauncher();


    @BeforeClass
    public static void startServer() throws Exception {
        new Thread(() -> {
            try {
                systemLauncher.startup(createSystemConfig());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
    }

    private static Map<String, Object> createSystemConfig() {
        Map<String, Object> attributes = new HashMap<>();
        URL initialConfig = QpidBrokerServer.class.getClassLoader().getResource(INITIAL_CONFIGURATION);
        attributes.put("type", "Memory");
        attributes.put("initialConfigurationLocation", initialConfig.toExternalForm());
        attributes.put("startupLoggedToSystemOut", true);
        return attributes;
    }

}
