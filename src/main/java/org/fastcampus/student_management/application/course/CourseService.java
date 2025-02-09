package org.fastcampus.student_management.application.course;

import java.util.ArrayList;
import java.util.List;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);
    // List<CourseInfoDto> courseInfoDos = new ArrayList<>();
    //  for (Course course : courses) {
    //    CourseInfoDto courseInfoDto = new CourseInfoDto(course);
    //    courseInfoDos.add(courseInfoDto);
    //  }
    //  return courseInfoDos;
    // 수정 코드
    // 람다 형식의 이점 -> 간결함
    return courses.stream().map(CourseInfoDto::new).toList();
  }

  public void changeFee(String studentName, int fee) {
    // TODO: 과제 구현 부분
    List<Course> courses = courseRepository.getCourseListByStudent(studentName);
//    Student student = studentService.getStudent(studentName);
//    List<Course> updateCourses = new ArrayList<>();
//
//    for (Course course : courses) {
//      Course updateCourse = new Course(student, course.getCourseName(), fee, course.getDayOfWeek(), course.getCourseTime());
//      updateCourses.add(updateCourse);
//    }
//    courseRepository.saveCourses(updateCourses);
    // 수정 코드
//    for (Course course : courses) {
//      // 만약 주말에는 1.5배 더 받아야한다는 로직이 추가되면
//      // 아래 처럼 할시 서비스단에 비즈니스 로직이 노출되므로 개선 방법 필요
//      if (course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
//        course.changeFee((int) (fee * 1.5));
//      }
//      course.changeFee(fee);
//    }
    // 서비스 레이어는 전혀 관련없이 CourseList에만 의존해서 메세지를 전달하고
    // 주말에 1.5배올리는 로직이 추가가 됨
    CourseList courseList = new CourseList(courses);
    courseList.changeAllCourseFee(fee);
  }
}
