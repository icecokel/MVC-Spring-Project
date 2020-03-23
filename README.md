## icecokeWebProject

### 개인 공부 및 편의를 위한 프로젝트
 * 리눅스 서버 공부 
    * CentOs 7 설치 관리
    * Mysql 설치 및 관리
    * FTP 포트 통신을 위한 서버 설정
    * Tomcat을 통한 배포 과정
 
 * 개발 공부
   * MVC 패턴에 의한 프로젝트 작성
   * MyBatis를 이용한 DB 연동
   * 이미지 파일 업로드 등을 이용한 회원관리
   * 회원 탈퇴시 회원 정보를 관리하기 위한 DB 설계
   * XML 파싱
     * 한겨례 xml 실시간 상위 TOP 5 기사 파싱
   * 새로운 라이브러리 사용 및 파일전송프로토콜 사용
     * commons net 라이브러리를 이용한 FTP 통신
   * 파일다운로드 작성
     * 파일 다운로드 뷰를 이용한 파일 및 엑셀 파일 다운로드 서비스 구현
   * 비통기 통신
     * ajax를 이용한 닉네임, 이메일 확인 및 댓글 서비스 구현
     
#### 메인 페이지

<img src="https://user-images.githubusercontent.com/55083854/77358113-9f14a200-6d8c-11ea-9271-8b5ce6fe81db.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77358118-9fad3880-6d8c-11ea-8711-3edf64853bb0.JPG" width = "65%"/>

