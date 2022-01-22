# TrainTicketing 
#### 자동 및 입석 예약 가능 열차 예매 시스템
해당 프로젝트는 요구사항 분석, 설계, 구현의 과정을 정의하고 문서화하는 시스템 분석 및 설계의 관점에서 작성되었습니다.
프로그램의 구현 내용의 간단한 화면설명은 및 입출력 정의는 "요약"에서 
설계과정과 개발시 문제해결 과정은 "문서"에서 확인할 수 있습니다.

## 요약
1. 로그인
<img src = "https://user-images.githubusercontent.com/81247213/147555822-f8885bd1-957b-43ce-b8ed-f109bef3debc.png" width ="200" height ="300" />

- 등록된 ID와 Password 와 다른 ID와 Password 를 입력한 경우 로그인이 되지 않는다.
- 로그인 창에서 ‘회원가입’ 버튼을 누르면 회원가입 창으로 넘어간다.
- ‘로그인’ 버튼을 누르면 열차 조회하는 창으로 넘어간다.

2. 회원가입

<img src = "https://user-images.githubusercontent.com/81247213/147558562-93e91bf2-48b7-48c4-97ce-5b268230989b.png" width ="200" height ="300" /><img src = "https://user-images.githubusercontent.com/81247213/147558595-7ac157ca-247d-4482-bc21-2e5880af6244.png" width ="120" height ="100" /><img src = "https://user-images.githubusercontent.com/81247213/147558692-bd2aebab-e14d-4f4c-a004-e5cc10590258.png" width ="120" height ="100" /><img src = "https://user-images.githubusercontent.com/81247213/147558719-ee49dd83-8c09-43e0-acd7-af9f5f53c0db.png" width ="120" height ="100" />

- ID와 Password를 모두 입력하지 않을 경우 2-1과 같은 경고창이 뜬다.
- 회원 가입이 완료되었을 경우 2-2와 같은 경고창이 뜬다.
- 이미 존재하는 ID로 가입할 경우 2-3과 같은 경고창이 뜬다.
- 가입된 ID와 Password 는 Login.csv 파일에 저장된다.

3. 열차 조회하기

<img src = "https://user-images.githubusercontent.com/81247213/147558877-679a0980-1487-42b4-b6e2-7d7dcfb16a09.png" width ="200" height ="300" /><img src = "https://user-images.githubusercontent.com/81247213/147558882-173d07c3-ba94-432b-8e93-c1bf7eb41c25.png" width ="120" height ="100" />

- 출발지, 도착지, 승객 수 등 모든 정보 미입력 시 3-1과 같은 경고창이 생성된다. 
- 경부선(서울역, 대전역, 구미역, 대구역, 부산역), 호남선(서대전역, 논산역, 익산역, 광주역, 목포역)이 있다. - 출발지 선택 시 출발지가 경부선일 경우 도착지 combobox에 경부선 기차역이 입력되고, 호남선일 경우 도
착지 combobox에 호남선 기차역이 입력된다.
- ‘조회하기’ 버튼을 누를 경우 입력된 정보에 맞는 열차가 출력된다.

4. 열차 출력

<img src = "https://user-images.githubusercontent.com/81247213/147559193-f22e7f40-b2c8-4aa3-ae06-011a0104c150.png" width ="200" height ="300" /><img src = "user-images.githubusercontent.com/81247213/147559197-a0a18d93-2293-4daa-a32f-ac1dd11c97bb.png" width ="120" height ="100" /><img src = "https://user-images.githubusercontent.com/81247213/147559200-9800a28f-8dbc-45a6-9aee-88909d69ac31.png" width ="120" height ="100" />

- 열차 조회하기에서 입력된 데이터에 맞는 열차가 출력된다.
- 매진된 열차 선택 시 4-1과 같은 팝업창이 생성된다. 
- 입석이 매진일 경우 4-2와 같은 경고창이 생성된다. 
- ‘선택’ 버튼을 누를 경우 좌석 선택창으로 넘어간다. 
- 이전 단계로 돌아갈 수 있다.

5. 좌석선택

<img src = "https://user-images.githubusercontent.com/81247213/147559301-19db7060-267b-469e-9b41-0fa3d1f932a3.png" width ="200" height ="300" />

- 1호 차부터 3호 차까지 선택할 수 있다. 
- 이전 단계로 돌아갈 수 있다. 
- 열차 정보 및 좌석 정보와 함께 reservation.csv 에 저장되고 train.csv 의 좌석 인덱스가 줄어든다. 
- 예매된 좌석, 실시간으로 예매한 좌석은 버튼이 비 활성화 된다.

