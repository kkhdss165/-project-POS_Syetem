# POS_Syetem
4학년 1학기 '스프링프레임워크' 기말 프로젝트

# <소개>
- 스프링프레임워크(Spring framework) POS 시스템(Point of Sale System) 프로젝트
- 데이터베이스(MySQL)를 활용하여, 회원, 상품, 재고의 CRUD 구현
- POS 시스템의 기본적인 계정, 재고 관리, 판매, 통계 기능 구현
- 웹서버는 <a href = "Apache Tomcat" >Apache Tomcat</a>을 사용

  ## 객체
    - 시스템의 CRUD를 위한 객체 (데이터베이스 테이블과 그에 매칭되는 자바 클래스)
    
    ### Member (<a href = "https://github.com/kkhdss165/-project-POS_Syetem/blob/main/src/main/java/object/Member.java">Member.java</a>에 매칭)
    
     <img src="./readme_images/table_member.png">
     
     - member_ID : 계정 아이디 (Primary Key)
     - member_PW : 계정 비밀번호
     - member_role : 계정 직위 (종류 : admin, manager, parttimer)(시스템 접근권한 차등)
     - member_name : 계정 이름
     - member_address : 주소
     - member_phone : 연락처
     - member_datetime : 생성시간(입사일)
     
    ### Product (<a href = "https://github.com/kkhdss165/-project-POS_Syetem/blob/main/src/main/java/object/Product.java">Product.java</a>에 매칭)
     
     <img src="./readme_images/table_product.png">
     
     - product_ID : 제품코드 (Primary Key)
     - product_name : 제품명
     - product_manufacturer : 제조사
     - product_price : 제품 가격
     - product_stocks : 제품 수량(재고)
     - prodcut_datetime : 입고일(재입고일)
     
    ### Recode (<a href = "https://github.com/kkhdss165/-project-POS_Syetem/blob/main/src/main/java/object/Recode.java">Recode.java</a>에 매칭)
    
     <img src="./readme_images/table_recode.png">
     
     - recode_ID : 판매기록 아이디 (Primary Key)(Auto_Increment)
     - product_ID : 제품코드
     - product_name : 제품명
     - product_manufacturer : 제조사
     - product_price : 제품 가격
     - sell_amount : 판매량
     - recode_datetime : 판매시간
     - recode_type : 판매기록 종류( normal: 정상거래, refund: 환불)
  
  # 기능
    <img src="./readme_images/login.gif">
    
    - POS시스템은 로그인 후 사용 가능

   ## 1) 판매기능
   
    ### 1) 판매기능 - 재고목록(홈)
    <img src="./readme_images/sell_list.gif">
   
    ### 1) 판매기능 - 제품판매
    <img src="./readme_images/sell_sell.gif">
    
    ### 1) 판매기능 - 기록조회
    <img src="./readme_images/sell_recode.gif">   
    
    ### 1) 판매기능 - 제품환불
    <img src="./readme_images/sell_refund.gif">
    

   
   ## 2) 재고관리기능
   <img src="./readme_images/rolediff_stock.gif">
   
   - **계정직위에 따라 기능접근권한 차등**
   - 재고수정/재고삭제 -> 관리자 기능


    ### 2) 재고관리기능 - 재고목록(홈)
    <img src="./readme_images/stock_list.gif">
   
    ### 2) 재고관리기능 - 신규입고
    <img src="./readme_images/stock_new.gif">
    
    ### 2) 재고관리기능 - 재입고
    <img src="./readme_images/stock_restock.gif">
    
    ### 2) 재고관리기능 - 재고수정
    <img src="./readme_images/stock_edit.gif">

    ### 2) 재고관리기능 - 재고삭제
    <img src="./readme_images/stock_delete.gif">
    
   
   ## 3) 계정관리기능
   <img src="./readme_images/rolediff_member.gif">
   
   - **계정직위에 따라 기능접근권한 차등**
   - 계정생성/계정목록/계정삭제 -> 관리자 기능
   
   
    ### 3) 계정관리기능 - 계정정보수정(홈)
    <img src="./readme_images/member_edit.gif">
   
    ### 3) 계정관리기능 - 계정생성/계정목록
    <img src="./readme_images/member_new.gif">
    
    ### 3) 재고관리기능 - 계정삭제
    <img src="./readme_images/member_delete.gif">
    
    
   ## 4) 통계기능
   
    ### 4) 통계기능 - 통계메인(홈)
    <img src="./readme_images/stat_main.gif">
   
    ### 4) 통계기능 - 시간별통계
     - 정상적인 판매기록에 대해서만 통계(환불기록은 제외)
     - member테이블의 recode_datetime을 문자열로 변경 후 시간에 따라 필요한 시간(문자열) 추출하여 통계
    
     #### 4) 통계기능 - 시간별통계 - 연간
     <img src="./readme_images/state_year.jpg">
     
     #### 4) 통계기능 - 시간별통계 - 월간
     <img src="./readme_images/stat_month.jpg">
     
     #### 4) 통계기능 - 시간별통계 - 주간
     <img src="./readme_images/stat_week.jpg">
     
     - **LocalDateTime.plusWeeks 사용하여 구현**
     
     #### 4) 통계기능 - 시간별통계 - 일간
     <img src="./readme_images/stat_day.jpg">
    
    
    ### 4) 통계기능 - 수치적통계
    
     #### 4) 통계기능 - 수치적통계 - 판매량순
     <img src="./readme_images/stat_quantity.jpg">
     
     #### 4) 통계기능 - 수치적통계 - 판매액순
     <img src="./readme_images/stat_total.jpg">
    

  ## 어려웠던점
  - 주간 통계 구현 >> LocalDateTime.plusWeeks 사용하여 구현
  
## <개발환경>
- IDE : Eclipse
- Web Server : Apache Tomcat
- Hardware : AMD RYZEN 2200G(4core) RAM 8GB

## <개발기간>
- 2022년 6월(1주)

## <참조>
- <a href = "https://github.com/kkhdss165/-project-POS_Syetem/blob/main/report/%EA%B0%9C%EB%B0%9C%EB%B3%B4%EA%B3%A0%EC%84%9C.pdf">개발보고서</a>
- <a href = "https://github.com/kkhdss165/-project-POS_Syetem/blob/main/report/%EC%82%AC%EC%9A%A9%EC%9E%90%EB%A9%94%EB%89%B4%EC%96%BC.pdf">사용자메뉴얼</a>
