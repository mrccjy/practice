package com.practice;

import java.math.BigDecimal;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2020/6/29 11:35
 */
public class Regext {
    public static void main(String[] args) {
//        String s = "SELECT id as key,floor_name as value FROM building_floor where t.project_id=${projectId} and building_id = ‘1’";
//        System.out.println(filterAndFollowingWhere(filterRaw(s)));
        System.out.println(new BigDecimal(10).divide(new BigDecimal(3), 5, BigDecimal.ROUND_HALF_UP));
    }

    private static String filterRaw(String s) {
        String regex = "(?im)(and|or)?\\s+[\\w\\._]+\\s*=\\s*\\$\\{[\\w\\._]+\\}";
        return s.replaceAll(regex, "");
    }

    private static String filterAndFollowingWhere(String s) {
        String regex = "(?im)(?<=where)\\s*(and|or)";
        return s.replaceAll(regex, "");
    }
}