6. 예매 내역 보기

<img src = "https://user-images.githubusercontent.com/81247213/147559371-4d93bdf4-7c17-4755-9f28-b16cc8cee7f3.png" width ="200" height ="300" />

-  로그인한 사용자의 출발지, 도착지, 날짜, 열차 정보 및 좌석 정보가 출력된다. 
-  ‘반환’ 버튼을 눌러 예매 취소가 가능하다. 
-  ‘반환’ 버튼을 선택할 시 조회하기 창으로 돌아간다. 
-  자동 예약 대기자는 해당 표를가진 유저가 “반환”할 때 즉시 해당 좌석을 받는다 
-  
## 문서

### 1. 서 론
#### 1-1. 개발 동기
기존의 철도 예약 서비스(코레일톡)를 사용하면서 불편함을 느꼈다. 매진된 표가 풀릴 경우 자동예약이 불
가능한 점과 입석 예매가 불가능한 부분에서 불편함을 느꼈다. 이러한 기존의 서비스의 불편한 점을 해결
하고자 개발하게 되었다. 

#### 1-2. 개발 목표
열차를 예약할 수 있는 GUI 프로그램을 구현하여 사용자에게 편리한 철도 예약 서비스를 제공하고자 한
다. 편리한 기차표 예약을 위한 기존서비스 기능 구현과 매진된 표 자동 예약기능 및 현장에서만 발권 가
능한 입석 예매 기능을 추가하여 기존의 철도 예약 서비스의 불편함을 제거하고자 한다.

#### 1-3. 개발하는 과제의 관련 기술현황
현재 철도 예약 서비스가 앱 및 특정 인터넷 사이트에서 이용할 수 있다. 

### 2. 작품 개요
사용자는 회원가입 하여 사용자를 등록한 후 로그인한다. 로그인한 후 출발지, 도착지, 시간, 승객 수를 입
력하여 열차를 조회한다. 이 시스템에서 사용자가 입력한 정보에 맞는 기차가 출력된다. 사용자는 원하는 
열차를 선택해 좌석을 예매한다. 이 예매한 내역 또한 볼 수 있다.

### 3. 기능 및 요구사항 분석
#### 3-1. 요구사항 분석
- 요구사항
  - 출발지, 도착지, 일시, 인원 선택
  - 로그인 및 회원가입 기능
  - 선택 목록에 맞는 열차 정보 출력 후 열차 선택
  - 좌석선택, 좌석 중복방지
  - 예약 내역 출력 확인
  - 매 단계마다 이전 단계로 돌아갈 수 있음. 
  - 2개 이상의 노선을 구현해야 함. 8. 매진열차에 대해 자동예약, 입석예약 기능 제공
- 로그인 상세화
  - 등록된 ID가 아닌 경우 로그인 불가능
  - Password가 틀린 경우 로그인 불가능
- 회원가입 상세화 
  - ID 및 Password 미입력 시 “모든 정보를 입력해주세요.”라는 경고창이 생성. 
  - 이미 존재하는 ID로 회원가입 시 “이미 존재하는 ID입니다.”라는 경고창이 생성. 
  - ID와 Password의 정보는 Login.csv 에 저장됨. 
- 열차 예매 상세화
  - 1인당 표 수 10장 미만으로 제약함. 해당 ID의 기존표 + 현재 화면에 입력되는 표 개수의 합이 10장 이상이라면 “10장 미만의 표만 예매 가능합니다.”라는 경고창 생성. 
  - 열차 조회 시 출발지, 도착지, 일시, 표 수 등 데이터 미입력 시 “모든 정보를 입력해주세요.”라는 경고창 생성. 
  - 열차 노선은 경부선(서울역, 대전역, 구미역, 대구역, 부산역), 호남선(서대전역, 논산역, 익산역, 광주역, 목
포역)이 있음 
  - 열차 노선 데이터만 추가해주면 별도의 변경없이 확장 가능
  - 열차 정보는 train_list.csv 에 저장된 데이터를 출력
  - 매진된 기차 선택 시 ‘자동예약’ 또는 ‘입석 예약’ 선택 창이 생성. 
  - 예매 내역은 열차 정보 및 좌석 정보와 함께 reservation.csv 에 저장됨. 
  - 모든 예매, 반환에 대해 train.csv의 남은 좌석, 입석의 데이터변경이 이루어짐
