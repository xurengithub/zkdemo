package com.xuren.demo.face;

import java.math.BigDecimal;
import java.util.Random;

public class RedPackSender {
    private int num;
    private BigDecimal totalMoney;
    private BigDecimal surplusMoney;
    private int surplusNum;

    public RedPackSender(int num, BigDecimal totalMoney) {
        this.num = num;
        this.surplusNum = num;
        this.totalMoney = totalMoney;
        this.surplusMoney = totalMoney;
    }

    public BigDecimal send() {
        // 剩余红包数
        // 和剩余钱数
        // 分发
        if(surplusNum <= 1) {
            surplusNum--;
            BigDecimal bigDecimal = surplusMoney;
            surplusMoney = BigDecimal.valueOf(0);
            return bigDecimal;

        }
        BigDecimal avg = surplusMoney.divide(new BigDecimal(surplusNum), 2);
        BigDecimal randomMoney;
        while (avg.compareTo(randomMoney = (rankBigDecimalFromRange(avg, surplusMoney)).setScale(2, BigDecimal.ROUND_HALF_DOWN)) > 0){
        }

        surplusNum--;
        surplusMoney = surplusMoney.subtract(randomMoney);

        return randomMoney;
    }

    private BigDecimal rankBigDecimalFromRange(BigDecimal from, BigDecimal to){
        if(from.compareTo(to) == 0)return from;
        if(from.compareTo(to) > 0){
            return to.add((from.subtract(to).multiply( new BigDecimal(new Random().nextDouble()))));
        }else{
            return from.add((to.subtract(from).multiply( new BigDecimal(new Random().nextDouble()))));
        }
    }


    public static void main(String[] args) {
        RedPackSender redPackSender = new RedPackSender(4,BigDecimal.valueOf(300));
        System.out.println(redPackSender.send().toString());
        System.out.println(redPackSender.send().toString());
        System.out.println(redPackSender.send().toString());
        System.out.println(redPackSender.send().toString());
    }

}
