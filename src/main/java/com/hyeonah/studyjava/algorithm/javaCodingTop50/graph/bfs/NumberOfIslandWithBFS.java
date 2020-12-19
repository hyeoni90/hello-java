package com.hyeonah.studyjava.algorithm.javaCodingTop50.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hyeonahlee on 2020-12-19.
 *
 * BFS > Queue
 */
public class NumberOfIslandWithBFS {

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '0', '1'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '1'},
            {'0', '0', '0', '0', '1'}
        };

        NumberOfIslandWithBFS numberOfIslandWithBFS = new NumberOfIslandWithBFS();
        System.out.println(numberOfIslandWithBFS.solution(grid));
    }

    private int solution(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y) {
        // 상 하 우 좌
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        // 좌표 값을 저장
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});  // (0,0)

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] point = queue.poll(); // (0,0)

            for (int i = 0; i < size; i++) {
                // 사방을 돌아야 함!
                for (int[] dir : dirs) {
                    //
                    int x1 = point[0] + dir[0];
                    int y1 = point[1] + dir[1];

                    if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == '1') {
//                        System.out.println("[" + x1 + "][" + y1 + "]");
                        grid[x1][y1] = '0';
                        queue.offer(new int[]{x1, y1});
                    }
                }
            }
        }
    }
}