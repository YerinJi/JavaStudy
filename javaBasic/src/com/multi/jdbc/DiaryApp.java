package com.multi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class DiaryApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/spring";
    private static final String DB_USER = "root"; // 데이터베이스 사용자 이름
    private static final String DB_PASSWORD = "1234"; // 데이터베이스 비밀번호

    // 4. 일기 삭제
    private static void deleteDiary(Scanner scanner) {
        System.out.print("삭제할 일기 ID: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM diary WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            System.out.println(rows + "개의 일기가 삭제되었습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. 일기 수정
    private static void updateDiary(Scanner scanner) {
        System.out.print("수정할 일기 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        System.out.print("새 제목: ");
        String newTitle = scanner.nextLine();
        System.out.print("새 내용: ");
        String newContent = scanner.nextLine();

        String query = "UPDATE diary SET title = ?, content = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, newTitle);
            statement.setString(2, newContent);
            statement.setInt(3, id);
            int rows = statement.executeUpdate();
            System.out.println(rows + "개의 일기가 수정되었습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createDiary(Scanner scanner) {
        System.out.print("제목: ");
        String title = scanner.next();
        System.out.print("내용: ");
        String content = scanner.next();
        String query="INSERT INTO DIARY(TITLE,CONTENT) VALUES(?,?)";
        try(Connection connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){

            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, content);
            int rows=statement.executeUpdate();
            System.out.println(rows+"개의 일기가 추가되었습니다");
        }catch(Exception e) {
            e.printStackTrace();

        }

    }
    private static void readDiary() {
        String query = "SELECT * FROM diary ORDER BY created_at DESC";
        try(Connection connection=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println("\n=== 저장된 일기 ===");
            while(resultSet.next()) {
                int id=resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                System.out.println("ID: " + id);
                System.out.println("제목: " + title);
                System.out.println("내용: " + content);
                System.out.println("작성일: " + createdAt);
                System.out.println("-------------------------");

            }

        }catch(Exception e) {
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        try(Scanner scanner=new Scanner(System.in)){
            while(true) {
                System.out.println("\n=== 일기장 프로그램 ===");
                System.out.println("1. 일기 추가");
                System.out.println("2. 일기 조회");
                System.out.println("3. 일기 수정");
                System.out.println("4. 일기 삭제");
                System.out.println("5. 종료");
                System.out.print("선택: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createDiary(scanner);
                        break;
                    case 2:
                        readDiary();
                        break;
                    case 3:
                        updateDiary(scanner);
                        break;
                    case 4:
                        deleteDiary(scanner);
                        break;
                    case 5:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("올바른 선택이 아닙니다.");
                }
            }

        }catch(Exception e) {

        }
    }


}



