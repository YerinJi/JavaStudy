package com.multi.designpattern;

//서비스 인터페이스
interface Service{
    void execute();
}
//서비스 구현 클래스
class ServiceImpl implements Service{
    @Override
    public void execute() {
        System.out.println("Executing Service");
    }
}
//클라이언트 클래스
class Client{
    private final Service service;

    //생성자를 통한 의존성 주입
    public Client(Service service){
        this.service = service;
    }

    public void performTask(){
        service.execute();
    }
}
//사용 예
public class ServiceMain {
    public static void main(String[] args) {
        //의존성을 외부에서 주입
        Service service = new ServiceImpl();
        Client client = new Client(service);
        client.performTask();
    }
}