- 좌석 선택 상세화
  - 1호 차, 2호 차, 3호 차가 있고 각 호차마다 20개의 좌석이 존재함.  
  - 이미 예약된 좌석은 예약 불가(버튼 비활성화)
   
- 예매 내역 출력 상세화
  - 로그인한 사용자가 예매한 날짜, 출발지, 도착지, 출발시간, 도착시간, 열차 번호 및 좌석 정보 등이 출
력됨. 
  - 반환 버튼을 통해 예매 취소 가능.
### 4. 설계
#### 4-1. 자료 구조

![image](https://user-images.githubusercontent.com/81247213/147559942-6d4095cb-45bb-4e62-88cb-0291260c14cd.png)

#### 4-2. 알고리즘 설계

![image](https://user-images.githubusercontent.com/81247213/147559980-f3c23db7-7591-4864-a613-7127339f1c2f.png)

#### 4-3. 프로그램 구조

![image](https://user-images.githubusercontent.com/81247213/147560035-3486b9fc-3018-42b2-8884-2b9321d6e0ba.png)

- public class GUI
  - change() :panel을 삭제, 변경하는 형식으로 화면 전환을 해준다. 
  - merge_reservation(): 예약내역 저장, readbyID 재호출
  - merge_train(): tarin.csv 의 남은 좌석, 입석 데이터 관리
- class base_panel
  - CommonStyle(): 각 화면들이 기본적으로 가지는 화면세팅을 해준다. 
  - 그 외 상속으로 활용될 변수들 선언되어 있음 
- class Current_info
  - re_tiket(): 티켓 반환시 필요한 조건과 이벤트 처리
- class Join_panel
  - go_login(): 로그인 화면으로 이동
  - new_join_action(): 회원정보 검사, Login파일 생성 or 데이터 추가
- class Login_panel
  - Join(): 회원가입 화면으로 이동
  - Login(): 로그인 검사, 메인화면으로 이동, id값으로 readById()
- class Search_Panel
  - go_listpanel(): 입력데이터 검사, listpanel로 이동
  - route_select(): JComboBox 출발역 선택시 노선에따른 도착역 생성
- class Seat_list
  - seat_button_action(): 좌석 클릭시 예매
- class Train_lsit
  - go_seat_list(): “선택”버튼의 이벤트, 해당하는 열차의 seatlist로 이동
  - sold_out(): “매진”버튼의 이벤트, 매진열차에대한 dialog 생성
- file_read():파일 읽기
- file_write():파일 쓰기
- file_delete_reservation(): 예약내역 1행 삭제
- file_point_replace(): 예약내역 or 기차내역 1셀만 지정 변경
- readByID(): 로그인된 ID값의 예약내역 read

#### 4-4. 설계 구성 요소
- 목표 설정
  - 출발지, 도착지, 일시, 인원을 선택하여 예약이 가능하게 한다. 
  - 가능 열차 출력을 하여 지정 일시 이후에 출발하는 모든 열차의 정보 출력하도록 구현. 
  - 좌석선택 사용자가 좌석 선택을 요구하는 경우 빈 좌석 상황을 출력하고 선택을 받아 기록한다. 좌석을 선택하지 않을 시 프로그램의 판단에 따라 좌석을 배정한다. 이때 좌석에 따른 우선순위를 정해 되도록 좋은 자리로 배정한다. (X) 
  - 예약 내역을 출력하여 재확인한다. 사용자가 취소할 경우 예약 첫 단계부터 다시 시작한다. 
  - 각 단계에서 이전 단계로 돌아가서 재선택할 수 있도록 한다. 
  - 겹치는 시간대 열차 예약 불허, 1인당 표 수 제한 등의 제약 사항을 설정할 수 있다. (△) 
  - 전체 기능을 GUI로 구성한다. 
  - 2개 이상의 노선에 대해 구현해야 한다. 
  - 열차 예약은 30일 전부터 가능하다. 
  - 오프라인 형태로 예약 내역 및 열차 정보를 저장하여 재사용 가능한 프로그램을 만든다. 
- 분석
  - 기존서비스에서는 매진 열차의 매진된 표를 직접 계속 확인해야 한다. 이러한 불편함을 없애기 위해 매진 좌석이 취소되었을 때 해당 열차의 자동예약기능을 추가한다. 
  - 입석 예약이 기존서비스에서는 불가능하다. 이를 해결하기 위해 열차당 입석 제한을 정해두고 입석 예약이 가능하게 한다. 
- 구현/제작
  - JAVA, swing 라이브러리를 이용한 GUI 구성
  - CSV 파일로 오프라인 데이터 저장한다. 
- 시험/평가
  - 기능과 성능 평가하기 위하여 테스트 데이터와 예매 시뮬레이션을 실시한다. 
  - 화면 단위 기능 테스트로 데이터 흐름 확인
  - 다양한 예외 사항을 테스트해본다. 결과 도출
  - 열차 조회, 열차 선택, 예약 정보 화면, 좌석 선택 총 4가지의 인터페이스로 구성된 프로그램 모든 기능은 서로 연결되어 정상흐름, 이전 화면이동이 가능하며 분석내용에 포함된 기능을 더하여 최종결과물을 도출할 것이다

#### 4-5. 설계 제한 요소
- 성능
  - 실행 속도: 일반적인 pc 환경에서 사용자가 지연됨을 느낄 수 없는 속도
- 기능 범위
  1) 출발지, 도착지, 일시, 인원 선택
  2) 선택 목록에 맞는 열차 정보 출력 후 열차 선택
  3) 좌석 선택
  4) 예약 내역 출력 확인
  5) 예약 취소할 경우 예약 첫 단계부터 다시 시작. 6) 매 단계마다 이전 단계로 돌아갈 수 있음
