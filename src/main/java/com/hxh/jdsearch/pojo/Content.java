package com.hxh.jdsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private String img;
    private String price;
    private String title;

    public String toString() {
        return img + ";\n" + price + ";\n" + title + ";\n" ;
    }
}
