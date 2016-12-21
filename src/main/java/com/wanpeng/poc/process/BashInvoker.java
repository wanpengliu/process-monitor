package com.wanpeng.poc.process;


import com.wanpeng.poc.util.Util;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class BashInvoker {

    @Value("${process.name}")
    private String process_name;

    public String getProcess_name() {
        return process_name;
    }

    public void setProcess_name(String process_name) {
        this.process_name = process_name;
    }

    public void monitorProcess() throws IOException {

        System.out.println("Monitor " + process_name);
        while(true) {
            String command = " ps -ef | grep -v grep | grep " + process_name + " | wc -l ";
            String s = Util.executeCommand(command);
            System.out.println(s);
        }
    }
}
