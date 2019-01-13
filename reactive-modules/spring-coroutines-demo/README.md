# 코틀린 리액티브 프로그래밍 
> 코틀린으로 리액티브 프로그래밍 맛보기용으로 아주 적절한 코드예제
> `bootRun`으로 로컬서버 띄우고 테스트 시 몽고DB를 셋팅해야줘야 하지만 테스트는 `de.flapdoodle.embed.mongo` 임베디드 몽고를 사용하기 때문에 손쉽게 테스트 가능 
> 코틀린 코드 디버겅이 매우 쉬우며 간단하게 동작원리 살펴보기 좋음 

## Article
* [Kotlin coroutines and Spring 5 · Code for glory](http://blog.alexnesterov.com/post/kotlin-coroutines-and-spring-5/)
  * Fork from : https://github.com/alek-sys/spring-coroutines-demo
  * CLI Commands
    > cd %PROJECT_ROOT%
    >
    > ./gradlew :spring-coroutines-demo:clean :spring-coroutines-demo:test
  
## Related Link 

### Kotlin Version Upgrade
* https://kotlinlang.org/docs/reference/using-gradle.html
* https://github.com/konrad-kaminski/spring-kotlin-coroutine/blob/master/spring-webflux-kotlin-coroutine/src/main/kotlin/org/springframework/web/server/CoroutineWebFilter.kt
* https://github.com/Kotlin/kotlinx.coroutines/blob/master/reactive/kotlinx-coroutines-reactor/README.md