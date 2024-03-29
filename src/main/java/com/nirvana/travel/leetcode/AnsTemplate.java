package com.nirvana.travel.leetcode;

import com.nirvana.travel.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author arainliu
 * @date 2021/4/21
 */
public class AnsTemplate {


  /**
   * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
   *
   * 示例 1:
   * 输入: "abab"
   * 输出: True
   *
   * 解释: 可由子字符串 "ab" 重复两次构成。
   * 示例 2:
   * 输入: "aba"
   * 输出: False
   *
   * 示例 3:
   * 输入: "abcabcabcabc"
   * 输出: True
   * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
   * @param s
   * @return
   */
  public boolean repeatedSubstringPattern(String s) {
    if((s.length() & 1) == 1) {
      return false;
    }

    int mid = s.length()>>1;
    return s.substring(0, mid).equals(s.substring(mid));
  }


  public static void main(String[] args) {
    System.out.println(new AnsTemplate().repeatedSubstringPattern("abab"));
  }

  public static void merge(int[] A, int m, int[] B, int n) {
    int pa = 0;
    int pb =0;
    int i = 0;
    int[] resArr = new int[m + n];
    while(pa <= m-1 && pb <= n-1) {
      while(pa <= m-1 && A[pa] <= B[pb]) {
        resArr[i++] = A[pa++];
      }
      while(pb <= n-1 && A[pa] > B[pb]) {
        resArr[i++] = B[pb++];
      }
    }

    while(pa <= m-1) {
      resArr[i++] = A[pa++];
    }

    while(pb <= n -1) {
      resArr[i++] = B[pb++];
    }

    A = resArr;
  }

  /**
   * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
   *
   * 说明: 叶子节点是指没有子节点的节点。
   *
   * 示例:
   *
   * 输入:
   *
   *    1
   *  /   \
   * 2     3
   *  \
   *   5
   *
   * 输出: ["1->2->5", "1->3"]
   *
   * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
   * @param root
   * @return
   */
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    dfs(root, paths, new StringBuffer());
    return paths;
  }

  public void dfs(TreeNode head, List<String> paths, StringBuffer sb) {
    sb.append(head.val);
    if (head.left == null && head.right == null) {
      paths.add(sb.toString());
      return ;
    }

    if (head.left != null) {
      dfs(head.left, paths, new StringBuffer(sb).append("->"));
    }

    if (head.right != null) {
      dfs(head.right, paths, new StringBuffer(sb).append("->"));
    }
  }


  public List<String> bfs(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<String> paths = new ArrayList<>();
    //定义Queue存放层序节点
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    Queue<String> queuePath = new LinkedList<>();
    queuePath.offer(String.valueOf(root.val));
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      String path = queuePath.poll();
      if (node.left == null && node.right == null) {
        paths.add(path);
      } else {
        if (node.left != null) {
          queue.offer(node.left);
          queuePath.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
        }

        if (node.right != null) {
          queue.offer(node.right);
          queuePath.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
        }
      }

    }

    return paths;
  }


  //约瑟夫环问题
  public List<List<Integer>> generate(int numRows) {

    List<List<Integer>> ans = new ArrayList<>();

    for (int i =0; i< numRows; i++) {
      List<Integer> rows = new ArrayList<>();

      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i -1) {
          rows.add(1);
        } else {
          rows.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
        }
      }

      ans.add(rows);
    }

    return ans;
  }
}
