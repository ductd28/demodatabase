package com.example.demodatabase.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demodatabase.Entity.Person;

import java.util.List;

public interface PersonDAO extends JpaRepository<Person, Long> {
	// Tìm theo tên
    List<Person> findByName(String name);

    // Tìm theo tuổi
    List<Person> findByAge(int age);

    // Tìm theo mức lương
    List<Person> findBySalary(double salary);

    // Tìm theo tên và tuổi
    List<Person> findByNameAndAge(String name, int age);

    // Tìm theo tuổi và mức lương
    List<Person> findByAgeAndSalary(int age, double salary);

    // Tìm theo mức lương lớn hơn một giá trị cho trước
    List<Person> findBySalaryGreaterThan(double salary);

    // Tìm theo mức lương nhỏ hơn hoặc bằng một giá trị cho trước
    List<Person> findBySalaryLessThan(double salary);

    // Tìm theo tên và sắp xếp theo tuổi tăng dần
    List<Person> findByNameOrderByAgeAsc(String name);

    // Tìm theo tuổi và sắp xếp theo mức lương giảm dần
    List<Person> findByAgeOrderBySalaryDesc(int age);

    // Tìm theo tên (không phân biệt chữ hoa, chữ thường)
    List<Person> findByNameIgnoreCase(String name);

    // Tìm theo mức lương lớn hơn một giá trị và sắp xếp theo tuổi giảm dần
    List<Person> findBySalaryGreaterThanOrderByAgeDesc(double salary);

    // Tìm theo tên chứa một phần và sắp xếp theo tuổi tăng dần
    List<Person> findByNameContainingOrderByAgeAsc(String partOfName);
}
