# Playdata Mini Project 3

프로젝트 주제 : [국민 청원 데이터](https://github.com/lovit/petitions_archive)(2017.09~2019.08)를 활용한 검색엔진  
  
프로젝트 기간 : 2023-07-05 ~ 2023-07-07 

## Team

|김태경|이동명|이재명|이태열|
|:---:|:---:|:---:|:---:|
|[ktk8916](https://github.com/ktk8916)|[dongmyoungLee](https://github.com/dongmyoungLee)|[LeeJMyeong](https://github.com/LeeJMyeong)|[gotoAbraxas](https://github.com/gotoAbraxas)|


## Tools
- Java 11, Spring boot 2.7.3, Mybatis
- MySQL, Elasticsearch 7.2, Logstash 7.2, Kibana 7.2 
- IntelliJ IDEA, MySql Workbench

## Goal

ELK Stack에 대한 이해와 활용
   - 한국어에 적절한 Tokenizer, 형태소분석기 사용
   - 오탈자 수정검색, 연관검색 제공
   - Logstash를 사용한 log 및 검색어 수집 파이프라인 구성
   - 수집된 검색어 기반으로 인기검색어 제공
   - log 분석을 위한 kibana 대쉬보드 생성

Spring과 Mybatis 활용, Transaction의 이해
  - 회원(가입, 로그인, 포인트 충전) 기능 구현
  - 청원 댓글(포인트사용) 기능 구현
  - 포인트 사용 시 로그 처리

## Arcitecture

![image](https://github.com/ktk8916/elk-study/assets/71807768/e6fb214a-eba9-4eff-851f-5ab12f5eb4eb)

## 시연

https://files.slack.com/files-pri/T053ASVJV96-F05G2A03RNJ/image.png

https://files.slack.com/files-pri/T053ASVJV96-F05G9079PKL/image.png

https://files.slack.com/files-pri/T053ASVJV96-F05G8S897B5/image.png