프로젝트의 메인 화면 [한겨례XML](http://www.hani.co.kr/rss/) 파싱하여 top 5 기사를 메인 페이지에 노출

[페이지 소스 보기](https://github.com/icecokel/MVC-Spring-Project/blob/master/icecokeWebproject/src/main/java/com/coke/ice/XMLContoller.java)

#### 회원 가입 페이지

<img src="https://user-images.githubusercontent.com/55083854/77359463-f451b300-6d8e-11ea-896a-21c619e1fca5.JPG" width = "65%"/>

회원가입 페이지.

<img src="https://user-images.githubusercontent.com/55083854/77359467-f582e000-6d8e-11ea-8e5a-40850829e967.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77359470-f582e000-6d8e-11ea-9cd8-b478ab03a6ed.JPG" width = "65%"/>

비동기 통신을 통한 실시간 이메일, 닉네임 중복 검사 및 유효성 검사

[페이지 소스 보기 - 스크립트](https://github.com/icecokel/MVC-Spring-Project/blob/master/icecokeWebproject/src/main/webapp/resources/scripts/join.js)

[페이지 소스 보기 - JSP](https://github.com/icecokel/MVC-Spring-Project/blob/master/icecokeWebproject/src/main/webapp/WEB-INF/views/user/join.jsp)

<img src="https://user-images.githubusercontent.com/55083854/77359473-f61b7680-6d8e-11ea-8c30-77cbed6bc811.JPG" width = "65%"/>

회원 가입 완료 후 바로 로그인 할 수 있도록 로그인 페이지로 이동.

  * 회원 가입 시 회원정보를 연동된 DB에 기록이 되며,
  * 비밀번호는 , jbcrypt 를 통해 다시 한번더 암호화 되어 저장된다. 

``` java
user.setPassword(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
````

#### 로그인 페이지


<img src="https://user-images.githubusercontent.com/55083854/77359552-16e3cc00-6d8f-11ea-95ae-dd08179a9a2c.JPG" width = "65%"/>

<img src="https://user-images.githubusercontent.com/55083854/77359555-1814f900-6d8f-11ea-8e61-2b202a05bfc1.JPG" width = "65%"/>

<img src="https://user-images.githubusercontent.com/55083854/77359557-1814f900-6d8f-11ea-8568-3dec9ffca20b.JPG" width = "65%"/>

#### 비밀번호 찾기

~~비밀번호 찾기~~  **새로운 비밀번호 발급으로 기능 변경**

<img src="https://user-images.githubusercontent.com/55083854/77359800-85c12500-6d8f-11ea-8830-45aca065e820.JPG" width = "65%"/>

회원 가입 당시 등록한 비밀번호 문답을 확인 

<img src="https://user-images.githubusercontent.com/55083854/77359797-85288e80-6d8f-11ea-945c-8024239e3bff.JPG" width = "50%"/>

랜덤 문자열을 발생시켜 지급, 후 해당 문자열로 DB에서 회원정보수정

#### 회원 정보 페이지

<img src="https://user-images.githubusercontent.com/55083854/77366665-d2126200-6d9b-11ea-996a-5104e2b072b0.JPG" width = "65%"/>

상단에 회원이미지 또는 닉네임을 클릭하여 회원정보 수정 페이지로 이동.

>JSP에 header.jsp 파일을 삽입 하였기에 모든 페이지에서 같은 기능을 제공 받을 수 있다.

<img src="https://user-images.githubusercontent.com/55083854/77366666-d3438f00-6d9b-11ea-8e9a-ea3251337c73.JPG" width = "65%"/>

등록된 이미지 삭제 및 개인 정보 수정이 가능 하지만

<img src="https://user-images.githubusercontent.com/55083854/77366667-d3438f00-6d9b-11ea-90d5-18bba5f34fad.JPG" width = "50%"/>

이메일 같이 고정되어야 할 값은 readonly되어 수정이 불가능 

```HTML
<input id="profileemail" name="profileemail" type="text" value="${user.email}" readonly>
```

<img src="https://user-images.githubusercontent.com/55083854/77366669-d3dc2580-6d9b-11ea-8655-b927161a5594.JPG" width = "65%"/>

회원정보가 수정되면 다시 로드 했을 때 변경된 정보를 받을 수 있다.

회원 탈퇴

<img src="https://user-images.githubusercontent.com/55083854/77366790-20276580-6d9c-11ea-9bd3-6bc04c05c8cd.JPG" width = "20%"/>

해당 페이지에서 회원 탈퇴하기 버튼을 눌러 탈퇴 진행 가능 

<img src="https://user-images.githubusercontent.com/55083854/77366791-20276580-6d9c-11ea-9f18-f379ad6c1025.JPG" width = "65%"/>

오 입력 방지를 위해 의사를 다시 확인

<img src="https://user-images.githubusercontent.com/55083854/77366793-20bffc00-6d9c-11ea-98e1-776521103659.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77366795-20bffc00-6d9c-11ea-80ae-7d6559341561.JPG" width = "65%"/>

회원 테이블에서는 제거가 되나, 제거된 회원 정보를 다른 테이블로 이동하여 보관된다.
(회원 탈퇴 후 정보 3개월간 정보보관 등의 기능을 구축하기 위한 DB 설계)

패스워드 수정

<img src="https://user-images.githubusercontent.com/55083854/77366736-fcfcb600-6d9b-11ea-849f-da9b51199683.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77366737-fe2de300-6d9b-11ea-903e-19e5ad276b89.JPG" width = "45%"/>

회원 정보 수정 페이지에서 비밀번호 변경을 요청 시 본인 인증 후 패스워드를 수정 할 수 있게 된다.

#### 게시판 페이지

<img src="https://user-images.githubusercontent.com/55083854/77366861-4ea54080-6d9c-11ea-9f05-b24fbe3ed1a3.JPG" width = "65%"/>

10개씩 페이징 처리 되어 전체 게시글을 화면에 출력

<img src="https://user-images.githubusercontent.com/55083854/77366863-4f3dd700-6d9c-11ea-8c68-858f5ba7738e.JPG" width = "65%"/>

summernote 에디터가 추가된 게시글 작성 페이지. 태그 및 그림 모두 저장 가능
```HTML
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/summernote/summernote-ko-KR.js"></script>
```

<img src="https://user-images.githubusercontent.com/55083854/77366864-4fd66d80-6d9c-11ea-99fc-527230ff621f.JPG" width = "65%"/>

저장된 게시글을 불러와도,  태그 및 그림이 깨지지 않고, 화면에 출력

<img src="https://user-images.githubusercontent.com/55083854/77366865-4fd66d80-6d9c-11ea-9abc-1d0cc7adfdc7.JPG" width = "65%"/>

<img src="https://user-images.githubusercontent.com/55083854/77366866-506f0400-6d9c-11ea-998f-bbe09c39b530.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77366868-506f0400-6d9c-11ea-8e51-3513c37b5873.JPG" width = "20%"/>
<img src="https://user-images.githubusercontent.com/55083854/77366870-51079a80-6d9c-11ea-953c-1c6ecb1d92b8.JPG" width = "35%"/>

엑셀 다운로드

<img src="https://user-images.githubusercontent.com/55083854/77366872-51a03100-6d9c-11ea-8240-f250ef37c693.JPG" width = "65%"/>



#### 파일 전송 페이지

<img src="https://user-images.githubusercontent.com/55083854/77366963-857b5680-6d9c-11ea-9aa9-b6d857c46318.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77366965-8613ed00-6d9c-11ea-9474-d16be8d5638f.JPG" width = "65%"/>

파일을 선택 후 업로드를 진행하면 서버에 FTP 포트를 통해 지정된 위치에 지정된 이름으로 저장된다.

>서버의 정보는 DB에 저장되어있으며, 파일 관련 페이지 로드 시 FTP 연결을 먼저 진행한다. (연결 지연 방지)

<img src="https://user-images.githubusercontent.com/55083854/77366969-86ac8380-6d9c-11ea-8931-93d9330877e2.JPG" width = "65%"/>

본인이 업로드한 정보만 열람이 가능하다.

<img src="https://user-images.githubusercontent.com/55083854/77366972-86ac8380-6d9c-11ea-846f-169ebd63e8b7.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77366974-87451a00-6d9c-11ea-94a5-647f2c5bc3b3.JPG" width = "65%"/>

실제 파일 명과 서버에 저장되는 파일명을 DB에 저장하여 중복성을 제거하고, 유저의 편의를 더 했다.


<img src="https://user-images.githubusercontent.com/55083854/77366975-87ddb080-6d9c-11ea-9222-c66253960faf.JPG" width = "65%"/>

<img src="https://user-images.githubusercontent.com/55083854/77366976-88764700-6d9c-11ea-8140-3debff832ff8.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77366979-88764700-6d9c-11ea-99e1-90676acce627.JPG" width = "65%"/>
<img src="https://user-images.githubusercontent.com/55083854/77366980-890edd80-6d9c-11ea-8915-727e9bd15923.JPG" width = "65%"/>

<img src="https://user-images.githubusercontent.com/55083854/77366981-89a77400-6d9c-11ea-8335-f9680ab72751.JPG" width = "65%"/>

파일 삭제 요청 시, 해당 정보는 다른 테이블로 이동되어 따로 보관됨 (파일 복구 기능을 제공하기 위함.)
