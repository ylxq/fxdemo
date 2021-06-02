package com.tao.fx.luckdraw;

import lombok.Builder;
import lombok.Data;

/**
 * @author taowenchen
 */
@Data
@Builder
public class Prize {
    private String name;
    private Integer percent;
}
