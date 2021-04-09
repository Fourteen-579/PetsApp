package com.fourteen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultReturn {
    private String code;
    private String msg;
    private String count;
    private Object data;
}
