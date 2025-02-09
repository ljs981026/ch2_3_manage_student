package org.fastcampus.student_management.domain;

public class Student {

  private final String name;
  private final int age;
  private final String address;
  private boolean activated;

  public Student(String name, int age, String address) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("이름은 필수 입력값입니다.");
    }

    this.name = name;
    this.age = age;
    this.address = address;
    this.activated = true;
  }
  // SETTER 사용하면 동일한 메세지를 던지는 여러기능을 사용하기 때문에
  // 객체 개발 형식에 위배될 수 있다. 레이어 형식은 제외
  public void activate() {
    if(this.activated) {
      throw new IllegalArgumentException();
    }
    this.activated = true;
  }

  public void deactivate() {
    if(!this.activated) {
      throw new IllegalArgumentException();
    }
    this.activated = false;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }
  public boolean isActivate() {
    return activated;
  }
}
