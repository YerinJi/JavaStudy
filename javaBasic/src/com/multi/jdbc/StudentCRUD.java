package com.multi.jdbc;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUD { // CRUD 프로그램을 위한 클래스 정의
    // 데이터베이스 연결 정보
    private static final String DB_URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "root"; // 데이터베이스 사용자 이름
    private static final String DB_PASSWORD = "1234"; // 데이터베이스 비밀번호

    public static void main(String[] args) { // 프로그램 실행 진입점
        try (Scanner scanner = new Scanner(System.in)) { // Scanner를 try-with-resources로 선언하여 자동으로 닫히게 설정
            while (true) { // 무한 루프를 사용하여 메뉴 반복 출력
                // 메뉴 출력
                System.out.println("\n=== Student CRUD Menu ===");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt(); // 사용자로부터 메뉴 선택 입력 받음
                scanner.nextLine(); // 버퍼에 남아있는 줄바꿈 문자 제거

                switch (choice) { // 선택한 옵션에 따라 동작 분기
                    case 1:
                        addStudent(scanner); // 학생 추가 기능 호출
                        break;
                    case 2:
                        viewStudents(); // 학생 조회 기능 호출
                        break;
                    case 3:
                        updateStudent(scanner); // 학생 수정 기능 호출
                        break;
                    case 4:
                        deleteStudent(scanner); // 학생 삭제 기능 호출
                        break;
                    case 5:
                        System.out.println("Exiting..."); // 종료 메시지 출력
                        return; // 프로그램 종료
                    default:
                        System.out.println("Invalid choice. Try again."); // 잘못된 입력 메시지 출력
                }
            }
        }
    }

    // 학생 추가 기능
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter name: "); // 학생 이름 입력 요청
        String name = scanner.nextLine(); // 사용자로부터 이름 입력받기
        System.out.print("Enter age: "); // 학생 나이 입력 요청
        int age = scanner.nextInt(); // 사용자로부터 나이 입력받기
        scanner.nextLine(); // 버퍼에 남아있는 줄바꿈 문자 제거
        System.out.print("Enter major: "); // 학생 전공 입력 요청
        String major = scanner.nextLine(); // 사용자로부터 전공 입력받기

        // SQL INSERT 쿼리 준비
        String query = "INSERT INTO students (name, age, major) VALUES (?, ?, ?)";

        // 데이터베이스 연결 및 쿼리 실행
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스 연결 생성
             PreparedStatement pstmt = conn.prepareStatement(query)) { // PreparedStatement 객체 생성
            pstmt.setString(1, name); // 첫 번째 파라미터에 이름 설정
            pstmt.setInt(2, age); // 두 번째 파라미터에 나이 설정
            pstmt.setString(3, major); // 세 번째 파라미터에 전공 설정
            int rowsAffected = pstmt.executeUpdate(); // 쿼리 실행 및 영향받은 행 수 반환
            System.out.println(rowsAffected + " student(s) added."); // 결과 출력
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 발생 시 스택 트레이스 출력
        }
    }

    // 학생 조회 기능
    private static void viewStudents() {
        // SQL SELECT 쿼리 준비
        String query = "SELECT * FROM students";

        // 데이터베이스 연결 및 쿼리 실행
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스 연결 생성
             Statement stmt = conn.createStatement(); // Statement 객체 생성
             ResultSet rs = stmt.executeQuery(query)) { // 쿼리 실행 및 결과 집합 반환

            // 결과 출력
            System.out.println("\nID | Name       | Age | Major");
            System.out.println("----------------------------------");
            while (rs.next()) { // 결과 집합에서 다음 행으로 이동
                int id = rs.getInt("id"); // id 열 값 가져오기
                String name = rs.getString("name"); // name 열 값 가져오기
                int age = rs.getInt("age"); // age 열 값 가져오기
                String major = rs.getString("major"); // major 열 값 가져오기
                System.out.printf("%d | %s | %d | %s%n", id, name, age, major); // 형식화된 결과 출력
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 발생 시 스택 트레이스 출력
        }
    }

    // 학생 수정 기능
    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID to update: "); // 수정할 학생 ID 입력 요청
        int id = scanner.nextInt(); // 사용자로부터 ID 입력받기
        scanner.nextLine(); // 버퍼에 남아있는 줄바꿈 문자 제거
        System.out.print("Enter new name: "); // 새 이름 입력 요청
        String name = scanner.nextLine(); // 사용자로부터 새 이름 입력받기
        System.out.print("Enter new age: "); // 새 나이 입력 요청
        int age = scanner.nextInt(); // 사용자로부터 새 나이 입력받기
        scanner.nextLine(); // 버퍼에 남아있는 줄바꿈 문자 제거
        System.out.print("Enter new major: "); // 새 전공 입력 요청
        String major = scanner.nextLine(); // 사용자로부터 새 전공 입력받기

        // SQL UPDATE 쿼리 준비
        String query = "UPDATE students SET name = ?, age = ?, major = ? WHERE id = ?";

        // 데이터베이스 연결 및 쿼리 실행
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스 연결 생성
             PreparedStatement pstmt = conn.prepareStatement(query)) { // PreparedStatement 객체 생성
            pstmt.setString(1, name); // 첫 번째 파라미터에 새 이름 설정
            pstmt.setInt(2, age); // 두 번째 파라미터에 새 나이 설정
            pstmt.setString(3, major); // 세 번째 파라미터에 새 전공 설정
            pstmt.setInt(4, id); // 네 번째 파라미터에 ID 설정
            int rowsAffected = pstmt.executeUpdate(); // 쿼리 실행 및 영향받은 행 수 반환
            System.out.println(rowsAffected + " student(s) updated."); // 결과 출력
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 발생 시 스택 트레이스 출력
        }
    }

    // 학생 삭제 기능
    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: "); // 삭제할 학생 ID 입력 요청
        int id = scanner.nextInt(); // 사용자로부터 ID 입력받기

        // SQL DELETE 쿼리 준비
        String query = "DELETE FROM students WHERE id = ?";

        // 데이터베이스 연결 및 쿼리 실행
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스 연결 생성
             PreparedStatement pstmt = conn.prepareStatement(query)) { // PreparedStatement 객체 생성
            pstmt.setInt(1, id); // 첫 번째 파라미터에 ID 설정
            int rowsAffected = pstmt.executeUpdate(); // 쿼리 실행 및 영향받은 행 수 반환
            System.out.println(rowsAffected + " student(s) deleted."); // 결과 출력
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 발생 시 스택 트레이스 출력
        }
    }
}
