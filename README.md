[![Build Status](https://travis-ci.org/ncrash/programming-note.svg?branch=master)](https://travis-ci.org/ncrash/programming-note)

# Programming Note

* 백문이 불여일타. 기록이 기억을 지배한다.
* 학습을 통해 얻게된 코드베이스 경험을 잃어버리고 싶지 않아서 시작함
* Java Programing 역량 키우고 테스트 코드를 잘 만들어두어 두고두고 활용하기 위함
* 언제 어디서든 활용할 수 있는 코드경험 쌓기
* https://github.com/eugenp/tutorials 전략과 동일한 방식으로 학습경험 쌓아간다.
	* 차이점 하나. `maven` 대신 `gradle`로 빌드 시스템을 쓰는것
	* 차이점 두울. 알고리즘과 디자인패턴에 대해서도 다룰것

## Gradle

* 새로운 서브모듈 생성 시 `Build Init Plugin` 명령으로 프로젝트 초기화
* https://docs.gradle.org/current/userguide/build_init_plugin.html

```$ gradle init --type java-library```

```$ gradle init --type scala-library```

```$ gradle init --type groovy-library```
  
