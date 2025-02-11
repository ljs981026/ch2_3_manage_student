package org.fastcampus.student_management.application.student;

import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.StudentRepository;

public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void saveStudent(StudentInfoDto studentInfoDto) {
    Student student = new Student(studentInfoDto.getName(), studentInfoDto.getAge(), studentInfoDto.getAddress());
    studentRepository.save(student);
  }

  public Student getStudent(String name) {
    return studentRepository.findByName(name)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));
  }

  public void activateStudent(String name) {
    Student student = getStudent(name);
    // activate 메서드로 정확하게 어떤 동작을 하는지 명시
    student.activate();
  }

  public void deactivateStudent(String name) {
    Student student = getStudent(name);
    // 수정 코드
    // deactivate 메서드로 정확하게 어떤 동작을 하는지 명시
    student.deactivate();
  }
}
