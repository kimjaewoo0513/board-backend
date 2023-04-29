## 게시판 프로젝트 입니다.

- back-end로써 이루고자 한 목표는
spring boot 프레임워크를 통해 spring security + jwt를 이용한 로그인 로그아웃 구현을 직접 해보기입니다.
기본 crud 처리와 더불어 예외처리에 더욱 깊게 살펴 볼 수 있는 기회였습니다.

# 목차
* [패키지 구조](#-프로젝트-구조)
* [사용 기술](#-사용-기술)
* [기능](#-구현-기능)
* [기능 실행화면](#-기능-실행화면)
* [API 명세서](#-API-명세서)
* [ERD 설계](#-ERD-설계)
* [트러블슈팅](#-트러블슈팅)


# 프로젝트 구조
<img width="575" alt="backend-project-structure" src="">


# 사용 기술
|기술|버전|
|----|----|
|Spring Boot|2.7.2|
|Spring Security|2.7.2|
|Bean Validation|2.7.2|
|JSON Web Token|0.9.1|
|MyBatis|2.1.3|
|MySQL Connector J|8.0.28|


# 구현 기능
* 게시판 기능
  * 모든 게시글 및 특정 게시글 조회
  * 게시글 검색 (제목, 내용, 작성자)
  * 게시글 작성 [회원]
  * 게시글 수정 [회원, 게시글 작성자]
  * 게시글 삭제 [회원, 게시글 작성자]
  * 게시글 답글 작성 [회원]
* 댓글 기능
  * 댓글 조회
  * 댓글 작성 [회원]
  * 댓글 수정 [회원, 댓글 작성자]
  * 댓글 삭제 [회원, 댓글 작성자]
* 회원 기능
  * 회원가입
  * 로그인/로그아웃
  

# 기능 실행화면

## 게시판 기능
### 모든 게시글 및 특정 게시글 조회
* 모든 게시글을 조회할 수 있습니다. 페이징 기능을 통해 한 페이지에서 최대 10개의 게시글이 조회됩니다.

* 게시글의 제목을 클릭하면, 게시글의 상세 내용을 조회할 수 있습니다.

### 게시글 검색
* 게시글의 제목과 내용 또는 작성자로 게시글을 검색할 수 있습니다.

### 게시글 작성
* 로그인한 사용자는 게시글을 작성할 수 있습니다.
* 로그인하지 않았을 경우 글 작성이 제한됩니다.

### 게시글 수정
* 게시글 작성자는 게시글을 수정할 수 있습니다. 
* 자신이 작성한 게시글에만 수정, 삭제 버튼이 활성화됩니다.

### 게시글 삭제
* 게시글 작성자는 게시글을 삭제할 수 있습니다.

### 게시글 답글 작성
* 하나의 게시글에 대한 답글을 작성할 수 있습니다. `게시글 작성` 과 마찬가지로 로그인한 사용자만 답글을 작성할 수 있습니다.

## 댓글 기능
### 댓글 조회
* `게시글 상세` 에서 관련된 댓글을 조회할 수 있습니다. 페이징 기능을 통해 한 페이지에서 최대 5개의 댓글이 조회됩니다.

### 댓글 작성
* 로그인한 사용자는 댓글을 작성할 수 있습니다.

### 댓글 수정
* 자신이 작성한 댓글을 수정할 수 있습니다.

### 댓글 삭제
* 자신이 작성한 댓글을 삭제할 수 있습니다.

## 회원 기능
### 회원가입
* 회원가입 시 아이디 중복을 체크합니다.

* 회원가입을 통해 서비스에 사용자 정보를 저장합니다.

### 로그인/로그아웃
* 로그인
* 로그인을 완료하면 브라우저의 `Local Storage` 에 사용자 `id` 와 `JWT` 토큰 정보를 저장합니다.

* 로그아웃
* 로그아웃을 완료하면 브라우저의 `Local Storage` 의 내용도 삭제합니다.
  
# API 명세서
HTTP 메서드를 통해 행위를 명시할 수 있도록 RESTful 방식으로 설계했습니다. <br/><br/>

# ERD 설계
