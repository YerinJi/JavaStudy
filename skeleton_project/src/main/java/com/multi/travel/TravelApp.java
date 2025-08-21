package com.multi.travel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TravelApp {
    static final String URL = "jdbc:mysql://localhost:3306/travel_db?useSSL=false&serverTimezone=Asia/Seoul";
    static final String USER = "root";
    static final String PASS = "1234";

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS); Scanner sc = new Scanner(System.in)) {
            TravelService service = new TravelService(conn);
            while(true) {
                System.out.println("\n== TravelApp ==");
                System.out.println("1. 전체 목록");
                System.out.println("2. 권역별 목록 (권역입력)");
                System.out.println("3. 키워드 검색 (관광지/설명/주소)");
                System.out.println("4. 새 관광지 등록");
                System.out.println("5. 관광지 수정");
                System.out.println("6. 관광지 삭제");
                System.out.println("0. TravelApp 종료");
                System.out.print("번호를 선택해주세요: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1": showAllPage(service,sc); break;
                    case "2": inputDistrict(service,sc); break;
                    case "3": inputKeyword(service,sc); break;
                    case "4": createTravel(service,sc); break;
                    case "5": updateTravel(service,sc); break;
                    case "6": deleteTravel(service,sc); break;
                    default:
                        System.exit(0);

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showAllPage(TravelService service,Scanner sc) throws SQLException {
        System.out.print("시작 페이지 :");
        int page = sc.nextInt();
        System.out.print("페이지당 보여줄 개수 : ");
        int pagesize = sc.nextInt();
        sc.nextLine();
        var rows = service.getAllPage(page, pagesize);
        System.out.println(rows);

    }

    private static void inputDistrict(TravelService service, Scanner sc) throws SQLException {
        System.out.print("권역 입력(수도권/충청권/전라권/경상권/강원권/제주권): ");
        String district = sc.nextLine();
        var rows = service.getDistrictpage(district);
        System.out.println(rows);
    }

    private static void inputKeyword(TravelService service, Scanner sc) throws SQLException {
        System.out.print("키워드를 입력해주세요(제목/설명/주소): ");
        String keyword = sc.nextLine();
        var rows = service.searchKeyword(keyword);
        System.out.println(rows);
    }

    private static void createTravel(TravelService service, Scanner sc) throws SQLException {
        System.out.println("새로운 관광지를 추가합니다.");
        System.out.print("권역 : ");
        String district = sc.nextLine();
        System.out.print("관광지명: ");
        String title = sc.nextLine();
        System.out.print("관광지 설명: ");
        String description = sc.nextLine();
        System.out.print("관광지 주소: ");
        String address = sc.nextLine();
        System.out.print("연락처: ");
        String phone = sc.nextLine();
        service.createTravel(district, title, description, address, phone);
    }

    private static void updateTravel(TravelService service, Scanner sc) throws SQLException {
        System.out.println("관광지를 수정합니다.");
        System.out.print("수정할 관광지의 번호를 입력해주세요: ");
        int no = sc.nextInt();
        sc.nextLine();
        System.out.print("권역 : ");
        String district = sc.nextLine();
        System.out.print("관광지명: ");
        String title = sc.nextLine();
        System.out.print("관광지 설명: ");
        String description = sc.nextLine();
        System.out.print("관광지 주소: ");
        String address = sc.nextLine();
        System.out.print("연락처: ");
        String phone = sc.nextLine();
        service.updateTravel(no, district, title, description, address, phone);
    }

    private static void deleteTravel(TravelService service, Scanner sc) throws SQLException {
        System.out.println("관광지를 삭제합니다.");
        System.out.print("삭제할 관광지의 번호를 입력해주세요: ");
        int no =  sc.nextInt();
        sc.nextLine();
        service.deleteTravel(no);
        System.out.println("삭제완료");
    }


}
