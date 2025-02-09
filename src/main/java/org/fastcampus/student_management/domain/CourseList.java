package org.fastcampus.student_management.domain;

import java.util.List;

// 비즈니스 로직을 노출시키지 않기 위함
// 재사용성 높아짐, 가독성 높아짐, 테스트가 쉬워짐
public class CourseList {
  private final List<Course> courses;

  public CourseList(List<Course> course) {
    this.courses = course;
  }

  public void changeAllCourseFee(int fee) {
    for (Course course: courses) {
      if (course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
        course.changeFee((int) (fee * 1.5));
      }
      course.changeFee(fee);
    }
  }
}
