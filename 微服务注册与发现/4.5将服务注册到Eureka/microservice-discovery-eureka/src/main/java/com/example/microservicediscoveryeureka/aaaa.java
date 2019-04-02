package com.example.microservicediscoveryeureka;

import java.math.BigDecimal;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/6
 */
public class aaaa {
    public static void main(String[] args) {
        BigDecimal s=new BigDecimal(100000);
        for(;s.compareTo(new BigDecimal(999999))==-1;s=s.add(new BigDecimal(1))){
            char[] c=(""+s).toCharArray();
            char cc=c[0];
            c[0]=c[c.length-3];
            c[c.length-3]=cc;
            BigDecimal s2=new BigDecimal(c);
            if(s2.compareTo(s.multiply(new BigDecimal(3)))==0){
                System.out.println(s);
            }
        }
    }


}
