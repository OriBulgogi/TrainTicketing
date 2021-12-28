# TrainTicketing 
#### 자동 및 입석 예약 가능 열차 예매 시스템
해당 프로젝트는 요구사항 분석, 설계, 구현의 과정을 정의하고 문서화하는 시스템 분석 및 설계의 관점에서 시도되었습니다.
프로그램의 구현 내용의 간단한 화면설명은 및 입출력 정의는 "요약"에서 
설계과정과 개발시 문제해결 과정은 "문서"에서 확인할 수 있습니다.

## 요약
1. 로그인 창(첫 화면)
<img src = "https://user-images.githubusercontent.com/81247213/147555822-f8885bd1-957b-43ce-b8ed-f109bef3debc.png" width ="200" height ="300" />
- 등록된 ID와 Password 와 다른 ID와 Password 를 입력한 경우 로그인이 되지 않는다.   
- 로그인 창에서 ‘회원가입’ 버튼을 누르면 회원가입 창으로 넘어간다.   
- ‘로그인’ 버튼을 누르면 열차 조회하는 창으로 넘어간다.   

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
