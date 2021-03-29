package com.practice.sort;

import java.util.*;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/3/29 9:28
 */
public class TopologySort {
    public static void main(String[] args) {

        int[][] n =  {{1,2},{2,3}, {3,4}, {4}, {}};
        List<Integer> list = topologySort(5, n);
        System.out.println(list.toString());
    }

    /**
     * BSD 广度优先遍历图
     * @param n
     * @param adjacencyList
     * @return
     */
    private static List<Integer> topologySort(int n, int[][] adjacencyList) {
        List<Integer> resp = new ArrayList<>();

        //统计所有节点入度
        int[] inDegree = new int[n];
        for (int[] p : adjacencyList) {
            for (int i : p) {
                inDegree[i] += 1;
            }
        }


        //  取出入度为0的节点，从这些节点开始遍历图

        Queue<Integer> queue = new LinkedList<>();
        for (int d : inDegree) {
            if (d == 0) {
                queue.offer(d);
            }
        }

        if (queue.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        /**
         * 从入度为0的节点开始遍历图，并且把遍历的节点的子节点的入度-1，如果-1后的入度变成了0再加入需要遍历的节点列表上
         */
        while(!queue.isEmpty()) {
            int node = queue.poll();
            resp.add(node);
            for (int i : adjacencyList[node]) {
                inDegree[i] -= 1;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return resp.size() == n ? resp : Collections.EMPTY_LIST;
    }
}
