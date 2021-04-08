package com.fourteen.tools;

import java.util.UUID;

public class CreateId {
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
