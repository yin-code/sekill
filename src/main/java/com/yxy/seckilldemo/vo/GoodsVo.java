package com.yxy.seckilldemo.vo;

import com.yxy.seckilldemo.pojo.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends Goods {
    /* 秒杀价*/
    private BigDecimal seckillPrice;
    /*库存数量 */
    private Integer stockCount;
    /*开始时间 */
    private Date startDate;
    /*结束时间 */
    private Date endDate;


}