- 성능 제약 사항
  - 1인당 표 수 10장 미만으로 제약
  - 예약된 좌석은 예약 불가
  - 출발지, 도착지, 일시 등 데이터 미입력 시 예약 불가
- 규격/표준
  - 본 프로그램은 모든 windows os (7~현재) 환경에서 동작한다. csv파일을 excel 형태로 저장해야하므로 한셀, ms office excel 등의 csv 연동 가능한 응용프로그램이 설치되어 있어야 의도한 효율적인 오프라인 데이터 관리가 가능하다. 
- 신뢰성
  - 사용자가 예매한 내용과 오프라인 데이터 관리 내용이 항상 일치해야 한다. 사용자의 입력이 잘못된 경우나 고의적 오류 입력의 경우에도 적절한 오류 처리를 통해 데이터 무결성과 신뢰성이 보장되도록 한다. 이를 위해서 File I/O의 DML의 기능을 수행하는 메서드들은 항상 중복검사를 시행하도록 한다. 
- 안정성/내구성
  - 사용자의 잘못된, 고의적 오류 입력의 경우 적절한 오류 처리를 통하도록 한다. 테스트 과정에서 적절하지 못한 사용이 일어났을 때 프로그램이 이상 동작을 하거나 멈추지 않도록 발생 가능한 오류에 대해 사용자에게 경고하고 프로그램은 특이점에서 적절한 조치를 취한다. 
  - case1) 매진된 열차 선택 시 “전 좌석이 매진된 열차입니다” -경고창
  - case2) 출발지, 도착지, 일시 등 데이터 미입력 시 “모든 정보를 입력해주세요” -경고창
  - case3) 제한된 시간, 10장 이상의 예매, 동일한 시간에 복수의 열차 선택 –경고창
  - other case) 테스트 과정에서 반복 수정하도록 한다.

### 5. 구현
#### 5-1. 핵심 함수

- convertStirng(): 배열의 인덱스로 저장된 데이터를 String으로 반환하여주는 함수
```
static String convertString(String[] strArr, String delimiter) { 
  StringBuilder sb = new StringBuilder(); 
  for(String str : strArr) 
    sb.append(str).append(delimiter); 
  return sb.substring(0, sb.length()-1); 
  }
```
- merge_reservation(): convertString, file_write, readByID 함수를 묶어 사용자가 reservation의 저장을할
떄 해당 함수만 호출하면 되도록 설계
```
void merge_reservation() {
  String ret[] = new String[1]; 
  String s=null; 
  s = convertString(res_in_progress, ","); 
  ret[0]=s; 
  file_object.file_write(ret, "reservation.csv"); 
  readByID_data =file_object.readById("reservation.csv", res_in_progress[9]);
}
```
- merge_train(): 기차 좌석계산 함수 열차종류, 입석과 일반석의 row col값을 판단하여 저장해줌
```
void merge_train(GUI win,String[] key_line,int col_index,int change_value) {
  int row_index = 0; 
  s = 0; 
  ArrayList<String[]> origindata = file_object.file_read("train.csv"); 
  for(int i =0; i<origindata.size();i++) {
    for(int j=0; j<5;j++) {
      if (key_line[0].equals(origindata.get(i)[0]) && key_line[1].equals(origindata.get(i)[1])      
      && key_line[2].equals(origindata.get(i)[2]) && key_line[3].equals(origindata.get(i)[3]) 
      && key_line[4].equals(origindata.get(i)[4])) { 
        s=(Integer.parseInt(origindata.get(i)[col_index]) + change_value); 
        row_index = i; 
        }
      }
    }
    String repalce_value= Integer.toString(s);          
    file_object.file_point_replace("train.csv",row_index,col_index, repalce_value); 
    readByID_data=file_object.readById("reservation.csv",res_in_progress[9]); 
  }
```

