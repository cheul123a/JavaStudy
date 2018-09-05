chapter 03.

조건문과 반복문
=================

# 조건문(if문, switch문)

## if문

    if( 조건식 ) {
      실행문;
      실행문;
      ...
    }
    
+ if문은 조건식의 결과에 따라 블록 실행 여부가 결정된다.   
+ 조건식에는 true 또는 false 값을 산출할 수 있는 연산식이나, boolean 변수가 올 수 있다.   
+ 조건식이 true이면 블록을 실행하고 false이면 블록을 실행하지 않는다.
+ 중괄호 {} 블록은 여러 개의 실행문을 하나로 묶기 위해 작성된다. 실행문이 하나 이더라도 중괄호 {} 블록을 생략하지 않는것이 좋다.

### if-else문

    if( 조건식 ) {
          조건식이 true
    } else {
          조건식이 false
    }
    
+ if문은 else 블록과 함께 사용되어 조건식의 결과에 따라 실행 블록을 선택한다.
+ if 문의 조건식이 true 이면 if 문의 블록이 실행되고, 조건식이 false 이면 else 블록이 실행된다.

### if-else if-else 문
조건문이 여러 개인 if문도 있다. 처음 if 문의 조건식이 false일 경우 다른 조건식의 결과에 따라 실행 블록을 선택할 수 있는데,
if 블록의 끝에 else if문을 붙이면된다.

    if(조건식1) {
          조건식이1이 true
    } else if(조건식2) {
          조건식이2가 true
    } else {
          조건식1 및
          조건식2가 false
    }

    











































