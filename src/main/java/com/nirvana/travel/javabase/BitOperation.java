package com.nirvana.travel.javabase;

/**
 *
 * & 同为1则为1 否则为0
 * | 一位为1 则返回1
 * ~ 将操作数的每位取反
 * ^ 两位相同时返回0，不同时返回1
 * << 左移运算符 将操作数的二进制码整体左移指定位数，右边空出的以0填充 正数---乘2^n
 * >> 右移运算符 将操作数的二进制码整体右移指定位数，左边空出的以符号位填充（如果是正数，就是以0填充。如果是负数，就是以1填充。） 正数---除2^n
 * >>>无符号右移运算符 将操作数的二进制码整体右移指定位数，左边空出来的位总是以0填充。 正数---除2^n
 *
 * 说明：位运算的效率高于乘除运算，因为计算机底层就是0 1二进制来处理的。
 *
 *  位运算优先级
 * ~的优先级最高，其次是<<、>>和>>>，再次是＆，然后是^，优先级最低的是|
 *
 *
 * @author arainliu
 * @date 2021/1/11
 */
public class BitOperation {

  /**
   * 基础操作：
   * a|0 == a;
   * a&-1 == a;
   * a&0 == 0;
   *
   * a^a == 0;
   * a^0 == a;
   *
   * a|~a == -1;
   * a&~a == 0;
   * a&a == a;
   * a|a == a;
   *
   * a|(a&b) == a;
   * a&(a|b) == a;
   */

  //一、判断奇偶性
  //a&1 == 0；则a为偶数
  //a&1 == 1；则a为奇数



}