=> 위 함수의 간단한 사용성 (좌석 선택시)

```
for(int i=0; i<seat_button.length; i++) {
    if(e.getSource() == seat_button[i]) 
      win.res_in_progress[8]=""+i; 
    }
    win.merge_reservation(); 
    win.merge_train(win, win.res_in_progress,7,-1); 
    win.change(win,win.seat_list); 
    win.get_class=3;
```

#### 5-2. 실험 및 분석

- 파일 입출력 성능
  1) train.csv 파일이 존재해야 열차리스트를 보여줄수 있으므로 미리 준비되어있어야 한다. 
  2) 기존데이터와 함께 작용하므로 반복 실행/종료 하여도 데이터의 무결성이 보장된다. 
  3) 필요한 기능별로 입출력 함수를 구분하여 실행시 조건과 반복을 최소화 하였다. 
- GUI 성능
  1) 모든 화면은 의도대로 작동하였으나, 초기 사용자에게 정보를 알리는 리액션이 부족하다. 
  2) 기본적인 layout, 변수들, 자주 사용되는 일회성 component들을 Jpanel을 상속받는 base_panel 에 구현하고 나머지 패널에 base_panel을 상속시킴으로써 자원의 사용을 최소화 하였다.
였다.

### 6. 결론

- 요약
  - 작성자의 주관으로는 전체적으로 GUI, 파일 입출력이 의도한 대로 최대한 효율적으로 개발되었다. 의도한 기능이 모두 반복적인 테스트를 실행하였을 때 정상적으로 동작하며 일부 기능을 제외하고는 사용자가 사용하는데 지연시간을 전혀 느낄 수 없게 구현되었다. 
- 분석
  - UI 분야는 개발자가 조금이라도 구성을 할 줄 알아야 하지만, 보통의 개발자에게 어렵게 느껴지는 분야이다. 그럴 때 관련된 UI를 벤치마킹하면 좋은데 해당 프로젝트가 그 예시를 보여준다. file I/O method, method들과 조건식을 조합하여 많은 부분에 쓰일 코드를 줄이는 작업을 하는데 많은 노력을 기울였다. 초기개발 시 GUI 클래스 내에 파일 입출력 코드를 넣기도 했는데 이 방법으로 진행을 계속 하였다면 현재 코드의 2~3배는 되었을 것이다. 화면과 기능이 많아질 때 마다 time complexity가 얼마나 늘어날지 생각을 해보니 기능을 작게 분리하고 재사용성을 최대한으로 갖게 하는 것이 알고리즘과 비슷하거나 그 이상으로 중요하다고 분석하였다. 
- 결론
  - 설계단계를 명확하게 문서화, 최소~적정 단위의 기능분리, 팀원과의 반복적 의사소통 개발 진행법의 중요
도

- 향후 개선 과제
  - 요구사항에서 제시된 “좌석을 선택하지 않고 예약” 하는 기능을 구현하지 못하였다. 원인은 설계 과정에서 대략적인 의사 코드를 구상한 뒤, 어려운 조건을 요구하지 않는다 판단하여 화면 설계에서 제외를 시키게 되었다. 프로젝트 기간의 막바지에 쉽게 될 줄 알았던 것이 작은 오류들을 발생시켜 미완성하게 되었고 설계 단계에서 아무리 작은 것이라 생각되어도 정확한 문서화가 필수임을 깨달았다

- 기대효과
  - 대한민국의 전철은 거의 모두 “코레일 톡 app”을 통해 서비스된다. 공공시설이며, 대규모인 만큼 기본 기능에 매우 충실한 프로그램이지만 다수의 사용자가 불편함을 느끼는 아래의
    ```
    1) 매진 석을 잡기 위한 무한 새로 고침
    2) 오프라인에서 줄을 서서 직원에게 급하게 물어봐야 가능한 입석 티켓
    ```
  - 이 두 가지 기능을 해결하는 간단한 청사진을 제시함므로써 향후 개선의 필요성이 있을 때 그 예시 중 하나로 활용될 수 있다.



