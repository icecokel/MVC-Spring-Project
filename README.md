<img src="https://user-images.githubusercontent.com/55083854/77358113-9f14a200-6d8c-11ea-9271-8b5ce6fe81db.JPG" width = "65%"/>

 [>>AWS server 확인하러가기<<](http://52.79.236.107:8080)

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
     
#### 수정 진행 중

\ | 기존 | 목표 | 비고
---- | ---- | ---- | ----
라이브러리 | commons net | 찾는중(Apache Mina SSHD :: SFTP)  | 라이브러리 확인 필요
문제점 | FTP로 파일전송, AWS 에서 사용 불가 | SFTP 공개키를 전송하여 AWS에서 사용가능 | .
