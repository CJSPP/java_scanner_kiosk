package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Order {

    //대기 번호를 위한 변수
    int count = 1;

    // 장바구니에 담기는 상품목록
    List<Product> productList = new ArrayList<>();

    //장바구니에 담겨있는 상품을 가져오기 위한 주문목록(주문취소 & 총 판매금액 & 총 판매상품)
    List<Product> orderList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    String[] burger_name = {"ShackBurger", "SmokeShack", "Shroom Burger", "Cheeseburger", "Hamburger"};
    double[] burger_price = {6.9, 8.9, 9.4, 6.9, 5.4};
    String[] burger_comment = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거",
            "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
            "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
            "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
            "비프패티를 기반으로 야채가 들어간 기본버거"};

    /*맨 처음에는 기본 생성자 Order()를 main 클래스에서 호출했지만
     그렇게 하면 장바구니(=List)에 하나가 담길 때 마다 새로운 객체를
     호출해야 하기 때문에(new Order();) 일반 메소드로 바꿔서 호출했다.
     */
    public void a() {
        boolean stop = true;
        while (stop) {
            mainMenu(); //메인 메뉴판 호출
            int num = sc.nextInt();
            switch (num) {

                case 0:
                    //총 판매금액 & 총 판매상품목록 조회
                    total_product();

                case 1:
                    burgerMenu(); //버거 메뉴판 호출
                    break;
                case 2:
                    System.out.println("미완성입니다..");
                    break;
                case 3:
                    System.out.println("미완성입니다..");
                    break;
                case 4:
                    System.out.println("미완성입니다..");
                    break;
                case 5:
                    // 장바구니 조회 및 주문                    
                    show_basket();
                    break;
                case 6:
                    // 주문 취소                    
                    cancel_order();
                    break;
            }
        }
    }


    //메인 메뉴판
    private void mainMenu() {
        System.out.println("\n" + "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"" + "\n"
                + "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
                "[ SHAKESHACK MENU ]\n" +
                "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
                "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
                "3. Drinks          | 매장에서 직접 만드는 음료\n" +
                "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
                "\n" +
                "[ ORDER MENU ]\n" +
                "5. Order       | 장바구니를 확인 후 주문합니다.\n" +
                "6. Cancel      | 진행중인 주문을 취소합니다.");
    }

    // 버거 메뉴판
    /*같은 코드가 중복되서 좋은 코드는 아니지만 스캐너 변수인
     num을 add_basket(int num) 메소드에 파라미터로 전달하기위함이다.*/
    private void burgerMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다." + "\n" +
                "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요." + "\n" +
                "[ Burgers MENU ]\n" +
                "1. ShackBurger   | W" + 6.9 + " | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                "2. SmokeShack    | W" + 8.9 + " | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                "3. Shroom Burger | W" + 9.4 + " | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거\n" +
                "4. Cheeseburger  | W" + 6.9 + " | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                "5. Hamburger     | W" + 5.4 + " | 비프패티를 기반으로 야채가 들어간 기본버거 \n" +
                "6. 뒤로가기");


        while (true) {
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    add_basket(num);
                    break;
                case 2:
                    add_basket(num);
                    break;
                case 3:
                    add_basket(num);
                    break;
                case 4:
                    add_basket(num);
                    break;
                case 5:
                    add_basket(num);
                    break;

                case 6:
                    System.out.println("메뉴판으로 이동합니다.");
                    a();
                    break;
            }
        }
    }

    //장바구니 추가
    //bugerMenu에서 스캐너 객체로 입력받은 num을 가져와서 배열의 인덱스로 지정해주었다.
    public void add_basket(int num) {
        System.out.println("\"" + burger_name[num - 1] + "     | W " + burger_price[num - 1] + " | " + burger_comment[num - 1] + "\"" +
                "\n" +
                "위 메뉴를 장바구니에 추가하시겠습니까?" + "\n" +
                "1. 확인        2. 취소");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int num2 = sc.nextInt();
            switch (num2) {
                case 1:

                    int count = 0;

                    //Product 객체(자식클래스)를 호출하고 값을 저장한 다음, 장바구니(productList)에 상품을 담는다.
                    Product product = new Product(burger_name[num - 1], burger_price[num - 1], burger_comment[num - 1]);
                    productList.add(new Product(product.getName(), product.getPrice(), product.getComment()));

                    System.out.println(burger_name[num - 1] + " 가 장바구니에 추가되었습니다.");
                    a();
                    break;

                case 2:
                    System.out.println("취소되었습니다.");
                    burgerMenu();
                    break;
            }
        }
    }

    //    productList에 추가된(=장바구니에 추가된) 목록을 for문을 이용해서 보여준다. + 주문완료 화면 + 장바구니 삭제
    public void show_basket() {
        double total_price = 0;

        if (productList.size() == 0) {
            System.out.println("장바구니에 담긴 상품이 없습니다." + "\n");
        }

        System.out.println("[ Orders ]");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getName() + "   | W "
                    + productList.get(i).getPrice() + " | "
                    + productList.get(i).getComment());


            total_price += productList.get(i).getPrice();
        }
        System.out.println("[ Total ]");


        System.out.print("W ");

        /*  더블형이기 때문에 총 가격을 더하다 보면 둘째 자리 이상이 보일 때가 있으므로
    String.format으로 소수점 첫째 자리까지 반올림을 해준다.*/
        System.out.println(String.format("%.1f", total_price));
        System.out.println();
        System.out.println("1. 주문      2. 메뉴판");
        int num = sc.nextInt();

        //Thread.sleep(3000)의 예외 처리
        try {
            //에러가 발생할 수 있는 코드
            switch (num) {
                case 1 -> {

                    /*장바구니에 상품이 담겨있지 않아도 대기번호가 발급 되는 오류가 있어서
                     if문으로 productList의 길이가 0이라면(=장바구니에 아무것도 없다면)*/
                    if (productList.size() == 0) {

                        System.out.println("상품을 장바구니에 담아주세요.");

                    } else if (productList.size() > 0) {

                        //장바구니 목록을 주문 목록으로 복사(주문 내역 취소 & 총 판매금액 & 총 상품판매목록 조회에서 사용)
                        orderList.addAll(productList);
                        
                          /*Try Catch문이 제대로 동작하는지 확인을 위한 테스트 코드
                          (이 코드로 테스트 하려면 orderList.addAll(productList); 주석처리 하고
                           밑에 있는 코드를 주석처리 해제)
                           단, .size()를 제거하면 정상적으로 복사가 됨.*/
//                        orderList = new ArrayList<>(productList);
//                        Collections.copy(orderList, productList);

                        //장바구니에 담긴 상품목록 초기화
                        productList.clear();

                        System.out.println("주문이 완료되었습니다!");
                        System.out.println("대기번호는 [ " + count + " ] 번 입니다.");
                        System.out.println("3초후 메뉴판으로 돌아갑니다.");

                        //3초 시간 지연
                        Thread.sleep(3000);

                        count++;
                    }
                }
                case 2 -> {
                    System.out.println("메뉴판으로 이동합니다.");
                    System.out.println();
                    a();
                }
            }

        } catch (Exception e) {

            //오류 출력(방법은 여러가지)
            e.printStackTrace();
            System.out.println("오류가 발생하여 처음 화면으로 이동합니다.");
            a();

        }
    }

    // 주문 상품 취소
    public void cancel_order() {
        System.out.println("진행하던 주문을 취소하시겠습니까? \n" +
                "1. 확인        2. 취소");

        int num = sc.nextInt();

        switch (num) {
            case 1:
                //주문한 상품이 없다면 메뉴판으로 이동, 상품이 있다면 주문 취소
                if (orderList.size() == 0) {
                    System.out.println("주문된 상품이 없습니다. 메뉴판으로 이동합니다.");
                    a();

                } else {

                    //최근에 주문했던 것을 취소(= orderList 맨 마지막 인덱스 값 제거)
                    orderList.remove(orderList.size() - 1);
                    count--;
                    System.out.println("진행하던 주문이 취소되었습니다.");
                    a();
                }
            case 2:
                System.out.println("메뉴판으로 이동합니다.");
                a();
        }
    }

    // 총 판매금액 & 총 판매상품목록 조회
    public void total_product() {

        //총 판매 가격
        double total_price = 0;
        for (int i = 0; i < orderList.size(); i++) {
            total_price += orderList.get(i).getPrice();
        }
        System.out.println("[ 총 판매금액 현황 ] \n" +
                "현재까지 총 판매된 금액은 [ W " + String.format("%.1f", total_price) + " ]입니다 \n \n" +
                "[ 총 판매상품 목록 현황 ] \n" +
                "현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");

        // 총 판매 상품
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println("- " + orderList.get(i).getName() + "   | W "
                    + orderList.get(i).getPrice());
        }
        System.out.println("\n" + "1. 돌아가기");

        int num = sc.nextInt();

        if (num == 1) {
            System.out.println("메뉴판으로 이동합니다.\n");
            a();
        }
    }
}



