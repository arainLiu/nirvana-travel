package com.nirvana.travel.me.patternDesign.create.builder;

/**
 * @author arainliu
 * @date 2021/9/2
 */
public class Human {

  private String head;

  private String body;

  private String foot;

  public String getHead() {
    return head;
  }

  public void setHead(String head) {
    this.head = head;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getFoot() {
    return foot;
  }

  public void setFoot(String foot) {
    this.foot = foot;
  }

  @Override
  public String toString() {
    return "Human{" +
      "head='" + head + '\'' +
      ", body='" + body + '\'' +
      ", foot='" + foot + '\'' +
      '}';
  }
}
