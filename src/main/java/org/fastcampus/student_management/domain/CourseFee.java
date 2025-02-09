package org.fastcampus.student_management.domain;
// V0 사용 -> 재사용이 가능하고 캡슐화가 될 뿐만 아니라 가독성이 생김
public class CourseFee {
  private int fee;

  public CourseFee(int fee) {
    this.fee = fee;
  }

  public void changeFee(int fee) {
    this.fee = fee;
  }

  private void checkFee(int fee) {
    if (fee < 0) {
      throw  new IllegalArgumentException("수강료는 0원 이상이어야 합니다.");
    }
  }

  public int getFee() {
    return fee;
  }
}
